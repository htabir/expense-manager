import Cache.Root;
import Pages.Auth;

public class Main {
    public static void main(String[] args) {
//        new DbConnect();
        Root root = new Root();
        new Auth(root);
    }
}
