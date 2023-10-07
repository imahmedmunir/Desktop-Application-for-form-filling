/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author Muneer Ahmed
 */
public class Stdnt_accnts {
    private int st_bn_id;
    private String acc_num;
    private String pass;
    private int bn_id;
    private int bn_balance;
private byte[] file;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    public int getSt_bn_id() {
        return st_bn_id;
    }

    public void setSt_bn_id(int st_bn_id) {
        this.st_bn_id = st_bn_id;
    }

    public String getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(String acc_num) {
        this.acc_num = acc_num;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getBn_id() {
        return bn_id;
    }

    public void setBn_id(int bn_id) {
        this.bn_id = bn_id;
    }

    public int getBn_balance() {
        return bn_balance;
    }

    public void setBn_balance(int bn_balance) {
        this.bn_balance = bn_balance;
    }
    
}
