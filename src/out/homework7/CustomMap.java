package out.homework7;

public class CustomMap<K, V> {
    private Object[][] array = new Object[1][];
    private int size;

    public int size() {
        return size;
    }

    public void add(K key, V value) {
        int keyIndex = containsKey(key);
        if (keyIndex != -1) {
            array[keyIndex] = new Object[]{key, value};
        } else {
            size++;
            if (array.length < size) {
                Object[][] newArray = new Object[array.length + 1][];
                System.arraycopy(array, 0, newArray, 0, size - 1);
                array = newArray;
            }
            array[size - 1] = new Object[]{key, value};
        }
    }

    public Object get(K key) {
        for (int elementIndex = 0; elementIndex < array.length; elementIndex++) {
            if (array[elementIndex] != null && array[elementIndex][0].equals(key)) {
                return array[elementIndex][1];
            }
        }
        return null;
    }

    public void remove(K key) {
        int keyIndex = containsKey(key);
        if (keyIndex != - 1) {
            Object[][] newArray = new Object[array.length][];
            if (keyIndex > 0) {
                System.arraycopy(array, 0, newArray, 0, keyIndex);
            }
            System.arraycopy(array, keyIndex + 1, newArray, keyIndex, array.length - keyIndex - 1);
            array = newArray;
            size--;
        }
    }

    public int containsKey(Object key) {
        if (size > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null && array[i][0].equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
