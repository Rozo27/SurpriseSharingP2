package surprise;

import java.util.ArrayList;

public class MinionToy implements ISurprise{
    private String nume;
    private static int i=-1;
    private static ArrayList<String> minionName=new ArrayList<String>(6);
    private static void setMinionName(){
        minionName.add("Dave");
        minionName.add("Carl");
        minionName.add("Kevin");
        minionName.add("Stuart");
        minionName.add("Jerry");
        minionName.add("Tim");
    }
    private MinionToy(String nume){
        this.nume=nume;
    }
    @Override
    public void enjoy(){
        System.out.println("Ai primit un minion de tip "+this.nume);
    }
    public static MinionToy generate(){
        MinionToy.setMinionName();
        if(i<minionName.size()-1)
            i++;
        else i=0;
        return new MinionToy(minionName.get(i));
    }
}
