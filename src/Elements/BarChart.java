package Elements;

import Assets.Styles;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {
    public BarChart(int width, Color color, float percentage){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.background);
        setSize(width, 32);

        JPanel bar = new JPanel();
        bar.setLayout(null);
        bar.setBackground(color);
        add(bar);
        bar.setBounds(0, 0, (int)(width*percentage), 32);
    }
}
