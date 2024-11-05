package it.unibo.inner.design;

import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePolicy<T> implements IterableWithPolicy<T> {

    ArrayList<T> n;

    


    public IterablePolicy(Collection<? extends T> n) {
        this.n.addAll(n);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }
    
}
