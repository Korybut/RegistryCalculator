import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 15.07.2017.
 */
class Menu extends JMenuBar {

    private JMenuItem newfile = new JMenuItem();
    private JMenuItem save = new JMenuItem();
    private JMenuItem load = new JMenuItem();
    private JMenuItem exit = new JMenuItem();

    private JMenuItem clear = new JMenuItem();
    private JMenuItem random = new JMenuItem();
    private JMenuItem exchange = new JMenuItem();

    private JMenuItem polski = new JMenuItem("Polski");
    private JMenuItem english = new JMenuItem("English");
    private JMenuItem showHideStatusBar = new JMenuItem();

    private JMenuItem calculateAll = new JMenuItem();
    private JMenuItem onlyAdd = new JMenuItem();
    private JMenuItem onlySub = new JMenuItem();
    private JMenuItem newParam = new JMenuItem();
    private JMenuItem onlyPositive = new JMenuItem();
    private JMenuItem onlyNegative = new JMenuItem();
    private JMenu file = new JMenu();
    private JMenu edit = new JMenu();
    private JMenu view = new JMenu();
    private JMenu options = new JMenu();
    private JMenu help = new JMenu();
    private JMenu mode = new JMenu();
    private JMenu language = new JMenu();
    private JMenuItem modeCalculator = new JMenuItem();
    private JMenuItem helper = new JMenuItem();
    private JMenuItem about = new JMenuItem();

    public void updateDisplay(ResourceBundle res){
        newfile.setText(res.getString("newfile"));
        save.setText(res.getString("save"));
        load.setText(res.getString("load"));
        exit.setText(res.getString("exit"));
        clear.setText(res.getString("clear"));
        random.setText(res.getString("random"));
        exchange.setText(res.getString("exchange"));
        showHideStatusBar.setText(res.getString("hideshow_stat"));
        calculateAll.setText(res.getString("calculateAll"));
        onlyAdd.setText(res.getString("onlyAdd"));
        onlySub.setText(res.getString("onlySub"));
        newParam.setText(res.getString("newParam"));
        onlyPositive.setText(res.getString("onlyPositive"));
        onlyNegative.setText(res.getString("onlyNegative"));
        file.setText(res.getString("file"));
        edit.setText(res.getString("edit"));
        view.setText(res.getString("view"));
        options.setText(res.getString("options"));
        help.setText(res.getString("help"));
        mode.setText(res.getString("mode_dots"));
        language.setText(res.getString("lang"));
        modeCalculator.setText(res.getString("calculator"));
        helper.setText(res.getString("help"));
        about.setText(res.getString("about"));
        validate();
    }

    Menu(){

        add(file);
        add(edit);
        add(view);
        add(options);
        add(help);

        file.add(newfile);
        Image newfileIcon = new ImageIcon(this.getClass().getResource("/images/newfile.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        newfile.setIcon(new ImageIcon(newfileIcon));
        newfile.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        file.add(save);
        Image saveIcon = new ImageIcon(this.getClass().getResource("/images/save.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        save.setIcon(new ImageIcon(saveIcon));
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        file.add(load);
        Image loadIcon = new ImageIcon(this.getClass().getResource("/images/load.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        load.setIcon(new ImageIcon(loadIcon));
        file.insertSeparator(3);
        Image closeIcon = new ImageIcon(this.getClass().getResource("/images/close.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        exit.setIcon(new ImageIcon(closeIcon));
        file.add(exit);

        edit.add(clear);
        clear.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        Image clearIcon = new ImageIcon(this.getClass().getResource("/images/clear.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        clear.setIcon(new ImageIcon(clearIcon));
        edit.add(random);
        Image randomIcon = new ImageIcon(this.getClass().getResource("/images/random.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        random.setIcon(new ImageIcon(randomIcon));
        edit.add(exchange);
        Image exchangeIcon = new ImageIcon(this.getClass().getResource("/images/exchange.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        exchange.setIcon(new ImageIcon(exchangeIcon));

        view.add(mode);
        view.add(language);

        language.add(polski);
        language.add(english);
        mode.add(modeCalculator);
        modeCalculator.setEnabled(false);
        JMenuItem modeTesterHex = new JMenuItem("Tester Hex");
        mode.add(modeTesterHex);
        view.add(showHideStatusBar);

        options.add(calculateAll);
        Image calculateIcon = new ImageIcon(this.getClass().getResource("/images/calculate.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        calculateAll.setIcon(new ImageIcon(calculateIcon));
        calculateAll.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
        options.add(onlyAdd);
        options.add(onlySub);
        options.insertSeparator(3);
        options.add(newParam);
        Image newParamIcon = new ImageIcon(this.getClass().getResource("/images/newparam.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        newParam.setIcon(new ImageIcon(newParamIcon));
        newParam.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        Image positiveIcon = new ImageIcon(this.getClass().getResource("/images/positive.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        options.add(onlyPositive);
        onlyPositive.setIcon(new ImageIcon(positiveIcon));
        Image negativeIcon = new ImageIcon(this.getClass().getResource("/images/negative.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        options.add(onlyNegative);
        onlyNegative.setIcon(new ImageIcon(negativeIcon));

        help.add(helper);
        Image aboutIcon = new ImageIcon(this.getClass().getResource("/images/helper.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        about.setIcon(new ImageIcon(aboutIcon));
        help.add(about);

        about.addActionListener(e -> new AboutFrame());
    }

    void setTextFieldOfItems(TextFieldsArray t){
        onlyPositive.addActionListener(e -> t.setOnlyPositive());
        onlyNegative.addActionListener(e -> t.setOnlyNegative());
        newParam.addActionListener(e -> t.setNewParameters());
        exchange.addActionListener(e -> t.exchange());
        calculateAll.addActionListener(e -> t.calculateAll());
        onlyAdd.addActionListener(e -> t.calculateOnlyAdd());
        onlySub.addActionListener(e -> t.calculateOnlySub());
        random.addActionListener(e -> t.setRandom());
        clear.addActionListener(e -> t.clear());
    }

    JMenuItem getNewfile() {
        return newfile;
    }

    void save(TextFieldsArray t, StatusBar sb) {
        save.addActionListener(e -> {
            EditFile editFile = new EditFile();
            editFile.save(t, sb);
        });
    }

    JMenuItem getPolskiItem() { return polski; }

    JMenuItem getEnglishItem() { return english; }

    JMenuItem getLoad() {
        return load;
    }

    JMenuItem getExit() {
        return exit;
    }

    JMenuItem getShowHideStatusBar() {
        return showHideStatusBar;
    }

}
