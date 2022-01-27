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
            return  false;
        }
        return false;
    }

    public Boolean addAccount(Root root, String title, String category, String bank, String balance){
        String query = "INSERT INTO `account` (`user`, `title`, `category`, `bank`, `type`, `balance`, `created_at`) VALUES ('"+root.user.id+"', '"+title+"', '"+category+"', '"+bank+"', 'debit', '"+balance+"', current_timestamp())";
//        System.out.println(query);
        try{
            int rs = statement.executeUpdate(query);
            System.out.println(rs);
        }catch (Exception e){
            return  false;
        }

        return true;
    }
}
