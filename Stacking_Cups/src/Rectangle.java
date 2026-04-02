<<<<<<< HEAD
package src;

import java.awt.*;
=======
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
<<<<<<< HEAD
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Rectangle{

    public static int EDGES = 4;
    
=======
 * @author Michael Kolling and David J. Barnes (Modified)
 * @version 1.0 (15 July 2000)()
 */

public class Rectangle {

    public static int EDGES = 4;

>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new rectangle at default position with default color.
     */
<<<<<<< HEAD
    public Rectangle(){
        height = 30;
        width = 40;
=======
    public Rectangle(int perimetro) {
        int size = perimetro / 4;
        height = size;
        width = size;
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        xPosition = 70;
        yPosition = 15;
        color = "magenta";
        isVisible = false;
    }
<<<<<<< HEAD
    
=======
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971

    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
<<<<<<< HEAD
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight(){
=======
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight() {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
<<<<<<< HEAD
    public void moveLeft(){
=======
    public void moveLeft() {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle a few pixels up.
     */
<<<<<<< HEAD
    public void moveUp(){
=======
    public void moveUp() {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        moveVertical(-20);
    }

    /**
     * Move the rectangle a few pixels down.
     */
<<<<<<< HEAD
    public void moveDown(){
=======
    public void moveDown() {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally.
<<<<<<< HEAD
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
=======
     * 
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the rectangle vertically.
<<<<<<< HEAD
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
=======
     * 
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the rectangle horizontally.
<<<<<<< HEAD
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
=======
     * 
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance) {
        int delta;

        if (distance < 0) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

<<<<<<< HEAD
        for(int i = 0; i < distance; i++){
=======
        for (int i = 0; i < distance; i++) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the rectangle vertically.
<<<<<<< HEAD
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
=======
     * 
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance) {
        int delta;

        if (distance < 0) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

<<<<<<< HEAD
        for(int i = 0; i < distance; i++){
=======
        for (int i = 0; i < distance; i++) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size
<<<<<<< HEAD
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        if (newHeight >=0 && newWidth >=0){
        erase();
        height = newHeight;
        width = newWidth;
        draw();
        }
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
=======
     * 
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht  the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        if (newHeight >= 0 && newWidth >= 0) {
            erase();
            height = newHeight;
            width = newWidth;
            draw();
        }
    }

    /**
     * Change the color.
     * 
     * @param color the new color. Valid colors are "red", "yellow", "blue",
     *              "green",
     *              "magenta" and "black".
     */
    public void changeColor(String newColor) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        color = newColor;
        draw();
    }

    /*
     * Draw the rectangle with current specifications on screen.
     */

    private void draw() {
<<<<<<< HEAD
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, 
                                       width, height));
=======
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                    new java.awt.Rectangle(xPosition, yPosition,
                            width, height));
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            canvas.wait(10);
        }
    }

    /*
     * Erase the rectangle on screen.
     */
<<<<<<< HEAD
    private void erase(){
        if(isVisible) {
=======
    private void erase() {
        if (isVisible) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
<<<<<<< HEAD
    
    
    
    /**
     * Calculate the perimeter of the Rectangle
     * @return perimeter of the rectangle of type int
     */
    public int perimeter(){
        return 2*(height+width);
    }
    
    
    /**
     * 
     */
    public void zoom(char z){
        if (z=="AUMENTA"){
            height= height+height;
            width= width+width;
            perimeter();
    }
}

=======

    /**
     * Calculate the perimeter of the Rectangle
     * 
     * @return perimeter of the rectangle of type int
     */
    public int perimeter() {
        return 2 * (height + width);
    }

    /**
     * Aumenta o disminuye el tamaño del cuadrado
     * 
     * @params char
     * @returns void
     */
    public void zoom(char z) {
        double factor;
        if (z == '+') {
            factor = 2.0;
        } else if (z == '-') {
            factor = 0.5;
        } else {
            return;
        }

        int newHeight = (int) Math.round(height * factor);
        int newWidth = (int) Math.round(height * factor);

        changeSize(newHeight, newWidth);
    }

    /**
     * Mueve el rectangulo en diagonal cayendo
     * 
     * @params
     */
    public void walk(int times) {
        int steps = Math.abs(times);
        int dx = (times >= 0) ? 20 : -20; // Acá se caerá hacia la izquierda o derecha

        for (int i = 0; i < steps; i++) {
            erase();
            xPosition += dx;
            yPosition += 20; // Aca hará el salto de caída x veces
            draw();
        }
    }

    /**
     * Verifica si el rectangulo es un cuadrado
     */
    public boolean esCuadrado() {
        return width == height;
    }
}
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
