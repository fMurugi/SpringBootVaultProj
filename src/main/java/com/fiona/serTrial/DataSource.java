// package com.fiona.serTrial;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class DataSource {
//     @Autowired
//     private VaultConfiguration VaultConfiguration;

//     @Bean
//     public DataSource dataSource(){
//         return DataSourceBuilder.create()
//         .username(vaultConfiguration.getProperty("spring.datasource.username"))
//         .password(vaultConfiguration.getProperty("spring.datasource.password"))
//         .driverClassName("com.mysql.cj.jdbc.Driver")
//         .build();

//     }
    
// }
