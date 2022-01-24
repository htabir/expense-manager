package Controller;

import Cache.Root;

import java.sql.SQLException;

public class DashboardController {
    public DashboardController(Root root) {
        DbConnect dbConnect = new DbConnect();
        root.dash.cash = countTotalCash(root.user.id, dbConnect);
        root.dash.bank = countTotalBank(root.user.id, dbConnect);
        root.dash.mobile = countTotalMobile(root.user.id, dbConnect);
    }

    public int countTotalCash(int user, DbConnect dbConnect) {
        int cash = 0;
        try {
            dbConnect.resultSet = dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + user + " AND `category`='cash'");
            while (dbConnect.resultSet.next()) {
                cash += Integer.parseInt(dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cash;
    }

    public int countTotalBank(int user, DbConnect dbConnect) {
        int bank = 0;
        try {
            dbConnect.resultSet = dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + user + " AND `category`='bank'");
            while (dbConnect.resultSet.next()) {
                bank += Integer.parseInt(dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }

    public int countTotalMobile(int user, DbConnect dbConnect) {
        int mobile = 0;
        try {
            dbConnect.resultSet = dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + user + " AND `category`='mobile'");
            while (dbConnect.resultSet.next()) {
                mobile += Integer.parseInt(dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
    }
}
