/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Muskan
 */
import Database.user;
import javax.swing.JOptionPane;
import java.sql.*;
import Database.DbOperations;
import login.Login;
public class UserDb
{
    public static void save(user user)
    {
        String query="insert into user(name,password,email,phone,address,status) values('"+user.getName()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getPhone()+"','"+user.getAddress()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered Sucessfully");
    }
    
    public static user login(String uname, String password)
    {
        user user=null;
        try
        {
            ResultSet rs=DbOperations.getData("select * from user where uname='"+txtuname+"' and password='"+txtpassword+"'");
            while(rs.next())
            {
                user=new user();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
}
