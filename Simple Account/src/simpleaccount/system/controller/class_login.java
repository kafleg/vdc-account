package simpleaccount.system.controller;

import simpleaccount.system.model.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class class_login {

    public static boolean isLogin(String userName, String Password) {
        int count = dbConnection.getRowCount("select * from tbl_user where user_name='" + userName + "' and user_password='" + Password + "'");
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String getUserType(String userName) throws SQLException {
        ResultSet rs = dbConnection.getData("select * from tbl_user where user_name='" + userName + "'");
        String UserType = "";
        while (rs.next()) {
            UserType = rs.getString("user_type");
        }
        return UserType;
    }
}
