package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
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

        private final int dayNumb;
        

        Month(int i) {
            this.dayNumb = i;
        }
        
     
        private Month fromString(String s){
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
                throw new NoSuchElementException("No Month with such name exists");
            }else if (count.size()>1){
                throw new NoSuchElementException("Ambiguous input");
            }
            return count.get(0);
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
