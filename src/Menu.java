import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 15.07.2017.
 */
class Menu extends JMenuBar {

    private JMenu file = new JMenu();
    private JMenu edit = new JMenu();
    private JMenu view = new JMenu();
    private JMenu options = new JMenu();
    private JMenu help = new JMenu();
    private JMenu mode = new JMenu();
    private JMenu language = new JMenu();
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
    private JMenuItem modeCalculator = new JMenuItem();
    private JMenuItem helper = new JMenuItem();
    private JMenuItem about = new JMenuItem();
    private JMenuItem modeTesterHex = new JMenuItem("Tester Hex");

    Menu(){

        add(file);
        add(edit);
        add(view);
        add(options);
        add(help);

        addItemIcon(newfile,"/images/newfile.png");
        addItemIcon(save,"/images/save.png");
        addItemIcon(load,"/images/load.png");
        addItemIcon(exit,"/images/close.png");
        addItemIcon(clear,"/images/clear.png");
        addItemIcon(random,"/images/random.png");
        addItemIcon(exchange,"/images/exchange.png");
        addItemIcon(calculateAll,"/images/calculate.png");
        addItemIcon(newParam,"/images/newparam.png");
        addItemIcon(onlyPositive,"/images/positive.png");
        addItemIcon(onlyNegative,"/images/negative.png");
        addItemIcon(helper,"/images/helper.png");

        calculateAll.setAccelerator(KeyStroke.getKeyStroke("ctrl A"));
        newParam.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        save.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        newfile.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        clear.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));

        file.add(newfile);
        file.add(save);
        file.add(load);
        file.insertSeparator(3);
        file.add(exit);
        edit.add(clear);
        edit.add(random);
        edit.add(exchange);
        view.add(mode);
        view.add(language);
        language.add(polski);
        language.add(english);
        mode.add(modeCalculator);
        modeCalculator.setEnabled(false);
        mode.add(modeTesterHex);
        view.add(showHideStatusBar);
        options.add(calculateAll);
        options.add(onlyAdd);
        options.add(onlySub);
        options.insertSeparator(3);
        options.add(newParam);
        options.add(onlyPositive);
        options.add(onlyNegative);
        help.add(helper);
        help.add(about);
        about.addActionListener(e -> new AboutFrame());
    }

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

    public void addItemIcon(JMenuItem item, String str){
        item.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource(str)).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH)));
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
