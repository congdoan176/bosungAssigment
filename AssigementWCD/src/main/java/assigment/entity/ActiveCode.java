package assigment.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
public class ActiveCode {
    @Id
    private String code;
//    private long expiredTime;
    private int status;// 1.da dung , 2.chua dung
    private long createdAt;
    private long updatedAt;

    @Index
    @Load
    private Ref<Account> email;

    public ActiveCode() {
        this.code = generatNumberCode();
        this.status = 1;
    }
    public static String generatNumberCode() {
        String generatedString = RandomStringUtils.randomAlphanumeric(7);
        System.out.println(generatedString);
        return generatedString;
    }
    public String getCode() {
        return code;
    }

    public ActiveCode setCode(String code) {
        this.code = code;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ActiveCode setStatus(int status) {
        this.status = status;
        return this;
    }

    public Ref<Account> getEmail() {
        return email;
    }

    public ActiveCode setEmail(Ref<Account> email) {
        this.email = email;
        return this;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public ActiveCode setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public ActiveCode setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
