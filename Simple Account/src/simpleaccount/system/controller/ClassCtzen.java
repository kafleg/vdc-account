package simpleaccount.system.controller;

import simpleaccount.system.model.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassCtzen {

    public static void addCtzen(String id, String name, String address, String phone, String email, String ward_no) {
        dbConnection.runQuery("INSERT INTO `tbl_ctzen`(ctzen_id ,`name`, `address`, `phone`, `email`, `ward_no`) VALUES ("+id+",'" + name + "','" + address + "','" + phone + "','" + email + "','" + ward_no + "')");
    }

    public static ResultSet showCtzen(String txtSearch) {
        ResultSet s = null;
        String sql = "select * from tbl_ctzen where 1=1";
        if (txtSearch == "") {
        } else {
            sql += " and name like '%" + txtSearch + "%'";
        }
        s = dbConnection.getData(sql);
        return s;
    }

    public static String getEmployeeName(String ward_no) throws SQLException {
        String EmployeeName = "";
        ResultSet rs = dbConnection.getData("select * from tbl_usercustomer where ward_no='" + ward_no + "'");
        while (rs.next()) {
            EmployeeName = rs.getString("name");
        }
        return EmployeeName;
    }
}
