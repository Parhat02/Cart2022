package com.java.tutorial.classtutorial;

public class GraphicRectangle extends GraphicObject{
    @Override
    void resize() {
        System.out.println("I resized the rectangle");
    }

    @Override
    void draw(int r) {
        System.out.println("I draw a rectangle");
    }

    public static void main(String[] args) {
        GraphicRectangle rectangle=new GraphicRectangle();
        rectangle.x=30;
        rectangle.y=50;
        rectangle.moveTo(rectangle.x+10, rectangle.y+9);
        rectangle.resize();
        System.out.println(GraphicObject.z);
        GraphicObject.z=40;
        System.out.println(GraphicObject.z);
    }

}
