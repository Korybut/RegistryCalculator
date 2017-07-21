import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Korybut on 18.07.2017.
 */
public class StatusBar extends JComponent {

    private JLabel modeStatus = new JLabel(" Status trybu");
    private JLabel emptyStatus = new JLabel();
    private JLabel indexFieldStatus = new JLabel("0:0", SwingConstants.CENTER);
    private JLabel fileNameStatus = new JLabel("brak pliku tekstowego .txt ", SwingConstants.RIGHT);

    public StatusBar() {
        setLayout(null);
        Border barBorder = new EtchedBorder(EtchedBorder.RAISED);
        Font barFont = new Font("Arial", Font.BOLD, 11);

        add(modeStatus);
        modeStatus.setFont(barFont);
        modeStatus.setBounds(2,0,100,18);
        modeStatus.setBorder(barBorder);

        add(emptyStatus);
        emptyStatus.setBounds(104,0,200,18);
        emptyStatus.setBorder(barBorder);

        add(indexFieldStatus);
        indexFieldStatus.setFont(barFont);
        indexFieldStatus.setBounds(306,0,50,18);
        indexFieldStatus.setBorder(barBorder);

        add(fileNameStatus);
        fileNameStatus.setFont(barFont);
        fileNameStatus.setBounds(358,0,200,18);
        fileNameStatus.setBorder(barBorder);

    }

    public void setModeStatus(String txt) {
        modeStatus.setText(txt);
    }

    public void setIndexFieldStatus(String txt) {
        indexFieldStatus.setText(txt);
    }
}
