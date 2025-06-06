package com.multitap.feedback.infrastructure.repository;

import com.multitap.feedback.domain.FeedbackElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackElementRepository extends JpaRepository<FeedbackElement, Long> {

    List<FeedbackElement> findByCategoryCode(String categoryCode);
}
