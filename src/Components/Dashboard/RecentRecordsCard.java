package Components.Dashboard;

import Assets.Styles;
import Elements.Line;

import javax.swing.*;

public class RecentRecordsCard extends JPanel {
    public RecentRecordsCard(){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);

        JLabel header = new JLabel("Recent Records");
        styles.labelStyling(header, styles.typo, styles.REGULAR, 16);
        add(header);
        header.setBounds(16, 8, 412, 20);

        Line line = new Line(412);
        add(line);
        line.setBounds(16, 36, 412, 1);
    }
}
