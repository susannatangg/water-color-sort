import java.awt.*;
import java.util.*;

public class Tube{
    
    private Stack<Color> colors;
    private int currNumColors;
    private int currNumBlocks;
    private boolean isMystery;
    
    public Tube(Color[] colors, boolean isMystery){
        this.colors = new Stack<Color>();
        int numColors = 0;
        int numBlocks = 0;
        Color currColor = colors[0];
        for (int i=0; i<colors.length; i++){
            if(colors[i]==null){
                break;
            }
            this.colors.add(colors[i]);
            numBlocks++;
            if(i>0 && !colors[i].equals(currColor)){
                currColor=colors[i];
                currColor=colors[i];
            }
        }
        this.currNumColors=numColors;
        this.currNumBlocks=numBlocks;
        this.isMystery=isMystery;
    }

    public void drawTube(Graphics g)
    {
        //TODO: draw
    }

    public Stack<Color> getColors(){
        return colors;
    }

    public boolean isEmpty(){
        return currNumBlocks == 0;
    }

    public boolean isFull(){
        return currNumBlocks == 4;
    }

    public int numBlocks(){
        return currNumBlocks;
    }
    
    public int numColors()
    {
        return currNumColors;
    }
    
    public boolean isComplete()
    {
        return (isFull() && numColors() == 1);
    }
   
    public Color topColor()
    {
        Color top = colors.peek();
        return top;
    }

    public void pourTo(Tube otherTube)
    {
        otherTube.getColors().push(colors.pop());
    }
    public boolean sameColor(Color otherColor)
    {
        if (topColor().equals(otherColor))
        {
            return true;
        }
        return false;
    }

    public boolean isMystery()
    {
        return isMystery;
    }
    
}
