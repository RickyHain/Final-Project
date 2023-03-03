public class Display {
    private int stage;
    private String model;

    public Display(){
        this.stage =0;
        this.model = "   ____\n  |\n  |\n  |\n______";
    }

    public void nextStage(){
        this.stage+=1;
        this.model = changemodel(this.stage);
    }

    public String toString(){
        return this.model;
    }

    public int getStage(){
        return this.stage;
    }

    public static String changemodel(int stage)
    {
        if(stage==1)
            return "   ____\n  |    O \n  |\n  |\n______";
        else if(stage==2)
            return "   ____\n  |    O \n  |    | \n  |\n______";
        else if(stage==3)
            return "   ____\n  |    O \n  |   /| \n  |\n______";
        else if(stage==4)
            return "   ____\n  |    O \n  |   /|\\ \n  |\n______";
        else if(stage==5)
            return "   ____\n  |    O \n  |   /|\\ \n  |   / \n______";
        else if(stage==6)
            return "   ____\n  |    O \n  |   /|\\ \n  |   / \\\n______";

        return "";
    }
}
