/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Xavier
 */
public class AccountService {
    public User login(String username, String password) {
        
        User user = new User(username);
        
        if(username.equals("abe") && password.equals(user.getPassword())) {
            return user;
        }
        else if (username.equals("barb") && password.equals(user.getPassword())) {
            return user;
        }
        
        return null;
    }
}
