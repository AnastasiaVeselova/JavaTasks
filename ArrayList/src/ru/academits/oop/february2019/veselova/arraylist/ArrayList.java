package ru.academits.oop.february2019.veselova.arraylist;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int length;

    private int modCount = 0;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity is less than or equal to zero.");
        }

        items = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < length) {
            return (T1[]) Arrays.copyOf(items, length, a.getClass());
        }
        System.arraycopy(items, 0, a, 0, length);
        if (a.length > length) {
            a[length] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        add(length, t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(length, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of array bounds.");
        }
        if (c.size() == 0) {
            return false;
        }

        ensureCapacity(length + c.size());
        System.arraycopy(items, index, items, index + c.size(), length - index);
        int i = index;
        for (T item : c) {
            items[i] = item;
            i++;
        }
        modCount++;
        length += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int initialModCount = modCount;

        int i = 0;
        while (i < length) {
            if (c.contains(items[i])) {
                remove(i);
            } else {
                i++;
            }
        }

        return modCount != initialModCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int initialModCount = modCount;
        int i = 0;
        while (i < length) {
            if (!c.contains(items[i])) {
                remove(i);
            } else {
                i++;
            }
        }
        return modCount != initialModCount;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            items[i] = null;
        }

        length = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of array bounds.");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of array bounds.");
        }

        T oldItem = items[index];
        items[index] = element;
        return oldItem;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of array bounds.");
        }
        if (length == items.length) {
            increaseCapacity();
        }

        if (index < length - 1) {
            System.arraycopy(items, index, items, index + 1, length - index);
        }
        items[index] = element;
        length++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of array bounds.");
        }
        T deletedItem = items[index];

        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        length--;
        modCount++;
        return deletedItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (items.length > length) {
            items = Arrays.copyOf(items, length);
        }
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }


    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String delimiter = ", ";

        result.append("{ ");
        for (int i = 0; i < length; i++) {
            result.append(items[i]);
            result.append(delimiter);
        }
        result.setLength(result.length() - delimiter.length());
        result.append(" }");

        return result.toString();
    }
}