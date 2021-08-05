/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Role;

/**
 *
 * @author 856885
 */
public class RoleDB {
    
    public ArrayList<Role> getAll() {
        // initalize arraylist to return later
        ArrayList<Role> givenRoles = new ArrayList<Role>();
        
        // setup connection and grab connection from the pool
        ConnectionPool conPool = ConnectionPool.getInstance();
        Connection con = conPool.getConnection();

        // instantiate ps and rs for later
        PreparedStatement ps = null;
        ResultSet rs = null;

        // statement 
        String query = "SELECT * from role";

        try {
            // setup result set and prepared statement for later
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            // loop through the result set and make new role objects
            while (rs.next()) {
                givenRoles.add( new Role(rs.getInt(0), rs.getString(1)));
            }
            
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            conPool.freeConnection(con);
        }


        return givenRoles;
    }
}
