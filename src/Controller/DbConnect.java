package Controller;

import Cache.Root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnect {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public DbConnect() {
        try {
            // Local DB | Xampp
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensemanager", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }

    }

    public boolean login(Root root, String email, String password) {
        String query = "SELECT * FROM `user` WHERE `email`='" + email + "' AND `password`=PASSWORD('" + password + "')";
        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                root.user.id = Integer.parseInt(resultSet.getString(1));
                root.user.name = resultSet.getString(2);
                root.user.email = resultSet.getString(3);
                root.user.authenticated = true;
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public Boolean addAccount(Root root, String title, String category, String bank, String balance) {
        String query = "INSERT INTO `account` (`user`, `title`, `category`, `bank`, `type`, `balance`, `created_at`) VALUES ('" + root.user.id + "', '" + title + "', LOWER('" + category + "'), '" + bank + "', 'debit', '" + balance + "', current_timestamp())";
        try {
            int rs = statement.executeUpdate(query);
            query = "SELECT `id` FROM `account` WHERE `user` = " + root.user.id + " ORDER BY `id` DESC LIMIT 1";
            resultSet = statement.executeQuery(query);
            String ac = "";
            if (resultSet.next()) {
                ac = resultSet.getString(1);
            }
            query = "INSERT INTO `record` (`user`, `account`, `transfered_to`, `type`, `category`, `amount`, `note`, `created_at`) VALUES ('" + root.user.id + "', '" + ac + "', NULL, 'income', 'new account', '" + balance + "', NULL, current_timestamp())";
            rs = statement.executeUpdate(query);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public ResultSet fetchAccounts(Root root) {
        String query = "SELECT `id`, `title` FROM `account` WHERE `user`= " + root.user.id + " AND `status` = 1";
        try {
            resultSet = root.dbConnect.statement.executeQuery(query);
        } catch (Exception e) {
            resultSet = null;
        }
        return resultSet;
    }

    public Boolean addRecord(Root root, int account, String type, String category, int transferred_to, String amount) {
        try {
            String query;
            if (transferred_to != -1) {
                query = "INSERT INTO `record` (`user`, `account`, `transfered_to`, `type`, `category`, `amount`) VALUES ('" + root.user.id + "', '" + account + "', '" + transferred_to + "', LOWER('" + type + "'), LOWER('transfer | withdraw'), '" + amount + "')";
//                System.out.println(query);
                int rs = statement.executeUpdate(query);
                updateAccount(root, account, "-"+amount);
                updateAccount(root, transferred_to, "+"+amount);
            } else {
                query = "INSERT INTO `record` (`user`, `account`, `transfered_to`, `type`, `category`, `amount`) VALUES ('" + root.user.id + "', '" + account + "', NULL, LOWER('" + type + "'), LOWER('" + category + "'), '" + amount + "')";
//                System.out.println(query);
                int rs = statement.executeUpdate(query);
                if(type.contains("Expense")){
                    updateAccount(root, account, "-"+amount);
                }else{
                    updateAccount(root, account, "+"+amount);
                }
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateAccount(Root root, int account, String amount){
        try{
            String query = "UPDATE `account` SET `balance` = `balance`"+amount+" WHERE `id` = " + account;
            int rs = statement.executeUpdate(query);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
