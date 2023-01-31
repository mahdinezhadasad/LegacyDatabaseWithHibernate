package com.example.legacyjpa.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "wp_users", indexes = {@Index(name = "user_login_key", columnList = "user_login"),
        @Index(name = "user_nicenam", columnList = "user_nicename"),
        @Index(name = "user_email", columnList = "user_email")})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max = 60)
    @Column(name = "user_login", length = 60)
    private String login;
    
    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserMeta>  userMetaSet;
    
    @NotNull
    @Size(max = 60)
    @Column(name = "user_pass")
    private String password;
    
    @NotNull
    @Size(max = 50)
    @Column(name = "user_nicename")
    private String nicename;
    @NotNull
    @Size(max = 100)
    @Email
    @Column(name = "user_email", length = 100)
    private String email;
    @NotNull
    @Size(max = 100)
    @URL
    @Column(name = "user_url", length = 100)
    private String url;
    @NotNull
    @Column(name = "user_registered")
    private Timestamp registered;
    
    @NotNull
    @Size(max = 255)
    @Column(name = "user_activation_key", length = 255)
    private String activationKey;
    
    @NotNull
    @Column(name = "user_status")
    private Integer status;
    @NotNull
    @Size(max = 250)
    @Basic(optional = false)
    private String displayName;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getNicename() {
        return nicename;
    }
    
    public void setNicename(String nicename) {
        this.nicename = nicename;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Timestamp getRegistered() {
        return registered;
    }
    
    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }
    
    public String getActivationKey() {
        return activationKey;
    }
    
    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}