package com.multitap.feedback.infrastructure;

import com.multitap.feedback.entity.FeedbackElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackElementRepository extends JpaRepository<FeedbackElement, Long> {

    List<FeedbackElement> findByCategoryCode(String categoryCode);
}
