package com.demosec.demosec;

import com.demosec.demosec.auth.AuthenticationService;
import com.demosec.demosec.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import static com.demosec.demosec.user.Role.ADMIN;
import static com.demosec.demosec.user.Role.MANAGER;

@SpringBootApplication
public class DemoSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service) {
        return args -> {

          var admin = RegisterRequest.builder()
                  .firstname("admin")
                  .lastname("Admin")
                  .email("admin@admin.com")
                  .password("admin")
                  .role(ADMIN)
                  .build();
            System.out.println("admin token :"+ service.register(admin).getToken());

            var manager = RegisterRequest.builder()
                    .firstname("manager")
                    .lastname("manager")
                    .email("manager@manager.com")
                    .password("manager")
                    .role(MANAGER)
                    .build();
            System.out.println("manager token :"+ service.register(manager).getToken());

        };

    }
}
