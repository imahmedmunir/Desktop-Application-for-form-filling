/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Management;

import BeanClasses.BankBean;
import BeanClasses.DepartmentBean;
import BeanClasses.Exam_FormBean;
import BeanClasses.SemesterBean;
import BeanClasses.Stdnt_accnts;
import BeanClasses.Subject_Bean;
import BeanClasses.Uni_bank;
import BeanClasses.st_login;
import Frames.Exam_Form;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muneer Ahmed
 */
public class DBM_system {

    static Connection con;

    static {
        try {
            into();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void into() throws Exception {
        
        String url = "jdbc:mysql://localhost:3306/exam_online_form?useSSL=false";
        String username = "root";
        String pass = "root";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, pass);
        System.out.println("Connection Established.......");
    }

    public static DepartmentBean getClarkdpt(int d_id){
        String query="select d_name from department where d_id="+d_id;
        System.out.println(query);
        DepartmentBean bean = new DepartmentBean();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            ps=con.prepareStatement(query);
            resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                String dpt_name=resultSet.getString("d_name");
                
                bean.setD_name(dpt_name);
            }
        }catch(Exception e){e.printStackTrace();}
          return bean;
    }
    
    public static Vector get_dept() throws Exception {
        String query = "select * from department";
        System.out.println(query);
        Vector vctr = new Vector();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int dpt_id = rs.getInt("d_id");
                String dpt_Name = rs.getString("d_name");
                String remarks = rs.getString("remarks");

                DepartmentBean bean = new DepartmentBean();

                bean.setD_id(dpt_id);
                bean.setD_name(dpt_Name);
                bean.setD_remarks(remarks);
                vctr.addElement(bean);

            }
            return vctr;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }



    }

    public static int insert_dept(String d_name, String remarks) throws Exception {
        String query = "insert into department(d_name, remarks) values('" + d_name + "', '" + remarks + "')";
        System.out.println(query);
        PreparedStatement ps = null;
        int row = 0;
        try {
            ps = con.prepareStatement(query);
            row = ps.executeUpdate();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;

    }

    public static int update_dpt(int d_id, String d_name, String d_remarks) throws Exception {
        String query = "update department set d_name='" + d_name + "', remarks='" + d_remarks + "' where d_id=" + d_id;
        System.out.println(query);
        PreparedStatement ps = null;
        int row = 0;
        try {
            ps = con.prepareStatement(query);
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public static int remove_dpt(int id) throws Exception {
        String query = "delete from department where d_id=" + id;
        System.out.println(query);
        PreparedStatement ps = null;
        int row = 0;
        ps = con.prepareStatement(query);
        row = ps.executeUpdate();
        return row;
    }

    public  static SemesterBean getClerksmstr(int sm_id)throws Exception{
    String query="select sm_number from semester where sm_id="+sm_id;
        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        SemesterBean bean = new SemesterBean();
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()){
            String sm_no=rs.getString("sm_number");
            
            bean.setSm_number(sm_no);
        }
        return bean;
        }
    
    public static Vector get_semesters() throws Exception {
        String query = "select * from semester ";
        System.out.println(query);
        Vector v = new Vector();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int smstr_id = rs.getInt("sm_id");
                String smtr_numer = rs.getString("sm_number");

                SemesterBean bean = new SemesterBean();

                bean.setSm_number(smtr_numer);
                bean.setSm_id(smstr_id);
                v.addElement(bean);


            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    public static Vector get_bank() throws Exception {
        String query = "select * from bank";
        System.out.println(query);
        Vector v = new Vector();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int b_id = rs.getInt("bn_id");
                String b_name = rs.getString("bn_name");

                BankBean bean = new BankBean();

                bean.setB_id(b_id);
                bean.setB_name(b_name);
                v.addElement(bean);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    public static Uni_bank get_Uni_bank() throws Exception {
        String query = "select * from uni_bank_account";
        System.out.println(query);
        Uni_bank bean = new Uni_bank();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int b_id = rs.getInt("uni_b_id");
                String b_name = rs.getString("accout_num");
                int balance = rs.getInt("balance");

                bean.setId(b_id);
                bean.setAcc_num(b_name);
                bean.setBalance(balance);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bean;
    }

//    public static Exam_FormBean fetch_data(String rollno) throws Exception {
//        String query = "select * from exam_form where ef_name =" + rollno;
//        System.out.println(query);
//        Exam_FormBean bean = new Exam_FormBean();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = con.prepareStatement(query);
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                int e_id = rs.getInt("ef_id");
//                String e_name = rs.getString("ef_name");
//                String e_rollno = rs.getString("ef_rollno");
//                String f_name = rs.getString("ef_fname");
//                String e_type = rs.getString("ex_type");
//                Date e_date = rs.getDate("exm_date");
//                int e_fee = rs.getInt("ex_fee");
//                String cntct = rs.getString("contact");
//                String challan = rs.getString("challanno");
//                Blob print = rs.getBlob("printchallan");
//
//
//                bean.setEx_id(e_id);
//                bean.setEx_name(e_name);
//                bean.setRollno(e_rollno);
//                bean.setF_name(f_name);
//                bean.setEx_typ(e_type);
//                bean.setAdm_date(e_date);
//                bean.setEx_fee(e_fee);
//                bean.setContct(cntct);
//                bean.setChallano(challan);
//                bean.setPrint_challan(print);
//            }
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return bean;
//
//    }
//
    public static Stdnt_accnts get_stdnt_acc(String ac_num) throws Exception {
        String query = "SELECT * FROM student_accounts where acc_num = " + ac_num;
        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Stdnt_accnts bean = new Stdnt_accnts();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("s_ac_id");
                String acc_no = rs.getString("acc_num");
                String pass = rs.getString("pass");
                int bn_id = rs.getInt("bn_id");
                int balance = rs.getInt("balance");

                bean.setSt_bn_id(id);
                bean.setAcc_num(acc_no);
                bean.setPass(pass);
                bean.setBn_balance(balance);
                bean.setBn_id(bn_id);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Uni_bank get_all() throws Exception {
        String query = "select * from uni_bank_account";
        System.out.println(query);
        Uni_bank uni_bean = new Uni_bank();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int b_id = rs.getInt("uni_b_id");
                String uni_acc = rs.getString("accout_num");
                int balance = rs.getInt("balance");

                uni_bean.setAcc_num(uni_acc);
                uni_bean.setId(b_id);
                uni_bean.setBalance(balance);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return uni_bean;
    }

    public static int updateBalace_Uni(int balnce) throws Exception {
        String query = "update uni_bank_account set balance=" + balnce;
        System.out.println(query);
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            int row = ps.executeUpdate();
            return row;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    public static int updateBalace_Stdnt(String acc_num, int balnce) throws Exception {
        String query = "UPDATE student_accounts SET balance=" + balnce + " WHERE acc_num=" + acc_num;
        System.out.println(query);
        PreparedStatement ps = null;
        try {                       //emarks='"+depRemarks+"' where dep_id="+depId;
            ps = con.prepareStatement(query);
            int row = ps.executeUpdate();
            return row;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
    
    
    public static Boolean login(String name, String pass) throws Exception {
      Boolean accout=false;
        String query = "SELECT roll_no , paswrd FROM stdn_login where roll_no='"+name+"'  and paswrd='"+pass+"'";
        System.out.println(query);
        //st_login bean = new st_login();
        Statement ps = con.createStatement();
        ResultSet rs = ps.executeQuery(query);
        accout=rs.next();
        return accout;
        }

    public static Vector login() throws Exception {
        String query = "SELECT * FROM stdn_login ";
        System.out.println(query);
        //st_login bean = new st_login();
        Vector v = new Vector();
        ArrayList list = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int s_id = rs.getInt("s_id");
                String rollno = rs.getString("roll_no");
                String pass = rs.getString("paswrd");

                st_login bean = new st_login();

                bean.setS_id(s_id);
                bean.setRollno(rollno);
                bean.setPass(pass);
                v.addElement(bean);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;

    }

    public static st_login fetch_login(String table_row) throws Exception {
        String query = "SELECT * FROM stdn_login where s_id=" + table_row;
        System.out.println(query);
        st_login bean = new st_login();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int s_id = rs.getInt("s_id");
                String rollno = rs.getString("roll_no");
                String pass = rs.getString("paswrd");

                bean.setS_id(s_id);
                bean.setRollno(rollno);
                bean.setPass(pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public static int insert_st_acount(int s_id, String rollno, String pass) throws Exception {
        String query = "insert into stdn_login (s_id, roll_no, paswrd) values ("+ s_id +", '" + rollno + "', '" + pass + "')";
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();
        return row;
    }

    public static int update_st_acount(int id, String rollno, String pass) throws Exception {
        String query = "update stdn_login set roll_no= '" + rollno + "', paswrd='" + pass + "' where s_id=" + id;
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();
        return row;
    }

    public static int remove_st_acount(int id) throws Exception {
        String query = "delete from stdn_login where s_id=" + id;
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();
        return row;
    }

    public boolean getAccount(int bankId, String accNum, String passwd) {
        boolean checkAccount = false;
        try {

            String query = "SELECT `acc_num`,`pass`,`bn_id` FROM student_accounts  WHERE `bn_id`=" + bankId + " AND `pass`='" + passwd + "' AND `acc_num`='" + accNum + "';";
            Statement stat = con.createStatement();
            ResultSet executeQuery = stat.executeQuery(query);
            checkAccount = executeQuery.next();


        } catch (SQLException ex) {
            Logger.getLogger(DBM_system.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return checkAccount;
    }

    public static Vector get_Sub(int smstr_id, int dpt_id) throws Exception {
        String query = "SELECT * FROM subjectof_sm WHERE sm_id=" + smstr_id + " AND dpt_id=" + dpt_id;
        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v = new Vector();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                int sub_id = rs.getInt("sb_id");
                String sub_name = rs.getString("sb_names");
                int smst_id = rs.getInt("sm_id");
                int d_id = rs.getInt("dpt_id");

                Subject_Bean bean = new Subject_Bean();
                bean.setSb_id(sub_id);
                bean.setSb_name(sub_name);
                bean.setSm_id(smst_id);
                bean.setDpt_id(dpt_id);
                v.addElement(bean);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public static int insert_sub(int d_id, int smstr_id, String sub_name) throws Exception {
        String query = "insert into subjectof_sm (dpt_id, sm_id, sb_names) values(" + d_id + ", " + smstr_id + ", '" + sub_name + "')";
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();

        return row;

    }

    public static int update_sub(int s_id, int dpt_id, int smstr_id, String sub_name) throws Exception {
        String query = "update subjectof_sm set sb_names='" + sub_name + "' where sb_id=" + s_id + " and dpt_id=" + dpt_id + " and sm_id=" + smstr_id;
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();
        return row;
    }

    public static int remove_sub(int s_id, int d_id, int sm_id) throws Exception {
        String query = "delete from subjectof_sm where sb_id=" + s_id + " and dpt_id=" + d_id + " and sm_id=" + sm_id;
        System.out.println(query);
        PreparedStatement ps = null;
        ps = con.prepareStatement(query);
        int row = ps.executeUpdate();
        return row;
    }

    public static Exam_FormBean get_chalnID_names() throws Exception {
        String query = "select ef_id from exam_form";
        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Exam_FormBean bean = new Exam_FormBean();

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ex_id = rs.getInt("ef_id");
                //String name = rs.getString("ef_name");

                bean.setEx_id(ex_id);
                //bean.setEx_name(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;

    }

    public static Vector get_submittedForm(String roll_no) {
        String query = "SELECT exam_form.*, d_name, sm_number FROM exam_form , department , semester WHERE  exam_form.ef_rollno='"+roll_no+"' and  exam_form.dpt_id=department.d_id AND exam_form.smstr_id=semester.sm_id and ef_rollno";
        
        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector v = new Vector();
        try{
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            
           if(rs.next()){
               String name =rs.getString("ef_name");
               String roll=rs.getString("ef_rollno");
               String fname=rs.getString("ef_fname");
               String fee=rs.getString("ex_fee");
               String cntct=rs.getString("contact");
               String ex_type=rs.getString("ex_type");
               Date date = rs.getDate("exm_date");
               String smstr = rs.getString("sm_number");
               String dpt= rs.getString("d_name");
               
               Exam_FormBean form_Bean = new Exam_FormBean();
               DepartmentBean departmentBean = new DepartmentBean();
               SemesterBean sb = new SemesterBean();
               
               form_Bean.setEx_name(name);
               form_Bean.setRollno(roll_no);
               form_Bean.setF_name(fname);
               form_Bean.setEx_fee(fee);
               form_Bean.setContct(cntct);
               form_Bean.setEx_typ(ex_type);
               form_Bean.setAdm_date(date);
               sb.setSm_number(smstr);
               departmentBean.setD_name(dpt);
               
               v.add(form_Bean);
               v.add(sb);
               v.add(departmentBean);
               
               
           }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return v;

    }
    
    
    
    public static Exam_FormBean get_submit_Samjh(String roll_no) {
        String query = "SELECT * FROM exam_form WHERE  ef_rollno= '"+roll_no+"' ";

        System.out.println(query);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Exam_FormBean form_Bean = new Exam_FormBean();
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

           while(rs.next()) {
                String name = rs.getString("ef_name");
                String roll = rs.getString("ef_rollno");
                String fname = rs.getString("ef_fname");
                String fee = rs.getString("ex_fee");
                String cntct = rs.getString("contact");
                String ex_type = rs.getString("ex_type");
                Date date = rs.getDate("exm_date");
                String feePaid=rs.getString("Form_print");
                int chalano=rs.getInt("ef_id");
                int ex_id=rs.getInt("ef_id");
                int dpt_id=rs.getInt("dpt_id");
                int sm_id=rs.getInt("smstr_id");
                //String acc= rs.getString("acc_no");
                
                //form_Bean.setAcc(acc);
                form_Bean.setEx_name(name);
                form_Bean.setRollno(roll_no);
                form_Bean.setF_name(fname);
                form_Bean.setEx_fee(fee);
                form_Bean.setContct(cntct);
                form_Bean.setEx_typ(ex_type);
                form_Bean.setAdm_date(date);
                form_Bean.setPrint_challan(feePaid);
                form_Bean.setChallano(chalano);
                form_Bean.setEx_id(ex_id);
                form_Bean.setDpt_id(dpt_id);
                form_Bean.setSmstr_id(sm_id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return form_Bean;
     }

    public static int insert_ExamForm(int d_id, int Smstr_id, String name, String rollno, String F_name, String ex_type, Date date, int fee, String contact, int chal_no, String form_print) throws Exception {
        String query = "INSERT INTO exam_form (dpt_id,smstr_id,ef_name, ef_rollno, ef_fname,ex_type, exm_date,ex_fee,contact,challanno,Form_print) VALUES (" + d_id + ", " + Smstr_id + ", '" + name + "', '" + rollno + "', '" + F_name + "', '" + ex_type + "', '" + date + "'," + fee + ",'" + contact + "'," + chal_no + ",'" + form_print + "')";
        System.out.println(query);
        PreparedStatement ps = null;
        int row = 0;
        try {
            ps = con.prepareStatement(query);
            row = ps.executeUpdate();

            return row;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;


    }

    public static int update_Admin_ExamForm(int d_id, int sm_id, String rollno, String name, String f_name, String cntct, String fee, Date date, String type ) {
        String query = "update exam_form set ef_name='" + name + "', ef_fname='" + f_name + "', contact='" + cntct + "', ex_fee='" + fee + "', exm_date='" + date + "', ex_type='" + type + "' , dpt_id="+d_id+" , smstr_id="+sm_id+" where ef_rollno='"+rollno+"'";
        System.out.println(query);
        PreparedStatement ps = null;
        int row = 0;
        try {
            ps = con.prepareStatement(query);
            row = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBM_system.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    
    }

