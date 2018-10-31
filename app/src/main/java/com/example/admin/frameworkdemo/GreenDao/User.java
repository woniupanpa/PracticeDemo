package com.example.admin.frameworkdemo.GreenDao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
@Entity        /*@Entity表示这个实体类一会会在数据库中生成对应的表*/
public class User {
    @Id
    private Long id;/*@Id表示该字段是id*/
    @Property(nameInDb = "USERNAME")
    private String username;/*@Property则表示该属性将作为表的一个字段，其中nameInDb看名字就知道这个属性在数据库中对应的数据名称*/
    @Property(nameInDb = "NICKNAME")
    private String nickname;
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 523935516)
    public User(Long id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "id="+id+ " " +"username=" + username + " " + "nickname" + nickname ;
    }
}
