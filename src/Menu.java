import javax.swing.*;

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
    private JMenuItem onlyNegtive = new JMenuItem("Losowe parametry ujemne");

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
        file.add(save);
        file.add(load);
        file.add(exit);

        edit.add(clear);
        edit.add(random);
        edit.add(exchange);

        view.add(mode);
        mode.add(modeCalculator);
        modeCalculator.setEnabled(false);
        mode.add(modeTesterHex);
        view.add(showHideStatusBar);

        options.add(calculateAll);
        options.add(onlyAdd);
        options.add(onlySub);
        options.add(newParam);
        options.add(onlyPositive);
        options.add(onlyNegtive);

        help.add(helper);
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

    public JMenuItem getOnlyNegtive() {
        return onlyNegtive;
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
