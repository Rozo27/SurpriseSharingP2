package main;

import bag.FIFO;
import bag.IBag;
import bag.LIFO;
import bag.RandomGiveAway;

public class BagFactory implements IBagFactory {
    @Override
    public IBag makeBag(String type) {
        if(type.equalsIgnoreCase("random")){
           return new RandomGiveAway();
        }
        else if(type.equalsIgnoreCase("fifo")){
            return new FIFO();
        }
        return new LIFO();
    }
}
