package DataStructureImplementation;

import java.util.Arrays;

/**
 * Created by Jason on 12/28/15.
 */
public class ArrayListImpl<T> {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    public ArrayListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T t) {
        if (size == elements.length) ensureCapacity();
        elements[size++] = t;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public T get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        return (T) elements[i];
    }

}
