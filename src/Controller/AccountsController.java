package Controller;

import Cache.Root;

import java.sql.SQLException;

public class AccountsController {
    public AccountsController(Root root){
        root.dbConnect = new DbConnect();
        fetchAccounts(root);
    }

    public void fetchAccounts(Root root){
        try {
            root.accounts.list = root.dbConnect.statement.executeQuery("SELECT * FROM `account` WHERE `user`=" + root.user.id);
        } catch (SQLException e) {
            root.accounts.list = null;
        }
    }
}
