package com.java.tutorial.configutility.classtutorial;

public abstract class GraphicObject {
    int x;
    int y;
    static int z=20;
    //define a method ith implementation
    void moveTo(int newX, int newY){
        System.out.println("This object is moved to location: "+newX+","+newY);
    }
    //define abstract method
    abstract void resize();
    abstract void draw(int r);
}
