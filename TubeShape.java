import java.awt.geom.*;
//JAVADOCS DONE
/**
 * Creates the rectangle + rounded half circle that represents the tube shape
 * Uses the path2d float class to achieve this
 */
public class TubeShape extends Path2D.Float{

    /**
     * Adds a point on a path by moving to the specific x/y coordinates
     * Draws a straight line from current coord to new specificed one
     * Adds the curved segmenet of the rounded edge of the test tube using
     * given radius, height, x/y coords
     * closes the current drawn path
     * @param x x coordinate
     * @param y y coordinate
     * @param height height of tube
     * @param radius radius of tube
     */
    public TubeShape(double x,double y, int height, int radiusX, int radiusY) {
        int width=2*radiusX;
        moveTo(x, y);
        lineTo(width+x, y);
        lineTo(width+x, height-radiusY+y);
        curveTo(width+x, height-radiusY+y, width+x, height+y, width-radiusX+x, height+y);
        curveTo(radiusX+x, height+y, x, height+y, x, height-radiusY+y);
        lineTo(x, height-radiusY+y);
        closePath();
    }
}
