package Cache;

import Controller.DbConnect;

public class Root {
    public static User user;
    public static DashData dash;
    public static Accounts accounts;
    public static Records records;
    public static DbConnect dbConnect;

    public Root(){
        user = new User();
        dash = new DashData();
        accounts = new Accounts();
        records = new Records();
        dbConnect = new DbConnect();
    }
}
