package com.java.tutorial.classtutorial;

public class GraphicCircle extends GraphicObject{
    @Override
    void resize() {
        System.out.println("I resize the circle");
    }

    @Override
    void draw(int r) {
        System.out.println("I draw the circle with the radius "+r);
    }

    public static void main(String[] args) {
        GraphicCircle circle=new GraphicCircle();
        circle.x=10;
        circle.y=20;
        circle.draw(5);
        circle.resize();
        circle.moveTo(3,4);
    }
}
