package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

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

        private final int dayNumb;
        

        Month(int i) {
            this.dayNumb = i;
        }
        
     
        private Month fromString(String s){
            int i;
            for(Month temp : Month.values()){
                i = 0;
                char [] tm = temp.name().toCharArray();
                char [] k = s.toCharArray();
                for(; i < k.length  && tm[i] == k [i]; i++);
                if(i == k.length){
                    return temp;
                }
            }
        }
       
        
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
