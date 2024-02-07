package ru.vlsu.ispi.kpp.SpringMVC;

import java.util.Random;


public class RandomService {
    private final int rnd;

    RandomService(){
        Random rand = new Random();
        rnd = rand.nextInt(100);
    }

    public int get(){
        return rnd;
    }
}
