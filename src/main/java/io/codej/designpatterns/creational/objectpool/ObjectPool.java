package io.codej.designpatterns.creational.objectpool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ObjectPool {
    private final int allocationSize = 10;
    private List<Controlable> freeList = new ArrayList<>();
    private List<Poolable> inUseList = new ArrayList<>();

    interface ClassFactory<E> {

        E create();

        static Controlable toControlable(Object o) {
            return (Controlable)o;
        }

        static Poolable toPoolable(Object o) {
            return (Poolable)o;
        }
    }

    public synchronized <E> E get(ClassFactory<E> factory) {
        if(freeList.size()>0) {
           Controlable c = freeList.remove(0);
           inUseList.add((Poolable)c);
            try {
                return (E) c;
            } finally {
                c.activate();
            }
        } else {
            return allocate(factory, allocationSize);
        }
    }

    public synchronized <E> void put(E obj) {
        Poolable p = ClassFactory.toPoolable(obj);
        if(inUseList.remove(p)) {
            p.reset();
            Controlable c = ClassFactory.toControlable(obj);
            try {
                freeList.add(c);
            } finally {
                c.deactivate();
            }
        }
    }

    /**
     * Derived class is allowed to provide a different size than this allocationSize.
     * @param size allocation size, can be -ve
     * @param <E>
     * @return null if -ve size is passed, allocates E instances are return first element
     */
    protected  <E> E allocate(ClassFactory<E> factory, int size) {
        if(size > 0) {
            IntStream.range(0, size).forEach(i->{
                System.out.println("adding object [" + i + "] into pool");
                Object obj = factory.create();
                Controlable c = ClassFactory.toControlable(obj);
                freeList.add(c);
            });
            Controlable c = freeList.remove(0);
            inUseList.add((Poolable)c);
            c.activate();
            return (E)c;
        } else {
            IntStream.range(size, 0).forEach((IntConsumer) freeList.remove(0));
        }
        return null;
    }
}
