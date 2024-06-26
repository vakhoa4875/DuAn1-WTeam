package UX_UI;

import dao.UserDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import library.Auth;
import library.DialogHelper;
import library.Extension;
import model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 *
 * @author PHAT
 */
public class JDialogLogin extends javax.swing.JDialog {

    /**
     * Creates new form JDialogLogin
     */
    public JDialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    public JDialogLogin(User user) {
        super();
        initComponents();
        setLocationRelativeTo(null);
        this.user0 = user;
        init();
    }

    void init() {
        txtTaiKhoan.setText(user0 == null ? "" : user0.getUserName());

        Extension.togglePassword(txtMatKhau);

        btnDangNhap.addActionListener(e -> {
            login();
        });
        btnToSignUp.addActionListener(e -> {
            toSignUpForm();
        });
        btnLoginGG.setEnabled(false);
        rdoNhoMatKhau.setEnabled(false);
    }

    UserDAO dao = new UserDAO();
    User user0 = new User();
    ArrayList<User> userList = dao.select();

    boolean validateInput() {
        if (Extension.areEmpty(txtTaiKhoan, txtMatKhau)) {
            DialogHelper.alert(null, "Username hoặc Mật khẩu không được để trống");
            return false;
        }
        return true;
    }

    boolean checkUser() {
        if (!validateInput()) {
            return false;
        }
        String username = txtTaiKhoan.getText();
        String pass = new String(txtMatKhau.getPassword());

        for (User user : userList) {
            if ((username.equals(user.getUserName()) || username.equals(user.getEmail()))) {
                this.user0 = user;
                if (pass.equals(user.getPassword())) {
                    Auth.user = user0;
//                    System.out.println(user0.getUserID());
//                    System.out.println(user0.getPassword());
                    return true;
                } else {
                    DialogHelper.alert(null, "Sai Mật Khẩu! Vui lòng thử lại");
                    txtMatKhau.setText("");
                    return false;
                }
            }
        }
        DialogHelper.alert(null, "Tài khoản không tồn tại! Vui lòng kiểm tra thông tin đăng nhập!");
        return false;
    }


    void login() {
        if (checkUser()) {
            DialogHelper.alert(null, "Đăng nhập thành công!");
            toMainForm();
        }
    }

    void toMainForm() {
        this.dispose();
        new HiForm(new JFrame(), true).setVisible(true);
        if (this.user0.getReader()) {
            new JFrameTrangChuKhachHangver2().setVisible(true);
        } else if (!this.user0.getReader()) {
            new JFrameTrangChuQuanLy().setVisible(true);
        }
    }
//    user0.getUserID()

    void toSignUpForm() {
        this.dispose();
        new JDialogDangKi(new JFrame(), true).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        rdoNhoMatKhau = new javax.swing.JRadioButton();
        txtMatKhau = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnQuenMK = new javax.swing.JButton();
        btnLoginGG = new javax.swing.JButton();
        btnToSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("NERDYERS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_github.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N
        jLabel3.setText("Tài Khoản");

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTaiKhoan.setText("reader");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N
        jLabel4.setText("Mật Khẩu");

        btnDangNhap.setBackground(new java.awt.Color(153, 153, 153));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        rdoNhoMatKhau.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N
        rdoNhoMatKhau.setText("Nhớ mật khẩu cho lần sau");
        rdoNhoMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhoMatKhauActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setText("123");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-gg.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        btnQuenMK.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        btnQuenMK.setForeground(new java.awt.Color(51, 51, 255));
        btnQuenMK.setText("Quên mật khẩu?");
        btnQuenMK.setBorder(null);
        btnQuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuenMKActionPerformed(evt);
            }
        });

        btnLoginGG.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        btnLoginGG.setForeground(new java.awt.Color(51, 51, 255));
        btnLoginGG.setText("Đăng nhập với Google");
        btnLoginGG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLoginGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginGGActionPerformed(evt);
            }
        });

        btnToSignUp.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        btnToSignUp.setForeground(new java.awt.Color(51, 51, 255));
        btnToSignUp.setText("Đăng kí");
        btnToSignUp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnToSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoginGG, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnToSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdoNhoMatKhau)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoNhoMatKhau)
                    .addComponent(btnQuenMK))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(btnLoginGG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnToSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void rdoNhoMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhoMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhoMatKhauActionPerformed

    private void btnQuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuenMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuenMKActionPerformed

    private void btnLoginGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginGGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginGGActionPerformed

    private void btnToSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnToSignUpActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogLogin dialog = new JDialogLogin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnLoginGG;
    private javax.swing.JButton btnQuenMK;
    private javax.swing.JButton btnToSignUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoNhoMatKhau;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
