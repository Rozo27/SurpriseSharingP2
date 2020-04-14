package bag;
import surprise.ISurprise;

import java.util.ArrayList;

public interface IBag {
    ArrayList<ISurprise> bag=new ArrayList<ISurprise>();
    // adds a surprise in the bag
    void put(ISurprise newSurprise);

    // adds all the surprises from another IBag
    //   -> the 'bagOfSurprises' will be empty() afterwards
    void put(IBag bagOfSurprises);

    // removes a surprise from the bag and returns it
    ISurprise takeOut();

    // Checks if the bag is empty or not
    boolean isEmpty();

    // Returns the number of surprises
    int size();

    void print();
    ISurprise getBag(int i);
}
