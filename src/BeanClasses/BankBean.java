/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Muneer Ahmed
 */
public class BankBean {
    private int b_id;
    private String b_name;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
    
    public String toString(){
        return b_name;
    }
}
