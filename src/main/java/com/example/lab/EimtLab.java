package com.example.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EimtLab {

    public static void main(String[] args) {
        SpringApplication.run(EimtLab.class, args);
    }

}
