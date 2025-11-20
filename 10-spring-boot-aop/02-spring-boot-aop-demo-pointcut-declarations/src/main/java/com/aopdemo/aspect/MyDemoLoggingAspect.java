package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n<---------> Executing @Around on method: "+method);

//        Long begin = System.currentTimeMillis();
        Long begin = System.nanoTime();

        Object result = null;
        try{
            proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());

            //result = "Major accident! But no worries, your private AOP helicopter is on the way!";
            throw e;
        }

//        Long end = System.currentTimeMillis();
        Long end = System.nanoTime();

        Long duration = end - begin;

        System.out.println("Duration: "+duration/1000+" nanoseconds");

        return result;
    }

    @After("execution(* com.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<---------> Executing @After (finally) on method: "+method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingAdviceFindAccountAdvice(JoinPoint joinPoint, Throwable theExc){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<---------> Executing @AfterThrowing on method: "+method);

        System.out.println("\n<---------> The exception is: "+theExc);
    }

    //add a new advice for @Afterreturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void AfterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n<---------> Executing @AfterReturning on method: "+method);

        System.out.println("\n<---------> Result is: "+result);

        //post process the data and modify it
        convertAccountNamesToUpperCase(result);
        System.out.println("\n<---------> post processed Result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount: result){
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }
    }

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("\n <=========> executing before add account advice <=========>");
        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);
        //display the method arguments
        Object[] args = joinPoint.getArgs();

        for (Object tempArgs : args){
            System.out.println(tempArgs);
            if(tempArgs instanceof Account){
                Account account = (Account) tempArgs;
                System.out.println("Account name: "+account.getName());
                System.out.println("Account level: "+account.getLevel());
            }
        }
    }


}
