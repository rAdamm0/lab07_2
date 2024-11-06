package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

import it.unibo.nestedenum.Comp.byDays;
import it.unibo.nestedenum.Comp.byOrder;

import java.util.List;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public enum Month{
        JAN(31),
        FEB(28),
        MAR(31),
        APR(30),
        MAY(31),
        JUN(30),
        JUL(31),
        AUG(31),
        SEP(30),
        OCT(31),
        NOV(30),
        DEC(31);

        public final int dayNumb;
        

        Month(int i) {
            this.dayNumb = i;
        }
        
     
        public static Month fromString(String s){
            int i;
            List<Month> count = new ArrayList<>();
            for(Month temp : Month.values()){
                i = 0;
                char [] tm = temp.name().toCharArray();
                char [] k = s.toCharArray();
                for(; i < k.length  && Character.toUpperCase(tm[i]) == Character.toUpperCase(k[i]); i++);
                if(i == k.length){
                    //return temp;
                    count.add(temp);
                }
            }
            if(count.isEmpty()){
                throw new IllegalArgumentException("No Month with such name exists");
            }else if (count.size()>1){
                throw new IllegalArgumentException("Ambiguous input");
            }
            return count.get(0);
        }
       
        
    }

    @Override
    public Comparator<String> sortByDays() {
        return new byDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new byOrder();
    }
}
