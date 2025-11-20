package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void a_logToCloudAsync(){
        System.out.println("\n<=========> Logging the cloud using async fashion <=========>");
    }

//    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//    public void b_addTheDataToCloud(){
//        System.out.println("<=========> adding the data to the cloud using async fashion <=========>");
//    }
//
//    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//    public void c_backupData() {
//        System.out.println("<=========> Backing up the data <=========>");
//    }
//
//    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//    public void d_cleanCache() {
//        System.out.println("<=========> cleaning the cache <=========>");
//    }
}
