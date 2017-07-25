import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import static java.lang.System.exit;

/**
 * Created by Korybut on 11.07.2017.
 */
public class Frame extends JFrame implements ActionListener, MouseListener {

    HEXArray hexArray = new HEXArray();
    RegistryOperation regOp = new RegistryOperation();
    TextFieldsArray txtFields = new TextFieldsArray();

    /* right panel with operation buttons */
    RightPanel rightPanel = new RightPanel();

    /* menu bar */
    Menu mainMenu = new Menu();

    /* status bar */
    StatusBar statusBar = new StatusBar();



    public Frame() throws FileNotFoundException{

        super("Rejestry - Kalkulator");
        setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        pack();
        setLayout(null);
        setLocation(getSize().width/2+340, getSize().height/2+200);
        setSize(565,300);
        setResizable(false);
        setVisible(true);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));

        /* FRAMES LOOKS LIKE WINDOWS */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);

        /* set whole block textFields */
        add(txtFields);
        txtFields.setVisible(true);
        txtFields.setBounds(20,20,325,200);

        for(int a=0; a<8; a++){
            for(int b=0; b<4; b++){
                txtFields.getField(a,b).addMouseListener(this);
            }
        }

        add(rightPanel);
        rightPanel.setLocation(345,20);

        setJMenuBar(mainMenu);

        rightPanel.getButRand().addActionListener(this);
        rightPanel.getButClear().addActionListener(this);
        rightPanel.getButCalAll().addActionListener(this);
        rightPanel.getButComboBox().addActionListener(this);

        mainMenu.getExit().addActionListener(this);
        mainMenu.getSave().addActionListener(this);
        mainMenu.getLoad().addActionListener(this);
        mainMenu.getNewfile().addActionListener(this);
        mainMenu.getClear().addActionListener(this);
        mainMenu.getRandom().addActionListener(this);
        mainMenu.getExchange().addActionListener(this);
        mainMenu.getShowHideStatusBar().addActionListener(this);
        mainMenu.getCalculateAll().addActionListener(this);
        mainMenu.getOnlyAdd().addActionListener(this);
        mainMenu.getOnlySub().addActionListener(this);
        mainMenu.getOnlyPositive().addActionListener(this);
        mainMenu.getOnlyNegative().addActionListener(this);
        mainMenu.getNewParam().addActionListener(this);

        add(statusBar);
        statusBar.setBounds(0,228,565,20);

    }



    private boolean checkInsertValue(int i){
        int errorThis = -1;
        boolean ok = true;
        try {
            errorThis = Integer.parseInt(txtFields.getValue(0, i), 16);
            errorThis = Integer.parseInt(txtFields.getValue(1, i), 16);
        } catch (NumberFormatException n) {
            n.printStackTrace();
            ok = false;
            String numberFormatMsg = "W conajmniej jednym polu wprowadzono błędną wartość!";
            JOptionPane.showMessageDialog(null, numberFormatMsg, "Błędna wartość", JOptionPane.ERROR_MESSAGE);
            if (errorThis == -1) {
                txtFields.getField(0, i);
            }
        }
        return ok;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rightPanel.getButRand() || e.getSource() == mainMenu.getRandom()){
            for(int a=0; a<2; a++){
                for(int b=0; b<4; b++){
                    txtFields.setValue(new RandomizeHex().getRandomHex(), a, b);
                }
            }
        }
        if(e.getSource() == mainMenu.getOnlyPositive()){
            for(int a=0; a<2; a++){
                for(int b=0; b<4; b++){
                    txtFields.setValue(new RandomizeHex(0).getRandomHex(), a, b);
                }
            }
        }
        if(e.getSource() == mainMenu.getOnlyNegative()){
            for(int a=0; a<2; a++){
                for(int b=0; b<4; b++){
                    txtFields.setValue(new RandomizeHex(1).getRandomHex(), a, b);
                }
            }
        }
        if(e.getSource() == mainMenu.getNewParam()){
            for(int b=0; b<4; b++){
                txtFields.setValue(txtFields.getValue(2, b), 0, b);
                txtFields.setValue(txtFields.getValue(5, b), 1, b);
            }
            for(int a=2; a<8; a++){
                for(int b=0; b<4; b++){
                    if(a>1) txtFields.setValue("", a, b);
                    else txtFields.setValue("0000", a, b);
                }
            }
        }
        if(e.getSource() == mainMenu.getExchange()){
            for(int b=0; b<4; b++){
                String temp = txtFields.getValue(0, b);
                txtFields.setValue(txtFields.getValue(1, b), 0, b);
                txtFields.setValue(temp, 1, b);
            }
        }
        if(e.getSource() == rightPanel.getButClear() || e.getSource() == mainMenu.getClear()){
            for(int a=0; a<8; a++){
                for(int b=0; b<4; b++){
                    if(a>1) txtFields.setValue("", a, b);
                    else txtFields.setValue("0000", a, b);
                }
            }
        }
        if(e.getSource() == rightPanel.getButCalAll() || e.getSource() == mainMenu.getCalculateAll()){
            for(int i=0; i<4; i++){
                if(checkInsertValue(i)){
                    txtFields.setValue(regOp.hexAddw(txtFields.getValue(0,i),txtFields.getValue(1,i)),2,i);
                    txtFields.setValue(regOp.hexAddsw(txtFields.getValue(0,i),txtFields.getValue(1,i)),3,i);
                    txtFields.setValue(regOp.hexAddusw(txtFields.getValue(0,i),txtFields.getValue(1,i)),4,i);
                    txtFields.setValue(regOp.hexSubw(txtFields.getValue(0,i),txtFields.getValue(1,i)),5,i);
                    txtFields.setValue(regOp.hexSubsw(txtFields.getValue(0,i),txtFields.getValue(1,i)),6,i);
                    txtFields.setValue(regOp.hexSubusw(txtFields.getValue(0,i),txtFields.getValue(1,i)),7,i);
                }

            }
        }
        if(e.getSource() == mainMenu.getOnlyAdd()){
            for(int i=0; i<4; i++){
                if(checkInsertValue(i)){
                    txtFields.setValue(regOp.hexAddw(txtFields.getValue(0,i),txtFields.getValue(1,i)),2,i);
                    txtFields.setValue(regOp.hexAddsw(txtFields.getValue(0,i),txtFields.getValue(1,i)),3,i);
                    txtFields.setValue(regOp.hexAddusw(txtFields.getValue(0,i),txtFields.getValue(1,i)),4,i);
                }

            }
        }
        if(e.getSource() == mainMenu.getOnlySub()){
            for(int i=0; i<4; i++){
                if(checkInsertValue(i)){
                    txtFields.setValue(regOp.hexSubw(txtFields.getValue(0,i),txtFields.getValue(1,i)),5,i);
                    txtFields.setValue(regOp.hexSubsw(txtFields.getValue(0,i),txtFields.getValue(1,i)),6,i);
                    txtFields.setValue(regOp.hexSubusw(txtFields.getValue(0,i),txtFields.getValue(1,i)),7,i);
                }

            }
        }
        if(e.getSource() == mainMenu.getShowHideStatusBar()){
            if(statusBar.isVisible()) {
                statusBar.setVisible(false);
                setSize(565,280);
            }
            else {
                statusBar.setVisible(true);
                setSize(565,300);
            }
        }
        if(e.getSource() == mainMenu.getNewfile()){
            if(JOptionPane.showOptionDialog(null,"Czy napewno chcesz zamknąć poprzedni projekt i stworzyć nowy?","Nowy plik",
                    JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null) == 0){
                for(int a=0; a<8; a++){
                    for(int b=0; b<4; b++){
                        if(a>1) txtFields.setValue("", a, b);
                        else txtFields.setValue("0000", a, b);
                    }
                }
                statusBar.setFileNameStatus("currently file is not saved ");
            }
        }
        if(e.getSource() == mainMenu.getSave()){
            EditFile editFile = new EditFile();
            editFile.save(txtFields, statusBar);
        }
        if(e.getSource() == mainMenu.getLoad()){
            EditFile editFile = new EditFile();
            txtFields = editFile.open(txtFields, statusBar);
        }
        if(e.getSource() == rightPanel.getButComboBox()){
            for(int i=0; i<4; i++) {
                if (checkInsertValue(i)) {
                    int num = rightPanel.getBoxListCalculate().getSelectedIndex();
                    switch(num){
                        case 0:
                            txtFields.setValue(regOp.hexAddw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 2, i);
                            break;
                        case 1:
                            txtFields.setValue(regOp.hexAddsw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 3, i);
                            break;
                        case 2:
                            txtFields.setValue(regOp.hexAddusw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 4, i);
                            break;
                        case 3:
                            txtFields.setValue(regOp.hexSubw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 5, i);
                            break;
                        case 4:
                            txtFields.setValue(regOp.hexSubsw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 6, i);
                            break;
                        case 5:
                            txtFields.setValue(regOp.hexSubusw(txtFields.getValue(0, i), txtFields.getValue(1, i)), 7, i);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        if(e.getSource() == mainMenu.getExit()){
            if(JOptionPane.showOptionDialog(null, "Czy napewno chcesz zakończyć działanie programu?", "Zamknij",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int a=0; a<8; a++) {
            for (int b = 0; b < 4; b++) {
                if (e.getSource() == txtFields.getField(a, b)) {
                    statusBar.setIndexFieldStatus(String.valueOf(a + ":" + b));
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
