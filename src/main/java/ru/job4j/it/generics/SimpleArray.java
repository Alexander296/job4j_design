package ru.job4j.it.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int size = 0;
    int point = 0;

    public SimpleArray(int length) {
        this.data = (T[]) new Object[length];
    }

    public void add(T model) {
        Objects.checkIndex(size, data.length);
        data[size] = model;
        size++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        T[] result = (T[]) new Object[data.length - 1];
        System.arraycopy(data, 0, result, 0, index);
        System.arraycopy(data, index + 1, result, index, data.length - index - 1);
        data = result;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        data[index] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[point++];
            }
        };
    }
}
