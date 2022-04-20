import java.awt.geom.*;

public class TubeShape extends Path2D.Float{
    public TubeShape(int x,int y, int height, int radius) {
        moveTo(x, y);
        lineTo(50+x, y);
        lineTo(50+x, height-radius+y);
        curveTo(50+x, height-radius+y, 50+x, height+y, 50-radius+x, height+y);
        curveTo(radius+x, height+y, x, height+y, x, height-radius+y);
        lineTo(x, height-radius+y);
        closePath();
    }
}
