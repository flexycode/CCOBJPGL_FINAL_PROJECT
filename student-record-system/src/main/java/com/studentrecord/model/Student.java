package studentrecord.model;

public class Student {
    private String studentNo;
    private String department;
    private String degree;
    private String name;
    private String pinCode; // New field for PIN code

    // Constructor
    public Student(String studentNo, String department, String degree, String name) {
        this.studentNo = studentNo;
        this.department = department;
        this.degree = degree;
        this.name = name;
        this.pinCode = pinCode; // Initialize the PIN code
    }

    // Getters and Setters
    public String getStudentNo() { return studentNo; }
    public void setStudentNo(String studentNo) { this.studentNo = studentNo; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPinCode() { return pinCode; } // Getter for PIN code
    public void setPinCode(String pinCode) { this.pinCode = pinCode; } // Setter for PIN code
}