package ru.job4j.it.generics;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        SimpleArray<String> data = new SimpleArray<>(1);
        data.add("Hello");
        assertThat(data.get(0), is("Hello"));
    }

    @Test
    public void get() {
        SimpleArray<String> data = new SimpleArray<>(1);
        int index = 0;
        data.add("Hello");
        assertThat(data.get(index), is("Hello"));
    }

    @Test
    public void remove() {
        SimpleArray<String> data = new SimpleArray<>(3);
        int index = 1;
        data.add("1");
        data.add("2");
        data.add("3");
        data.remove(index);
        assertThat(data.get(index), is("3"));
    }

    @Test
    public void set() {
        SimpleArray<String> data = new SimpleArray<>(3);
        int index = 1;
        data.add("1");
        data.add("2");
        data.add("3");
        data.set(index, "Hello");
        assertThat(data.get(index), is("Hello"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWhenArrayFull() {
        SimpleArray<String> data = new SimpleArray<>(1);
        data.add("Hello");
        data.add("Bye");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWhenIndexOutOfBoundsOfDataStored() {
        SimpleArray<String> data = new SimpleArray<>(5);
        int index = 2;
        data.add("Hello");
        data.add("Bye");
        data.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWhenIndexOutOfBoundsOfDataStored() {
        SimpleArray<String> data = new SimpleArray<>(5);
        int index = 4;
        data.add("1");
        data.add("2");
        data.add("3");
        data.remove(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWhenIndexOutOfBoundsOfDataStored() {
        SimpleArray<String> data = new SimpleArray<>(5);
        int index = 4;
        data.add("1");
        data.add("2");
        data.set(index, "Hello");
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromNullArray() {
        SimpleArray<String> data = new SimpleArray<>(5);
        Iterator<String> it = data.iterator();
        it.next();
    }

    @Test
    public void whenReadSequence() {
        SimpleArray<String> data = new SimpleArray<>(3);
        data.add("1");
        data.add("2");
        data.add("3");
        Iterator<String> it = data.iterator();
        assertThat(it.next(), is("1"));
        assertThat(it.next(), is("2"));
        assertThat(it.next(), is("3"));
    }

    @Test
    public void whenMultiCallHasNextThenTrue() {
        SimpleArray<String> data = new SimpleArray<>(3);
        data.add("1");
        data.add("2");
        data.add("3");
        Iterator<String> it = data.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenArrayNullHasNext() {
        SimpleArray<String> data = new SimpleArray<>(3);
        Iterator<String> it = data.iterator();
        assertThat(it.hasNext(), is(false));
    }


}