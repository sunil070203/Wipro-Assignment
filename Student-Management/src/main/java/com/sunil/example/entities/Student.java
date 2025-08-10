package com.sunil.example.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="Student_table")
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollno;
	private String name;
	private int age;
	private String email;
	private String address;
	private LocalDate dob;
	

}
