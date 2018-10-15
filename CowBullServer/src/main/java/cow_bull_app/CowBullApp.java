package cow_bull_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CowBullApp {
    public static void main(String args[]){
        ConfigurableApplicationContext run = SpringApplication.run(CowBullApp.class, args);
    }
}
