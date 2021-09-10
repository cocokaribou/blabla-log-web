package com.cocokaribou.blabla_lee.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 * - 메인 클래스
 * - @SpringBootApplicaiton : 스프링부트 자동설정, 스프링 bean 읽기 가능
 * - 이 클래스는 프로젝트 최상단에 위치해야함
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 WAS
    }
}
