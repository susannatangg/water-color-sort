import java.awt.*;
import java.util.*;

public class Tube{
    
    private Stack<ColorBlock> colors;
    private int currNumBlocks;
    private boolean isMystery;
    private boolean isSelected;
    private int y=0;
    private int originalY=0;
    private int tubeX;
    private int tubeY;
    
    public Tube(Color[] colors, boolean isMystery){
        this.colors=new Stack<ColorBlock>();
        int numBlocks=0;
        Color currColor=colors[0];
        for (int i=0; i<colors.length; i++){
            if(colors[i]==null){
                break;
            }
            if(isMystery){
                this.colors.add(new ColorBlock(colors[i], true));
            }else{
                this.colors.add(new ColorBlock(colors[i], false));
            }
            numBlocks++;
            if(i>0 && !colors[i].equals(currColor)){
                currColor=colors[i];
            }
        }
        if(isMystery && !this.colors.isEmpty()){
            Color topColor=this.colors.peek();
            this.colors.peek().setIsMystery(false);
            Stack<ColorBlock> temp = new Stack<ColorBlock>();
            while (!this.colors.isEmpty())
            {
                if(this.colors.peek().equals(topColor)){
                    temp.push(this.colors.pop());
                    temp.peek().setIsMystery(false);
                }else{
                    break;
                }
            }
            while(!temp.isEmpty()){
                this.colors.push(temp.pop());
            }
        }
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
        
        Stack<ColorBlock> colorsTmp = new Stack<ColorBlock>();
        colorsTmp.addAll(colors);
        if(currNumBlocks>0){
            while(!colorsTmp.isEmpty()){
                int yCoord=y+20+(40*(4-currNumBlocks))+(40*(currNumBlocks-currNumBlocksTmp));
                drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,yCoord);
                currNumBlocksTmp--;
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
    public void drawColor(Graphics g, ColorBlock c, int pos, int x, int y)
    {
        if (pos == 1)
        {
            Graphics2D g2d = (Graphics2D) g.create();
            if(c.getIsMystery()){
                g2d.setColor(Color.GRAY);
            }
            else {
                g2d.setColor(c);
            }
            TubeShape bottom = new TubeShape(x, y, 40, 25);
            g2d.fill(bottom);
        }
        else
        {
            if(c.getIsMystery()){
                g.setColor(Color.GRAY);
            }
            else {
                g.setColor(c);
            }
            g.fillRect(x, y, 50, 40);
        }
        if(c.getIsMystery()){
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 25));
            g.drawString("?", x + 20, y + 28);
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

    public void setTubeX(int x){
        tubeX=x;
    }

    public void setTubeY(int y){
        tubeY=y;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getY(){
        return y;
    }

    public int getTubeX(){
        return tubeX;
    }

    public int getTubeY(){
        return tubeY;
    }

    public int getOriginalY(){
        return originalY;
    }

    public Stack<ColorBlock> getColors(){
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

    public void addToNumBlocks(int n){
        currNumBlocks+=n;
    }
    
    public boolean isComplete()
    {
        if(!isFull()){
            return false;
        }
        Stack<Color> colorsTmp = new Stack<Color>();
        colorsTmp.addAll(colors);
        Color previousColor=colorsTmp.peek();
        while(!colorsTmp.isEmpty()){
            if(!previousColor.equals(colorsTmp.peek())){
                return false;
            }
            previousColor=colorsTmp.pop();
        }
        return true;
    }
   
    public Color topColor()
    {
        if(colors.isEmpty()){
            return null;
        }
        Color top = colors.peek().getColor();
        return top;
    }

    public void pourTo(Tube otherTube)
    {
        Color previousColor = topColor();
        while (!colors.isEmpty() && colors.peek().equals(previousColor) && otherTube.numBlocks()<4)
        {
            if(isMystery){
                colors.peek().setIsMystery(false);
            }
            previousColor=colors.peek();
            otherTube.getColors().push(colors.pop());
            currNumBlocks--;
            otherTube.addToNumBlocks(1);
        }
        if(isMystery && !this.colors.isEmpty()){
            Color topColor=this.colors.peek();
            this.colors.peek().setIsMystery(false);
            Stack<ColorBlock> temp = new Stack<ColorBlock>();
            while (!this.colors.isEmpty())
            {
                if(this.colors.peek().equals(topColor)){
                    temp.push(this.colors.pop());
                    temp.peek().setIsMystery(false);
                }else{
                    break;
                }
            }
            while(!temp.isEmpty()){
                this.colors.push(temp.pop());
            }
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
