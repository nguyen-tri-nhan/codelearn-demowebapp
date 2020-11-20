/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.dtos.UserDTO;
import com.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class UserDAO {
    private Connection conn = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    public UserDTO checkLogin(String ID, String password) throws SQLException, Exception {
        UserDTO result = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                
                String sql = "SELECT userid , fullname , password , roleid"
                        + " FROM tblUsers WHERE userid = ? AND password = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, ID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new UserDTO(rs.getString("userid"),
                            rs.getString("fullname"),
                            "***", rs.getInt("roleid"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
