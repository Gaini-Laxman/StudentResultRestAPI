package com.javafullstackguru.service;


import com.javafullstackguru.entity.SchoolResult;

public interface SchoolService {

    // Save student result with marks and result status
    SchoolResult saveStudentResult(SchoolResult studentResult);

    // Retrieve student result by hall ticket number
    SchoolResult getStudentResultByHallTicketNumber(String hallTicketNumber);
}

