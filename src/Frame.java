import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.exit;

/**
 * Created by Korybut on 11.07.2017.
 * last edit 29.09.2017.
 */
public class Frame extends JFrame {

    private TextFieldsArray txtFields = new TextFieldsArray();
    private RightPanel rightPanel = new RightPanel();
    private Menu mainMenu = new Menu();
    private StatusBar statusBar = new StatusBar();
    private EditFile editFile = new EditFile();
    private Locale localePolish = new Locale("pl", "PL");
    private Locale localeEnglish = new Locale("en", "GB");
    private Locale currentLocale;
    private ResourceBundle res;

    private String closeMessage;
    private String createMessage;
    private String closeBtnMsg;
    private String createBtnMsg;
    private String statFileText;

    public Frame() throws FileNotFoundException{

        super("Registry Calculator");
        setDefaultCloseOperation(Frame.DO_NOTHING_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        pack();
        setLayout(null);
        setLocation(getSize().width/2+340, getSize().height/2+200);
        setSize(565,300);
        setResizable(false);
        setCurrentLocale(localePolish);
        validate();
        setVisible(true);

        addWindowListener(new WindowsAction());

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
                txtFields.getField(a,b).addMouseListener(new MouseAction());
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
        mainMenu.getLoad().addActionListener(e -> {
            editFile = new EditFile();
            txtFields = editFile.open(txtFields, statusBar);
        });
        mainMenu.getNewfile().addActionListener(e -> createNewFile());
        mainMenu.getShowHideStatusBar().addActionListener(e -> {
            if(statusBar.isVisible()) {
                statusBar.setVisible(false);
                setSize(565,280);
            }
            else {
                statusBar.setVisible(true);
                setSize(565,300);
            }
        });
        mainMenu.getPolskiItem().addActionListener(e -> setCurrentLocale(localePolish));
        mainMenu.getEnglishItem().addActionListener(e -> setCurrentLocale(localeEnglish));

        add(statusBar);
        statusBar.setBounds(0,228,565,20);
    }

    public void setCurrentLocale(Locale locale){
        currentLocale = locale;
        res = ResourceBundle.getBundle("Bundle", currentLocale);
        updateDisplay();
        // update whole class strings.
        mainMenu.updateDisplay(res);
        rightPanel.updateDisplay(res);
        editFile.updateDisplay(res);
        validate();
    }

    private void updateDisplay(){
        closeMessage = res.getString("close_frame");
        createMessage = res.getString("create_newfile");
        closeBtnMsg = res.getString("close");
        createBtnMsg = res.getString("newfile");
        statFileText = res.getString("stat_notsave");
    }

    private void closeFrame(){
        if(JOptionPane.showOptionDialog(null, closeMessage, closeBtnMsg,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) exit(0);
    }

    private void createNewFile(){
        if(JOptionPane.showOptionDialog(null,createMessage, createBtnMsg,
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null) == 0){
            for(int a=0; a<8; a++){
                for(int b=0; b<4; b++){
                    if(a>1) txtFields.setValue("", a, b);
                    else txtFields.setValue("0000", a, b);
                }
            }
            statusBar.setFileNameStatus(statFileText);
        }
    }

    private class MouseAction extends MouseAdapter{
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
    }

    private class WindowsAction extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            closeFrame();
        }
    }
}