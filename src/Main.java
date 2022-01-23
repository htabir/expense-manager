import Cache.Root;
import Controller.DbConnect;
import Pages.Auth;

public class Main {
    public static void main(String[] args) {
        Root root = new Root();
        new DbConnect();
        new Auth(root);
//        new Base(root);
    }
}
