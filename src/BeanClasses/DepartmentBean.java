package BeanClasses;
public class DepartmentBean {
    private int d_id;
    private String d_name;
    private String d_remarks;

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_remarks() {
        return d_remarks;
    }

    public void setD_remarks(String d_remarks) {
        this.d_remarks = d_remarks;
    }
    
    public String toString(){
        return d_name;
    }
}
