package com.example.person.configuration;

<<<<<<< HEAD
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
=======
>>>>>>> cbbde4622372a633bdf2b5579dbb715ef3af051b
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Bean
<<<<<<< HEAD
    //@LoadBalanced
=======
>>>>>>> cbbde4622372a633bdf2b5579dbb715ef3af051b
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
