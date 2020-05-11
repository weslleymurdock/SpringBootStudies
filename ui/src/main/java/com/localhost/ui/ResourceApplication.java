package com.localhost.ui;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping; 

public class ResourceApplication extends WebSecurityConfigurerAdapter{
    
    @RequestMapping("/")
    @CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = { "x-auth-token", "x-requested-with", "x-xsrf-token" })
    public Message home() {
        return new Message("Hello World");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests().anyRequest().authenticated();
    }

    @Component
    @ConfigurationProperties("ui")
    class UIProperties {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    public Message(String content) {
        this.setContent(content);
    }

    public Message() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}