package main;

import bag.IBag;
import surprise.ISurprise;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    private IBag bag;
    private int waitTime;

    public AbstractGiveSurprises(String type,int waitTime){
        this.bag =(new BagFactory()).makeBag(type);
        this.waitTime=waitTime;
    }

    public void put(ISurprise newSurprise){
        bag.put(newSurprise);
    }
    public void put(IBag surprises){
        bag.put(surprises);
    }
    public ISurprise give(){
        return bag.takeOut();

    }
    public void giveAll(){
        for(int i=0;i<this.bag.size();i++){
            this.bag.takeOut().enjoy();
            try{
                TimeUnit.SECONDS.sleep(this.waitTime);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public boolean isEmpty(){
        return bag.isEmpty();
    }

    abstract protected void giveWithPassion();
}
