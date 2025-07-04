package com.mycompany.librarymanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean bean = (MyBean) context.getBean("myBean");
        bean.doTask();
    }
}