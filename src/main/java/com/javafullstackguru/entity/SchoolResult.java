package com.javafullstackguru.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hallTicketNumber;
    private String studentName;
    private int maths;
    private int science;
    private int social;
    private int telugu;
    private int english;
    private int hindi;
    private int totalMarks;
    private String resultStatus;


}
