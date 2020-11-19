package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] array;
    private final int size;

    public ImmutableArrayList() {
        this.array = new Object[0];
        this.size = this.array.length;
    }

    public ImmutableArrayList(Object[] array) {
        this.array = array.clone();
        this.size = this.array.length;
    }

    private void checkId(int id) {
        if (id < 0 || id >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return this.addAll(this.size, new Object[]{e});
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return this.addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(this.size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] ansArr = new Object[this.size + c.length];
        System.arraycopy(this.array, 0, ansArr, 0, index);
        System.arraycopy(c, 0, ansArr, index, c.length);
        System.arraycopy(this.array, index, ansArr, index + c.length, this.size - index);
        return new ImmutableArrayList(ansArr);
    }

    @Override
    public Object get(int index) {
        checkId(index);
        return this.array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkId(index);
        Object[] ansArr = new Object[this.size - 1];
        System.arraycopy(this.array, 0, ansArr, 0, index);
        System.arraycopy(this.array, index + 1, ansArr, index, this.size - index - 1);
        return new ImmutableArrayList(ansArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if(this.size == 0){
            return new ImmutableArrayList(new Object[]{e});
        }

        Object[] tempArray = this.array.clone();
        tempArray[index] = e;
        return new ImmutableArrayList(tempArray);
    }

    @Override
    public int indexOf(Object e) {
        return java.util.Arrays.asList(this.array).indexOf(e);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array).substring(1,
                Arrays.toString(this.array).length() - 1);
    }
}
