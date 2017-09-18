import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 15.07.2017.
 */
class Menu extends JMenuBar {

    ResourceBundle bundle = Localization.bundle;

    private JMenuItem newfile = new JMenuItem(bundle.getString("newfile"));
    private JMenuItem save = new JMenuItem(bundle.getString("save"));
    private JMenuItem load = new JMenuItem(bundle.getString("load"));
    private JMenuItem exit = new JMenuItem(bundle.getString("exit"));

    private JMenuItem clear = new JMenuItem(bundle.getString("clear"));
    private JMenuItem random = new JMenuItem(bundle.getString("random"));
    private JMenuItem exchange = new JMenuItem(bundle.getString("exchange"));

    private JMenuItem polski = new JMenuItem("Polski");
    private JMenuItem english = new JMenuItem("English");
    private JMenuItem showHideStatusBar = new JMenuItem(bundle.getString("hideshow_stat"));

    private JMenuItem calculateAll = new JMenuItem(bundle.getString("calculateAll"));
    private JMenuItem onlyAdd = new JMenuItem(bundle.getString("onlyAdd"));
    private JMenuItem onlySub = new JMenuItem(bundle.getString("onlySub"));
    private JMenuItem newParam = new JMenuItem(bundle.getString("newParam"));
    private JMenuItem onlyPositive = new JMenuItem(bundle.getString("onlyPositive"));
    private JMenuItem onlyNegative = new JMenuItem(bundle.getString("onlyNegative"));

    Menu(){

        JMenu file = new JMenu(bundle.getString("file"));
        add(file);
        JMenu edit = new JMenu(bundle.getString("edit"));
        add(edit);
        JMenu view = new JMenu(bundle.getString("view"));
        add(view);
        JMenu options = new JMenu(bundle.getString("options"));
        add(options);
        JMenu help = new JMenu(bundle.getString("help"));
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

        JMenu mode = new JMenu(bundle.getString("mode_dots"));
        view.add(mode);

        JMenu language = new JMenu(bundle.getString("lang"));
        view.add(language);

        language.add(polski);
        language.add(english);

        JMenuItem modeCalculator = new JMenuItem(bundle.getString("calculator"));
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

        JMenuItem helper = new JMenuItem(bundle.getString("help"));
        help.add(helper);
        Image aboutIcon = new ImageIcon(this.getClass().getResource("/images/helper.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        JMenuItem about = new JMenuItem(bundle.getString("about"));
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
