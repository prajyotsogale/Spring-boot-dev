package com.aopdemo.dao;

import com.aopdemo.Account;

public interface AccountDao {
    void addAccount(Account account, Boolean vipFlag);
    boolean doWork();
}
