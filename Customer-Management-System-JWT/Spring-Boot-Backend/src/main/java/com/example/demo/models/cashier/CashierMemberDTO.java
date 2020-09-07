package com.example.demo.models.cashier;


//Responsible for get data and pass it to DAO layer (Pass to database) via CashierMemberDAO
public class CashierMemberDTO {

    private String cashierName;
    private String cashierContactNo;
    private String userName;
    private String password;

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
}
