import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import static java.lang.System.exit;

/**
 * Created by Korybut on 11.07.2017.
 */
public class Frame extends JFrame implements ActionListener, MouseListener, WindowListener {

    TextFieldsArray txtFields = new TextFieldsArray();

    /* right panel with operation buttons */
    RightPanel rightPanel = new RightPanel();

    /* menu bar */
    Menu mainMenu = new Menu();

    /* status bar */
    StatusBar statusBar = new StatusBar();



    public Frame() throws FileNotFoundException{

        super("Rejestry - Kalkulator");
        setDefaultCloseOperation(Frame.DO_NOTHING_ON_CLOSE);
        pack();
        setLayout(null);
        setLocation(getSize().width/2+340, getSize().height/2+200);
        setSize(565,300);
        setResizable(false);
        setVisible(true);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        this.addWindowListener(this);

        /* FRAMES LOOKS LIKE WINDOWS */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
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

        rightPanel.setRandom(txtFields);
        rightPanel.clear(txtFields);
        rightPanel.calculateAll(txtFields);
        rightPanel.calculateFromComboBox(txtFields);

        mainMenu.setTextFieldOfItems(txtFields);
        mainMenu.getExit().addActionListener(e -> closeFrame());
        mainMenu.save(txtFields, statusBar);
        mainMenu.getLoad().addActionListener(this);
        mainMenu.getNewfile().addActionListener(e -> createNewFile());
        mainMenu.getShowHideStatusBar().addActionListener(this);

        add(statusBar);
        statusBar.setBounds(0,228,565,20);

    }

    private void closeFrame(){
        if(JOptionPane.showOptionDialog(null, "Czy napewno chcesz zakończyć działanie programu?", "Zamknij",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) exit(0);
    }

    private void createNewFile(){
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

    @Override
    public void actionPerformed(ActionEvent e) {

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
        if(e.getSource() == mainMenu.getLoad()){
            EditFile editFile = new EditFile();
            txtFields = editFile.open(txtFields, statusBar);
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeFrame();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
