/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tabs;

import Database.productDB;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import login.Login;
import model.customerm;

/**
 *
 * @author Muskan
 */
public class Billing extends javax.swing.JFrame {

    /**
     * Creates new form Billing
     */
    public Billing() {
        initComponents();
        showTable();
        btnAdd.setEnabled(false);
        setScreenFull();
    }
    public void setScreenFull()
    {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xs=(int)tk.getScreenSize().getWidth();
        int ys=(int)tk.getScreenSize().getHeight();
        Insets scnMax=Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBarSize=scnMax.bottom;
    
        this.setSize(xs,ys);
    }
    
    public void validateFields() {
        String names = name.getText();
        String productName = prodName.getText();
        if (!names.equals("") && !productName.equals("")) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }

    }
    
    /*public void updateProduct()
    {
        try   
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            //String query="UPDATE Products SET ProdName='" + prodName.getText() + "',Price=" + price.getText() + "',Quantity=" + qty.getText() + "',Company=" + comp.getText() + " ' WHERE id=" + id.getText() + "";
             Statement st=con.createStatement();
            String sql1="select * from products";
            ResultSet rs=st.executeQuery(sql1);
            while(rs.next())
            {
             int oqty=Integer.valueOf(rs.getInt("Quantity"));
             int q=oqty-Integer.valueOf(qty.getText());
             String sql = "UPDATE Products SET Quantity=?, WHERE id=?";
 
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,Integer.toString(q));
            statement.setString(2, id.getText());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
            {
                JOptionPane.showMessageDialog(this,"Product Updated Successfully");
            }  
            }
            
            
            
            showTable();
        }catch(Exception ex)
        {
            System.out.println(ex);
        } 
        
    }*/
    
    public void showTable()
    {
        try 
        {
            // TODO add your handling code here:
           // JTable prodTb = productTable;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            Statement st=con.createStatement();
            String sql="select * from products";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                String id=String.valueOf(rs.getInt("id"));
                String ProductName=rs.getString("ProdName");
                String Price=String.valueOf(rs.getInt("Price"));
                String Quantity=String.valueOf(rs.getInt("Quantity"));
                String Company=String.valueOf(rs.getString("Company"));
                
                String tblData[]={id,ProductName,Price,Quantity,Company};
                DefaultTableModel tbleModel;
                tbleModel = (DefaultTableModel)productTable.getModel();
                tbleModel.addRow(tblData);
                
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /*public void updateProduct()
    {
        try   
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            //String query="UPDATE Products SET ProdName='" + prodName.getText() + "',Price=" + price.getText() + "',Quantity=" + qty.getText() + "',Company=" + comp.getText() + " ' WHERE id=" + id.getText() + "";
            String sql = "UPDATE Products SET  Quantity=?, WHERE id=?";
            String newQty=qty.getText();
            String oldQty=
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, qty.getText());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
            {
                JOptionPane.showMessageDialog(this,"Product Updated Successfully");
            }  
        }catch(Exception ex){
        {
            System.out.println(ex);
        } 
        }
        
    }*?
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        grdTotLbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        prodName = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        comp = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTxt = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        showTbl1 = new javax.swing.JButton();
        btnGrd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        amtReceived = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        amtReceivable = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        prodId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 96, 96));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 1080));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        grdTotLbl.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        grdTotLbl.setText("Rs. ");
        jPanel3.add(grdTotLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 120, 40));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setText("Bill Id");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 30));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setText("Company");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel10.setText("Amount Receivable");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 150, 20));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel11.setText("Phone");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, 30));

        btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPrint.setText("Print ");
        btnPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 580, 90, 30));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add to bill.jpg"))); // NOI18N
        btnAdd.setText("ADD TO BILL");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 160, 40));

        id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, 30));

        prodName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        prodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodNameActionPerformed(evt);
            }
        });
        prodName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prodNameKeyReleased(evt);
            }
        });
        jPanel3.add(prodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, 30));

        name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
        });
        jPanel3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, 30));

        comp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compActionPerformed(evt);
            }
        });
        jPanel3.add(comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 160, 30));

        qty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        jPanel3.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 160, 30));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "ProductName", "Price", "Quantity", "Company"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 440, 200));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel5.setText("Billing Point");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 180, 40));

        billTxt.setColumns(20);
        billTxt.setRows(5);
        jScrollPane2.setViewportView(billTxt);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 420, 230));

        jLabel12.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel12.setText("Products List");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 180, 40));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel13.setText("Price");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 30));

        price.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceKeyReleased(evt);
            }
        });
        jPanel3.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 160, 30));

        jLabel15.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel15.setText("Bill Preview");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 180, 40));

        showTbl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showTbl1.setText("Clear ");
        showTbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        showTbl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTbl1ActionPerformed(evt);
            }
        });
        jPanel3.add(showTbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 90, 40));

        btnGrd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGrd.setText("Add Grand Total");
        btnGrd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnGrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrdActionPerformed(evt);
            }
        });
        jPanel3.add(btnGrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 120, 40));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel16.setText("Product Name");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 30));

        amtReceived.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        amtReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtReceivedActionPerformed(evt);
            }
        });
        amtReceived.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amtReceivedKeyReleased(evt);
            }
        });
        jPanel3.add(amtReceived, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 160, 30));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel17.setText("Amount Received");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 140, 20));

        amtReceivable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        amtReceivable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtReceivableActionPerformed(evt);
            }
        });
        amtReceivable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amtReceivableKeyReleased(evt);
            }
        });
        jPanel3.add(amtReceivable, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 160, 30));

        phone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel3.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, 30));

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel18.setText("Id");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 20, 30));

        btnAdd1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add product.png"))); // NOI18N
        btnAdd1.setText("ADD CUSTOMER");
        btnAdd1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 160, 40));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel19.setText("Name");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 30));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel20.setText("Name");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 30));

        prodId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        prodId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodIdActionPerformed(evt);
            }
        });
        jPanel3.add(prodId, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 70, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 860, 620));

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel4.setText("Suppliers");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 120, 30));

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel6.setText("Customers");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, 30));

        jLabel14.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel14.setText("Products");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, 30));

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here
        try
        {
            boolean complete=billTxt.print();
            if(complete)
            {
                JOptionPane.showMessageDialog(null, "Printed Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Printing Canceled!","Printer",JOptionPane.ERROR_MESSAGE);
            }
        }catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        

    }//GEN-LAST:event_btnPrintActionPerformed

    private void prodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodNameActionPerformed

    private void prodNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_prodNameKeyReleased

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_nameKeyReleased

    private void compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed
    Double uprice,prodTot=0.0,grdTotal=0.0;
    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
        int rowNum=productTable.getSelectedRow();
        TableModel model=productTable.getModel();

        prodId.setText(model.getValueAt(rowNum, 0).toString());
        //name.setText(model.getValueAt(rowNum,1).toString());
        prodName.setText(model.getValueAt(rowNum,1).toString());
        price.setText(model.getValueAt(rowNum,2).toString());
        comp.setText(model.getValueAt(rowNum,4).toString());
        uprice=Double.valueOf(model.getValueAt(rowNum, 2).toString());
        prodTot=uprice*Integer.valueOf(qty.getText());
    }//GEN-LAST:event_productTableMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        new Products().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1ComponentShown

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed
    int i=0;
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(name.getText().isEmpty() || prodName.getText().isEmpty() || qty.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Information");
        }
        
        else
        {
            
            i++;
            prodTot=uprice*Integer.valueOf(qty.getText());
            grdTotal=grdTotal+prodTot;
            if(i==1)
            {
            billTxt.setText("---------------------------------------ANU COSMETICS------------------------------------"+"\n"+"Name: "+name.getText()+"\n"+"Num   \t Product  \t Quantity \t Price    \t Total"+ "\n"+i+"\t"+prodName.getText()+"\t"+qty.getText()+"\t"+uprice+"\t"+prodTot+"\n");
            }
            else
            {
               // updateProduct();
                billTxt.setText(billTxt.getText()+i+"\t"+prodName.getText()+"\t"+qty.getText()+"\t"+uprice+"\t"+prodTot+"\n");
                
                        
            }
            grdTotLbl.setText("Rs"+grdTotal);
        } 
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void priceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_priceKeyReleased

    private void showTbl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTbl1ActionPerformed
        // TODO add your handling code here:
        id.setText("");
        prodName.setText("");
        name.setText("");
        qty.setText("");
        comp.setText("");
        price.setText("");
    }//GEN-LAST:event_showTbl1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
       new Suppliers().setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new Customer().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you really want to logout?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnGrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrdActionPerformed
                billTxt.setText(billTxt.getText()+"\t \t \t "+"Grand Total \t"+grdTotal);       
                btnGrd.setEnabled(false);// TODO add your handling code here:
        
    }//GEN-LAST:event_btnGrdActionPerformed

    private void amtReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtReceivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtReceivedActionPerformed

    private void amtReceivedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtReceivedKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_amtReceivedKeyReleased

    private void amtReceivableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtReceivableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtReceivableActionPerformed

    private void amtReceivableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtReceivableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_amtReceivableKeyReleased

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        customerm cus = new customerm();
        cus.setcName(name.getText());
        cus.setAmtReceived(amtReceived.getText());
        cus.setAmtReceivable(amtReceivable.getText());
        cus.setPhone(phone.getText());
        //prod.setExDate(exDate.getDate());
        //prod.setMfDate(mfDate.getDate());
        productDB.addCus(cus);
        setVisible(false);
       new Billing().setVisible(true);
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void prodIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amtReceivable;
    private javax.swing.JTextField amtReceived;
    private javax.swing.JTextArea billTxt;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnGrd;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPrint;
    private javax.swing.JTextField comp;
    private javax.swing.JLabel grdTotLbl;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField price;
    private javax.swing.JTextField prodId;
    private javax.swing.JTextField prodName;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qty;
    private javax.swing.JButton showTbl1;
    // End of variables declaration//GEN-END:variables
}
