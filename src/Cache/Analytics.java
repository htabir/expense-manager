package Cache;

import java.sql.ResultSet;

public class Analytics {
    public int period;
    public String param;
    public ResultSet list;
    public int total;
    public Analytics(){
        total = 0;
        param = "*";
        period = 1;
    }
}
