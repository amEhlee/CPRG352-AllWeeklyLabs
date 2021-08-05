/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import models.Role;

import java.util.ArrayList;



/**
 *
 * @author 856885
 */
public class RoleService {
    
    public ArrayList<Role> getAll()  {
        return new RoleDB().getAll();
    }
}
