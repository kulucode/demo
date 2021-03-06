package cn.tpson.demo.springbootdubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication

/** 当接口被@Mapper注解时，会自动扫描此接口，所以可以不需要@MapperScan **/
//@MapperScan("cn.tpson.demo.springbootdubbo.provider.mapper")
public class ProviderApplication {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
        context.registerShutdownHook();
        SpringUtils.setApplicationContext(context);
        countDownLatch.await();
    }
}
