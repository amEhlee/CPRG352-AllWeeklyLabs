package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
           
                String body = "Successful login by " + user.getFirstName() + " on " + (new java.util.Date()).toString();
                GmailService.sendMail(email, "Successful Login", body, false);                
                /*
                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);
                */
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }

    public boolean forgotPassword(String email, String path) {
        try {
            System.out.println("zzz3");
            User user = new UserDB().get(email);

            if(user != null) {
                System.out.println("zzz4");
                String to = user.getEmail();
                String subject = "Note Keeper: Forgotten Password";
                String template = path;
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("username", user.getEmail());
                tags.put("password", user.getPassword());
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                
                GmailService.sendMail(to, subject, template, tags);  
                System.out.println("zzz5");
                return true;
            }

        } catch (Exception e) {
            //TODO: handle exception
        }


        return false;
    }
}
