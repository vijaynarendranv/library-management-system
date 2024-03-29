/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;
import static Jframe.DBConnection.con;
import static java.lang.Class.forName;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Saughanthikaa K E
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    //return d book
    public boolean returnBook(){
       boolean isReturned = false;
       int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where student_id = ? and book_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"returned");
            pst.setInt(2, studentId);
            pst.setInt(3,bookId);
            pst.setString(4,"pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isReturned = true;
            }else{
                isReturned = false;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return isReturned;    
    }
    
    
    
    //updating bk count
    public void getIssueBookDetails(){
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setInt(2,studentId);
            pst.setString(3,"pending");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                
                lbl_issueId.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_issueDate.setText(rs.getString("issue_date"));
                lbl_dueDate.setText(rs.getString("due_date"));
                lbl_bookError.setText("");
            }else{
                lbl_issueId.setText("");
                lbl_bookName.setText("");
                lbl_studentName.setText("");
                lbl_issueDate.setText("");
                lbl_dueDate.setText("");
                lbl_bookError.setText("no record found");
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    //insert issue book details to database
    public void updateBookCount()
    {
        int bookId = Integer.parseInt(txt_bookId.getText());
        try
        {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity=quantity+1 where book_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0)
            {
                JOptionPane.showMessageDialog(this,"book count updated");
                //int initialCount = Integer.parseInt(lbl_dueDate.getText());
                //lbl_dueDate.setText(Integer.toString(initialCount - 1));
            
            }
            else
            {
                JOptionPane.showMessageDialog(this,"cant update book count");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
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

        panel_main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_issueDate = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_issueId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_bookError2 = new javax.swing.JLabel();
        lbl_bookError3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel14.setText(" Book Details");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 100));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 320, 5));

        lbl_issueDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 170, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book name:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Student name:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Issue id:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        lbl_issueId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_issueId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_issueId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(lbl_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 170, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 170, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 170, 30));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Due date:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, -1, -1));

        lbl_bookError2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_bookError2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 750, 160, 20));

        lbl_bookError3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_bookError3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookError3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 640, 160, 20));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Issue date:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        lbl_dueDate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 170, 30));

        lbl_bookError.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 330, 20));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 430, 810));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("RETURN BOOK");
        panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 330, -1));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 140, 290, 5));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, 40, 30));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_bookId.setPlaceholder("Enter BookId......");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 270, 270, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Book id:");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 160, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_studentId.setPlaceholder("Enter Username......");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, 270, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("Student id:");
        panel_main.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 160, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 102, 255));
        rSMaterialButtonCircle1.setText("FIND BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 340, 60));

        jPanel5.setBackground(new java.awt.Color(51, 0, 204));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Back");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 70, 50));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("RETURN BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 340, 60));

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-2.png"))); // NOI18N
        jLabel22.setText("Issue id:");
        panel_main.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 200, 420, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, 1411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_main, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       getIssueBookDetails(); 
      
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(returnBook() == true){
                JOptionPane.showMessageDialog(this,"book returned successfully");
                updateBookCount();
        }else{
                JOptionPane.showMessageDialog(this,"book return failed");

        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookError2;
    private javax.swing.JLabel lbl_bookError3;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDate;
    private javax.swing.JLabel lbl_issueId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
