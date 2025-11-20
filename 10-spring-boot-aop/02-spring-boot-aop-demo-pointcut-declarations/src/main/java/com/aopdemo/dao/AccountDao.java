package com.aopdemo.dao;

import com.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account, Boolean vipFlag);
    boolean doWork();

    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
