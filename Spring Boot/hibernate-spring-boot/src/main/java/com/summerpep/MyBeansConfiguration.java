package com.summerpep;

import com.summerpep.algo.MyNextPasswordHasher;
import com.summerpep.algo.MySimplePasswordHasher;
import com.summerpep.algo.PasswordHasher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// to create a bean explicitly, same as @Component
@Configuration
@ImportResource("classpath:beans.xml")
public class MyBeansConfiguration {
    @Bean
    PasswordHasher nextPasswordHasher(){
        return new MyNextPasswordHasher();
    }
    @Bean
    PasswordHasher simplePasswordHasher(){
        return new MySimplePasswordHasher();
    }
}
