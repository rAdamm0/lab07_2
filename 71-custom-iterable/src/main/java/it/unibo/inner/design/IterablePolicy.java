package it.unibo.inner.design;

import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePolicy<T> implements IterableWithPolicy<T> {

    private ArrayList<T> n = new ArrayList<>();
    private Predicate<T> p;

    public IterablePolicy(T[] elem, Predicate<T> pred){
        this.p = pred;
        for(T k : elem){
            if(pred.test(k)){
                this.n.add(k);
            }
        }
    }


    public IterablePolicy(T[] elem){
        this(elem, new Predicate<T>() {
            public boolean test(T elem) {
                return true;
            }
        });
    }

    private class PolicyIter implements Iterator<T>{

        private int length=0;

        public boolean hasNext() {
            if (length>= n.size()) {
                return false;
            }
            return true;
           }

        public T next() {
            do {
                if(this.hasNext() && p.test(n.get(this.length))){
                    return n.get(this.length++);
                    }
                this.length++;
                }while(this.hasNext());
            return null;
        }

    }
    
    @Override
    public Iterator<T> iterator() {
        return new PolicyIter();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.p = filter;
    }

    
}


    

