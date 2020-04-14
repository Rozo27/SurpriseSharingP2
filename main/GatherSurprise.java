package main;
import surprise.Candies;
import surprise.FortuneCookie;
import surprise.ISurprise;
import surprise.MinionToy;

import java.util.ArrayList;
import java.util.Random;

public final class GatherSurprise {
    private static Random random=new Random();
    private GatherSurprise(){
    }
    public static ArrayList<ISurprise> gather(int n){
        ArrayList<ISurprise> array=new ArrayList<ISurprise>(n);
        int i;
        for(i=0;i<n;i++){
            switch (random.nextInt(3)){
                case 0:array.add(FortuneCookie.generate());
                    break;
                case 1:array.add(Candies.generate());
                    break;
                case 2: array.add(MinionToy.generate());
                    break;
            }
        }
        return array;
    }
    public static ISurprise gather(){
        switch (random.nextInt(3)){
            case 0: return FortuneCookie.generate();

            case 1:return Candies.generate();

            case 2:return MinionToy.generate();
            default:return null;
        }
    }
}
