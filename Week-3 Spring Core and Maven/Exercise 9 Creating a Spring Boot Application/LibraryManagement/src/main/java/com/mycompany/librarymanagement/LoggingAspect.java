package com.mycompany.librarymanagement;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.mycompany.librarymanagement.MyBean.doTask(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method doTask()");
    }
}