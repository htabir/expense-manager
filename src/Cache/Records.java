package Cache;

import java.sql.ResultSet;

public class Records {
    public int state;
    public String param;
    public ResultSet list;
    public int total;

    public Records() {
        total = 0;
        state = 1;
        param = "*";
    }
}
