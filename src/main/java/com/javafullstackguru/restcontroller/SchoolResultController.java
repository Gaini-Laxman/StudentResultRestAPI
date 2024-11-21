package com.javafullstackguru.restcontroller;

import com.javafullstackguru.entity.SchoolResult;
import com.javafullstackguru.service.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/results")
public class SchoolResultController {

    @Autowired
    private SchoolServiceImpl service;

    // Endpoint to save student result
    @PostMapping("/save")
    public SchoolResult saveResult(@RequestBody SchoolResult studentResult) {
        studentResult.setTotalMarks(calculateTotalMarks(studentResult)); // Calculate total marks
        studentResult.setResultStatus(determineResultStatus(studentResult)); // Determine result status
        return service.saveStudentResult(studentResult);
    }

    // Endpoint to fetch student result by hall ticket number
    @GetMapping("/result/{hallTicketNumber}")
    public SchoolResult getResultByHallTicket(@PathVariable String hallTicketNumber) {
        return service.getStudentResultByHallTicketNumber(hallTicketNumber);
    }

    // Helper method to calculate total marks
    private int calculateTotalMarks(SchoolResult result) {
        return result.getMaths() + result.getScience() + result.getSocial() +
                result.getTelugu() + result.getEnglish() + result.getHindi();
    }

    // Helper method to determine result status
    private String determineResultStatus(SchoolResult result) {
        return result.getTotalMarks() >= 35 * 6 ? "Pass" : "Fail"; // Assuming passing marks per subject is 35
    }
}
