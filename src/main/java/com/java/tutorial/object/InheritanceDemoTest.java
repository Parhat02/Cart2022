package com.java.tutorial.object;

public class InheritanceDemoTest extends InheritanceDemo{
    private String researchField;
    private String advisorName;

    public InheritanceDemoTest() {
    }

    public InheritanceDemoTest(String researchField, String advisorName) {
        this.researchField = researchField;
        this.advisorName = advisorName;
    }

    public InheritanceDemoTest(String firstName, String lastName, String className, String major, String gender, String researchField, String advisorName) {
        super(firstName, lastName, className, major, gender);
        this.researchField = researchField;
        this.advisorName = advisorName;
    }

    @Override
    public String toString() {
        return super.toString()+"InheritanceDemoTest{" +
                "researchField='" + researchField + '\'' +
                ", advisorName='" + advisorName + '\'' +
                '}';
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }


    public static void main(String[] args) {
        InheritanceDemoTest demoTest=new InheritanceDemoTest();
        demoTest.setResearchField("Selenium Test Automation");
        demoTest.setClassName("Test Automation");
        demoTest.setAdvisorName("Selenium Master");
        demoTest.setFirstName("user1");
        demoTest.setLastName("user2");
        //print out information
        System.out.println("Username: "+demoTest.getFirstName()+" "+demoTest.getLastName());
        System.out.println("Class: "+demoTest.getClassName());
        System.out.println("Advisor: "+demoTest.getAdvisorName());
        System.out.println("Research Field: "+demoTest.getResearchField());

        InheritanceDemo demoTest1=new InheritanceDemoTest();
        demoTest1.setFirstName("Ferhat");
        demoTest1.setMajor("ELT");

        String classna="dkhfwfi";
        System.out.println(demoTest.toString());
    }
}
