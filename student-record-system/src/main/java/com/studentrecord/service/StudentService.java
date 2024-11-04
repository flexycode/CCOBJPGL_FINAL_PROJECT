package studentrecord.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import studentrecord.model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    // Path to the JSON file where student data is stored
    private static final String DATA_FILE = "students.json";

    // List to hold the student records
    private List<Student> students;

    // Gson instance for JSON serialization/deserialization
    private final Gson gson;

    // Constructor to initialize the StudentService
    public StudentService() {
        this.gson = new Gson();
        this.students = loadStudents(); // Load students from the JSON file
    }

    /**
     * Loads the list of students from the JSON file.
     * If the file does not exist, an empty list is returned.
     *
     * @return List of students
     */
    private List<Student> loadStudents() {
        try {
            // Check if the data file exists
            if (Files.exists(Paths.get(DATA_FILE))) {
                // Read the JSON file and convert it to a List of Student objects
                Reader reader = new FileReader(DATA_FILE);
                return gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any IO exceptions
        }
        return new ArrayList<>(); // Return an empty list if the file doesn't exist or an error occurs
    }

    /**
     * Saves the current list of students to the JSON file.
     */
    private void saveStudents() {
        try (Writer writer = new FileWriter(DATA_FILE)) {
            // Convert the list of students to JSON and write it to the file
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for any IO exceptions
        }
    }

    /**
     * Adds a new student to the list and saves the updated list to the file.
     *
     * @param student The student object to be added
     */
    public void addStudent(Student student) {
        students.add(student); // Add the new student to the list
        saveStudents(); // Save the updated list to the file
    }

    /**
     * Updates an existing student's information in the list and saves the changes.
     *
     * @param updatedStudent The student object with updated information
     */
    public void updateStudent(Student updatedStudent) {
        // Iterate through the list to find the student to update
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNo().equals(updatedStudent.getStudentNo())) {
                // Update the student record
                students.set(i, updatedStudent);
                saveStudents(); // Save the updated list to the file
                break; // Exit the loop after updating
            }
        }
    }

    /**
     * Retrieves a student by their student number.
     *
     * @param studentNo The student number to search for
     * @return An Optional containing the found student, or empty if not found
     */
    public Optional<Student> getStudentByNo(String studentNo) {
        // Search for the student with the given student number
        return students.stream()
                .filter(s -> s.getStudentNo().equals(studentNo)) // Filter by student number
                .findFirst(); // Return the first matching student, if any
    }

    /**
     * Retrieves a list of all students.
     *
     * @return A list of all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a new list containing all students
    }

    /**
     * Deletes a student from the list based on their student number and saves the changes.
     *
     * @param studentNo The student number of the student to be deleted
     */
    public void deleteStudent(String studentNo) {
        // Remove the student from the list if they match the given student number
        students.removeIf(s -> s.getStudentNo().equals(studentNo));
        saveStudents(); // Save the updated list to the file
    }
}