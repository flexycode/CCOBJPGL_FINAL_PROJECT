package com.artificialledgersrm.service;

import com.artificialledgersrm.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing student records.
 */
public class StudentService {
    private final List<Student> students;

    /**
     * Initializes the StudentService with an empty list of students.
     */
    public StudentService() {
        students = new ArrayList<>();
    }

    /**
     * Adds a new student to the record.
     *
     * @param student The student to add
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Retrieves all students in the record.
     *
     * @return A list of all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    /**
     * Finds a student by their student number.
     *
     * @param studentNo The student number to search for
     * @return The found student, or null if not found
     */
    public Student getStudentByNo(String studentNo) {
        return students.stream()
                .filter(s -> s.getStudentNo().equals(studentNo))
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an existing student's information.
     *
     * @param updatedStudent The student with updated information
     */
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNo().equals(updatedStudent.getStudentNo())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }
}