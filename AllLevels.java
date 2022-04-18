public class AllLevels {

    private Level[] levels;
    private int numLevels;
    private int levelsCompleted;

    public AllLevels(int numLevels){
        this.numLevels = numLevels;
        this.levels = new Level[numLevels];
        this.levelsCompleted = 0;
    }

    public int getNumLevels(){
        return numLevels;
    }

    public int getLevelsCompleted(){
        return levelsCompleted;
    }

    public void setLevelsCompleted(int n){
        levelsCompleted=n;
    }

    public boolean allLevelsCompleted()
    {
        boolean complete = true;
        for (Level l : levels)
        {
            if (!l.isComplete())
            {
                complete = false;
            }
        }

        return complete;
    }
}
