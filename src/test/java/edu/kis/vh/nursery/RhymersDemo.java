package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int MAX_LOOP = 15;
    public static final int RHYMERS_LIMIT = 3;
    public static final int RANDOM_RANGE = 20;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < MAX_LOOP; i++)
            for (int j = 0; j < RHYMERS_LIMIT; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < MAX_LOOP; i++)
            rhymers[RHYMERS_LIMIT].countIn(rn.nextInt(RANDOM_RANGE));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[RHYMERS_LIMIT]).reportRejected());
        
    }
    
}