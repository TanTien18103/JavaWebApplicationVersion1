/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessDatabase;

import BasicObject.Food;
import MyLib.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 84398
 */
public class FoodDao {

    public static ArrayList<Food> GetAllFood() throws Exception {
        Connection cn = DBUtils.makeConnection();
        ArrayList<Food> list = new ArrayList<>();
        if (cn != null) {
            String sql = "select id,name,description,price,cookingTime,status from dbo.tblFoods";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int time = rs.getInt("cookingTime");
                    boolean status = rs.getBoolean("status");
                    Food f = new Food(id, name, description, price, time, status);
                    list.add(f);
                }
            }
        }
        return list;
    }

    public static int AddFood(String id, String name, String des, String price, String time, String status) throws Exception {
        Connection cn = DBUtils.makeConnection();
        int rs = 0;
        if (cn != null) {
            String sql = "insert dbo.tblFoods values (?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, des);
            pst.setString(4, price);
            pst.setString(5, time);
            pst.setString(6, status);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }

}
