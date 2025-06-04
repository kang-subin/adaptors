package com.multitap.feedback.infrastructure;

import com.multitap.feedback.entity.FeedbackScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackScoreRepository extends JpaRepository<FeedbackScore, Long> {


}
