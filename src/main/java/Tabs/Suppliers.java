/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tabs;

import Database.productDB;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Supplier;
import login.Login;
//import model.product;

/**
 *
 * @author Muskan
 */
public class Suppliers extends javax.swing.JFrame {

    /**
     * Creates new form Suppliers
     */
    public Suppliers() {
        initComponents();
        btnAdd.setEnabled(false);
        showTable();
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
        String supName = sName.getText();
        String num = phone.getText();
        if (!supName.equals("") && !num.equals("")) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }
    }
    
    public void clearTable()
    {
        DefaultTableModel Model;
        Model = (DefaultTableModel)supTable.getModel();
        Model.setRowCount(0);  
    }
    
    public void showTable()
    {
        try 
        {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            Statement st=con.createStatement();
            String sql="select * from suppliers";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                String ids=String.valueOf(rs.getInt("Id"));
                String supName=rs.getString("SupplierName");
                String num=String.valueOf(rs.getString("Phone"));
                String amtPay=String.valueOf(rs.getInt("AmountPaid"));
                String amtPayble=String.valueOf(rs.getInt("AmountPayable"));
                
                String tblData[]={ids,supName,num,amtPay,amtPayble};
                DefaultTableModel tbleModel;
                tbleModel = (DefaultTableModel)supTable.getModel();
                tbleModel.addRow(tblData);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateSupplier()
    {
        try   
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            //String query="UPDATE Products SET ProdName='" + prodName.getText() + "',Price=" + price.getText() + "',Quantity=" + qty.getText() + "',Company=" + comp.getText() + " ' WHERE id=" + id.getText() + "";
            String sql = "UPDATE Suppliers SET SupplierName=?, Phone=?, AmountPaid=?, AmountPayable=? WHERE id=?";
 
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, sName.getText());
            statement.setString(2, phone.getText());
            statement.setString(3, amtPaid.getText());
            statement.setString(4, amtPayable.getText());
            statement.setString(5, id.getText());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
            {
                JOptionPane.showMessageDialog(this,"Supplier Updated Successfully");
            }  
            clearTable();
            showTable();
        }catch(Exception ex)
        {
            System.out.println(ex);
        } 
        
    }
    
    public void deleteSupplier()
    {
        //String sname=sName.getText();
        int sid=Integer.parseInt(id.getText());      
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management_system","root","");
            String query="delete from Suppliers where id="+sid;
            Statement delete=con.createStatement();
            delete.executeUpdate(query);
            clearTable();
            showTable();
            JOptionPane.showMessageDialog(this,"Supplier deleted Successfully");
        }catch(Exception ex) 
               {
               System.out.println(ex);
               }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        amtPaid = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        sName = new javax.swing.JTextField();
        amtPayable = new javax.swing.JTextField();
        payDate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        supTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        genderCombo = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 700));

        jPanel1.setBackground(new java.awt.Color(250, 96, 96));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel3.setText("Suppliers List");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 180, 40));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel14.setText("Gender");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 30));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel15.setText("ID");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 30, 20));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel16.setText("A/C Payble");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 120, 20));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel17.setText("Phone");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 20));

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel18.setText("Supplier Name");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel19.setText("Amount Paid");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, 20));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel20.setText("Payment Date");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 120, 20));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clear.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel4.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 160, 40));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add product.png"))); // NOI18N
        btnAdd.setText("ADD SUPPLIER");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, 40));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel4.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, 40));

        amtPaid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        jPanel4.add(amtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 160, 30));

        phone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneKeyReleased(evt);
            }
        });
        jPanel4.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 160, 30));

        sName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        sName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNameActionPerformed(evt);
            }
        });
        sName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sNameKeyReleased(evt);
            }
        });
        jPanel4.add(sName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 30));

        amtPayable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        amtPayable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtPayableActionPerformed(evt);
            }
        });
        jPanel4.add(amtPayable, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 160, 30));

        payDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 102, 102)));
        jPanel4.add(payDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 180, 30));

        supTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Supplier Name", "Phone", "Amount Paid", "Amount Payable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        supTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(supTable);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 830, 250));

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel6.setText("Manage Suppliers");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 200, 40));

        genderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboActionPerformed(evt);
            }
        });
        jPanel4.add(genderCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, 30));

        id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), null, null, new java.awt.Color(255, 153, 153)));
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 160, 30));

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear ");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 151, 151)));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel4.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 160, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 850, 610));

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel4.setText("Products");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 120, 30));

        jLabel21.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel21.setText("Customers");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, 30));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabel1.setText("Billing / Selling");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 160, 30));

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel7.setText("Suppliers List");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 180, 40));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(id.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Select the Product to be deleted");
        }
        else
        deleteSupplier();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        Supplier supp = new Supplier();
        supp.setsName(sName.getText());
        supp.setPhone(phone.getText());
        supp.setAmtPaid(amtPaid.getText());
        supp.setAmtPayable(amtPayable.getText());
        //prod.setExDate(exDate.getDate());
        //prod.setMfDate(mfDate.getDate());
        productDB.addSup(supp);
        clearTable();
        //showTable();
        setVisible(false);
       new Suppliers().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(id.getText().isEmpty() || sName.getText().isEmpty() || phone.getText().isEmpty() || amtPaid.getText().isEmpty() || amtPayable.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Missing Infromation");
        }
        else
        {
        updateSupplier();
        }
            
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void sNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNameActionPerformed

    private void amtPayableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtPayableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtPayableActionPerformed

    private void genderComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboActionPerformed

    private void sNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sNameKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_sNameKeyReleased

    private void phoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_phoneKeyReleased

    private void supTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supTableMouseClicked
        // TODO add your handling code here:
        int rowNum=supTable.getSelectedRow();
        TableModel model=supTable.getModel();
        
        id.setText(model.getValueAt(rowNum, 0).toString());
        sName.setText(model.getValueAt(rowNum,1).toString());
        phone.setText(model.getValueAt(rowNum,2).toString());
        amtPaid.setText(model.getValueAt(rowNum,3).toString());
        amtPayable.setText(model.getValueAt(rowNum,4).toString());
    }//GEN-LAST:event_supTableMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        id.setText("");
        sName.setText("");
        phone.setText("");
        amtPaid.setText("");
        amtPayable.setText("");

    }//GEN-LAST:event_btnClearActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Products().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        new Customer().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new Billing().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int a= JOptionPane.showConfirmDialog(null,"Do you really want to logout?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suppliers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suppliers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amtPaid;
    private javax.swing.JTextField amtPayable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> genderCombo;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser payDate;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField sName;
    private javax.swing.JTable supTable;
    // End of variables declaration//GEN-END:variables
}
