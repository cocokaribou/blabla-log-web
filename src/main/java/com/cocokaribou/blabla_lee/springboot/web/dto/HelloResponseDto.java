package com.cocokaribou.blabla_lee.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //final 필드가 포함된 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
