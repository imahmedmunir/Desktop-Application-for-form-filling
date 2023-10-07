/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import BeanClasses.DepartmentBean;
import BeanClasses.Exam_FormBean;
import BeanClasses.SemesterBean;
import BeanClasses.Stdnt_accnts;
import BeanClasses.Uni_bank;
import DB_Management.DBM_system;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;

/**
 *
 * @author Muneer Ahmed
 */
public class Exam_Form extends javax.swing.JFrame {

    Boolean access = false; //defining instance variable

    public Exam_Form() throws Exception {
        initComponents();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("muet_logo.png")));

        buttonGroup1.add(suplementary_RButton1);
        buttonGroup1.add(Annual_RadioButton2);

        Toolkit kit = this.getToolkit();
        Dimension size = kit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        get_dpt_item();
        get_bank_item();
        get_uniAcc();
        get_smstr();
        get_sub();
        get_chaln_id();
        date_chose.setDate(new java.util.Date());
    }

    public void get_chaln_id() throws Exception {

        Exam_FormBean bean = DBM_system.get_chalnID_names();
        int id = bean.getEx_id() + 1;
        challano_TextField1.setText(id + "");
    }

    public void get_uniAcc() throws Exception {
        Uni_bank u_bean = new Uni_bank();
        u_bean = DBM_system.get_all();
        UniAcc_TextField3.setText(u_bean.getAcc_num());
    }

    public void get_dpt_item() throws Exception {
        Vector v = new Vector();
        v = DBM_system.get_dept();
        dpt_ComboBox2.removeAllItems();

        for (int i = 0; i < v.size(); i++) {
            dpt_ComboBox2.addItem(v.elementAt(i));
        }
    }

    public void get_smstr() throws Exception {
        Vector v = new Vector();
        v = DBM_system.get_semesters();
        smstr_ComboBox1.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            smstr_ComboBox1.addItem(v.elementAt(i));
        }
    }

    public void get_sub() throws Exception {
        SemesterBean bean = (SemesterBean) smstr_ComboBox1.getSelectedItem();
        DepartmentBean bean2 = (DepartmentBean) dpt_ComboBox2.getSelectedItem();

        if (bean == null) {
            return;
        }
        Vector v = new Vector();
        v = DBM_system.get_Sub(bean.getSm_id(), bean2.getD_id());
        subject_List1.setListData(v);
    }

    public void get_bank_item() throws Exception {
        Vector v = new Vector();
        v = DBM_system.get_bank();
        bank_ComboBox3.removeAllItems();
        for (int i = 0; i < v.size(); i++) {
            bank_ComboBox3.addItem(v.elementAt(i));
        }
    }
    String acc_no = null;  //student acc_no
    File challn = null; //bank challan

    public void challan_method() {
        try {
            challn = new File(name_TextField.getText() + " challan.pdf");
            String FilePath = challn.getAbsolutePath();
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(FilePath));
            String name =name_TextField.getText();
            String fee = fees_TextField3.getText();
            String fee_submit=feeSubmitting_TextField5.getText();
            document.open();
            Exam_FormBean efb = DBM_system.get_submit_Samjh(roll_TextField1.getText());
            //if (efb == null) return;
            document.add(new Paragraph(" HBL MUET University              ", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph(" Sub-Branch Jamshoro              ", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph("                                  Bank copy   ", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph(" A/C No:                          " + acc_no, FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph(" Challan no:                      " + efb.getChallano(), FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph(" Reg: no :   _____________________", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, Font.BOLD)));
            document.add(new Paragraph(" Full Name :                      " + name, FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" Exam Fee :                       " + fee, FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" Fee Paid :                       " + fee_submit, FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" -----------------------------------------------", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" Amount in words: One Thousand Six hundred only            ", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph("-------------------------------------------------", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" Manager :                     Cashier:                                 ", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.add(new Paragraph(" ______________                ___________________ ", FontFactory.getFont(FontFactory.TIMES_BOLD, 8, Font.BOLD)));
            document.close();
           
            } catch (Exception e) {
        }
    }

    public Boolean access() {
        Boolean check = false;
        try {

            Stdnt_accnts bean = new Stdnt_accnts();
            DBM_system bM_system = new DBM_system();
            int bankId = bank_ComboBox3.getSelectedIndex() + 1;
            String accNum = accno_TextField2.getText();
            String pass = acc_PasswordField1.getText();
            boolean account = bM_system.getAccount(bankId, accNum, pass);
            JOptionPane.showMessageDialog(null, "Is there any Acccount  :" + account);

            if (account == true) {
                int fee = Integer.parseInt(fees_TextField3.getText() + "");
                String uni_acc = UniAcc_TextField3.getText();
                bean = DBM_system.get_stdnt_acc(accNum);

                int st_acc_balance = bean.getBn_balance();
                JOptionPane.showMessageDialog(null, "Student balance " + st_acc_balance);

                if (st_acc_balance >= fee) {
                    Uni_bank u_b = new Uni_bank();
                    u_b = DBM_system.get_Uni_bank();
                    int blnce = u_b.getBalance();
                    JOptionPane.showMessageDialog(null, "Uni balance " + blnce);
                    int tot_blnc = fee + blnce;
                    int new_st_bln = st_acc_balance - fee;
                    JOptionPane.showMessageDialog(null, "total blnce " + tot_blnc);
                    int row = DBM_system.updateBalace_Uni(tot_blnc);
                    int row1 = DBM_system.updateBalace_Stdnt(accNum, new_st_bln);

                    if (row > 0 && row1 > 0) {
                        acc_no = accno_TextField2.getText();
                        JOptionPane.showMessageDialog(null, "Your exam fee Transfered to University Bank Successfully");
                        check = true;
                        challan_method();
                        accno_TextField2.setText(null);
                        acc_PasswordField1.setText(null);
                        get_chaln_id();
                    }

                } else {
                    String stmnt = "Your Account balance is less than required \n Please Recharge your account";
                    JOptionPane.showMessageDialog(null, stmnt);
                    accno_TextField2.setText(null);
                    acc_PasswordField1.setText(null);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }

//    public Boolean access() {
//        boolean pas = false;
//        Stdnt_accnts bean = new Stdnt_accnts();
//
//        DBM_system bM_system = new DBM_system();
//        int bankId = bank_ComboBox3.getSelectedIndex() + 1;
//        String accNum = accno_TextField2.getText();
//        String pass = acc_PasswordField1.getText();
//        boolean account = bM_system.getAccount(bankId, accNum, pass);
//        JOptionPane.showMessageDialog(null, "Is Acccount :" + account);
//        if (account == true) {
//            pas = true;
//        }
//
//        return pas;
//    }
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject_List1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        dpt_ComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        challano_TextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        roll_TextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Annual_RadioButton2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        UniAcc_TextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fname_TextField2 = new javax.swing.JTextField();
        acc_PasswordField1 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        bank_ComboBox3 = new javax.swing.JComboBox();
        Transfer_Button2 = new javax.swing.JButton();
        accno_TextField2 = new javax.swing.JTextField();
        fees_TextField3 = new javax.swing.JTextField();
        smstr_ComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        contact_TextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        suplementary_RButton1 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        feeSubmitting_TextField5 = new javax.swing.JTextField();
        date_chose = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Examination Form");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null, new java.awt.Font("Algerian", 3, 36), new java.awt.Color(0, 0, 255))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(subject_List1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null, new java.awt.Font("Arial Rounded MT Bold", 3, 24), new java.awt.Color(51, 0, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 255));

        jLabel9.setText("Exam Fee");

        dpt_ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpt_ComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Father Name");

        challano_TextField1.setEditable(false);
        challano_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challano_TextField1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Fees");

        jLabel11.setText("Department");

        name_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_TextFieldActionPerformed(evt);
            }
        });

        roll_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roll_TextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Semester");

        Annual_RadioButton2.setText("Annual");

        jLabel4.setText("Roll No:");

        UniAcc_TextField3.setEditable(false);
        UniAcc_TextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UniAcc_TextField3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Examination");

        fname_TextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname_TextField2ActionPerformed(evt);
            }
        });

        acc_PasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_PasswordField1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Challan No:");

        bank_ComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bank_ComboBox3ActionPerformed(evt);
            }
        });

        Transfer_Button2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Transfer_Button2.setForeground(new java.awt.Color(255, 0, 0));
        Transfer_Button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attach.png"))); // NOI18N
        Transfer_Button2.setText("Transfer");
        Transfer_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transfer_Button2ActionPerformed(evt);
            }
        });

        accno_TextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accno_TextField2ActionPerformed(evt);
            }
        });

        fees_TextField3.setEditable(false);
        fees_TextField3.setText("1600");
        fees_TextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fees_TextField3ActionPerformed(evt);
            }
        });

        smstr_ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smstr_ComboBox1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Exam Date");

        contact_TextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact_TextField4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Name");

        jLabel12.setText("Bank");

        suplementary_RButton1.setText("Suplementary");
        suplementary_RButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplementary_RButton1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Acc: number");

        jLabel15.setText("Password");

        jLabel16.setText("University Acc: no:");

        jLabel18.setText("Contact");

        feeSubmitting_TextField5.setEditable(false);
        feeSubmitting_TextField5.setText("Online Paid");
        feeSubmitting_TextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeSubmitting_TextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(smstr_ComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpt_ComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roll_TextField1)
                                .addComponent(name_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fname_TextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Annual_RadioButton2)
                                    .addGap(18, 18, 18)
                                    .addComponent(suplementary_RButton1))
                                .addComponent(contact_TextField4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(date_chose, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(76, 76, 76)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(challano_TextField1)
                                    .addComponent(bank_ComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(accno_TextField2)
                                    .addComponent(acc_PasswordField1)
                                    .addComponent(UniAcc_TextField3)
                                    .addComponent(fees_TextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Transfer_Button2)))
                        .addGap(73, 73, 73))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(feeSubmitting_TextField5)
                        .addGap(450, 450, 450))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpt_ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(challano_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(smstr_ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roll_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bank_ComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(acc_PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UniAcc_TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(fname_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Annual_RadioButton2)
                                    .addComponent(suplementary_RButton1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(accno_TextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fees_TextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(date_chose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Transfer_Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact_TextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(feeSubmitting_TextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Subjects");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_1.png"))); // NOI18N
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
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(233, 233, 233))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(531, 531, 531))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (access == true) {
                // Exam_FormBean bean = new Exam_FormBean();
                DepartmentBean d_bea = (DepartmentBean) dpt_ComboBox2.getSelectedItem();
                int d_id = Integer.parseInt(d_bea.getD_id() + ""); //getting id and converting into Integer
                SemesterBean s_bean = (SemesterBean) smstr_ComboBox1.getSelectedItem();
                int s_id = Integer.parseInt(s_bean.getSm_id() + "");

                //bean = DBM_system.get_all_examForm();
                //  challano_TextField1.setText(bean.getEx_id()+1 + "");//if anyone submiting online
                String rollno = roll_TextField1.getText();            //chalan number;
                String name = name_TextField.getText();
                String f_name = fname_TextField2.getText();
                String exm_type = null;
                if (Annual_RadioButton2.isSelected()) {
                    exm_type = Annual_RadioButton2.getText();
                } else if (suplementary_RButton1.isSelected()) {
                    exm_type = suplementary_RButton1.getText();
                }

                   java.sql.Date dts = new java.sql.Date(date_chose.getDate().getTime());
                int chall_num = Integer.parseInt(challano_TextField1.getText() + "");
                String cntc = contact_TextField4.getText();
                int fee = Integer.parseInt(fees_TextField3.getText() + "");
                String print_form = feeSubmitting_TextField5.getText();
                int row = DBM_system.insert_ExamForm(d_id, s_id, name, rollno, f_name, exm_type, dts, fee, cntc, chall_num, print_form);
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, name + " your Exam form submitted ");
                    access = false;
                }
            } else {
                String statmnt = "Dear You must submit exam fees \n You did not submit fees";
                JOptionPane.showMessageDialog(null, statmnt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void feeSubmitting_TextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeSubmitting_TextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeSubmitting_TextField5ActionPerformed

    private void suplementary_RButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplementary_RButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suplementary_RButton1ActionPerformed

    private void contact_TextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact_TextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact_TextField4ActionPerformed

    private void smstr_ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smstr_ComboBox1ActionPerformed
        try {
            get_sub();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_smstr_ComboBox1ActionPerformed

    private void fees_TextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fees_TextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fees_TextField3ActionPerformed

    private void accno_TextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accno_TextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accno_TextField2ActionPerformed

    private void Transfer_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Transfer_Button2ActionPerformed
        access = access(); //access is instance variable defined in class
        //access() is mathod which will return boolean value

        //        public Boolean access() {
            //            Boolean check=false;
            //           try {
                //
                //            Stdnt_accnts bean = new Stdnt_accnts();
                //            DBM_system bM_system = new DBM_system();
                //            int bankId = bank_ComboBox3.getSelectedIndex() + 1;
                //            String accNum = accno_TextField2.getText();
                //            String pass = acc_PasswordField1.getText();
                //            boolean account = bM_system.getAccount(bankId, accNum, pass);
                //            JOptionPane.showMessageDialog(null, "Is Acccount :" + account);
                //
                //            if (account == true) {
                    //                int fee = Integer.parseInt(fees_TextField3.getText() + "");
                    //                String uni_acc = UniAcc_TextField3.getText();
                    //                bean = DBM_system.get_stdnt_acc(accNum);
                    //
                    //                int st_acc_balance = bean.getBn_balance();
                    //                JOptionPane.showMessageDialog(null, "Student balance " + st_acc_balance);
                    //
                    //                if (st_acc_balance >= fee) {
                        //                    Uni_bank u_b = new Uni_bank();
                        //                    u_b = DBM_system.get_Uni_bank();
                        //                    int blnce = u_b.getBalance();
                        //                    JOptionPane.showMessageDialog(null, "Uni balance " + blnce);
                        //                    int tot_blnc = fee + blnce;
                        //                    int new_st_bln = st_acc_balance - fee;
                        //                    JOptionPane.showMessageDialog(null, "total blnce " + tot_blnc);
                        //                    int row = DBM_system.updateBalace_Uni(tot_blnc);
                        //                    int row1 = DBM_system.updateBalace_Stdnt(accNum, new_st_bln);
                        //
                        //                    if (row > 0 && row1 > 0) {
                            //                        JOptionPane.showMessageDialog(null, "Your exam fee Transfered to University Bank Successfully");
                            //                        check=true;
                            //                    }
                        //
                        //                }
                    //            }
                //
                //        } catch (Exception e) {e.printStackTrace();}
            //
            //           return check;
            //        }
        //       Stdnt_accnts bean = new Stdnt_accnts();
        //
        //       DBM_system bM_system=new DBM_system();
        //       int bankId=bank_ComboBox3.getSelectedIndex()+1;
        //       String accNum=accno_TextField2.getText();
        //       String pass=acc_PasswordField1.getText();
        //        boolean account = bM_system.getAccount(bankId,accNum,pass);
        //        JOptionPane.showMessageDialog(null,"Is Acccount :"+account);
        //        //try{
            //BankBean bean1 = (BankBean)bank_ComboBox3.getSelectedItem();
            //       bean=DBM_system.get_stdnt_acc();
            //
            //       String acc_num = accno_TextField2.getText();
            //       String acc_pass = acc_PasswordField1.getText();
            //      //  int b=bean1.getB_id();
            //       int sb =bean.getBn_id();
            //        JOptionPane.showMessageDialog(null, b);
            //        JOptionPane.showMessageDialog(null, sb);
            //
            //
            //       JOptionPane.showMessageDialog(null, b==bean.getBn_id());
            //      // JOptionPane.showMessageDialog(null, bean.getAcc_num());
            //
            //        if(b==bean.getBn_id() && acc_num.equals(bean.getAcc_num()) && acc_pass.equals(bean.getPass())){
                //           JOptionPane.showMessageDialog(null, "wellcome");
                //
                //           int fee= Integer.parseInt(fees_TextField3+"");
                //            String uni_acc = UniAcc_TextField3.getText();
                //
                //            int st_acc_balance =bean.getBn_balance();
                //
                //            if(st_acc_balance>=fee){
                    //                Uni_bank u_b= new Uni_bank();
                    //                int blnce=u_b.getBalance();
                    //                int tot_blnc=fee+blnce;
                    //
                    //              JOptionPane.showMessageDialog(null, tot_blnc);
                    //            }
                //
                //
                //        }else
            //       {
                //           JOptionPane.showMessageDialog(null, "Account Number or password is incorrect");
                //       }
            //   }catch(Exception e){e.printStackTrace();}
        //
        //
    }//GEN-LAST:event_Transfer_Button2ActionPerformed

    private void bank_ComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bank_ComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bank_ComboBox3ActionPerformed

    private void acc_PasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_PasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_PasswordField1ActionPerformed

    private void fname_TextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname_TextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname_TextField2ActionPerformed

    private void UniAcc_TextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UniAcc_TextField3ActionPerformed

    }//GEN-LAST:event_UniAcc_TextField3ActionPerformed

    private void roll_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roll_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roll_TextField1ActionPerformed

    private void name_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_TextFieldActionPerformed

    private void challano_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challano_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_challano_TextField1ActionPerformed

    private void dpt_ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpt_ComboBox2ActionPerformed
        try {
            get_smstr();
        } catch (Exception ex) {
            Logger.getLogger(Exam_Form.class
                .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dpt_ComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam_Form.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Exam_Form().setVisible(true);




                } catch (Exception ex) {
                    Logger.getLogger(Exam_Form.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Annual_RadioButton2;
    private javax.swing.JButton Transfer_Button2;
    private javax.swing.JTextField UniAcc_TextField3;
    private javax.swing.JPasswordField acc_PasswordField1;
    private javax.swing.JTextField accno_TextField2;
    private javax.swing.JComboBox bank_ComboBox3;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
