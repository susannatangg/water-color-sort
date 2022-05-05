import java.awt.*;

public class Level{
    
    private Tube[] tubes;
    private int numTubes;
    private int numCompleteTubes;
    private boolean isMystery;
    private int numColors;

    public Level(Tube[] tubes, int numColors, boolean isMystery)
    {
        this.isMystery = isMystery;
        this.tubes = tubes;
        this.numTubes = tubes.length;
        this.numCompleteTubes = 0;
        this.numColors = numColors;
    }

    public void drawTubes(Graphics g){
        if(numTubes==5)
        {
            for(int i=0; i<5; i++)
            {
                if(i<3)
                {
                    tubes[i].drawTube(g,(i*100)+75, 200);
                    tubes[i].setTubeX(i*100+75);
                    tubes[i].setTubeY(200);
                }
                else
                {
                    tubes[i].drawTube(g,((i-3)*100)+125, 435);
                    tubes[i].setTubeX((i-3)*100+125);
                    tubes[i].setTubeY(435);
                }
            }
        }
        else if(numTubes==7)
        {
            for (int i=0; i<7; i++)
            {
                if (i<4)
                {
                    tubes[i].drawTube(g, (i*85)+50, 200);
                    tubes[i].setTubeX((i*85)+50);
                    tubes[i].setTubeY(200);
                }
                else
                {
                    tubes[i].drawTube(g, ((i-4)*85)+90, 435);
                    tubes[i].setTubeX(((i-4)*85)+90);
                    tubes[i].setTubeY(435);
                }
            }
            
        }
        else if(numTubes==9)
        {
            for (int i=0; i<9; i++)
            {
                if (i<5)
                {
                    tubes[i].drawTube(g, (i*70)+35, 200);
                    tubes[i].setTubeX((i*70)+35);
                    tubes[i].setTubeY(200);
                }
                else
                {
                    tubes[i].drawTube(g, ((i-5)*80)+55, 435);
                    tubes[i].setTubeX(((i-5)*80)+55);
                    tubes[i].setTubeY(435);
                }
            }
        }
    }

    public Tube[] getTubes()
    {
        return tubes;
    }

    public int getNumTubes()
    {
        return numTubes;
    }

    public int getNumColors(){
        return numColors;
    }

    public int getNumCompleteTubes()
    {
        return numCompleteTubes;
    }

    public void incrementNumCompleteTubes()
    {
        numCompleteTubes++;
    }
    
    public boolean isComplete()
    {
        if (getNumCompleteTubes() == getNumColors())
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
