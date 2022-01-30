package Elements;

import Assets.Styles;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ComboInput extends JPanel {
    private JLabel label;
    public JComboBox comboBox;
    private int width;
    public ComboInput(String[] options){
        Styles styles = new Styles();
        setLayout(null);
        setBackground(styles.white);
        width = 100;

        label = new JLabel("Label");
        styles.labelStyling(label, styles.typo, styles.LIGHT, 16);
        add(label);
        label.setBounds(0, 0, width, 20);

        comboBox = new JComboBox(options);
        add(comboBox);
        comboBox.setBackground(styles.background);
        comboBox.setBorder(new LineBorder(styles.grey));
        comboBox.setFont(new FontHelper(styles.REGULAR, 16));
        comboBox.setBounds(0, 28, width, 48);
    }

    public void setLabel(String label){
        this.label.setText(label);
    }

    public void setWidth(int width){
        this.width = width;
        label.setSize(this.width, 17);
        comboBox.setSize(this.width, 40);
    }

    public void setBounds(int x, int y){
        super.setBounds(x, y, this.width, 77);
    }

    public String getText(){
        return (String) comboBox.getSelectedItem();
    }

    public void required(int x){
        Styles styles = new Styles();
        JLabel req = new JLabel("*");
        styles.labelStyling(req, styles.red, styles.MEDIUM, 16);
        this.add(req);
        req.setBounds(x, 0, 8, 20);
    }

    public int getIndex(){
        return comboBox.getSelectedIndex();
    }

    public void removeLevel(){
        this.remove(label);
    }
}
