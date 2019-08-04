package assigment.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Account {
    @Id
    private String email;
    private String password;
    private String name;
    private String phone;
    private String imgUrl;
    private int status;
    private long createdAt;
    private long updatedAt;

    public long getCreatedAt() {
        return createdAt;
    }

    public int getStatus() {
        return status;
    }

    public Account setStatus(int status) {
        this.status = status;
        return this;
    }

    public Account setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public Account setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Account setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
