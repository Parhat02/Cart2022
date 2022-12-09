package com.java.tutorial.classtutorial;

public class TestSuiteConstructor {
    private String projectName;
    private int projectId;
    private int testSuiteId;
    private String testSuiteName;
    private String testSuiteDescription;

    //create a class constructor without argument list

    public TestSuiteConstructor() {
    }

    //create a class constructor with all fields in the class

    public TestSuiteConstructor(String projectName, int projectId, int testSuiteId, String testSuiteName, String testSuiteDescription) {
        this.projectName = projectName;
        this.projectId = projectId;
        this.testSuiteId = testSuiteId;
        this.testSuiteName = testSuiteName;
        this.testSuiteDescription = testSuiteDescription;
    }

    //create get and set method

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTestSuiteId() {
        return testSuiteId;
    }

    public void setTestSuiteId(int testSuiteId) {
        this.testSuiteId = testSuiteId;
    }

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName(String testSuiteName) {
        this.testSuiteName = testSuiteName;
    }

    public String getTestSuiteDescription() {
        return testSuiteDescription;
    }

    public void setTestSuiteDescription(String testSuiteDescription) {
        this.testSuiteDescription = testSuiteDescription;
    }

    public static void main(String[] args){
        //create a test suite object
        TestSuiteConstructor testSuiteConstructor=new TestSuiteConstructor();
        //set test suite object properties
        testSuiteConstructor.setTestSuiteName("Longin suite");
        testSuiteConstructor.setTestSuiteId(1);
        testSuiteConstructor.setTestSuiteDescription("Users should be able to login the system");
        //get test suite object properties
        System.out.println("Test Suite Name : "+testSuiteConstructor.getTestSuiteName());
        System.out.println("Test Suite Id : "+testSuiteConstructor.getTestSuiteId());
        System.out.println("Test Suite Description : "+testSuiteConstructor.getTestSuiteDescription());

        //create a test suite object with initial value
        TestSuiteConstructor testSuiteConstructor2=new TestSuiteConstructor("Test",0,2,"Logout Test Suite","User should be able to logout");
        System.out.println("Test Suite Name : "+testSuiteConstructor2.getTestSuiteName());
        System.out.println("Test Suite Id : "+testSuiteConstructor2.getTestSuiteId());
        System.out.println("Test Suite Description : "+testSuiteConstructor2.getTestSuiteDescription());


    }
}
