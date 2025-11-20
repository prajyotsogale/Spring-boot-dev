package com.aopdemo;

import com.aopdemo.dao.AccountDao;
import com.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
        return runner->{
            demoTheBeforeAdvice(accountDao, membershipDao);



        };
    }

    private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
        Account account = new Account();
        accountDao.addAccount(account, true);
        accountDao.doWork();

        System.out.println("\nCalling the membership business method");

        membershipDao.addMember();
        membershipDao.goToSleep();
    }
}
