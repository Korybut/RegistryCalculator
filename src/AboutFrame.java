import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Korybut on 25.07.2017.
 */
class AboutFrame extends JFrame {

    private Image logo = new ImageIcon(this.getClass().getResource("/images/icon.png")).getImage()
            .getScaledInstance(80,80,Image.SCALE_SMOOTH);

    AboutFrame() throws HeadlessException {
        super("O Programie");
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocation(getSize().width/2+500, getSize().height/2+190);
        setSize(260,320);
        setResizable(false);
        setVisible(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/helper.png"))
                .getScaledInstance(20,20,Image.SCALE_SMOOTH));

        JLabel logoLabel = new JLabel(new ImageIcon(logo));
        add(logoLabel);
        logoLabel.setBounds(10,10,80,80);

        JLabel nameTitle = new JLabel("<html>Registry<br></br>Calculator v.1.0</html>");
        add(nameTitle);
        nameTitle.setBounds(100,30,150,40);
        nameTitle.setFont(new Font("Corbel", Font.BOLD, 17));

        JLabel labelInfo = new JLabel("<html>Created by Łukasz Krzewiński<br></br>version 1.0<br></br>last built. 25.07.2017</html>");
        labelInfo.setBounds(20,70,180,160);
        labelInfo.setFont(new Font("Corbel", Font.PLAIN, 15));
        add(labelInfo);

        try {
            URI uri = new URI("https://github.com/Korybut/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        JLabel labelMore = new JLabel("<html>more on: https://github.com/Korybut<br></br><br></br>2017 Open-Source<html>");
        labelMore.setBounds(20,190,185,80);
        labelMore.setFont(new Font("Corbel", Font.PLAIN, 14));
        add(labelMore);
    }
}
