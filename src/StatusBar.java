import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 18.07.2017.
 */
class StatusBar extends JComponent {

    private JLabel indexFieldStatus = new JLabel("0:0", SwingConstants.CENTER);
    private JLabel fileNameStatus = new JLabel("currently file is not saved ", SwingConstants.RIGHT);
    private JLabel modeStatus = new JLabel();
    private JLabel emptyStatus = new JLabel();
    private Font barFont = new Font("Arial", Font.BOLD, 11);
    private Border barBorder = new EtchedBorder(EtchedBorder.RAISED);

    StatusBar() {
        setLayout(null);

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

    public void updateDisplay(ResourceBundle res){
        modeStatus.setName(res.getString("mode"));
    }

    public void setIndexFieldStatus(String txt) { indexFieldStatus.setText(txt); }

    public String getFileNameStatus() {
        return fileNameStatus.getText();
    }

    public void setFileNameStatus(String name) {
        fileNameStatus.setText(name);
    }
}
