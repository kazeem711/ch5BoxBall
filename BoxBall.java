import java.awt.*;
import java.awt.geom.*;
/**
 *Lab 5 -  Box Ball Animation Demo
 *
 * @author Kazeem Azeez
 * @version October 12, 2019
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of the ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xMove;
    private int yMove;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int xMove, int yMove, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        this.xMove = xMove;
        this.yMove = yMove;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void boxBounce()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase the ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move the ball according to the position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += yMove;
        xPosition += xMove;

        // check if the ball hit the ground
        if(xPosition >= (550 - diameter) || xPosition <= 10){
            xMove = -xMove;
        }
        if(yPosition >= (450 - diameter) || yPosition <= 10) {
            yMove = -yMove;
        }

        // draw again at new position
        boxBounce();
    }    

    /**
     * return the horizontal position of the ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of the ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
