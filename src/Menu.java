import javax.swing.*;
import java.awt.*;

/**
 * Created by Korybut on 15.07.2017.
 */
class Menu extends JMenuBar {

    private JMenuItem newfile = new JMenuItem("Nowy plik");
    private JMenuItem save = new JMenuItem("Zapisz do pliku");
    private JMenuItem load = new JMenuItem("Wczytaj z pliku");
    private JMenuItem exit = new JMenuItem("Zakończ");

    private JMenuItem clear = new JMenuItem("Wyczyść pola");
    private JMenuItem random = new JMenuItem("Wypełnij losowo");
    private JMenuItem exchange = new JMenuItem("Zamień miejscami");


    private JMenuItem showHideStatusBar = new JMenuItem("Pokaż pasek stanu");

    private JMenuItem calculateAll = new JMenuItem("Oblicz wszystko");
    private JMenuItem onlyAdd = new JMenuItem("Tylko dodawanie");
    private JMenuItem onlySub = new JMenuItem("Tylko odejmowanie");
    private JMenuItem newParam = new JMenuItem("Add i Sub jako parametry");
    private JMenuItem onlyPositive = new JMenuItem("Losowe parametry dodatnie");
    private JMenuItem onlyNegative = new JMenuItem("Losowe parametry ujemne");

    Menu(){

        JMenu file = new JMenu("Plik");
        add(file);
        JMenu edit = new JMenu("Edycja");
        add(edit);
        JMenu view = new JMenu("Widok");
        add(view);
        JMenu options = new JMenu("Opcje");
        add(options);
        JMenu help = new JMenu("Pomoc");
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

        JMenu mode = new JMenu("Tryb...");
        view.add(mode);
        JMenuItem modeCalculator = new JMenuItem("Kalkulator");
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

        JMenuItem helper = new JMenuItem("Pomoc");
        help.add(helper);
        Image aboutIcon = new ImageIcon(this.getClass().getResource("/images/helper.png")).getImage()
                .getScaledInstance(20,20,Image.SCALE_SMOOTH);
        JMenuItem about = new JMenuItem("O programie");
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
