package Cache;

import java.sql.ResultSet;

public class DashData {
    public int cash;
    public int bank;
    public int mobile;
    public int income;
    public int expense;
    public int income_old;
    public int expense_old;
    public ResultSet recordSet;

    public DashData(){
        income = expense = income_old = expense_old = 0;
    }
}
