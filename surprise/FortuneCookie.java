package surprise;

import java.util.ArrayList;
import java.util.Random;

public class FortuneCookie implements ISurprise {
    private String mesaj;
    private static Random random=new Random();
    private static ArrayList<String> zicale=Zicale.generateZicale();
    private FortuneCookie(String mesaj){
        this.mesaj=mesaj;
    }
    @Override
    public void enjoy(){
        System.out.println(mesaj);
    }
    public static FortuneCookie generate(){
        return new FortuneCookie(zicale.get(random.nextInt(20)));
    }
}
