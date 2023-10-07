/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Muneer Ahmed
 */
public class Exam_FormBean {
    private  DepartmentBean db=null;
    private SemesterBean sb=null;
    
    /*we are making object of department and semester 
     * because there is relationship b/w tables
     * so we make collection frame work (any list) generic
     * if we do not have generic list then we have to add
     * all the object in list and fetch one by one...
     * that will work properly but not a good approach
     * so we are making getter and setter of relationship (table) class
     * departmetn and semester
     */

    public DepartmentBean getDb() {
        return db;
    }

    public void setDb(DepartmentBean db) {
        this.db = db;
    }

    public SemesterBean getSb() {
        return sb;
    }

    public void setSb(SemesterBean sb) {
        this.sb = sb;
    }
    
    
    private int ex_id;
    private String ex_name;
    private String rollno;
    private String f_name;
    private String ex_typ;
    private String ex_fee;
    private String contct;
    private int challano;
    private String print_challan;
    Date adm_date;
    private int dpt_id;
    private int smstr_id;
    private String acc;

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public int getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }

    public int getSmstr_id() {
        return smstr_id;
    }

    public void setSmstr_id(int smstr_id) {
        this.smstr_id = smstr_id;
    }
    

    public int getEx_id() {
        return ex_id;
    }

    public void setEx_id(int ex_id) {
        this.ex_id = ex_id;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getEx_typ() {
        return ex_typ;
    }

    public void setEx_typ(String ex_typ) {
        this.ex_typ = ex_typ;
    }

    public String getEx_fee() {
        return ex_fee;
    }

    public void setEx_fee(String ex_fee) {
        this.ex_fee = ex_fee;
    }

    public String getContct() {
        return contct;
    }

    public void setContct(String contct) {
        this.contct = contct;
    }

    public int getChallano() {
        return challano;
    }

    public void setChallano(int challano) {
        this.challano = challano;
    }

    public String getPrint_challan() {
        return print_challan;
    }

    public void setPrint_challan(String print_challan) {
        this.print_challan = print_challan;
    }

    public Date getAdm_date() {
        return adm_date;
    }

    public void setAdm_date(Date adm_date) {
        this.adm_date = adm_date;
    }

    public String toString(){
        return ex_name;
    }

}
