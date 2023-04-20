package com.fiona.serTrial;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
@ConfigurationProperties
public class AppConfiguration {
     String  password;
     String username;
    public void appCon() throws  IOException {
        // Set the URL of the Vault API endpoint and the path of the secret
        String apiUrl = "http://localhost:8200/v1";
        String secretPath ="secret/data/javatodev_core_api/dev";

        // Create an HTTP client with SSL/TLS verification disabled
        HttpClient httpClient = HttpClientBuilder.create().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        try {
            // Creatcurl -H "X-Vault-Token: hvs.pumZqQhUsqGqndvV2ekKXkMP" http://127.0.0.1:8200/ui/vault/secrets/secret/show/javatodev_core_api/deve an HTTP request to retrieve the secret
            HttpGet request = new HttpGet(apiUrl + "/" + secretPath);
            request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + "hvs.pumZqQhUsqGqndvV2ekKXkMP");

            // Execute the request and get the response
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String responseBody = entity != null ? EntityUtils.toString(entity) : null;

            // Parse the response body into a JSON object
            System.out.println("--------------------------------------------------");
            System.out.println(responseBody);
            JSONObject json = new JSONObject(responseBody);

            // Get the secret data from the JSON object
            JSONObject data = json.getJSONObject("data").getJSONObject("data");
            username = data.getString("spring.datasource.username");
            password = data.getString("spring.datasource.password");
            System.out.println("##############################################333");
            System.out.println("UserName : "+username);
            System.out.println("Password: "+password);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
//            httpClient.close();
        }
    }
    public  void dbConnection() throws SQLException {
        String dbUrl ="Jdbc:mysql://localhost:3306/employee";
        String dbUserName =username ;
        String dbPassword=password;
        // Create a connection to the database

        Connection conn =null ;
        try{
            conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("successfully connected to database");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=");
        }catch(SQLException e){
            System.out.println("Error connecting to db"+ e.getMessage());
        }finally {
            if(conn!=null){
                conn.close();
            }
        }

        //close connection
        conn.close();
    }

}
