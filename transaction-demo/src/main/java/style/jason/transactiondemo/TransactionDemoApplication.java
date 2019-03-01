package style.jason.transactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TransactionDemoApplication {

    @Autowired
    PlatformTransactionManager transactionManager;

    public static void main(String[] args) {
        SpringApplication.run(TransactionDemoApplication.class, args);
    }

    @PostConstruct
    public void viewTransactionManager() {
        // 添加断点查看事务
        System.out.println(transactionManager.getClass().getName());
    }
}
