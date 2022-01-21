package Cache;

public class User {
    private int user_id;
    private String  email;
    private boolean authenticated;

    public User(){
        authenticated = false;
    }

    public boolean isAuthenticated(){
        return this.authenticated;
    }

}
