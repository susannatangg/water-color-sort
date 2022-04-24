import java.awt.*;
import java.util.*;

public class Tube{
    
    private Stack<Color> colors;
    private int currNumColors;
    private int currNumBlocks;
    private boolean isMystery;
    private boolean isSelected;
    private int y=0;
    private int originalY=0;
    
    public Tube(Color[] colors, boolean isMystery){
        this.colors=new Stack<Color>();
        int numColors=0;
        int numBlocks=0;
        Color currColor=colors[0];
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
        this.isSelected=false;
    }

    public void drawTube(Graphics g, int x, int y1)
    {
        if(y==0){
            y=y1;
            originalY=y1;
        }
        int currNumBlocksTmp = currNumBlocks;
        
        Stack<Color> colorsTmp = new Stack<Color>();
        colorsTmp.addAll(colors);
        //mystery shows only top color rest are black 
        if(isMystery){
            drawColor(g,colorsTmp.peek(),currNumBlocksTmp,x,y+20);
            colorsTmp.pop();
            while(!colorsTmp.isEmpty()){
                drawColor(g,Color.BLACK,currNumBlocksTmp,x,y+20+(40*(currNumBlocks-currNumBlocksTmp)));
                colorsTmp.pop();
                currNumBlocksTmp--;               
            }
        }else{
            if(currNumBlocks==4){
                while(!colorsTmp.isEmpty()){
                    drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,y+20+(40*(currNumBlocks-currNumBlocksTmp)));
                    currNumBlocksTmp--;
                }
            }else if(currNumBlocks==3){
                while(!colorsTmp.isEmpty()){
                    drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,y+60+(40*(currNumBlocks-currNumBlocksTmp)));
                    currNumBlocksTmp--;
                }
            }else if(currNumBlocks==2){
                while(!colorsTmp.isEmpty()){
                    drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,y+100+(40*(currNumBlocks-currNumBlocksTmp)));
                    currNumBlocksTmp--;
                }
            }else if(currNumBlocks==1){
                while(!colorsTmp.isEmpty()){
                    drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,y+140+(40*(currNumBlocks-currNumBlocksTmp)));
                    currNumBlocksTmp--;
                }
            }
        }
        g.setColor(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g.create();
        TubeShape tube = new TubeShape(x,y,180,25);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(tube);
        g2d.dispose();
    }
    
    //draws color blocks in test tubes, positions
    // 1234 bottom to top
    public void drawColor(Graphics g, Color c, int pos, int x, int y)
    {
        if (pos == 1)
        {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(c);
            TubeShape bottom = new TubeShape(x, y, 40, 25);
            g2d.fill(bottom);
        }
        else
        {
            g.setColor(c);
            g.fillRect(x, y, 50, 40);
        }
    }

    public void select(){
        isSelected=true;
        //raise
        //y -= 20;
    }


    public void deselect(){
        isSelected=false;
        //unraise
        //y += 20;
    }

    public boolean getIsSelected(){
        return isSelected;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getY(){
        return y;
    }

    public int getOriginalY(){
        return originalY;
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

    public void setNumBlocks(int n){
        currNumBlocks+=n;
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
        if(colors.isEmpty()){
            return null;
        }
        Color top = colors.peek();
        return top;
    }

    public void pourTo(Tube otherTube)
    {
        Color previousColor = topColor();
        while (!colors.isEmpty() && colors.peek().equals(previousColor) && otherTube.numBlocks()<4)
        {
            previousColor=colors.peek();
            otherTube.getColors().push(colors.pop());
            currNumBlocks--;
            otherTube.setNumBlocks(1);
        }
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
