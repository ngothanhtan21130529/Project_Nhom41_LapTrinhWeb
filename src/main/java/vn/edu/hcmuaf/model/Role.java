package vn.edu.hcmuaf.model;

import java.io.Serializable;

public class Role implements Serializable {
    private int id;
    private String roleName;

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    public Role(String roleName){
        this.roleName=roleName;
    }
    public Role(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
