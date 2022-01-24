package Controller;

import Cache.Root;

import java.sql.SQLException;

public class DashboardController {
    public DashboardController(Root root) {
        root.dash.cash = countTotalCash(root);
        root.dash.bank = countTotalBank(root);
        root.dash.mobile = countTotalMobile(root);
    }

    public int countTotalCash(Root root) {
        int cash = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='cash'");
            while (root.dbConnect.resultSet.next()) {
                cash += Integer.parseInt(root.dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cash;
    }

    public int countTotalBank(Root root) {
        int bank = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='bank'");
            while (root.dbConnect.resultSet.next()) {
                bank += Integer.parseInt(root.dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }

    public int countTotalMobile(Root root) {
        int mobile = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='mobile'");
            while (root.dbConnect.resultSet.next()) {
                mobile += Integer.parseInt(root.dbConnect.resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
    }
}
