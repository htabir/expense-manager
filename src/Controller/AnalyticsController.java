package Controller;

import Cache.Root;

import java.sql.SQLException;

public class AnalyticsController {
    public AnalyticsController(Root root) {
        root.dbConnect = new DbConnect();
        fetchAnalytics(root);
    }

    public void fetchAnalytics(Root root) {
        String query = "SELECT initcap(`category`), `type`, SUM(`amount`) as 'total' FROM `record` WHERE `created_at` BETWEEN NOW() - INTERVAL " + root.analytics.period + " DAY AND NOW() AND `transfered_to` IS NULL AND `user` = " + root.user.id;
        if (root.analytics.param.contains("expense")) {
            query += " AND LOWER(`type`) = 'expense'";
        } else if (root.analytics.param.contains("income")) {
            query += " AND LOWER(`type`) = 'income'";
        }
        query += " GROUP BY `category`";
        System.out.println(query);
        try {
            root.analytics.list = root.dbConnect.statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("failed");
            root.analytics.list = null;
        }
    }
}
