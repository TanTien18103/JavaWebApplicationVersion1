/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

import BasicObject.User;
import MyLib.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 84398
 */
public class UserDao {

    public static User getUser(String userid, String password) throws Exception {
        User u = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select userID, fullName, roleID, password from dbo.tblUsers where userID = ? and password = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, userid);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("userID");
                    String name = rs.getString("fullName");
                    String role = rs.getString("roleID");
                    u = new User(userid, name, role, password);
                }
            }
            cn.close();
        }
        return u;
    }
}
