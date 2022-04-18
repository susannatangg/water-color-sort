import java.awt.*;

public class Level{
    
    private Tube[] tubes;
    private int numTubes;
    private int numCompleteTubes;
    private boolean isMystery;
    private int numColors;

    public Level(int numTubes, int numColors, boolean isMystery){
        this.isMystery = isMystery;
        tubes = new Tube[numTubes];
        this.numTubes = numTubes;
        this.numCompleteTubes = 0;
        this.numColors = numColors;
    }

    public void drawTubes(Graphics g){
        for (Tube t: tubes){
            t.drawTube(g);
        }
    }

    public Tube[] getTubes(){
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
    
    public boolean isComplete()
    {
        if (getNumCompleteTubes() == getNumColors())
        {
            return true;
        }
        return false; 
    }

    public boolean isMystery(){
        return isMystery;
    }
}
