/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UX_UI;

import dao.UserDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import library.DialogHelper;
import library.EmailSender;
import library.Extension;
import model.User;

/**
 *
 * @author PHAT
 */
public class JDialogDangKi extends javax.swing.JDialog {

    /**
     * Creates new form JDialogDangKi
     */
    public JDialogDangKi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    User user0;

    public JDialogDangKi(User user0) {
        super();
        initComponents();
        init();
        this.user0 = user0;
        setModel(user0);
    }

    private void init() {
        this.setLocationRelativeTo(null);
        
        Extension.togglePassword(txtPass1);
        Extension.togglePassword(txtPass2);
        
        btnDangKi.addActionListener(e -> {
            insertUser();
        });
        btnToVerification.addActionListener(e -> {
            directToVerfication(user0);
        });
    }

    UserDAO dao = new UserDAO();

    ArrayList<User> userList = dao.select();

    Boolean isDuplicated(String userName, String email) {
//        boolean check = true;
        for (User user : userList) {
            if (userName.equals(user.getUserName()) || email.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    Integer isUpdatable(String userID) {
        for (User user : userList) {
            if (userID.equals(user.getUserID()) && user.getVerificated() == false) {
                return 1;
            }
            if (userID.equals(user.getUserID()) && user.getVerificated() == true) {
                return null;
            }
        }
        return 0;
    }

    void setModel(User user) {
        txtTaiKhoan.setText(user.getUserName());
//        txtPass1.setText(user.getPassword());
//        txtPass2.setText(user.getPassword());
        txtEmail.setText(user.getEmail());
    }

    User getModel() {
//        User user = new User();
        String userID = this.user0 == null ? Extension.randomString("user_", 15) : this.user0.getUserID();
        String userName = txtTaiKhoan.getText();
        String email = txtEmail.getText();
//        String sdt = txtSoDienThoai.getText();
        String pass1 = new String(txtPass1.getPassword());
        String pass2 = new String(txtPass2.getPassword());
        if (!Extension.isEmail(txtEmail)) {
            DialogHelper.alert(null, "Email chưa đúng syntax!");
        }
        if (Extension.areEmpty(txtTaiKhoan, txtEmail)) {
            DialogHelper.alert(null, "Tên tài khoản và Email không được để trống");
            return null;
        }
        if (!pass1.equals(pass2)) {
            DialogHelper.alert(null, "Xác Nhận Mật khẩu không khớp.");
            return null;
        }
        if (isDuplicated(userName, email)) {
            DialogHelper.alert(null, "Username hoặc Email đã tồn tại.");
            return null;
        }
        User user = new User(userID, userName, pass1, email, true, false);
        return user;

    }

    void insertUser() {
        User user = getModel();
        if (user == null) {
            return;
        }
        Integer check = isUpdatable(user.getUserID());

        if (check == null) {
            DialogHelper.alert(null, "Tài khoản đã tồn tại!");
            return;
        }
        if (check == 0) {
            dao.insert(user);
        } else if (check == 1) {
            dao.update(user);
        }
        boolean option = DialogHelper.confirm(null, "Cần xác nhận email?");
        this.user0 = user;
        if (option) {
            directToVerfication(user);
        }
//        String OTP = Extension.randomString("", 15);
//        EmailSender.emailSender(user.getEmail(), user.getUserName(), OTP);
//        this.setVisible(false);
//        new JDialogXacNhanEmail(this, OTP, user).setVisible(true);
    }

    void directToVerfication(User user) {
        if (user == null) {
            DialogHelper.alert(null, "Không thể chuyển hướng khi không có thông tin đã được đăng kí!");
            return;
        }
        this.dispose();
        new JDialogXacNhanEmail(user).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDangNhap = new javax.swing.JLabel();
        btnDangKi = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        btnToVerification = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tài Khoản");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Xác nhận mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Đã có tài khoản?");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtDangNhap.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        txtDangNhap.setForeground(new java.awt.Color(0, 153, 255));
        txtDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDangNhap.setText("Đăng nhập tại đây");

        btnDangKi.setBackground(new java.awt.Color(204, 204, 204));
        btnDangKi.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnDangKi.setForeground(new java.awt.Color(51, 51, 0));
        btnDangKi.setText("ĐĂNG KÍ");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_github.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 22)); // NOI18N
        jLabel1.setText("ĐĂNG KÍ TÀI KHOẢN");

        btnToVerification.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        btnToVerification.setForeground(new java.awt.Color(0, 0, 255));
        btnToVerification.setText("Email Verification>>>");
        btnToVerification.setBorder(null);
        btnToVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToVerificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnToVerification))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToVerification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDangNhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangKiActionPerformed

    private void btnToVerificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToVerificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnToVerificationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Windows (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogDangKi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogDangKi dialog = new JDialogDangKi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnToVerification;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel txtDangNhap;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
