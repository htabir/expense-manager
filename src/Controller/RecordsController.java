package Controller;

import Cache.Root;

import java.sql.SQLException;

public class RecordsController {
    public RecordsController(Root root){
        root.dbConnect = new DbConnect();
        fetchRecords(root);
    }

    public void fetchRecords(Root root){
        String query = "SELECT initcap(`record`.`category`), `account`.`title`, `record`.`type`, `record`.`amount` FROM `record` LEFT JOIN `account` on `record`.`account` = `account`.`id` WHERE `record`.`user` = " + root.user.id;

        if(root.records.param.contains("expense")){
            query += " AND LOWER(`record`.`type`) = 'expense'";
        }else if(root.records.param.contains("income")){
            query += " AND LOWER(`record`.`type`) = 'income'";
        }
        root.records.param = "*";

        query += " ORDER BY `record`.`id` DESC";
        try {
            root.records.list = root.dbConnect.statement.executeQuery(query);
        } catch (SQLException e) {
            root.records.list = null;
        }
    }

}
