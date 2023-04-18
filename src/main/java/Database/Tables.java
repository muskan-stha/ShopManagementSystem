/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Muskan
 */
import javax.swing.*;
public class Tables 
{
    public static void main(String[] args)
    {
        try
        {
           String userTable; 
            userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(50))";
           DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
