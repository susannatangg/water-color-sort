import java.awt.*;

// JAVA DOCS DONE
/**
 * Represents one level in the game.
 * Draws tubes for the level depending on which level it is, 
 * returns the number of tubes, the number of colors in the level, the number of complete tubes, 
 * whether the level is a mystery level, and whether or not the level is complete or not. 
 */
public class Level{
    
    private Tube[] tubes;
    private int numTubes;
    private int numCompleteTubes;
    private boolean isMystery;
    private int numColors;

    /**
     * Describes the parameters necessary for any level
     * @param tubes tubes drawn 
     * @param numColors number of colorblocks
     * @param isMystery whether the level is mystery or not
     */
    public Level(Tube[] tubes, int numColors, boolean isMystery)
    {
        this.isMystery = isMystery;
        this.tubes = tubes;
        this.numTubes = tubes.length;
        this.numCompleteTubes = 0;
        this.numColors = numColors;
    }

    /**
     * drawstubes (5, 7, or 9) layouts 
     * with specific location coordinates
     * @param g graphics
     */
    public void drawTubes(Graphics g){
        if(numTubes==5)
        {
            for(int i=0; i<5; i++)
            {
                if(i<3)
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point(i*100+75,200);
                        tubes[i].setOriginalY(200);
                        tubes[i].originalLoc=new Point(i*100+75,200);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
                else
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point((i-3)*100+125,435);
                        tubes[i].setOriginalY(435);
                        tubes[i].originalLoc=new Point((i-3)*100+125,435);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
            }
        }
        else if(numTubes==7)
        {
            for (int i=0; i<7; i++)
            {
                if (i<4)
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point((i*85)+50,200);
                        tubes[i].setOriginalY(200);
                        tubes[i].originalLoc=new Point((i*85)+50,200);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
                else
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point(((i-4)*85)+90,435);
                        tubes[i].setOriginalY(435);
                        tubes[i].originalLoc=new Point(((i-4)*85)+90,200);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
            }
            
        }
        else if(numTubes==9)
        {
            for (int i=0; i<9; i++)
            {
                if (i<5)
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point((i*70)+35,200);
                        tubes[i].setOriginalY(200);
                        tubes[i].originalLoc=new Point((i*70)+35,200);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
                else
                {
                    if(tubes[i].loc==null){
                        tubes[i].loc=new Point(((i-5)*80)+55,435);
                        tubes[i].setOriginalY(435);
                        tubes[i].originalLoc=new Point(((i-5)*80)+55,435);
                    }
                    tubes[i].drawTube(g,tubes[i].getTubeX(),tubes[i].getTubeY());
                }
            }
        }
    }

    /**
     * gets tubes
     * @return tubes 
     */
    public Tube[] getTubes()
    {
        return tubes;
    }

    /**
     * gets number of numtubes
     * @return numTubes
     */
    public int getNumTubes()
    {
        return numTubes;
    }

    /**
     * gets number of colors
     * @return numcolors
     */
    public int getNumColors(){
        return numColors;
    }

    /**
     * gets number of complete tubes
     * @return numcompletetubes
     */
    public int getNumCompleteTubes()
    {
        return numCompleteTubes;
    }

    /**
     * increases number of complete tubes
     * throughout the game
     * @return numcompletetubes++
     */
    public void incrementNumCompleteTubes()
    {
        numCompleteTubes++;
    }
    
    /**
     * determines whether or not
     * a tube is complete or not
     * if the number of complete tubes
     * is equal to the number of colors
     * @return true/false if complete or not
     */
    public boolean isComplete()
    {
        if (getNumCompleteTubes() == getNumColors())
        {
            return true;
        }
        return false; 
    }

    /**
     * whether a level is a mystery level or not
     * @return isMystery
     */
    public boolean isMystery()
    {
        return isMystery;
    }
}
