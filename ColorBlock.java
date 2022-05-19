import java.awt.*;
//JAVADOCS DONE
/**
 * Overrides the Color Class and deals with mystery levels.
 */
public class ColorBlock extends Color{

    private boolean isMystery;
    private Color c;

    /**
     * uses colors from color Class
     * icludes mystery level aspect of Colorblock
     */
    public ColorBlock(Color c, boolean isMystery){
        super(c.getRed(),c.getGreen(),c.getBlue());
        this.c=c;
        this.isMystery=isMystery;
    }
    /**
     * gets if level is mystery or not
     * @return isMystery level
     */
    public boolean getIsMystery()
    {
        return isMystery;
    }
    /**
     * sets isMystery to a boolean b
     */
    public void setIsMystery(boolean b){
        isMystery=b;
    }
    /**
     * gets Color 
     * @return c color 
     */
    public Color getColor(){
        return c;
    }

}
