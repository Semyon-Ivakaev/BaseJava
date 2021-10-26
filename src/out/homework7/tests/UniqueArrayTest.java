package out.homework7.tests;

import org.junit.jupiter.api.Test;
import out.homework7.UniqueArray;

import static org.junit.jupiter.api.Assertions.*;

class UniqueArrayTest {
    UniqueArray array = new UniqueArray();

    @org.junit.jupiter.api.Test
    void size() {
        array.add("Some String1");
        array.add("Some String2");
        assertEquals(2, array.size());
    }

    @org.junit.jupiter.api.Test
    void add() {
        array.add("Some String1");
        array.add("Some String2");
        array.add("Some String3");
        assertEquals(3, array.size());
    }

    @Test
    void addWithException() {
        String str = "I want Exception!";
        try {
            array.add(str);
            array.add(str);
            fail("Введенный элемент уже добавлен в список.");
        } catch (Exception e) {

        }
    }

    @org.junit.jupiter.api.Test
    void get() {
        String str = "String";
        array.add(str);
        assertEquals(str, array.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Integer number = 999;
        array.add(number);
        array.remove(0);
        assertEquals(0, array.size());
    }

    @org.junit.jupiter.api.Test
    void put() {
        String strOne = "One";
        String strTwo = "Two";
        String strThree = "Three";
        array.add(strOne);
        array.add(strTwo);
        array.put(strThree, 0);
        assertEquals(strThree, array.get(0));
    }
}