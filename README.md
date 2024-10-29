# CCOBJPGL_FINAL_PROJECT : CASE STUDY STUDENT RECORD MANAGEMENT

### Group Name: [Artificial Ledger Technology - T1](https://github.com/Artificial-Ledger-Technology)  🇵🇭
### Subject & Section: 🧚‍♂️ [CCOBJPGL COM24P](https://www.youtube.com/watch?v=dQw4w9WgXcQ) 🧚‍♀️
### Professor: 👦 [Jay D. Abaleta](https://www.youtube.com/watch?v=Zi_XLOBDo_Y)                    
### No. of Units: [3 Units](https://www.youtube.com/watch?v=d_Z-neEBuWM) 
### Prerequisite: [CCPRGG2L Intermediate Programming](https://github.com/flexycode/CCPRGG2L_INTERMEDIATE_PROGRAMMING)       
### Course Repo: [CCOBJPGL COM24P1](https://github.com/flexycode/CCOBJPGL)        

# 📊 Table of Contents

- [Introduction](#introduction) 
- [Lesson](#lesson)           
- [Final Project](#final-project) 
- [Contributing](#contributing)           
- [License](#licensee)   
- [Acknowledgements](#acknowledgements) 
- [FAQ](#faq)       
- [Changelog](#changelogs)   

# 🧠 Introduction

A case study for student record with User Management Authenticated by Generated QR Code

## Techstacks
1. IDEA IntelliJ Ultimate or Community Edition (for Free)
2. Java
3. IDE IntelliJ
4. Maven

## [Final Project](#final)   
 
### 🏦 Case Study: Student Record with User Management Authenticated by Generated QR Code 🔒  

#### Problem Statement : 

🚀 Create an Object-Oriented `Student Record with User Management Authenticated by Generated QR Code` that allows an `administrator` to manage student records (add, view, and update student details.)

#### ✨ Features:

✨ The system should have to options to Login:

- #### Admin : Can manage student records
- #### Student : Can only view student details

#### ⛓️ Program Requirements    

##### 🚀 1. User Management

* Two roles: Admin and Student.

* Admin:
```
Username: Admin

Password: Admin@123
```
* Student:
```
Username: Student

Password: Stud321@
```

##### 🚀 2. Student Records

* Students have:
```
o StudentNo

o Department

o Degree

o Name
```
##### 🚀 3. Encapsulation:

* Ensure all fields are private and provide public getter and setter methods for accessing and modifying them.

##### 🚀 4. All student attributes are private.

##### 🚀 5. Access to student data is through getter and setter methods.

##### 🚀 6. Credentials are accessed through authentication methods.

##### 🚀 7. Student Records will be inputted and manage by the Administrator Account

##### 🚀 8. Student Record existing DBS

```DBS
o StudentNo: 2024117769
```


# 🧊 ArtificialLedgerSRM - Complete Project Overview

###   Project Structure

#### 💻 Code Project Structure using [Maven](https://www.geeksforgeeks.org/what-is-maven)

Artificial Ledger Student record management tree using "package-by-features" or "package-by-components"  

##### Student record management v1
```bash
student-record-system/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studentrecord/
│   │   │           ├── App.java
│   │   │           ├── auth/
│   │   │           │   ├── AuthenticationService.java
│   │   │           │   ├── PinCodeGenerator.java
│   │   │           │   └── QRCodeGenerator.java
│   │   │           ├── model/
│   │   │           │   ├── Student.java
│   │   │           │   └── User.java
│   │   │           ├── service/
│   │   │           │   ├── StudentService.java
│   │   │           │   └── UserService.java
│   │   │           └── ui/
│   │   │           │   ├── AdminDashboard.java
│   │   │           │   ├── LoginFrame.java
│   │   │           │   └── StudentDashboard.java
│   │   │           └── util/
│   │   │               ├── Constants.java
│   │   │                └── ResourceManager.java
│   │   │
│   │   └── resources/
│   │       ├── images/
│   │       │   ├── background.jpg
│   │       │   └── logo.png
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── studentrecord/
│                   └── tests/
└── README.md

```


This will be the Updated Intermediate (Will Delete this after we finish the project)

##### Student record management v2 (Final Version)
```bash
student-management-system/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── studentmanagement/
│   │   │           ├── StudentManagementApp.java
│   │   │           ├── model/
│   │   │           │   ├── Student.java
│   │   │           │   └── User.java
│   │   │           ├── service/
│   │   │           │   ├── AuthenticationService.java
│   │   │           │   ├── DataPersistenceService.java
│   │   │           │   └── QRCodeService.java
│   │   │           └── gui/
│   │   │               ├── LoginFrame.java
│   │   │               ├── AdminFrame.java
│   │   │               ├── StudentFrame.java
│   │   │               └── QRLoginDialog.java
│   │   └── resources/
│   │       ├── config/
│   │       │   └── application.properties
│   │       ├── images/
│   │       │   ├── logo.png
│   │       │   └── background.jpg
│   │       └── data/
│   │           └── students.json
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── studentmanagement/
│       │           ├── model/
│       │           │   ├── StudentTest.java
│       │           │   └── UserTest.java
│       │           └── service/
│       │               ├── AuthenticationServiceTest.java
│       │               ├── DataPersistenceServiceTest.java
│       │               └── QRCodeServiceTest.java
│       └── resources/
│           └── test-data/
│               └── test-students.json
└── docs/
    ├── api/
    │   └── javadoc/
    ├── design/
    │   ├── class-diagram.png
    │   └── sequence-diagrams/
    └── user-manual/
        ├── admin-guide.md
        └── student-guide.md   
...  
```

# 💻 To run the application

1. Set up a new Maven project in IntelliJ IDEA.
2. Make sure the files are into the appropriate package structure.
3. Make sure all dependencies are resolved.
4. Run the Main.java class.

### 💻 The system provides the following features:

* User authentication with two roles: Admin and Student.
* QR code generation for login credentials.
* Admin can add and view student records.
* Students can view their own information.

### 💻 To set up this project in IntelliJ IDEA:

1. Open IntelliJ IDEA and select "Create New Project".
2. Choose "Maven" as the project type.
3. Select your project SDK (Java 11 or later is recommended).
4. Enter the GroupId (com.example) and ArtifactId (student-record-management).
5. Choose a project location and finish creating the project.
6. IntelliJ will create the basic structure. You can then create the packages and classes according to the structure above.
7. Copy the contents of the `pom.xml` file we provided earlier into your project's `pom.xml`.
8. Create each Java file in its respective package and copy the code we've provided.

After setting up the project structure, you can start implementing each class. Remember to refresh your Maven project after updating the `pom.xml` to ensure all dependencies are properly downloaded and configured.


##### pom.xml 

```pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.studentrecord</groupId>
    <artifactId>student-record-system</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- QR Code generation -->
        <dependency>
            <groupId>com.google.zxing</groupId>
            <artifactId>core</artifactId>
            <version>3.5.1</version>
        </dependency>
        <dependency>
            <groupId>com.google.zxing</groupId>
            <artifactId>javase</artifactId>
            <version>3.5.1</version>
        </dependency>
        
        <!-- JSON handling -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.2</version>
        </dependency>
        
        <!-- Testing -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.9.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.4.1</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.studentrecord.App</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```


# 💎 Components
This tree structure represents the Maven standard directory layout for a Java project. Here's a brief explanation of each component:

1. `student-record-management/`: This is the root directory of your project.
2. `pom.xml`: This file is at the root level and contains the project configuration and dependencies.
3. `src/`: This directory contains all the source files.
4. `main/`: This subdirectory of src/ contains the main application code and resources.
5. `java/`: This contains all the Java source files.
6. `com/example/`: This is the base package for all your Java classes.
7. `Main.java`: The main class to run the application.
8. `model/`: This package contains the data model classes.
9. `service/`: This package contains the service classes that handle business logic.
10. `util/`: This package contains utility classes.
11. `gui/`: This package contains all the GUI-related classes.
12. `resources/`: This directory is for non-Java resources like configuration files, images, etc. It's empty in this project but included for completeness.


# 🏆 Contributing     

### Contributing     
If you would like to contribute to the Banking System, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request to the main repository.

### 🧠 Submitting Changes

🧠 Contributions are welcome! If you have ideas for improvements or want to add more exercises, follow these steps:

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push to your fork and submit a pull request. 💕💕💕💕

### 👋 Contributors
### Special thanks to all my groupmates: 
 * ####  😎 [Jay Arre Talosig](https://github.com/flexycode) - Machine Learning Engineer | Blockchain Developer | Bioinformatics Scientist    
 * ####  🧭 [Bherliane Mallari](https://github.com/mallaribs01) - Software Engineer | Full Stack Developer | Front-End Developer
 * ####  💥 [Hannah Padilla](https://github.com/hnnhpdll) - Software Engineer | Full Stack Developer | Back-End Engineer
 * ####  🎲 [Brian De Vera](https://github.com/scarfer14) - Network Security Engineer | Digital Forensic Analyst | Robotics Engineer
 * ####  🤖 [Mystic Love](https://github.com/flexyledger) - Necromancer | Fortune Teller | Data Engineer

### 🛸 Reporting Issues

```bash
Some changes need to be address
- Coming Soon
- Coming Soon
- Coming Soon
```

###### 🤖 If you encounter any issues or have suggestions, please open an issue to let us know.

# 🔭Acknowledgements     

### ✨ Professor Jay A. Abaleta   
Professor Jay Abaleta is a Senior Software Engineer and esteemed faculty member at National University. With a strong background in teaching the core principles and advanced concepts of Java, he is highly regarded in the field. In addition to his role at National University, Prof. Abaleta also serves as a Professor at Adamson University and as a lecturer of IT/CS at Arba Minch University, sharing his expertise with students worldwide. Having studied at St. Paul University Philippines, Prof. Abaleta brings a wealth of knowledge and experience to his teaching. Known for his friendly and approachable nature, Prof. Abaleta fosters a positive learning environment where students thrive. His dedication and passion for teaching have made him a beloved professor among his students.

# 🔑 License     

The Artificial Ledger Technology Bank App is licensed under the [MIT License](https://opensource.org/licenses/MIT) and [ALT Licence](https://github.com/flexycode/CCOBJPGL_TEAM2_PROJECT/blob/master/LICENSE).
This project is licensed under the MIT License and Artificial Ledger Technology.

## Changelogs 

## [10.1.5] - 2024-10-19      
### Added
- 💻 Final Project requirements for our project
- ✨ Bootcamp Webinar ni Prof Ponio sa GDSC
- ✨ Brainstorming for our Project requirements  
- ✨ Coming Soon 💻 🚀
- ✨ Coming Soon 🧠 🔑

## [10.1.1] - 2024-09-20
### Activity
- ✨ Will designate a task from all the group members

## [10.1.3] - 2024-09-21 
### Activity
- ✨ Finalizing our Case Study: Student Record with User Management Authenticated by Generated QR Code
- ✨ Will designate a task from all the group members
- ✨ Create Architecture tree structure using Maven 

## [10.1.2] - 2024-09-22 
### HotFix
- ✨ Fix a unresponsive GUI in AdminFrame 
- ✨ Coming Soon

## [10.1.2] - 2024-10-23 
### Activity
- ✨ Debug StudentService java class
- ✨ Debug UserService java class

## [10.1.2] - 2024-10-24 
### Activity
- ✨ Agile Scrum
- ✨ Team Case Study

## [10.1.2] - 2024-10-25 
### Activity
- ✨ Agile Scrum
- ✨ Team Case Study

## [10.1.2] - 2024-10-26 
### Activity
- ✨ Update the Project Structure
- ✨ Update pom.xml to v1

## [10.1.2] - 2024-10-27 
### Activity
- ✨ Update the Project Structure
- ✨ Update pom.xml to final version

## [10.1.2] - 2024-10-28 
### Activity
- ✨ Update the Project Structure
- ✨ Upload new project file for student record management
- ✨ Fix README.md

## [10.1.2] - 2024-10-29
### Activity
- ✨ Debug util and services in the Project Structure
- ✨ Upload asset folder
- ✨ Update README.md


🧊 Case Study Project

<!-- This comment is intended for commiting message in pull-request 
Always use this "🧊 Case Study Project" for commiting message for "Pull-request"
<!-- End point line for this comment  -->

  
<!-- Introduction Pannel button link, it will redirect to the top -->
#### [Back to Table of Content](#-introduction)
<!-- End point line insert Thanks for visiting enjoy your day, feel free to modify this  -->
---
<p align="center">
<img src="https://readme-typing-svg.demolab.com/?lines=Thanks+For+Visiting+Enjoy+Your+Day+~!;" alt="mystreak"/>
</p>

<!-- Genshin Impact -->
<div align="center">
<img src="https://media.giphy.com/media/qr4CNpxIL6wwNUYZsL/giphy.gif?cid=ecf05e47iqq0k4rx0kv1fb3w4hl8dja3ouiqzx4vz1665i6b&ep=v1_stickers_search&rid=giphy.gif&ct=s" width="300">
</div>

<!-- End point line insert Comeback again next time, feel free to modify this  -->
<p align="center">
<img src="https://readme-typing-svg.demolab.com/?lines=💎💎Come+Back+Again+next+time💎💎" alt="mystreak"/>
</p>

</p>
    
<br>
<!-- End point insert background effect line of sight color red -->
<img src="https://user-images.githubusercontent.com/74038190/212284100-561aa473-3905-4a80-b561-0d28506553ee.gif" width="1000">

