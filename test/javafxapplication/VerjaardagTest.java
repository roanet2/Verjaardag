package javafxapplication;

import model.Verjaardag;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class VerjaardagTest {



    @Test
    public void testToString() {
        System.out.println("toString");
        Verjaardag verjaardag = new Verjaardag("roan", LocalDate.of(1998, 10, 22));
        String expResult = "22/10 roan 20";
        String result = verjaardag.toString();
        assertEquals(expResult,result);
    }

    @Test
    public void testGetVolgendeVerjaardag() {
        Verjaardag verjaardag = new Verjaardag("roan", LocalDate.of(1998, 10, 22));
        System.out.println("getVolgendeVerjaardag");
        LocalDate expResult = LocalDate.of(2019, 10, 22);
        LocalDate result = verjaardag.getVolgendeVerjaardag();
        assertEquals(expResult,result);
    }
}
