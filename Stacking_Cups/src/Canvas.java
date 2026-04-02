<<<<<<< HEAD
package src;

=======
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
<<<<<<< HEAD
 * the BlueJ "shapes" example. 
=======
 * the BlueJ "shapes" example.
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 *
 * @version: 1.6 (shapes)
 */
<<<<<<< HEAD
public class Canvas{
=======
public class Canvas {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

<<<<<<< HEAD
	private static Canvas canvasSingleton;

	/**
	 * Factory method to get the canvas singleton object.
	 */
	public static Canvas getCanvas(){
		if(canvasSingleton == null) {
			canvasSingleton = new Canvas("BlueJ Shapes Demo", 300, 300, 
										 Color.white);
		}
		canvasSingleton.setVisible(true);
		return canvasSingleton;
	}

	//  ----- instance part -----
=======
    private static Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("BlueJ Shapes Demo", 300, 300,
                    Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    // ----- instance part -----
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;
<<<<<<< HEAD
    private List <Object> objects;
    private HashMap <Object,ShapeDescription> shapes;
    
    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColour){
=======
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;

    /**
     * Create a Canvas.
     * 
     * @param title   title to appear in Canvas Frame
     * @param width   the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour the desired background colour of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColour) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColour = bgColour;
        frame.pack();
<<<<<<< HEAD
        objects = new ArrayList <Object>();
        shapes = new HashMap <Object,ShapeDescription>();
=======
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
<<<<<<< HEAD
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible){
        if(graphic == null) {
=======
     * 
     * @param visible boolean value representing the desired visibility of
     *                the canvas (true or false)
     */
    public void setVisible(boolean visible) {
        if (graphic == null) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
<<<<<<< HEAD
            graphic = (Graphics2D)canvasImage.getGraphics();
=======
            graphic = (Graphics2D) canvasImage.getGraphics();
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            graphic.setColor(backgroundColour);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
<<<<<<< HEAD
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String color, Shape shape){
    	objects.remove(referenceObject);   // just in case it was already there
    	objects.add(referenceObject);      // add at the end
    	shapes.put(referenceObject, new ShapeDescription(shape, color));
    	redraw();
    }
 
    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased 
     */
    public void erase(Object referenceObject){
    	objects.remove(referenceObject);   // just in case it was already there
    	shapes.remove(referenceObject);
    	redraw();
=======
     * 
     * @param referenceObject an object to define identity for this shape
     * @param color           the color of the shape
     * @param shape           the shape object to be drawn on the canvas
     */
    // Note: this is a slightly backwards way of maintaining the shape
    // objects. It is carefully designed to keep the visible shape interfaces
    // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject); // just in case it was already there
        objects.add(referenceObject); // add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    /**
     * Erase a given shape's from the screen.
     * 
     * @param referenceObject the shape object to be erased
     */
    public void erase(Object referenceObject) {
        objects.remove(referenceObject); // just in case it was already there
        shapes.remove(referenceObject);
        redraw();
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    }

    /**
     * Set the foreground colour of the Canvas.
<<<<<<< HEAD
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    public void setForegroundColor(String colorString){
		if(colorString.equals("red"))
			graphic.setColor(Color.red);
		else if(colorString.equals("black"))
			graphic.setColor(Color.black);
		else if(colorString.equals("blue"))
			graphic.setColor(Color.blue);
		else if(colorString.equals("yellow"))
			graphic.setColor(Color.yellow);
		else if(colorString.equals("green"))
			graphic.setColor(Color.green);
		else if(colorString.equals("magenta"))
			graphic.setColor(Color.magenta);
		else if(colorString.equals("white"))
			graphic.setColor(Color.white);
		else
			graphic.setColor(Color.black);
=======
     * 
     * @param newColour the new colour for the foreground of the Canvas
     */
    public void setForegroundColor(String colorString) {
        if (colorString.equals("red"))
            graphic.setColor(Color.red);
        else if (colorString.equals("black"))
            graphic.setColor(Color.black);
        else if (colorString.equals("blue"))
            graphic.setColor(Color.blue);
        else if (colorString.equals("yellow"))
            graphic.setColor(Color.yellow);
        else if (colorString.equals("green"))
            graphic.setColor(Color.green);
        else if (colorString.equals("magenta"))
            graphic.setColor(Color.magenta);
        else if (colorString.equals("white"))
            graphic.setColor(Color.white);
        else
            graphic.setColor(Color.black);
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
<<<<<<< HEAD
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        } catch (Exception e){
=======
     * 
     * @param milliseconds the number
     */
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
            // ignoring exception at the moment
        }
    }

<<<<<<< HEAD
	/**
	 * Redraw ell shapes currently on the Canvas.
	 */
	private void redraw(){
		erase();
		for(Iterator i=objects.iterator(); i.hasNext(); ) {
                       shapes.get(i.next()).draw(graphic);
        }
        canvas.repaint();
    }
       
    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase(){
=======
    /**
     * Redraw ell shapes currently on the Canvas.
     */
    private void redraw() {
        erase();
        for (Iterator i = objects.iterator(); i.hasNext();) {
            shapes.get(i.next()).draw(graphic);
        }
        canvas.repaint();
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase() {
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        Dimension size = canvas.getSize();
        graphic.fill(new java.awt.Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

<<<<<<< HEAD

=======
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
<<<<<<< HEAD
    private class CanvasPane extends JPanel{
        public void paint(Graphics g){
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
=======
    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
<<<<<<< HEAD
    private class ShapeDescription{
    	private Shape shape;
    	private String colorString;

		public ShapeDescription(Shape shape, String color){
    		this.shape = shape;
    		colorString = color;
    	}

		public void draw(Graphics2D graphic){
			setForegroundColor(colorString);
			graphic.draw(shape);
			graphic.fill(shape);
		}
=======
    private class ShapeDescription {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.draw(shape);
            graphic.fill(shape);
        }
>>>>>>> 596a0adb08a3526b8e24f786e3ffca7b8b830971
    }

}
