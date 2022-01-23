package Elements;

import javax.swing.*;

public class Line extends JPanel {
    public Line(int width){
        ImagePanel img = new ImagePanel("D:\\kodes\\Java\\New folder\\ExpenseManager\\src\\Assets\\image\\line.png", width, 1);
        img.setBounds(0, 0, width, 1);
        add(img);
    }
}
