package com.cocokaribou.blabla_lee.springboot.service.posts;

import com.cocokaribou.blabla_lee.springboot.domain.posts.Posts;
import com.cocokaribou.blabla_lee.springboot.domain.posts.PostsRepository;
import com.cocokaribou.blabla_lee.springboot.web.dto.PostsResponseDto;
import com.cocokaribou.blabla_lee.springboot.web.dto.PostsSaveRequestDto;
import com.cocokaribou.blabla_lee.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // response가 오는거란 뜻인가? 트랜잭션이 끝나는 시점에 해당 테이블에 변경분 반영
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;

        // entity의 값만 변경하면 별도로 update 쿼리를 날릴 필요 x
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
