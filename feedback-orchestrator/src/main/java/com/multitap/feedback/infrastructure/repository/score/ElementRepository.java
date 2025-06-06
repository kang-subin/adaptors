package com.multitap.feedback.infrastructure.repository.score;

import com.multitap.feedback.domain.score.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 피드백 요소에 대한 정보를 담아 놓는 테이블
public interface ElementRepository extends JpaRepository<Element, Long> {

    List<Element> findByCategoryCode(String categoryCode);
}
