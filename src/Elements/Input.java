package Elements;

import Assets.Styles;

import javax.swing.*;
import java.awt.*;

public class Input extends JPanel{
    private JLabel label;
    private JPasswordField field;
    private String type;
    private int width;
    private Color background;
    public Input(Color background){
        Styles styles = new Styles();
        this.background = background;
        setLayout(null);
        if(background == styles.background){
            setBackground(styles.white);
        }else {
            setBackground(styles.background);
        }
        type = "text";
        width = 100;


        label = new JLabel("Label");
        styles.labelStyling(label, styles.typo, styles.LIGHT, 16);
        add(label);
        label.setBounds(0, 0, width, 20);

        field = new JPasswordField();
        styles.passwordFieldStyling(field, styles.typo, this.background, styles.REGULAR, 18);
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
            new Styles().passwordFieldStyling(field, new Styles().typo, this.background, Font.PLAIN, 18);
        }else if(type=="password"){
            field.setEchoChar('•');
            new Styles().passwordFieldStyling(field, new Styles().typo, this.background, Font.BOLD, 18);
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

    public void required(int x){
        Styles styles = new Styles();
        JLabel req = new JLabel("*");
        styles.labelStyling(req, styles.red, styles.MEDIUM, 16);
        this.add(req);
        req.setBounds(x, 0, 8, 20);
    }

    public void setValue(String value){
        field.setText(value);
    }

}
