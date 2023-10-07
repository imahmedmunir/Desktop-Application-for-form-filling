/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.DepartmentBean;
import BeanClasses.Exam_FormBean;
import BeanClasses.SemesterBean;
import BeanClasses.Subject_Bean;
import BeanClasses.st_login;
import java.util.Vector;
import DB_Management.DBM_system;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muneer Ahmed
 */
public class Main_Admin extends javax.swing.JFrame {

    /**
     * Creates new form Main_Admin
     */
    public Main_Admin() throws Exception {
        initComponents();
        buttonGroup1.add(Annual);
        buttonGroup1.add(Supplementary);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("muet_logo.png")));

        
        Toolkit kit = this.getToolkit();
        Dimension size = kit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height/ 2 - getHeight()/ 2);

        getDept();
        get_smstr();
        get_st_login();

    }

    public void getDept() throws Exception {
        Vector v = new Vector();
        v = DBM_system.get_dept();
        d_ComboBox2.removeAllItems();
        dpt_Combo.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            d_ComboBox2.addItem(v.elementAt(i));
            dpt_Combo.addItem(v.elementAt(i));
        }

        Dept_jList1.setListData(v);
    }

    public void get_smstr() throws Exception {
        Vector v = new Vector();
        v = DBM_system.get_semesters();
        smstr_ComboBox1.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            smstr_ComboBox1.addItem(v.elementAt(i));
            smstr_Com.addItem(v.elementAt(i));
        }
    }

    public void get_st_login() throws Exception {
        Vector<st_login> vctr = DBM_system.login();
        DefaultTableModel model = (DefaultTableModel) loginTable1.getModel();

        for (int rem = model.getRowCount() - 1; rem >= 0; rem--) {
            model.removeRow(rem);
        }
        Object row[] = new Object[3];
        for (int i = 0; i < vctr.size(); i++) {
            row[0] = vctr.get(i).getS_id();
            row[1] = vctr.get(i).getRollno();
            row[2] = vctr.get(i).getPass();

            model.addRow(row);
        }
    }

    public void update_sub() {
        try {
            SemesterBean bean = (SemesterBean) smstr_ComboBox1.getSelectedItem();

            DepartmentBean bean2 = (DepartmentBean) d_ComboBox2.getSelectedItem();
            if (bean == null || bean2 == null) {
                return;
            }
            Vector v = new Vector();
            v = DBM_system.get_Sub(bean.getSm_id(), bean2.getD_id());
            sub_List1.setListData(v);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        D_idTextField2.setText(null);
        Name_TextField1.setText(null);
        Remarks_jTextArea1.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Name_TextField1 = new javax.swing.JTextField();
        D_idTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Remarks_jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Dept_jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        Add_Button1 = new javax.swing.JButton();
        Update_Button2 = new javax.swing.JButton();
        remove_Button3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sub_List1 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        d_ComboBox2 = new javax.swing.JComboBox();
        smstr_ComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        s_theoryTextField2 = new javax.swing.JTextField();
        s_idTextField3 = new javax.swing.JTextField();
        add_subButton3 = new javax.swing.JButton();
        update_Button4 = new javax.swing.JButton();
        remove_Button5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        passwordField1 = new javax.swing.JPasswordField();
        rollno_TextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        serial_noTextField1 = new javax.swing.JTextField();
        confrm_passwordField2 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        new_acoutButton2 = new javax.swing.JButton();
        update_acoutButton1 = new javax.swing.JButton();
        new_acoutButton4 = new javax.swing.JButton();
        new_acoutButton3 = new javax.swing.JButton();
        new_acoutButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        loginTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        Annual = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        roll_noj = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cntct_jTextField7 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        fee_jTextField6 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        father_jT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Supplementary = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        update_adminjButton1 = new javax.swing.JButton();
        sname_TextField1 = new javax.swing.JTextField();
        dpt_Combo = new javax.swing.JComboBox();
        smstr_Com = new javax.swing.JComboBox();
        date_chose = new com.toedter.calendar.JDateChooser();
        search_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Showcard Gothic", 3, 36), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_label.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N

        jInternalFrame1.setVisible(true);

        jLabel2.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel4.setText("Department Name");

        D_idTextField2.setEditable(false);
        D_idTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_idTextField2ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Remarks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 24), new java.awt.Color(0, 0, 0))); // NOI18N

        Remarks_jTextArea1.setColumns(20);
        Remarks_jTextArea1.setRows(5);
        jScrollPane1.setViewportView(Remarks_jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Dept_jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                Dept_jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(Dept_jList1);

        jLabel5.setFont(new java.awt.Font("Calibri", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Department ");

        Add_Button1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Add_Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attach.png"))); // NOI18N
        Add_Button1.setText("ADD");
        Add_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_Button1ActionPerformed(evt);
            }
        });

        Update_Button2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Update_Button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        Update_Button2.setText("Update");
        Update_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_Button2ActionPerformed(evt);
            }
        });

        remove_Button3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remove_Button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_16x16.gif"))); // NOI18N
        remove_Button3.setText("Remove");
        remove_Button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_Button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(D_idTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel5))))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Add_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(Update_Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(remove_Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(D_idTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update_Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove_Button3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Departments", jPanel2);

        jInternalFrame2.setVisible(true);
        jInternalFrame2.getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Department");
        jInternalFrame2.getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 58, 110, 33);

        sub_List1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sub_List1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(sub_List1);

        jInternalFrame2.getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(486, 58, 214, 274);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("Semester");
        jInternalFrame2.getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 122, 102, 31);

        d_ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d_ComboBox2ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(d_ComboBox2);
        d_ComboBox2.setBounds(156, 59, 216, 33);

        smstr_ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smstr_ComboBox1ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(smstr_ComboBox1);
        smstr_ComboBox1.setBounds(157, 120, 215, 37);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Subjects");
        jInternalFrame2.getContentPane().add(jLabel9);
        jLabel9.setBounds(508, 11, 138, 36);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setText("Name");
        jInternalFrame2.getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 232, 45, 36);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("ID");
        jInternalFrame2.getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 187, 53, 34);
        jInternalFrame2.getContentPane().add(s_theoryTextField2);
        s_theoryTextField2.setBounds(157, 234, 216, 34);
        jInternalFrame2.getContentPane().add(s_idTextField3);
        s_idTextField3.setBounds(157, 187, 216, 34);

        add_subButton3.setBackground(new java.awt.Color(255, 255, 255));
        add_subButton3.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        add_subButton3.setForeground(new java.awt.Color(255, 0, 0));
        add_subButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        add_subButton3.setText("ADD");
        add_subButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_subButton3ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(add_subButton3);
        add_subButton3.setBounds(18, 360, 119, 47);

        update_Button4.setBackground(new java.awt.Color(255, 255, 255));
        update_Button4.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        update_Button4.setForeground(new java.awt.Color(255, 0, 0));
        update_Button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User-Interface-Available-Updates-icon.png"))); // NOI18N
        update_Button4.setText("Update");
        update_Button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_Button4ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(update_Button4);
        update_Button4.setBounds(205, 360, 119, 47);

        remove_Button5.setBackground(new java.awt.Color(255, 255, 255));
        remove_Button5.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        remove_Button5.setForeground(new java.awt.Color(255, 0, 0));
        remove_Button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase-128.png"))); // NOI18N
        remove_Button5.setText("Remove");
        remove_Button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_Button5ActionPerformed(evt);
            }
        });
        jInternalFrame2.getContentPane().add(remove_Button5);
        remove_Button5.setBounds(389, 360, 119, 47);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Subjects", jPanel3);

        jPanel5.setLayout(null);

        jInternalFrame3.setVisible(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Student Accounts");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login Accounts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 18), new java.awt.Color(51, 0, 204))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Confirm Password");

        rollno_TextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollno_TextField3ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText("Password");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("S. no");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Roll No");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(58, 58, 58)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serial_noTextField1)
                    .addComponent(rollno_TextField3)
                    .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(confrm_passwordField2))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serial_noTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollno_TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confrm_passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buttons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 18), new java.awt.Color(204, 0, 204))); // NOI18N

        new_acoutButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        new_acoutButton2.setForeground(new java.awt.Color(51, 51, 255));
        new_acoutButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_1.png"))); // NOI18N
        new_acoutButton2.setText("New Account");
        new_acoutButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_acoutButton2ActionPerformed(evt);
            }
        });

        update_acoutButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        update_acoutButton1.setForeground(new java.awt.Color(51, 0, 255));
        update_acoutButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        update_acoutButton1.setText("Update Account");
        update_acoutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_acoutButton1ActionPerformed(evt);
            }
        });

        new_acoutButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        new_acoutButton4.setForeground(new java.awt.Color(51, 0, 255));
        new_acoutButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/removee.png"))); // NOI18N
        new_acoutButton4.setText("Remove Account");
        new_acoutButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_acoutButton4ActionPerformed(evt);
            }
        });

        new_acoutButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        new_acoutButton3.setForeground(new java.awt.Color(51, 51, 255));
        new_acoutButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase-128.png"))); // NOI18N
        new_acoutButton3.setText("Clear");
        new_acoutButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_acoutButton3ActionPerformed(evt);
            }
        });

        new_acoutButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        new_acoutButton5.setForeground(new java.awt.Color(51, 51, 255));
        new_acoutButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/se.png"))); // NOI18N
        new_acoutButton5.setText("Show Password");
        new_acoutButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_acoutButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(new_acoutButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update_acoutButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(new_acoutButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(new_acoutButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(new_acoutButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(new_acoutButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(update_acoutButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(new_acoutButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(new_acoutButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(new_acoutButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(408, 408, 408))
        );

        loginTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "S: no", "Roll Number", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loginTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(loginTable1);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane4)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.add(jInternalFrame3);
        jInternalFrame3.setBounds(0, 0, 880, 480);

        jTabbedPane2.addTab("Student Accounts", jPanel5);

        jInternalFrame4.setVisible(true);

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("Student Submitted Exam Form");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 24), new java.awt.Color(255, 0, 51))); // NOI18N

        Annual.setText("Annual");

        jLabel25.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel25.setText("Contact");

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel22.setText("Date");

        cntct_jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cntct_jTextField7ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel23.setText("Exam Type");

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel21.setText("Semester");

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel16.setText("Name");

        jLabel26.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel26.setText("Exam Fee");

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setText("Roll no:");

        Supplementary.setText("Supplementary");

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setText("Department");

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel20.setText("Father Name");

        update_adminjButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        update_adminjButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        update_adminjButton1.setText("Update");
        update_adminjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_adminjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(56, 56, 56)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(father_jT)
                    .addComponent(sname_TextField1)
                    .addComponent(roll_noj)
                    .addComponent(dpt_Combo, 0, 138, Short.MAX_VALUE)
                    .addComponent(smstr_Com, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(Annual)
                        .addGap(18, 18, 18)
                        .addComponent(Supplementary))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(update_adminjButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addComponent(date_chose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fee_jTextField6)
                        .addComponent(cntct_jTextField7)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Supplementary)
                    .addComponent(Annual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(roll_noj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date_chose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(father_jT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fee_jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cntct_jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(smstr_Com, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(update_adminjButton1)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dpt_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        search_txt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search by Roll no", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 24), new java.awt.Color(51, 0, 255))); // NOI18N
        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Student Forms", jPanel8);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(74, 74, 74)
                .addComponent(jButton1)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void D_idTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_idTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_D_idTextField2ActionPerformed

    private void Dept_jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_Dept_jList1ValueChanged
        DepartmentBean bean = (DepartmentBean) Dept_jList1.getSelectedValue();
        if (bean == null) {
            return;
        }
        D_idTextField2.setText(bean.getD_id() + "");
        Name_TextField1.setText(bean.getD_name());
        Remarks_jTextArea1.setText(bean.getD_remarks());

    }//GEN-LAST:event_Dept_jList1ValueChanged

    private void Add_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_Button1ActionPerformed
        String d_name = Name_TextField1.getText();
        String d_remark = Remarks_jTextArea1.getText();
        try {
            int row = DBM_system.insert_dept(d_name, d_remark);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
                getDept();
                clear();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_Add_Button1ActionPerformed

    private void Update_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_Button2ActionPerformed
        int d_id = Integer.parseInt(D_idTextField2.getText() + "");
        String d_name = Name_TextField1.getText();
        String d_remarks = Remarks_jTextArea1.getText();
        try {
            int row = DBM_system.update_dpt(d_id, d_name, d_remarks);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, d_name + " department updated...");
                getDept();
                clear();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_Update_Button2ActionPerformed

    private void remove_Button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_Button3ActionPerformed
        int d_di = Integer.parseInt(D_idTextField2.getText() + "");
        try {
            int row = DBM_system.remove_dpt(d_di);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Department Removed...");
                getDept();
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_remove_Button3ActionPerformed

    private void smstr_ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smstr_ComboBox1ActionPerformed
        update_sub();
    }//GEN-LAST:event_smstr_ComboBox1ActionPerformed

    private void d_ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d_ComboBox2ActionPerformed
        try {
            get_smstr();
        } catch (Exception ex) {
            Logger.getLogger(Main_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_d_ComboBox2ActionPerformed

    private void sub_List1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sub_List1ValueChanged
        Subject_Bean bean = (Subject_Bean) sub_List1.getSelectedValue();
        if (bean == null) {
            return;
        }
        s_idTextField3.setText(bean.getSb_id() + "");
        s_theoryTextField2.setText(bean.getSb_name() + "");


    }//GEN-LAST:event_sub_List1ValueChanged

    private void add_subButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_subButton3ActionPerformed
        DepartmentBean bean = (DepartmentBean) d_ComboBox2.getSelectedItem();
        SemesterBean bean2 = (SemesterBean) smstr_ComboBox1.getSelectedItem();
        String sub_name = s_theoryTextField2.getText();
        int row = 0;
        try {
            row = DBM_system.insert_sub(bean.getD_id(), bean2.getSm_id(), sub_name);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, sub_name + " is Added");
                update_sub();
                s_idTextField3.setText(null);
                s_theoryTextField2.setText(null);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_add_subButton3ActionPerformed

    private void update_Button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_Button4ActionPerformed
        DepartmentBean bean = (DepartmentBean) d_ComboBox2.getSelectedItem();
        SemesterBean bean2 = (SemesterBean) smstr_ComboBox1.getSelectedItem();
        String sub_name = s_theoryTextField2.getText();
        int s_id = Integer.parseInt(s_idTextField3.getText() + "");
        int row = 0;
        try {
            row = DBM_system.update_sub(s_id, bean.getD_id(), bean2.getSm_id(), sub_name);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, sub_name + " Update....");
                s_idTextField3.setText(null);
                s_theoryTextField2.setText(null);
                update_sub();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_update_Button4ActionPerformed

    private void remove_Button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_Button5ActionPerformed
        DepartmentBean bean = (DepartmentBean) d_ComboBox2.getSelectedItem();
        SemesterBean bean2 = (SemesterBean) smstr_ComboBox1.getSelectedItem();
        int s_id = Integer.parseInt(s_idTextField3.getText() + "");

        int row = 0;
        try {
            row = DBM_system.remove_sub(s_id, bean.getD_id(), bean2.getSm_id());
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Subject Removed...");
                update_sub();
                s_idTextField3.setText(null);
                s_theoryTextField2.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_remove_Button5ActionPerformed

    private void rollno_TextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollno_TextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollno_TextField3ActionPerformed

    public void clear_login() {
        serial_noTextField1.setText(null);
        rollno_TextField3.setText(null);
        passwordField1.setText(null);
        confrm_passwordField2.setText(null);
    }
    private void new_acoutButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_acoutButton2ActionPerformed
        int s_id = Integer.parseInt(serial_noTextField1.getText());
        String rollno = rollno_TextField3.getText();
        String pass = passwordField1.getText();
        String cnfrm = confrm_passwordField2.getText();
        int row = 0;
        try {
            if (pass.equals(cnfrm)) {
                row = DBM_system.insert_st_acount(s_id,rollno, pass);
                if (row != 0) {
                    JOptionPane.showMessageDialog(null, "A new Accout is created...");
                    get_st_login();
                    clear_login();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password did not match.....");
                clear_login();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_new_acoutButton2ActionPerformed

    private void update_acoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_acoutButton1ActionPerformed
        int id = Integer.parseInt(serial_noTextField1.getText()+"");
        String rollno = rollno_TextField3.getText();
        String pass = passwordField1.getText();
        String cnfrm = confrm_passwordField2.getText();
        try {
            if (pass.equals(cnfrm)){
                int row = DBM_system.update_st_acount(id, rollno, pass);
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "Account is updated...");
                    clear_login();
                    get_st_login();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Password did not match");
                clear_login();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_update_acoutButton1ActionPerformed

    private void loginTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginTable1MouseClicked
        // TODO add your handling code here:
        try {
            int row = loginTable1.getSelectedRow();
            String table_click = (loginTable1.getModel().getValueAt(row, 0).toString());
            st_login fetch_login = DBM_system.fetch_login(table_click);
            serial_noTextField1.setText(fetch_login.getS_id() + "");
            rollno_TextField3.setText(fetch_login.getRollno());
            passwordField1.setText(fetch_login.getPass());
            confrm_passwordField2.setText(fetch_login.getPass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loginTable1MouseClicked

    private void new_acoutButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_acoutButton4ActionPerformed
        int s_no = Integer.parseInt(serial_noTextField1.getText());
        int row = 0;
        try {
            row = DBM_system.remove_st_acount(s_no);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Record Deleted.....");
                get_st_login();
                clear_login();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_new_acoutButton4ActionPerformed

    private void new_acoutButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_acoutButton3ActionPerformed
        clear_login();  // TODO add your handling code here:
    }//GEN-LAST:event_new_acoutButton3ActionPerformed

    private void new_acoutButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_acoutButton5ActionPerformed
        JOptionPane.showMessageDialog(null, passwordField1.getText());
    }//GEN-LAST:event_new_acoutButton5ActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        try{
            if (!search_txt.equals(null)) {
            String rollno = search_txt.getText();
            Exam_FormBean bean = DBM_system.get_submit_Samjh(rollno);
            if (bean == null) {
                return;
            }
            sname_TextField1.setText(bean.getEx_name());
            roll_noj.setText(bean.getRollno());
            father_jT.setText(bean.getF_name());
            String type = bean.getEx_typ();
            if (type.equals("Annual")) 
                Annual.setSelected(true);
            
            if (type.equals("Supplementary")) {
                Supplementary.setSelected(true);
            }

            java.util.Date date = bean.getAdm_date();
            date_chose.setDate(date);

            fee_jTextField6.setText(bean.getEx_fee());
            cntct_jTextField7.setText(bean.getContct());

        }

        }catch(NullPointerException e){}

    }//GEN-LAST:event_search_txtKeyReleased

    public void clear_txt() {
        roll_noj.setText(null);
        sname_TextField1.setText(null);
        father_jT.setText(null);
        dpt_Combo.removeItem(null);
        smstr_Com.removeItem(null);
        Annual.setSelected(false);
        Supplementary.setSelected(false);

        date_chose.setDate(null);
        fee_jTextField6.setText(null);
        cntct_jTextField7.setText(null);

    }
    private void update_adminjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_adminjButton1ActionPerformed
        try {
            //Exam_FormBean bean = DBM_system.get_chalnID_names();
            DepartmentBean dp_bean = (DepartmentBean) dpt_Combo.getSelectedItem();
            SemesterBean bean = (SemesterBean) smstr_Com.getSelectedItem();

            String rolln = roll_noj.getText();
            String name = sname_TextField1.getText();
            String fname = father_jT.getText();

            String e_type = null;
            if (Annual.isSelected()) {
                e_type = Annual.getText();
            }
            if (Supplementary.isSelected()) {
                e_type = Supplementary.getText();
            }

            java.sql.Date dts = new java.sql.Date(date_chose.getDate().getTime());

            String fee = fee_jTextField6.getText();
            String cntct = cntct_jTextField7.getText();
            int row = DBM_system.update_Admin_ExamForm(dp_bean.getD_id(), bean.getSm_id(), rolln, name, fname, cntct, fee, dts, e_type);
            JOptionPane.showMessageDialog(null, row);
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Record of " + rolln + " is updated...");
                clear_txt();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_update_adminjButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            LoginForm form = new LoginForm();
            form.setVisible(true);
            this.hide();
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Main_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cntct_jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cntct_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cntct_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main_Admin().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Main_Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Button1;
    private javax.swing.JRadioButton Annual;
    private javax.swing.JTextField D_idTextField2;
    private javax.swing.JList Dept_jList1;
    private javax.swing.JTextField Name_TextField1;
    private javax.swing.JTextArea Remarks_jTextArea1;
    private javax.swing.JRadioButton Supplementary;
    private javax.swing.JButton Update_Button2;
    private javax.swing.JButton add_subButton3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cntct_jTextField7;
    private javax.swing.JPasswordField confrm_passwordField2;
    private javax.swing.JComboBox d_ComboBox2;
    private com.toedter.calendar.JDateChooser date_chose;
    private javax.swing.JComboBox dpt_Combo;
    private javax.swing.JTextField father_jT;
    private javax.swing.JTextField fee_jTextField6;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable loginTable1;
    private javax.swing.JButton new_acoutButton2;
    private javax.swing.JButton new_acoutButton3;
    private javax.swing.JButton new_acoutButton4;
    private javax.swing.JButton new_acoutButton5;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JButton remove_Button3;
    private javax.swing.JButton remove_Button5;
    private javax.swing.JTextField roll_noj;
    private javax.swing.JTextField rollno_TextField3;
    private javax.swing.JTextField s_idTextField3;
    private javax.swing.JTextField s_theoryTextField2;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField serial_noTextField1;
    private javax.swing.JComboBox smstr_Com;
    private javax.swing.JComboBox smstr_ComboBox1;
    private javax.swing.JTextField sname_TextField1;
    private javax.swing.JList sub_List1;
    private javax.swing.JButton update_Button4;
    private javax.swing.JButton update_acoutButton1;
    private javax.swing.JButton update_adminjButton1;
    // End of variables declaration//GEN-END:variables
}
