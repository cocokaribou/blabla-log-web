package com.cocokaribou.blabla_lee.springboot.web;


import com.cocokaribou.blabla_lee.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            @RequestParam("name") String name,
            @RequestParam("amount") int amount) {
        // 외부 api로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name, amount);
    }
}
