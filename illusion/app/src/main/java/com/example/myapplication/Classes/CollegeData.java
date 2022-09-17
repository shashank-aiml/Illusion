package com.example.myapplication.Classes;

public class CollegeData {
    String CollegeName, Description, CourseAvailable, Fees, HighestPackage , LowestPackage, AveragePackage, StudentPlaced ,ImageURI;

    public String getCollegeName() {
        return CollegeName;
    }

    public void setCollegeName(String collegeName) {
        CollegeName = collegeName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCourseAvailable() {
        return CourseAvailable;
    }

    public void setCourseAvailable(String courseAvailable) {
        CourseAvailable = courseAvailable;
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

    public void setStudentPlaced(String studentPlaced) {
        StudentPlaced = studentPlaced;
    }

    public String getImageURI() {
        return ImageURI;
    }

    public void setImageURI(String imageURI) {
        ImageURI = imageURI;
    }

    public CollegeData(String collegeName, String description, String courseAvailable, String fees, String highestPackage, String lowestPackage, String averagePackage, String studentPlaced, String imageURI) {
        CollegeName = collegeName;
        Description = description;
        CourseAvailable = courseAvailable;
        Fees = fees;
        HighestPackage = highestPackage;
        LowestPackage = lowestPackage;
        AveragePackage = averagePackage;
        StudentPlaced = studentPlaced;
        ImageURI = imageURI;
    }
}
