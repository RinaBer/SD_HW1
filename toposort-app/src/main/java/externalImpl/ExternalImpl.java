package externalImpl;

import cs.technion.ac.il.sd.External;

/**
 * Created by rina.berlin on 4/15/2016.
 */
public class ExternalImpl implements External{

    @Override
    public void process(int i) {
        System.out.println(i);
    }

    @Override
    public void fail() {
        System.out.println("Error!!!!");
    }
}
