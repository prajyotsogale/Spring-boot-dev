package com.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao{
    @Override
    public Boolean addMember() {
        System.out.println(getClass()+" Doing my db work:adding a membership account in membershipdao");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+" going to sleep...");

    }
}
