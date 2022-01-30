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

        try {
            root.records.list = root.dbConnect.statement.executeQuery(query);
        } catch (SQLException e) {
            root.records.list = null;
        }
    }

}
