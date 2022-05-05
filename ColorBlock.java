import java.awt.*;

public class ColorBlock extends Color{

    private boolean isMystery;
    private Color c;

    public ColorBlock(Color c, boolean isMystery){
        super(c.getRed(),c.getGreen(),c.getBlue());
        this.c=c;
        this.isMystery=isMystery;
    }

    public boolean getIsMystery()
    {
        return isMystery;
    }

    public void setIsMystery(boolean b){
        isMystery=b;
    }

    public Color getColor(){
        return c;
    }

}
