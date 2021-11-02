package com.cocokaribou.blabla_lee.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 엔티티 클래스에서 Setter는 만들지 않는다!
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스 ex) SalesManager.java -> sales_manager table
public class Posts {
    //데이터베이스와 맞닿아있기 때문에 request, response 사용x
    //data layer

    @Id // PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 어노테이션 없이도 필드는 모두 칼럼이 됨, 기본값 외에 추가로 변경 필요한 옵션 있을 때
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
