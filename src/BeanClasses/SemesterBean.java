/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Muneer Ahmed
 */
public class SemesterBean {
    private int sm_id;
    private String sm_number;
   
    public int getSm_id() {
        return sm_id;
    }

    public void setSm_id(int sm_id) {
        this.sm_id = sm_id;
    }

    public String getSm_number() {
        return sm_number;
    }

    public void setSm_number(String sm_number) {
        this.sm_number = sm_number;
    }

       
    public String toString(){
        return sm_number;
    }
}
