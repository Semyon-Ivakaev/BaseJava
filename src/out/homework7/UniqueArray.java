package out.homework7;

import java.util.Arrays;

public class UniqueArray<T> {
    private Object[] array = new Object[10];
    private int size;

    public int size() {
        return size;
    }

    public void add(T newElement) {
        if (!contains(newElement, array)) {
            size++;
            if (array.length < size) {
                Object[] newArray = new Object[array.length + 5];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
            array[size - 1] = newElement;
        } else {
            throw new UniqueException("Введенный элемент уже добавлен в список.");
        }
    }

    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void remove(int index) {
        checkIndex(index);
        Object[] newArray = new Object[array.length];
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index - 1);
        }
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
        size--;
    }

    public void put(Object putElement, int index) {
        checkIndex(index);
        if (!contains(putElement, array)) {
            array[index] = putElement;
        }
    }

    public boolean contains(Object o, Object[] array) {
        for (Object el: array) {
            if (o.equals(el)) {
                return true;
            }
        }
        return false;
    }

    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(String.format("Index %d is greater then size %d", index, size - 1));
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index");
        }
    }
}
