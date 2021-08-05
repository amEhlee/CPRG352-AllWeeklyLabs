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
import models.User;

/**
 *
 * @author 856885
 */
public class UserDB {

    // setup connection and grab connection from the pool
    private ConnectionPool conPool = ConnectionPool.getInstance();
    private Connection con = conPool.getConnection();

    // instantiate ps and rs for later
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    
    /**
     * Returns all the users found in the sql database
     * @return
     */
    public ArrayList<User> getAll() {
        // initalize arraylist to return later
        ArrayList<User> givenUsers = new ArrayList<User>();
        
        // Given query for prepared statement
        String query = "SELECT * from user";

        try {
            // setup result set and prepared statement for later
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            // loop through the result set and make new role objects
            while (rs.next()) {
                String email = rs.getString(1), 
                       fname = rs.getString(3),
                       lname = rs.getString(4),
                       pass = rs.getString(5);
                
                Boolean active = rs.getBoolean(2);
                Role role = (Role) rs.getObject(6);

                givenUsers.add( new User(email, active, fname, lname, pass, role));
            }
            
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            conPool.freeConnection(con);
        }


        return givenUsers;
    }

    /*
    public void addUser(User givenUser) {
        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // setup result set and prepared statement for later
            ps = con.prepareStatement(query);

            // change statement to fit given attributes
            ps.setString(1,givenUser.getEmail());
            ps.setBoolean(2,givenUser.getActive());
            ps.setString(3,givenUser.getFirstName());
            ps.setString(4,givenUser.getLastName());
            ps.setString(5,givenUser.getPassword());
            ps.setObject(6,givenUser.getRole());

            // execute the update to user table
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            //TODO: handle exception
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            conPool.freeConnection(con);
        }
    }

    public void editUser(User givenUser) {
        try {
            // setup result set and prepared statement for later
            ps = con.prepareStatement(query);
            ps.setString(1, givenEmail);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            //TODO: handle exception
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            conPool.freeConnection(con);
        }
        
    }

    public void deleteUser(String givenEmail) {
        String query = "DELETE FROM user WHERE email = ?";

        try {
            // setup result set and prepared statement for later
            ps = con.prepareStatement(query);
            ps.setString(1, givenEmail);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            //TODO: handle exception
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            conPool.freeConnection(con);
        }
    }
    */
}
