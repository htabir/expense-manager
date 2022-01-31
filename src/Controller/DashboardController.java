package Controller;

import Cache.Root;

import java.sql.SQLException;

public class DashboardController {
    public DashboardController(Root root) {
        root.dbConnect = new DbConnect();
        countTotalCash(root);
        countTotalBank(root);
        countTotalMobile(root);
        calculateCashFlow(root);
    }

    public void countTotalCash(Root root) {
        int cash = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='cash'");
            while (root.dbConnect.resultSet.next()) {
                cash += Integer.parseInt(root.dbConnect.resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        root.dash.cash = cash;
    }

    public void countTotalBank(Root root) {
        int bank = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='bank'");
            while (root.dbConnect.resultSet.next()) {
                bank += Integer.parseInt(root.dbConnect.resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        root.dash.bank = bank;
    }

    public void countTotalMobile(Root root) {
        int mobile = 0;
        try {
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id + " AND `category`='mobile'");
            while (root.dbConnect.resultSet.next()) {
                mobile += Integer.parseInt(root.dbConnect.resultSet.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        root.dash.mobile = mobile;
    }

    public void calculateCashFlow(Root root) {
        try {
            String query = "SELECT `type`, SUM(`amount`) as 'total', `user` FROM `record` WHERE `transfered_to` IS NULL AND `user` = '" + root.user.id + "' AND `created_at` BETWEEN NOW() - INTERVAL 30 DAY AND NOW() GROUP BY `type`";
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery(query);
            while (root.dbConnect.resultSet.next()) {
                if (root.dbConnect.resultSet.getString(1).contains("income")) {
                    root.dash.income = Integer.parseInt(root.dbConnect.resultSet.getString(2));
                } else {
                    root.dash.expense = Integer.parseInt(root.dbConnect.resultSet.getString(2));
                }
            }

            query = "SELECT `type`, SUM(`amount`) as 'total', `user` FROM `record` WHERE `transfered_to` IS NULL AND `user` = '" + root.user.id + "' AND `created_at` BETWEEN NOW() - INTERVAL 60 DAY AND NOW() - INTERVAL 30 DAY GROUP BY `type`";
            root.dbConnect.resultSet = root.dbConnect.statement.executeQuery(query);
            while (root.dbConnect.resultSet.next()) {
                if (root.dbConnect.resultSet.getString(1).contains("income")) {
                    root.dash.income_old = Integer.parseInt(root.dbConnect.resultSet.getString(2));
                } else {
                    root.dash.expense_old = Integer.parseInt(root.dbConnect.resultSet.getString(2));
                }
            }

        } catch (Exception e) {
            System.out.println("failed");
        }
    }


}
