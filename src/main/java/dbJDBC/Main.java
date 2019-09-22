package dbJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ATMsql atmsql = context.getBean("bookDaoImp", ATMsql.class);

        //---- insert book ----
        Account newaccount = new Account("4", "nan", 556);
        atmsql.save(newaccount);

        // ---- select book ----
        Account spring = atmsql.findById(4);
        System.out.println("---getOne: "+spring);

        //
        List<Account> accountList = atmsql.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

        //---- update book ----
        newaccount.setBalance(600.00);
        atmsql.update(4, newaccount);

        spring = atmsql.findById(4);
        System.out.println("---fineById: " + spring);

        // ---- delete book ----
        atmsql.deleteById(1);

        accountList = atmsql.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
    }
}

