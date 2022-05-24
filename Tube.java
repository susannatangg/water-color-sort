import java.awt.*;
import java.util.*;
import java.awt.geom.*;

//JAVADOCS DONE
/**
 * This class constructs each tube. Each tube is a stack of Colors. 
 * Each slot in the stack is a color. 
 * The bottom of the stack is the bottom of the tube,
 * and the top of the stack is the top of the tube. 
 * In a regular level, all colors of the tube will be shown. 
 * In a mystery level, only the top color of the stack will be shown. 
 * The max number of color blocks in the tube is always 4.
 */
public class Tube{
    
    private Stack<ColorBlock> colors;
    private int currNumBlocks;
    private boolean isMystery;
    private boolean isSelected;
    private int originalY=0;
    Point2D loc;
    Point2D originalLoc;
    int angle=0;
    Color otherColor;
    int topColorHeight=40;
    boolean drawLast=false;
    boolean drawSecondLast=false;
    Color otherTubeTopColor;
    Tube pourToTube;
    
    /**
     * Deals with moving colorblocks when pouring 
     * from one tube to another
     * Deals with setting only the top colorblock to show 
     * in a mystery level 
     * @param colors array of colorblocks 
     * @param isMystery determine if level is mystery or not
     */
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

    /**
     * draws the tube with specific coordinates
     * sets the tubeshape 
     * @param g graphics
     * @param x x coordinate
     * @param y y coordinate
     */
    public void drawTube(Graphics g, double x, double y)
    {
        int currNumBlocksTmp = currNumBlocks;
        Stack<ColorBlock> colorsTmp = new Stack<ColorBlock>();
        colorsTmp.addAll(colors);
        if(currNumBlocks>0){
            double yCoord=y+20+(40*(4-currNumBlocks))+(40*(currNumBlocks-currNumBlocksTmp));
            drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,yCoord+(40-topColorHeight),topColorHeight);
            currNumBlocksTmp--;
            while(!colorsTmp.isEmpty()){
                yCoord=y+20+(40*(4-currNumBlocks))+(40*(currNumBlocks-currNumBlocksTmp));
                drawColor(g,colorsTmp.pop(),currNumBlocksTmp,x,yCoord,40);
                currNumBlocksTmp--;
            }
        }
        AffineTransform at = AffineTransform.getRotateInstance(
                Math.toRadians(0),loc.getX()+50,loc.getY());
            at.rotate(Math.toRadians(angle),loc.getX()+50,loc.getY());
        g.setColor(new Color(217, 217, 217));
        Graphics2D g2d = (Graphics2D) g.create();
        TubeShape tube = new TubeShape(x,y,180,25,25);
        g2d.setColor(new Color(217, 217, 217));
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(at.createTransformedShape(tube));
        g2d.dispose();
        if(angle>90){
            g.setColor(topColor());
            g.fillRect((int)loc.getX()+48,(int)loc.getY(),4,180-(pourToTube.numBlocks()*40)+(50+topColorHeight));
        }
    }
    
    /**
     * draws the colorblocks in the tubeshape tube
     * @param g graphics
     * @param c color block drawn
     * @param pos position in the tube; position 1 is the bottom of the tube
     * @param x x coordinate
     * @param y y coordinate
     */
    public void drawColor(Graphics g, ColorBlock c, int pos, double x, double y, int height)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        AffineTransform at = AffineTransform.getRotateInstance(
                Math.toRadians(0),loc.getX()+50,loc.getY());
            at.rotate(Math.toRadians(angle),loc.getX()+50,loc.getY());
        if (pos == 1 && !(topColorHeight==0 && currNumBlocks==1))
        {
            if(currNumBlocks==1 && topColorHeight<25){
                if(c.getIsMystery()){
                    g2d.setColor(Color.GRAY);
                }
                else {
                    g2d.setColor(c);
                }
                double radiusX=Math.sqrt(625-((25-topColorHeight)*(25-topColorHeight)));
                TubeShape bottom = new TubeShape(x+(25-radiusX), y, topColorHeight, (int)radiusX, topColorHeight);
                g2d.fill(at.createTransformedShape(bottom));
            }else{
                if(c.getIsMystery()){
                    g2d.setColor(Color.GRAY);
                }
                else {
                    g2d.setColor(c);
                }
                TubeShape bottom = new TubeShape(x, y, height, 25, 25);
                g2d.fill(at.createTransformedShape(bottom));
            }
        }
        else
        {
            if(c.getIsMystery()){
                g2d.setColor(Color.GRAY);
            }
            else {
                g2d.setColor(c);
            }
            g2d.fill(at.createTransformedShape(new Rectangle2D.Double(x,y,50,height)));
        }
        if(c.getIsMystery() && angle==0){
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.BOLD, 25));
            g.drawString("?", (int)x + 20, (int)y + 28);
        }
    }

    /**
     * gets the angle
     * @return the angle
     */
    public int getAngle(){
        return angle;
    }

    /**
     * sets top color height
     * @param height
     */
    public void setTopColorHeight(int n){
        topColorHeight=n;
    }

    /**
     * changes the angle
     */
    public void setAngle(int n){
        angle=n;
    }

    /**
     * tube is selected
     */
    public void select(){
        isSelected=true;
        //raise
        //y -= 20;
    }

    /**
     * tube is deselected
     */
    public void deselect(){
        isSelected=false;
        //unraise
        //y += 20;
    }

    /**
     * determines if a tube is selected or not
     * @return
     */
    public boolean getIsSelected(){
        return isSelected;
    }

    /**
     * sets the tube's x coordinate's location
     * @param x x coord
     */
    public void setTubeX(double x){
        loc.setLocation(x,loc.getY());
    }

    /**
     * sets hte tube's y coordinate's location
     * @param y y coord
     */
    public void setTubeY(double y){
        loc.setLocation(loc.getX(),y);
    }

    /**
     * gets the tube's x coordinate location
     * @return loc.getX() location of x
     */
    public double getTubeX(){
        return loc.getX();
    }

    /**
     * gets the tube's y coordinate location
     * @return loc.getY() location of y
     */
    public double getTubeY(){
        return loc.getY();
    }

    /**
     * gets original y coord location
     * @return originalY location
     */
    public int getOriginalY(){
        return originalY;
    }

    /**
     * determines original Y location
     * @param originalY og location
     */
    public void setOriginalY(int originalY){
        this.originalY=originalY;
    }

    /**
     * stack of colorblocks
     * gets colors in the stack
     * @return colors in stack
     */
    public Stack<ColorBlock> getColors(){
        return colors;
    }

    /**
     * if current number of colorblocks in the tube is 0
     * then the tube is empty
     * @return whether the tube is empty or not
     */
    public boolean isEmpty(){
        return currNumBlocks == 0;
    }

    /**
     * if current number of colorblocks in tube is 4 (max capacity)
     * the tube is full
     * @return whether the tube is full or not
     */
    public boolean isFull(){
        return currNumBlocks == 4;
    }

    /**
     * returns the current number of colorblocks
     * @return current number of blocks
     */
    public int numBlocks(){
        return currNumBlocks;
    }

    /**
     * increment number of currentnumber blocks
     * @param n number of colorblocks to add to another
     */
    public void addToNumBlocks(int n){
        currNumBlocks+=n;
    }
    
    /**
     * Determines whether a tube is complete or not.
     * A tube is complete if it is full, not empty, 
     * and has all of the same colors
     * @return true/false based on completion or not 
     */
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
   
    /**
     * gets the topcolor of the tube 
     * @return top topcolor
     */
    public Color topColor()
    {
        if(colors.isEmpty()){
            return null;
        }
        Color top = colors.peek().getColor();
        return top;
    }

    /**
     * pouring to another tube and transferring the colorblocks
     * Deals with transferring between different stacks for both normal
     * and mystery levels
     * @param otherTube that colors are being poured to 
     */
    public void pourTo(Tube otherTube)
    {
        Color previousColor = topColor();
        while (!colors.isEmpty() && colors.peek().equals(previousColor) /*&& otherTube.numBlocks()<4*/)
        {
            // if(isMystery){
            //     colors.peek().setIsMystery(false);
            // }
            previousColor=colors.peek();
            colors.pop();
            //otherTube.getColors().push(colors.pop());
            currNumBlocks--;
            //otherTube.addToNumBlocks(1);
        }
        if(isMystery && !this.colors.isEmpty()){
            Color topColor=this.colors.peek();
            //this.colors.peek().setIsMystery(false);
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

    public void addBlocks(Tube otherTube){
        Color previousColor = topColor();
        //int currNumBlocksTmp=currNumBlocks;
        Stack<ColorBlock> colorsTmp = new Stack<ColorBlock>();
        colorsTmp.addAll(colors);
        while (!colorsTmp.isEmpty() && colorsTmp.peek().equals(previousColor) && otherTube.numBlocks()<4)
        {
            // if(isMystery){
            //     colorsTmp.peek().setIsMystery(false);
            // }
            previousColor=colorsTmp.peek();
            otherTube.getColors().push(colorsTmp.pop());
            //currNumBlocksTmp--;
            otherTube.addToNumBlocks(1);
        }
        // if(isMystery && !colorsTmp.isEmpty()){
        //     Color topColor=colorsTmp.peek();
        //     colorsTmp.peek().setIsMystery(false);
        //     Stack<ColorBlock> temp = new Stack<ColorBlock>();
        //     while (!colorsTmp.isEmpty())
        //     {
        //         if(colorsTmp.peek().equals(topColor)){
        //             temp.push(colorsTmp.pop());
        //             temp.peek().setIsMystery(false);
        //         }else{
        //             break;
        //         }
        //     }
        //     while(!temp.isEmpty()){
        //         colorsTmp.push(temp.pop());
        //     }
        // }
        otherTube.topColorHeight=0;
    }

    /**
     * Compares the color between two different tubes
     * @param otherColor that is being compared to current
     * @return false if colors are not the same
     */
    public boolean sameColor(Color otherColor)
    {
        if (topColor().equals(otherColor))
        {
            return true;
        }
        return false;
    }

    /**
     * Mystery level or not
     * @return whether a level is a mystery level or not
     */
    public boolean isMystery()
    {
        return isMystery;
    }
}
