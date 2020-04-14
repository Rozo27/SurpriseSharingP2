package surprise;

import java.util.ArrayList;
import java.util.Random;

public class Candies implements ISurprise {
    private int noCandies;
    private static ArrayList<String> candiesType=new ArrayList<>(5);
    private String tip;
    private static Random random=new Random();
    private static void setCandiesType(){
        candiesType.add("chocolate");
        candiesType.add("jelly");
        candiesType.add("fruit");
        candiesType.add("vanilla");
        candiesType.add("peanut butter");
    }
    private Candies(int noCandies,String tip){
        this.noCandies=noCandies;
        this.tip=tip;
    }
    public static Candies generate(){
        Candies.setCandiesType();
        int nr=random.nextInt(100);
        while(nr==0)
            nr=random.nextInt(100);
        Candies newCandy=new Candies(nr,candiesType.get(random.nextInt(5)));
        return newCandy;
    }
    @Override
    public void enjoy(){
        System.out.println("Ai primit "+this.noCandies+" bomboane de tip "+this.tip);
    }
}
