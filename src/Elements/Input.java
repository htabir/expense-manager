package Elements;

import Assets.Styles;

import javax.swing.*;
import java.awt.*;

public class Input extends JPanel{
    private JLabel label = new JLabel("Label");
    private JPasswordField field = new JPasswordField();
    private String type = "text";
    private int width = 100;
    public Input(){
        Styles styles = new Styles();

        setLayout(null);
        setBackground(styles.background);

        styles.labelStyling(label, styles.typo, styles.LIGHT, 14);
        add(label);
        label.setBounds(0, 0, width, 20);

        styles.passwordFieldStyling(field, styles.typo, styles.REGULAR, 18);
        field.setEchoChar((char) 0);
        add(field);
        field.setBounds(0, 28, width, 48);
    }

    public void setLabel(String label){
        this.label.setText(label);
    }

    public String getText(){
        if(type=="text")    return String.valueOf(field.getPassword());
        return null;
    }

    public String getPassword(){
        if(type!="text")    return String.valueOf(field.getPassword());
        return null;
    }

    public void setWidth(int width){
        this.width = width;
        label.setSize(this.width, 17);
        field.setSize(this.width, 40);
    }

    public void setBounds(int x, int y){
        super.setBounds(x, y, this.width, 77);
    }

    public void setType(String type){
        this.type = type;
        if(type == "text"){
            field.setEchoChar((char) 0);
            new Styles().passwordFieldStyling(field, new Styles().typo, Font.PLAIN, 18);
        }else if(type=="password"){
            field.setEchoChar('•');
            new Styles().passwordFieldStyling(field, new Styles().typo, Font.BOLD, 18);
        }
    }

    public boolean isEmpty(){
        String value = type=="text"? this.getText() : this.getPassword();
        if(value.length()<=0){
            return true;
        }
        return false;
    }

    public void setDefault(){
        new Styles().defaultInputField(field);
    }

    public void setDanger(){
        new Styles().dangerInputField(field);
    }
}
