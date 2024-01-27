package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
    private String avatar;
    private Role role;
    private Timestamp birthday;
    private String roleName;

    public User() {
    }

    public User(int id, String userName, String password, String name, String email, String phone, Timestamp createdAt, Timestamp updatedAt, String status, String avatar, Role role, Timestamp birthday) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.avatar = avatar;
        this.role=role;
        this.birthday = birthday;
    }
    public User(String userName,String password,Role role) {
        this.userName=userName;
        this.password=password;
        this.role=role;
    }
    public User(int id,String userName){
        this.id=id;
        this.userName=userName;

    }
    public User(int id, String userName, String password, String email, Role role) {
        this.id = id;
        this.userName=userName;
        this.password=password;
        this.email=email;
        this.role=role;
    }

    public User(String name,String userName,String password,String email,Timestamp birthday,String phone){
        this.name=name;
        this.userName=userName;
        this.password=password;
        this.email=email;
        this.birthday=birthday;
        this.phone=phone;
    }
    public User(int id,String username,String password,String name,String email,String phone,Role role,Timestamp birthday){
        this.id=id;
        this.userName=username;
        this.password=password;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.role=role;
        this.birthday=birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}

