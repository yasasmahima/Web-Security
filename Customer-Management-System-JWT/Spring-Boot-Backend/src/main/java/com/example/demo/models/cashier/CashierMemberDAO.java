package com.example.demo.models.cashier;


import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "CashierMember ")
public class CashierMemberDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "cashierName")
    private String cashierName;

    @Column(name = "cashierContactNo")
    private String cashierContactNo;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierContactNo() {
        return cashierContactNo;
    }

    public void setCashierContactNo(String cashierContactNo) {
        this.cashierContactNo = cashierContactNo;
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

    @Override
    public String toString() {
        return "CashierMember{" +
                "id=" + id +
                ", cashierName='" + cashierName + '\'' +
                ", cashierContactNo='" + cashierContactNo + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
