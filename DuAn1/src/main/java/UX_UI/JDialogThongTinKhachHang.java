/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UX_UI;

import dao.readerDao;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import library.Auth;
import library.MsgBox;
import library.XDate;
import library.XImage;
import model.Reader;

/**
 *
 * @author TAN LOC
 */
public class JDialogThongTinKhachHang extends javax.swing.JDialog {

    readerDao dao = new readerDao();
    JFileChooser filechooser = new JFileChooser();
    /**
     * Creates new form JDialogThongTinKhachHang
     */
    public JDialogThongTinKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }
    
    
    public JDialogThongTinKhachHang(javax.swing.JDialog parent, boolean modal){
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GioiTinh = new javax.swing.ButtonGroup();
        jpnPersonalInfo = new javax.swing.JPanel();
        lblTittle = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblFillUserName = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblTichDIem = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTichDiem = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblChooseImage = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnChangePersonalInfo = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpnPersonalInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTittle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTittle.setText("Hồ Sơ Của Tôi ");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUserName.setText("Tên đăng nhập");

        lblFillUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFillUserName.setText("ABC");

        lblTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTen.setText("Tên");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        lblTichDIem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTichDIem.setText("Tích điểm");

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTichDiem.setEditable(false);
        txtTichDiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblSex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSex.setText("Giới tính");

        GioiTinh.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Nam");

        GioiTinh.add(rdoFemale);
        rdoFemale.setText("Nữ");

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("Ngày sinh");

        btnSave.setText("Lưu");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblChooseImage.setText("Chọn Ảnh");
        lblChooseImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChooseImageMouseClicked(evt);
            }
        });

        txtDate.setEditable(false);

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrangThai.setText("jLabel2");

        javax.swing.GroupLayout jpnPersonalInfoLayout = new javax.swing.GroupLayout(jpnPersonalInfo);
        jpnPersonalInfo.setLayout(jpnPersonalInfoLayout);
        jpnPersonalInfoLayout.setHorizontalGroup(
            jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPersonalInfoLayout.createSequentialGroup()
                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnPersonalInfoLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUserName)
                                    .addComponent(lblTichDIem)
                                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDate))
                                .addGap(38, 38, 38)
                                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                                        .addComponent(rdoMale, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                        .addGap(1, 1, 1)
                                        .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE))
                                    .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTichDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                            .addComponent(txtName)
                                            .addComponent(btnSave)
                                            .addComponent(txtEmail)
                                            .addComponent(lblFillUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDate))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lblChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                                .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnPersonalInfoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                                .addComponent(lblTittle)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(22, 22, 22))
        );
        jpnPersonalInfoLayout.setVerticalGroup(
            jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTittle)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai)
                .addGap(12, 12, 12)
                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(lblFillUserName))
                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTen)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTichDIem)
                            .addComponent(txtTichDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSex)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))))
                .addGap(18, 18, 18)
                .addGroup(jpnPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnPersonalInfoLayout.createSequentialGroup()
                        .addComponent(lblDate)
                        .addGap(38, 38, 38)
                        .addComponent(btnSave))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/github50.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnChangePersonalInfo.setText("Sửa Hồ Sơ");
        btnChangePersonalInfo.setBorder(null);
        btnChangePersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePersonalInfoActionPerformed(evt);
            }
        });

        btnChangePassword.setText("Đổi Mật Khẩu");
        btnChangePassword.setBorder(null);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnChangePersonalInfo)
                    .addComponent(btnChangePassword))
                .addGap(18, 18, 18)
                .addComponent(jpnPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnChangePersonalInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChangePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(jpnPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        
        
        openJDialogDoiMatKhau();
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void lblChooseImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChooseImageMouseClicked
        // TODO add your handling code here:
        uploadImage();
    }//GEN-LAST:event_lblChooseImageMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveUpdate();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnChangePersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePersonalInfoActionPerformed
        // TODO add your handling code here:
        changeInfo();
    }//GEN-LAST:event_btnChangePersonalInfoActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogThongTinKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogThongTinKhachHang dialog = new JDialogThongTinKhachHang(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup GioiTinh;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangePersonalInfo;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnPersonalInfo;
    private javax.swing.JLabel lblChooseImage;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFillUserName;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTichDIem;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTichDiem;
    // End of variables declaration//GEN-END:variables

    void init() {
        setfrom();
    }

    void openJDialogDoiMatKhau() {
        this.dispose();
        new JDialogDoiMK(this, true).setVisible(true);
    }

    void setfrom() {
        Reader reader = dao.selectByID(Auth.user.getUserID());
        
        lblTrangThai.setText(reader.getThanThiet() ? "Đọc giả thân thiết" : "Đọc giả bình thường");
        txtTichDiem.setText(reader.getTichDiem() + "");
        if (reader.getNgaySinh() != null && txtDate != null) {
            txtDate.setText(XDate.toString(reader.getNgaySinh(), "dd-MM-yyyy"));
        }
        if (reader.getAvatar() != null) {
            ImageIcon icon = XImage.read(reader.getAvatar());
            Image img = icon.getImage().getScaledInstance(lblChooseImage.getWidth(), lblChooseImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            lblChooseImage.setIcon(scaledIcon);
            lblChooseImage.setToolTipText(reader.getAvatar());
        }
        txtName.setText(reader.getHoTen());
        if (reader.getGioitinh()) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
        lblFillUserName.setText(Auth.user.getUserName());
        txtEmail.setText(Auth.user.getEmail());
    }

    Reader getFrom() {
        Reader rd = new Reader(); 
        
        rd.setThanThiet(lblTrangThai.getText() == "Đọc giả thân thiết" ? true : false);
        rd.setTichDiem(Integer.parseInt(txtTichDiem.getText()));
        rd.setNgaySinh(XDate.toDate(txtDate.getText()));
        rd.setAvatar(lblChooseImage.getToolTipText());
        rd.setHoTen(txtName.getText());
        boolean gioitinh = true;
        if (rdoMale.isSelected()) {
            gioitinh = true;
        }else if(rdoFemale.isSelected()) {
            gioitinh = false;
        }
        rd.setGioitinh(gioitinh);
        rd.setIdReader(Auth.user.getUserID());
        return rd;
    }

    void uploadImage() {
        if (filechooser.showOpenDialog(this) == filechooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            Image img = icon.getImage().getScaledInstance(lblChooseImage.getWidth(), lblChooseImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            lblChooseImage.setIcon(scaledIcon);
            lblChooseImage.setToolTipText(file.getName());
        }
    }

    void saveUpdate() {
        Reader reader = getFrom();
        try {
            dao.update(reader);
            this.setfrom();
            MsgBox.alert(this, "Cập nhật thông tin thành công!!!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thông tin thất bài!!!");
        }
    }

    void changeInfo() {
        txtName.setEditable(true);
        txtEmail.setEditable(true);
        txtDate.setEditable(true);
        btnSave.setEnabled(true);
    }
    
    
    

}
