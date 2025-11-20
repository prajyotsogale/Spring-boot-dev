package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass()+": inside getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": inside setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": inside getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": inside setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Murphy", "Gold"));
        accounts.add(new Account("Sayu", "Silver"));
        accounts.add(new Account("Kazuha", "Platinum"));
        return accounts;
    }

    @Override
    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass()+" Doing my db work:adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": doWork()");
        return false;
    }
}
