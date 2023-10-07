/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.DepartmentBean;
import BeanClasses.SemesterBean;
import DB_Management.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Random
 */
public class ManullayForm extends javax.swing.JFrame {

    /**
     * Creates new form ManullayForm
     */
    public ManullayForm() throws Exception {
        initComponents();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("muet_logo.png")));

        
        Toolkit kit = this.getToolkit();
        Dimension size = kit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        
        buttonGroup1.add(Annual_RadioButton2);
        buttonGroup1.add(suplementary_RButton1);

        dpt_item();
        smstr_item();
        getSub();
        
        date_chose.setDate(new java.util.Date());
    }

    public void dpt_item() throws Exception {
        Vector v = DBM_system.get_dept();
        dpt_ComboBox2.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            dpt_ComboBox2.addItem(v.elementAt(i));
        }
    }

    public void smstr_item() throws Exception {
        Vector v = DBM_system.get_semesters();
        smstr_ComboBox1.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            smstr_ComboBox1.addItem(v.elementAt(i));
        }
    }

    public void getSub() throws Exception {
        DepartmentBean bean = (DepartmentBean) dpt_ComboBox2.getSelectedItem();
        SemesterBean bean1 = (SemesterBean) smstr_ComboBox1.getSelectedItem();

        if (bean == null || bean1 == null) {
            return;
        }

        Vector v = DBM_system.get_Sub(bean1.getSm_id(), bean.getD_id());
        subject_List1.setListData(v);

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
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        smstr_ComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        contact_TextField4 = new javax.swing.JTextField();
        name_TextField = new javax.swing.JTextField();
        Annual_RadioButton2 = new javax.swing.JRadioButton();
        roll_TextField1 = new javax.swing.JTextField();
        date_chose = new com.toedter.calendar.JDateChooser();
        challano_TextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        feeSubmitting_TextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fname_TextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fees_TextField3 = new javax.swing.JTextField();
        suplementary_RButton1 = new javax.swing.JRadioButton();
        dpt_ComboBox2 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject_List1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Examination Form");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MUET", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Algerian", 3, 36), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Subjects");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Name");

        smstr_ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smstr_ComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Roll No:");

        jLabel11.setText("Department");

        contact_TextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_TextField4ActionPerformed(evt);
            }
        });

        name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_TextFieldActionPerformed(evt);
            }
        });

        Annual_RadioButton2.setText("Annual");

        roll_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roll_TextField1ActionPerformed(evt);
            }
        });

        challano_TextField1.setEditable(false);
        challano_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challano_TextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Semester");

        jLabel8.setText("Exam Date");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        feeSubmitting_TextField5.setEditable(false);
        feeSubmitting_TextField5.setText("Manually Pay");
        feeSubmitting_TextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeSubmitting_TextField5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Examination");

        fname_TextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname_TextField2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Exam Fee");

        fees_TextField3.setEditable(false);
        fees_TextField3.setText("1600");
        fees_TextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fees_TextField3ActionPerformed(evt);
            }
        });

        suplementary_RButton1.setText("Suplementary");
        suplementary_RButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplementary_RButton1ActionPerformed(evt);
            }
        });

        dpt_ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpt_ComboBox2ActionPerformed(evt);
            }
        });

        jLabel13.setText("Challan No:");

        jLabel18.setText("Contact");

        jLabel5.setText("Father Name");

        jLabel10.setText("Fee Submitted");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dpt_ComboBox2, 0, 168, Short.MAX_VALUE)
                        .addComponent(smstr_ComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(name_TextField)
                        .addComponent(roll_TextField1))
                    .addComponent(fees_TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_chose, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(contact_TextField4)
                    .addComponent(challano_TextField1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Annual_RadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(suplementary_RButton1))))
                            .addComponent(fname_TextField2)
                            .addComponent(feeSubmitting_TextField5))
                        .addGap(1, 1, 1)))
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dpt_ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(challano_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(contact_TextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fname_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(roll_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(smstr_ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Annual_RadioButton2)
                                    .addComponent(suplementary_RButton1))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fees_TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(feeSubmitting_TextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_chose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(subject_List1);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suplementary_RButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplementary_RButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suplementary_RButton1ActionPerformed

    private void fname_TextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname_TextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname_TextField2ActionPerformed

    private void name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_TextFieldActionPerformed

    private void roll_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roll_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roll_TextField1ActionPerformed

    private void smstr_ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smstr_ComboBox1ActionPerformed
        try {
            getSub();
        } catch (Exception ex) {
            Logger.getLogger(ManullayForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_smstr_ComboBox1ActionPerformed

    private void dpt_ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpt_ComboBox2ActionPerformed
        try {
            smstr_item();
        } catch (Exception ex) {
            Logger.getLogger(ManullayForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dpt_ComboBox2ActionPerformed

    private void feeSubmitting_TextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeSubmitting_TextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeSubmitting_TextField5ActionPerformed

    private void contact_TextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_TextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_TextField4ActionPerformed

    private void fees_TextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fees_TextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fees_TextField3ActionPerformed

    private void challano_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challano_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_challano_TextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
         // Exam_FormBean bean = new Exam_FormBean();
                DepartmentBean d_bea = (DepartmentBean) dpt_ComboBox2.getSelectedItem();
                int d_id = Integer.parseInt(d_bea.getD_id() + ""); //getting id and converting into Integer
                SemesterBean s_bean = (SemesterBean) smstr_ComboBox1.getSelectedItem();
                int s_id = Integer.parseInt(s_bean.getSm_id() + "");
                String rollno = roll_TextField1.getText();            //chalan number;
                String name = name_TextField.getText();
                String f_name = fname_TextField2.getText();
                String exm_type = null;
                if (Annual_RadioButton2.isSelected()) {
                    exm_type = Annual_RadioButton2.getText();
                } else if (suplementary_RButton1.isSelected()) {
                    exm_type = suplementary_RButton1.getText();
                }

                JOptionPane.showMessageDialog(null, "util date" + date_chose.getDate());
                java.sql.Date dts = new java.sql.Date(date_chose.getDate().getTime());
                JOptionPane.showMessageDialog(null, "Sql date " + dts);                                  //converting date from util to sql
                int chall_num = 0;
                String cntc = contact_TextField4.getText();
                int fee =Integer.parseInt(fees_TextField3.getText());
                String print_form =feeSubmitting_TextField5.getText() ;
                int row = DBM_system.insert_ExamForm(d_id, s_id, name, rollno, f_name, exm_type, dts, fee, cntc, chall_num, print_form);
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, name + " your Exam form submitted ");
                    
                }
        }catch(Exception e){e.printStackTrace();}        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   try {
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
            this.hide();
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Exam_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ManullayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManullayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManullayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManullayForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManullayForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ManullayForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Annual_RadioButton2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField challano_TextField1;
    private javax.swing.JTextField contact_TextField4;
    private com.toedter.calendar.JDateChooser date_chose;
    private javax.swing.JComboBox dpt_ComboBox2;
    private javax.swing.JTextField feeSubmitting_TextField5;
    private javax.swing.JTextField fees_TextField3;
    private javax.swing.JTextField fname_TextField2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JTextField roll_TextField1;
    private javax.swing.JComboBox smstr_ComboBox1;
    private javax.swing.JList subject_List1;
    private javax.swing.JRadioButton suplementary_RButton1;
    // End of variables declaration//GEN-END:variables
}