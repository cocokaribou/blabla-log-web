package com.cocokaribou.blabla_lee.springboot.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DB레이어 접근하는 인터페이스
 * - JpaRepository<엔티티클래스, PK 타입>
 * - Entity클래스와 EntityRepository 가 같은 레벨에 위치해야 한다
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {


}
