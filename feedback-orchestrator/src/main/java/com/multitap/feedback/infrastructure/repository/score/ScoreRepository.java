package com.multitap.feedback.infrastructure.repository.score;

import com.multitap.feedback.domain.score.Score;
import org.springframework.data.jpa.repository.JpaRepository;

// 피드백 점수를 담아 놓는 테이블
public interface ScoreRepository extends JpaRepository<Score, Long> {


}
