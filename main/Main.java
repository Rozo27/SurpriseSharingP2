package main;

import bag.FIFO;
import bag.IBag;
import bag.LIFO;
import bag.RandomGiveAway;
import surprise.Candies;
import surprise.FortuneCookie;
import surprise.ISurprise;
import surprise.MinionToy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i;

        //am creat 3 tipuri de surprize folosind metoda statica generate-genereaza surprize aleator
        ISurprise fCookie=FortuneCookie.generate();
        ISurprise candies=Candies.generate();
        ISurprise mToy=MinionToy.generate();

        ArrayList<ISurprise> surprises=new ArrayList<ISurprise>(3);
        surprises.add(fCookie);
        surprises.add(candies);
        surprises.add(mToy);

        FIFO fifo=new FIFO();
        LIFO lifo=new LIFO();
        RandomGiveAway random=new RandomGiveAway();

        //adaug cele 3 surprize si le scot in functie de tipul container-ului
        for(i=0;i<=2;i++){
            fifo.put(surprises.get(i));
            lifo.put(surprises.get(i));
            random.put(surprises.get(i));
        }
        ISurprise x;
        System.out.println("Container-ul fifo inainte de a scoate din el surprizele:");
        for(i=0;i<fifo.size();i++){
            fifo.getBag(i).enjoy();
        }
        System.out.println("Surprizele au fost scoase dupa cum urmeaza:");
        while((x=fifo.takeOut())!=null){
            x.enjoy();
        }
        System.out.println("Dimensiunea fifo dupa ce am scos surprizele:"+fifo.size());
        System.out.println("----------------------------------------");

        System.out.println("Container-ul lifo inainte de a scoate din el surprizele:");
        for(i=0;i<lifo.size();i++){
            lifo.getBag(i).enjoy();
        }
        System.out.println("Surprizele au fost scoase dupa cum urmeaza:");
        while((x=lifo.takeOut())!=null){
            x.enjoy();
        }
        System.out.println("Dimensiunea lifo dupa ce am scos surprizele:"+lifo.size());
        System.out.println("----------------------------------------");

        System.out.println("Container-ul random inainte de a scoate din el surprizele:");
        for(i=0;i<random.size();i++){
            random.getBag(i).enjoy();
        }
        System.out.println("Surprizele au fost scoase dupa cum urmeaza:");
        while((x=random.takeOut())!=null){
            x.enjoy();
        }
        System.out.println("Dimensiunea random dupa ce am scos surprizele:"+random.size());
        System.out.println("----------------------------------------");

        //adaug container-ul de tip fifo si random la cel de tip lifo
        for(i=0;i<=2;i++){
            fifo.put(surprises.get(i));
            lifo.put(surprises.get(i));
            random.put(surprises.get(i));
        }
        lifo.put(fifo);
        lifo.put(random);
        System.out.println("Elementele din lifo dupa ce am adaugat surprizele:");
        for(i=0;i<lifo.size();i++)
            lifo.getBag(i).enjoy();
        System.out.println("Dimensiunea fifo dupa ce am adaugat elementele in lifo:"+fifo.size());
        System.out.println("Dimensiunea random dupa ce am adaugat elementele in lifo:"+random.size());
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();

        //clasa abstracta GatherSurprises
        GatherSurprise.gather().enjoy();
        GatherSurprise.gather().enjoy();
        GatherSurprise.gather().enjoy();
        surprises=GatherSurprise.gather(5);
        for(i=0;i<surprises.size();i++){
            surprises.get(i).enjoy();
        }
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();
        //creare de containere folosind metoda makeBag din clasa BagFactory care implementeaza IBagFactory
        IBag containerF=(new BagFactory()).makeBag("fifo");
        IBag containerL=(new BagFactory()).makeBag("ranDom");
        IBag containerR=(new BagFactory()).makeBag("liFo");
        System.out.println(containerF.getClass());
        System.out.println(containerL.getClass());
        System.out.println(containerR.getClass());

        //AbstractGiveSurprises
        String type="lifo";
        int sec=4;
        GiveSurpriseAndHug giveAndHug=new GiveSurpriseAndHug(type,sec);
        GiveSurpriseAndSing giveAndSing=new GiveSurpriseAndSing(type,sec);
        GiveSurpriseAndApplause giveAndApplause=new GiveSurpriseAndApplause(type,sec);

        System.out.println("----------------------------------------");
        System.out.println();
        giveAndHug.put(lifo);
        giveAndHug.giveAll();
        giveAndHug.giveWithPassion();

        System.out.println("----------------------------------------");
        System.out.println();
        for(i=0;i<=2;i++){
            fifo.put(surprises.get(i));
            lifo.put(surprises.get(i));
            random.put(surprises.get(i));
        }
        lifo.put(fifo);
        lifo.put(random);
        giveAndApplause.put(lifo);
        giveAndApplause.giveAll();
        giveAndApplause.giveWithPassion();

        System.out.println("----------------------------------------");
        System.out.println();
        for(i=0;i<=2;i++){
            fifo.put(surprises.get(i));
            lifo.put(surprises.get(i));
            random.put(surprises.get(i));
        }
        lifo.put(fifo);
        lifo.put(random);
        giveAndSing.put(lifo);
        giveAndSing.giveAll();
        giveAndSing.giveWithPassion();
    }
}
