package ru.academits.oop.february2019.veselova.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int length;

    public int getSize() {
        return length;
    }

    public T getFirstItem() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return head.getData();
    }

    public T getByIndex(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Out of the list of border.");
        }
        return getItem(index).getData();
    }

    public T setByIndex(T newValue, int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Out of the list of border.");
        }

        ListItem<T> item = getItem(index);
        T previousValue = item.getData();
        item.setData(newValue);

        return previousValue;
    }

    public T removeByIndex(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Out of the list of border.");
        }
        if (index == 0) {
            return removeFirstItem();
        }

        ListItem<T> prevItem = getItem(index - 1);
        T valueOfDeleted = prevItem.getNext().getData();
        prevItem.setNext(prevItem.getNext().getNext());
        length--;

        return valueOfDeleted;
    }

    public void addFirstItem(T newValue) {
        ListItem<T> newItem = new ListItem<>(newValue);
        newItem.setNext(head);
        head = newItem;
        length++;
    }

    public void insertByIndex(T newValue, int index) {
        if (index > getSize() || index < 0) {
            throw new IndexOutOfBoundsException("Out of the list of border.");
        }
        if (index == 0) {
            addFirstItem(newValue);
            return;
        }

        ListItem<T> newItem = new ListItem<>(newValue);
        ListItem<T> prevItem = getItem(index - 1);
        newItem.setNext(prevItem.getNext());
        prevItem.setNext(newItem);
        length++;
    }

    public boolean removeByValue(T value) {
        if (Objects.equals(head.getData(), value)) {
            removeFirstItem();
            return true;
        }
        ListItem<T> item = head;

        while (item.getNext() != null) {
            if (Objects.equals(item.getNext().getData(), value)) {
                item.setNext(item.getNext().getNext());
                length--;
                return true;
            }
            item = item.getNext();
        }
        return false;
    }

    public T removeFirstItem() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }

        T firstValue = head.getData();
        head = head.getNext();
        length--;
        return firstValue;
    }

    public void reverse() {
        if (head == null) {
            return;
        }

        ListItem<T> item = head;
        ListItem<T> nextItem = head.getNext();

        item.setNext(null);
        for (int i = 0; i < length - 2; ++i) {
            ListItem<T> tmp = nextItem.getNext();
            nextItem.setNext(item);
            item = nextItem;
            nextItem = tmp;
        }
        head = nextItem;
        head.setNext(item);
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        if (isEmpty()) {
            return copy;
        }

        copy.head = new ListItem<>(head.getData());

        ListItem<T> currentItem = head.getNext();
        ListItem<T> currentCopyItem = copy.head;

        while (currentItem != null) {
            currentCopyItem.setNext(new ListItem<>(currentItem.getData()));

            currentItem = currentItem.getNext();
            currentCopyItem = currentCopyItem.getNext();
        }

        copy.length = length;
        return copy;
    }

    private boolean isEmpty() {
        return getSize() == 0;
    }

    private boolean isOutOfBounds(int index) {
        return index >= getSize() || index < 0;
    }

    private ListItem<T> getItem(int index) {
        ListItem<T> item = head;
        for (int i = 0; i < index; i++) {
            item = item.getNext();
        }
        return item;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }

        StringBuilder result = new StringBuilder();
        result.append("[ ");

        ListItem<T> item = head;

        while (item != null) {
            result.append(item.getData());
            result.append(", ");

            item = item.getNext();
        }
        result.setLength(result.length() - 2);
        result.append(" ]");

        return result.toString();
    }
}