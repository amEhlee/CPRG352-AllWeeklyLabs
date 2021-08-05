/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 856885
 */
public class UserService {
    
    public ArrayList<User> getAll()  {
        return new UserDB().getAll();
    }
}
