package springboot.demosecurity.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
    @Id
    @Column(name="username")
    private String userId;
    @Column(name="authority")
    private String role;

    public Authority(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public Authority() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "authority{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
