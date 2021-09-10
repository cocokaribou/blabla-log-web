package com.cocokaribou.blabla_lee.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * - 컨트롤러 클래스
 */


@RestController // json 반환하는 컨트롤러
public class HelloController {

    @GetMapping("/hello") //HTTP Get method 요청 받는 api를 만듦
    public String hello() {
        return "hello";
    }
}
