/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ai2313.work11923;

import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author opo25
 */
public class JInfo extends javax.swing.JFrame {
    static Employees eps = new Employees();
    static Employee e;
    static Salary s = new Salary();
   
    
    /**
     * Creates new form JInfo
     */
    public JInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        deptTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        saveBT = new javax.swing.JButton();
        clearBT = new javax.swing.JButton();
        showBT = new javax.swing.JButton();
        closeBT = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        okBT = new javax.swing.JButton();
        dayTF = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        jLabel1.setText("Employee ID");
        jPanel1.add(jLabel1);

        idTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTFActionPerformed(evt);
            }
        });
        jPanel1.add(idTF);

        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jPanel1.add(nameTF);

        jLabel4.setText("Department");
        jPanel1.add(jLabel4);
        jPanel1.add(deptTF);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        saveBT.setText("Save");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });
        jPanel2.add(saveBT);

        clearBT.setText("Clear");
        clearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTActionPerformed(evt);
            }
        });
        jPanel2.add(clearBT);

        showBT.setText("Show");
        showBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBTActionPerformed(evt);
            }
        });
        jPanel2.add(showBT);

        closeBT.setText("Close");
        closeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBTActionPerformed(evt);
            }
        });
        jPanel2.add(closeBT);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Information of Employee");

        jLabel6.setText("Working Days");

        okBT.setText("OK");
        okBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBTActionPerformed(evt);
            }
        });

        dayTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayTF, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBT, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayTF)
                    .addComponent(okBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTFActionPerformed

    private void closeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBTActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_closeBTActionPerformed

    private void showBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBTActionPerformed
        // TODO add your handling code here:
        new JDetail(eps.getEmployee(),eps.getIndex()).setVisible(true);
    }//GEN-LAST:event_showBTActionPerformed

    private void clearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTActionPerformed
        // TODO add your handling code here:
        idTF.setText("");
        nameTF.setText("");
        deptTF.setText("");
        dayTF.setText("");
    }//GEN-LAST:event_clearBTActionPerformed

    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
        // TODO add your handling code here:
        try{
             e = new Employee(Integer.parseInt(idTF.getText()),nameTF.getText(),deptTF.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Wrong Type!");
            return;
        }
        eps.setEmployee(e);
        //JOptionPane.showMessageDialog(null,eps.getCurrent().getId());
         
        eps.getCurrent().setSalary(s.salary);
        //JOptionPane.showMessageDialog(null,eps.getCurrent().getSalary());
        JOptionPane.showMessageDialog(null,"Save Successfully!");
        idTF.setText("");
        nameTF.setText("");
        deptTF.setText("");
        dayTF.setText("");
        
    }//GEN-LAST:event_saveBTActionPerformed

    private void dayTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayTFActionPerformed
        // TODO add your handling code here:
        new JDays(Integer.parseInt(dayTF.getText()),s).setVisible(true);
    }//GEN-LAST:event_dayTFActionPerformed

    private void okBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBTActionPerformed
        // TODO add your handling code here:

        new JDays(Integer.parseInt(dayTF.getText()),s).setVisible(true);
        //dayTF.setText("");
    }//GEN-LAST:event_okBTActionPerformed

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
            java.util.logging.Logger.getLogger(JInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBT;
    private javax.swing.JButton closeBT;
    private javax.swing.JTextField dayTF;
    private javax.swing.JTextField deptTF;
    private javax.swing.JTextField idTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton okBT;
    private javax.swing.JButton saveBT;
    private javax.swing.JButton showBT;
    // End of variables declaration//GEN-END:variables
}