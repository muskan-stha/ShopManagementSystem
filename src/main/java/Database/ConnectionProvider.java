/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Muskan
 */
import java.sql.*;
public class ConnectionProvider
{
    public static Connection getCon()
    {
        String url="jdbc:mysql://localhost:3306/shop_management_system";
        String uname="root";
        String pwd="";
        Connection con = null;
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection(url,uname,pwd);
  /*  if (con!= null)
    {
                System.out.println("Connected to the database");
            }*/
        }catch(Exception e)
        {
             return null;
        }
        return con;
    }
}