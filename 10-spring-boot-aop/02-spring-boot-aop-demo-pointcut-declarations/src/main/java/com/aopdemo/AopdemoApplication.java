package com.aopdemo;

import com.aopdemo.dao.AccountDao;
import com.aopdemo.dao.MembershipDao;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDao accountDao, TrafficFortuneService trafficFortuneService){
        return runner->{
            //demoTheBeforeAdvice(accountDao, membershipDao);
            //demoTheAfterReturningAdvice(accountDao);
            //demoTheAfterThrowingAdvice(accountDao);
            //demoTheAfterFinallyAdvice(accountDao);
            //demoTheAroundAdvice(trafficFortuneService);
            //demoTheAroundAdviceHandleException(trafficFortuneService);
            demoTheAroundAdviceRethrowException(trafficFortuneService);
        };
    }

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
        System.out.println("Calling getFortune method");
        Boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\nMy fortune is: "+data);
        System.out.println("done");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
        System.out.println("Calling getFortune method");
        Boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println("\nMy fortune is: "+data);
        System.out.println("done");
    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program: demoTheAroundAdvice");
        System.out.println("Calling getFortune method");
        String data = trafficFortuneService.getFortune();
        System.out.println("\nMy fortune is: "+data);
        System.out.println("done");
    }

    private void demoTheAfterFinallyAdvice(AccountDao accountDao) {
        List<Account> accounts = null;

        try{
            boolean tripWire = false;
            accounts = accountDao.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("Main Program: caught the exception: "+exc);
        }


        System.out.println("Main Program: demoTheAfterFinallyAdvice");
        System.out.println("Displaying the accounts");
        System.out.println(accounts+"\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
        List<Account> accounts = null;

        try{
            boolean tripWire = true;
            accounts = accountDao.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("Main Program: caught the exception: "+exc);
        }
        System.out.println("Main Program: demoTheAfterReturningAdvice");
        System.out.println("Displaying the accounts");
        System.out.println(accounts+"\n");

    }

    private void demoTheAfterReturningAdvice(AccountDao accountDao) {
        List<Account> accounts = accountDao.findAccounts();

        System.out.println("Main Program: demoTheAfterReturningAdvice");
        System.out.println("Displaying the accounts");
        System.out.println(accounts+"\n");


    }

    private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
        Account account = new Account();
        account.setName("mercury");
        account.setLevel("platinum");
        accountDao.addAccount(account, true);
        accountDao.doWork();

        //call the getter and setters from account
        System.out.println("\ncalling getter and setters");
        accountDao.setName("nemar");
        accountDao.setServiceCode("football");
        String name = accountDao.getName();
        String serviceCode = accountDao.getServiceCode();

        System.out.println("\nCalling the membership business method");
        membershipDao.addMember();
        membershipDao.goToSleep();
    }
}
