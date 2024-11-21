package com.javafullstackguru.service;


import com.javafullstackguru.entity.SchoolResult;
import com.javafullstackguru.repository.SchoolResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolResultRepository schoolResultRepository;

    // Save student result with marks and result status
    @Override
    public SchoolResult saveStudentResult(SchoolResult studentResult) {
        // Calculate total marks
        int total = studentResult.getMaths() + studentResult.getScience() + studentResult.getSocial() +
                studentResult.getTelugu() + studentResult.getEnglish() + studentResult.getHindi();
        studentResult.setTotalMarks(total);

        // Determine result status (Assuming passing marks in each subject is 35)
        String resultStatus = "Passed";
        if (studentResult.getMaths() < 35 || studentResult.getScience() < 35 || studentResult.getSocial() < 35 ||
                studentResult.getTelugu() < 35 || studentResult.getEnglish() < 35 || studentResult.getHindi() < 35) {
            resultStatus = "Failed";
        }
        studentResult.setResultStatus(resultStatus);

        return schoolResultRepository.save(studentResult);
    }

    // Retrieve student result by hall ticket number
    @Override
    public SchoolResult getStudentResultByHallTicketNumber(String hallTicketNumber) {
        return schoolResultRepository.findByHallTicketNumber(hallTicketNumber);
    }
}
