import Cache.Root;
import Pages.Base;

public class Main {
    public static void main(String[] args) {
//        new DbConnect();
        Root root = new Root();
//        new Auth(root);
        new Base(root);
    }
}
