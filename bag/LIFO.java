package bag;

import surprise.ISurprise;

import java.util.ArrayList;
import java.util.Random;

public class LIFO implements IBag {
    private ArrayList<ISurprise> bag;
    private Random random=new Random();
    public LIFO(){
        bag=new ArrayList<ISurprise>();
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.bag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        int i;
        while(bagOfSurprises.isEmpty()==false){
            this.bag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(this.isEmpty()==false) {
            ISurprise x = this.bag.get(this.bag.size() - 1);
            this.bag.remove(this.bag.size() - 1);
            return x;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if(this.bag.size()==0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return this.bag.size();
    }

    @Override
    public void print() {
        for(int i=0;i<this.bag.size();i++)
            System.out.println(this.bag.get(i));
    }
    @Override
    public ISurprise getBag(int i){
        return this.bag.get(i);
    }
}
