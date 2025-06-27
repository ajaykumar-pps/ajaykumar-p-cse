package com.finance.model;

public class LoanModel {
    private int id;                
    private String name;
    private String email;
    private String phone;
    private String address;
    private double loanAmount;
    private String loanType;
    private int duration;         
    private double income;
    private String status;         

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
