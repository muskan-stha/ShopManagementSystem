/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author Muskan
 */
import Tabs.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.product;
import model.Supplier;
import model.customerm;


public class productDB 
{
    
    public static void add(product product)
    {
        String query="insert into Products(ProdName,Price,Quantity,Company) values('"+product.getProdName()+"','"+product.getPrice()+"','"+product.getQty()+"','"+product.getCompany()+"')";
        DbOperations.setDataOrDelete(query,"Product has been added successfully");
        
    }
    
    /*public static void Update(product product)
    {
        String query="update Products set prodName=?, price=?,quantity=?, company=?";
        DbOperations.setDataOrDelete(query,"product has been updated successfully");
    }*/
    
    
    /*public static void update(product product)
    {
        String query="update Products set id=?, ProdName=?, Price=?, Quantity=?, Comapany=?;");
        
        DbOperations .setDataOrDelete(query,"Product Updated Successfully!");
    }*/
    public static void addSup(Supplier supplier)
    {
        String query="insert into Suppliers(SupplierName,Phone,AmountPaid,AmountPayable) values('"+supplier.getsName()+"','"+supplier.getPhone()+"','"+supplier.getAmtPaid()+"','"+supplier.getAmtPayable()+"')";
        DbOperations.setDataOrDelete(query,"Supplier has been added successfully");
        
    }
    public static void addCus(customerm customer)
    {
        String query="insert into Customer(CustomerName,AmountReceived,AmountReceivable,Phone) values('"+customer.getcName()+"','"+customer.getAmtReceived()+"','"+customer.getAmtReceivable()+"','"+customer.getPhone()+"')";
        DbOperations.setDataOrDelete(query,"Customer has been added successfully");
    }
}
