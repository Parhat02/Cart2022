package com.java.tutorial.object;

public class InheritanceDemo {
    //define class fields
    private String firstName;
    private String lastName;
    private String className;
    private String major;
    private String gender;

    public InheritanceDemo() {
    }

    public InheritanceDemo(String firstName, String lastName, String className, String major, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.major = major;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "InheritanceDemo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    //define class method

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
