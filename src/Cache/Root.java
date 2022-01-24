package Cache;

import Controller.DbConnect;

public class Root {
    public static User user;
    public static DashData dash;
    public static DbConnect dbConnect;

    public Root(){
        user = new User();
        dash = new DashData();
        dbConnect = new DbConnect();
    }
}
