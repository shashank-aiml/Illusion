package com.example.myapplication.Classes;

public class CollegeCardData {
    String CollegeName;
    String ImageURI;
    String Description;
    String CourseAvailable;
    String Fees;
    String HighestPackage;
    String LowestPackage;
    String AveragePackage;
    String StudentPlaced;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCourseAvailable() {
        return CourseAvailable;
    }

    public void setCourseAvailable(String coursesAvailable) {
        CourseAvailable = coursesAvailable;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String fees) {
        Fees = fees;
    }

    public String getHighestPackage() {
        return HighestPackage;
    }

    public void setHighestPackage(String highestPackage) {
        HighestPackage = highestPackage;
    }

    public String getLowestPackage() {
        return LowestPackage;
    }

    public void setLowestPackage(String lowestPackage) {
        LowestPackage = lowestPackage;
    }

    public String getAveragePackage() {
        return AveragePackage;
    }

    public void setAveragePackage(String averagePackage) {
        AveragePackage = averagePackage;
    }

    public String getStudentPlaced() {
        return StudentPlaced;
    }

    public void setStudentPlaced(String studentsPlaced) {
        StudentPlaced = studentsPlaced;
    }


    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getCollegeName() {
        return CollegeName;
    }

    public void setImageURI(String imageURI) {
        ImageURI = imageURI;
    }

    public String getImageURI() {
        return ImageURI;
    }
}
