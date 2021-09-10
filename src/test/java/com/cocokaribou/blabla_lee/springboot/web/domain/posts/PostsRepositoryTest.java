package com.cocokaribou.blabla_lee.springboot.web.domain.posts;

import com.cocokaribou.blabla_lee.springboot.domain.posts.Posts;
import com.cocokaribou.blabla_lee.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * JpaRepository의 save, findAll 기능 테스트
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // junit 단위테스트 끝날 때마다 수행되는 메소드, H2 db 데이터 초기화
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_post() {
        //given.. 그러니까 테스트 삽잆값
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("cocokaribou")
                        .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
