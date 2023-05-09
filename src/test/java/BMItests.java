import org.junit.jupiter.api.Test;

import static org.example.BMIberekening.berekenBMI;
import static org.example.BMIberekening.gezondBMI;
import static org.junit.jupiter.api.Assertions.*;

public class BMItests {
    @Test
    public void rekenTest() {
        assertTrue(Math.abs(22.4913 - berekenBMI(65,1.70)) < 1e-4); // Geldige berekening
        assertEquals(0.0,berekenBMI(-50.0,1.70)); // Ongeldige berekening
        assertEquals(0.0,berekenBMI(65,-5.0)); // Ongeldige berekening
    }

    @Test
    public void gezondTest() {
        assertTrue(gezondBMI(20.0, 30, "")); // Gezond
        assertFalse(gezondBMI(30, 30, "")); // Overgewicht
        assertFalse(gezondBMI(10, 30, "")); // Ondergewicht
        assertFalse(gezondBMI(0, 30, "")); // Ongeldige gegevens
    }

}

