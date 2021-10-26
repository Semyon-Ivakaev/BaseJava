package out.homework7.tests;

import org.junit.jupiter.api.Test;
import out.homework4.Client;
import out.homework7.CustomMap;

import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {
    CustomMap mapper = new CustomMap();

    @Test
    void get() {
        String testString = "Five";
        mapper.add(5, testString);
        assertEquals(testString, mapper.get(5));
    }

    @Test
    void getNull() {
        String testString = "Five";
        mapper.add(5, testString);
        assertNull(mapper.get(99));
    }

    @Test
    void add() {
        String testString = "TEST";
        mapper.add(99, testString);
        assertEquals(1, mapper.size());
    }

    @Test
    void remove() {
        mapper.add(11, false);
        mapper.remove(11);
        assertNull(mapper.get(11));
    }
}