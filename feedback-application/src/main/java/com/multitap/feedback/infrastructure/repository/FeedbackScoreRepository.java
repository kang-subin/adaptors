package com.multitap.feedback.infrastructure.repository;

import com.multitap.feedback.domain.FeedbackScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackScoreRepository extends JpaRepository<FeedbackScore, Long> {


}
