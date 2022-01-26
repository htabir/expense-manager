package Controller;

import Cache.Root;

import java.sql.SQLException;

public class AccountsController {
    public AccountsController(Root root){
        root.dbConnect = new DbConnect();
        fetchAccounts(root);
    }

    public void fetchAccounts(Root root){
        String query = "SELECT * FROM `account` WHERE `user`=" + root.user.id;
        if(root.accounts.param.contains("cash")){
            query+= " AND `category`='cash'";
        }else if(root.accounts.param.contains("bank")){
            query+= " AND `category`='bank'";
        }
        else if(root.accounts.param.contains("mobile")){
            query+= " AND `category`='mobile'";
        }
        root.accounts.param = "*";
        try {
            root.accounts.list = root.dbConnect.statement.executeQuery(query);
        } catch (SQLException e) {
            root.accounts.list = null;
        }
    }
}
