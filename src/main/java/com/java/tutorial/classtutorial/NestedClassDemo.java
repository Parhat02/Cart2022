package com.java.tutorial.classtutorial;

public class NestedClassDemo {
    //define a print method
    private void print(){
        System.out.println("This is a print statement of root class");
    }
    //define an inner class A
    class InnerClassA{
        private int addTwoNumbers(int a, int b){
            System.out.println(a+"+"+b+"="+(a+b));
            return a+b;
        }
    }
    //define a static classB
    static class InnerClassB{
        private static void multiplicationTable(int maxNumber){
            for (int i=1;i<=maxNumber;i++){
                for (int j=1;j<=i;j++){
                    System.out.print(i+"*"+j+"="+i*j+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        //use outer class
        NestedClassDemo demo=new NestedClassDemo();
        demo.print();

        //use inner class A (need to instantiate outer class)
        NestedClassDemo.InnerClassA classA=new NestedClassDemo().new InnerClassA();
        classA.addTwoNumbers(10,20);
        classA.addTwoNumbers(200,300);

        //static inner class (don't need to instantiate outer class)
        InnerClassB classB=new InnerClassB();
        classB.multiplicationTable(10);
        //can be used like this
        NestedClassDemo.InnerClassB classB1=new NestedClassDemo.InnerClassB();
        classB1.multiplicationTable(9);
        //or like this
        InnerClassB.multiplicationTable(8);
    }
}
