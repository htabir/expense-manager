package Elements;

import java.awt.*;

public class FontHelper extends Font {

    public FontHelper(int style, int size) {
        super("Outfit", 0, size);
        if (style == -1){
            super.name = "Outfit Thin";
        } else if (style == 0) {
            super.name = "Outfit Light";
        } else if (style == 2) {
            super.name = "Outfit Medium";
        } else if (style == 3) {
            super.name = "Outfit SemiBold";
        } else if (style == 4) {
            super.name = "Outfit Black";
        }
    }
}
