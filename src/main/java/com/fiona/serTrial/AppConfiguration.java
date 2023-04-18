package com.fiona.serTrial;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("trial")
public class AppConfiguration {
    private String username;
    private String token;
    private String password;


}
