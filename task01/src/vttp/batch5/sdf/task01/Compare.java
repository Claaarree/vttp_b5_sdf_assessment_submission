package vttp.batch5.sdf.task01;

import java.util.Comparator;

import vttp.batch5.sdf.task01.models.BikeEntry;

public class Compare implements Comparator<BikeEntry>{

    @Override
    public int compare(BikeEntry b1, BikeEntry b2) {
       return (b2.getRegistered() + b2.getCasual()) - (b1.getRegistered() + b1.getCasual());
    }
    
}
