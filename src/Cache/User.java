package Cache;

public class User {
    public int id;
    public String  name;
    public String  email;
    public boolean authenticated;

    public User(){
        authenticated = false;
    }

    public boolean isAuthenticated(){
        return this.authenticated;
    }

}
