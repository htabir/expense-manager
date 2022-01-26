package Cache;

import java.sql.ResultSet;

public class Accounts {
    public ResultSet list;
    public String param;
    public int total;

    public Accounts() {
        this.param = "*";
        total = 0;
    }
}
