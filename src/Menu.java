import javax.swing.*;
import java.awt.*;

/**
 * Created by Korybut on 15.07.2017.
 */
public class Menu extends JMenuBar {

    private JMenu file = new JMenu("Plik");
    private JMenu edit = new JMenu("Edycja");
    private JMenu view = new JMenu("Widok");
    private JMenu options = new JMenu("Opcje");
    private JMenu help = new JMenu("Pomoc");

    private JMenuItem newfile = new JMenuItem("Nowy plik");
    private JMenuItem save = new JMenuItem("Zapisz do pliku");
    private JMenuItem load = new JMenuItem("Wczytaj z pliku");
    private JMenuItem exit = new JMenuItem("Zakończ");

    private JMenuItem clear = new JMenuItem("Wyczyść pola");
    private JMenuItem random = new JMenuItem("Wypełnij losowo");
    private JMenuItem exchange = new JMenuItem("Zamień miejscami");


    private JMenu mode = new JMenu("Tryb...");
    private JMenuItem modeCalculator = new JMenuItem("Kalkulator");
    private JMenuItem modeTesterHex = new JMenuItem("Tester Hex");
    private JMenuItem showHideStatusBar = new JMenuItem("Pokaż pasek stanu");

    private JMenuItem calculateAll = new JMenuItem("Oblicz wszystko");
    private JMenuItem onlyAdd = new JMenuItem("Tylko dodawanie");
    private JMenuItem onlySub = new JMenuItem("Tylko odejmowanie");
    private JMenuItem newParam = new JMenuItem("Add i Sub jako parametry");
    private JMenuItem onlyPositive = new JMenuItem("Losowe parametry dodatnie");
    private JMenuItem onlyNegative = new JMenuItem("Losowe parametry ujemne");

    private JMenuItem helper = new JMenuItem("Pomoc");
    private JMenuItem checkUpdate = new JMenuItem("Sprawdź aktualizację");
    private JMenuItem about = new JMenuItem("O programie");

    public Menu(){

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
        mode.add(modeCalculator);
        modeCalculator.setEnabled(false);
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
    }

    public JMenuItem getNewfile() {
        return newfile;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getLoad() {
        return load;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getClear() {
        return clear;
    }

    public JMenuItem getRandom() {
        return random;
    }

    public JMenuItem getExchange() {
        return exchange;
    }

    public JMenuItem getMode() {
        return mode;
    }

    public JMenuItem getModeCalculator() {
        return modeCalculator;
    }

    public JMenuItem getModeTesterHex() {
        return modeTesterHex;
    }

    public JMenuItem getShowHideStatusBar() {
        return showHideStatusBar;
    }

    public JMenuItem getCalculateAll() {
        return calculateAll;
    }

    public JMenuItem getOnlyAdd() {
        return onlyAdd;
    }

    public JMenuItem getOnlySub() {
        return onlySub;
    }

    public JMenuItem getNewParam() {
        return newParam;
    }

    public JMenuItem getOnlyPositive() {
        return onlyPositive;
    }

    public JMenuItem getOnlyNegative() {
        return onlyNegative;
    }

    public JMenuItem getHelper() {
        return helper;
    }

    public JMenuItem getCheckUpdate() {
        return checkUpdate;
    }

    public JMenuItem getAbout() {
        return about;
    }
}
