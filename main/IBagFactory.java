package main;

import bag.IBag;

public interface IBagFactory {
    IBag makeBag(String type);
}
