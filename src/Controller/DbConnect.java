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
            // Remote DB | Hostinger
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://151.106.117.0:3306/u438744503_expenseManager", "u438744503_boruto", "Rasenshurik3n");
            // Local DB | Xampp
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensemanager", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }

    }

    public boolean login(Root root, String email, String password) {
        String query = "SELECT * FROM `user` WHERE `email`='"+ email +"' AND `password`=PASSWORD('"+ password +"')";
        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                root.user.id = Integer.parseInt(resultSet.getString(1));
                root.user.name = resultSet.getString(2);
                root.user.email = resultSet.getString(3);
                root.user.authenticated = true;
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
            return  false;
        }
        return false;
    }
}
