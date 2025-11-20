package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
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
