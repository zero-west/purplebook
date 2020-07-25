package me.zw.purplebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PurplebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurplebookApplication.class, args);
    }

}
