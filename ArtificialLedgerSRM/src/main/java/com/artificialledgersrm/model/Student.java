package com.artificialledgersrm.model;

/**
 * Represents a student in the ArtificialLedgerSRM system.
 * This class encapsulates student information including student number, department, degree, and name.
 */
public class Student {
    private String studentNo;
    private String department;
    private String degree;
    private String name;

    /**
     * Constructs a new Student with the specified details.
     *
     * @param studentNo  The student's unique identifier
     * @param department The student's department
     * @param degree     The student's degree program
     * @param name       The student's full name
     */
    public Student(String studentNo, String department, String degree, String name) {
        this.studentNo = studentNo;
        this.department = department;
        this.degree = degree;
        this.name = name;
    }

    /**
     * @return The student's unique identifier
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * @param studentNo The new student number to set
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * @return The student's department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department The new department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return The student's degree program
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree The new degree to set
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * @return The student's full name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}