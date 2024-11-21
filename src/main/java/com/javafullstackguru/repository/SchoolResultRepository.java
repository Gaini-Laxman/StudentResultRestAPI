package com.javafullstackguru.repository;

import com.javafullstackguru.entity.SchoolResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolResultRepository extends JpaRepository<SchoolResult, Long> {
    SchoolResult findByHallTicketNumber(String hallTicketNumber);
}
