import org.example.BMIberekening;
import org.example.BMIgrens;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

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
        assertTrue(gezondBMI(20.0, 30, "","Westen")); // Gezond
        assertFalse(gezondBMI(30, 30, "","Westen")); // Overgewicht
        assertFalse(gezondBMI(10, 30, "","Westen")); // Ondergewicht
        assertFalse(gezondBMI(0, 30, "","Westen")); // Ongeldige gegevens
    }
    @Test
    public void equivalenceTest() {
        BMIberekening kind1 = new BMIberekening(4,24,1.20,"man",44,"Westen");
        assertTrue(kind1.gezondBMI());
        BMIberekening kind2 = new BMIberekening(7,28,1.20,"vrouw",44,"Westen");
        assertFalse(kind2.gezondBMI());
        BMIberekening kind3 = new BMIberekening(9,28,1.20,"man",44,"Westen");
        assertFalse(kind3.gezondBMI());

        BMIberekening volwassene1 = new BMIberekening(19,65,1.70,"vrouw",63,"Westen");
        assertTrue(volwassene1.gezondBMI());
        BMIberekening volwassene2 = new BMIberekening(43,65,1.70,"vrouw",63,"Westen");
        assertTrue(volwassene1.gezondBMI());
        BMIberekening volwassene3 = new BMIberekening(63,65,1.70,"vrouw",63,"Westen");
        assertTrue(volwassene3.gezondBMI());


        BMIberekening oudere1 = new BMIberekening(70,70,1.70,"man",140,"Westen");
        assertTrue(oudere1.gezondBMI());
        BMIberekening oudere2 = new BMIberekening(88,70,1.70,"man",140,"Westen");
        assertTrue(oudere2.gezondBMI());
        BMIberekening oudere3 = new BMIberekening(94,70,1.70,"man",140,"Westen");
        assertTrue(oudere3.gezondBMI());
    }

    @Test
    public void pairwiseGezondTest() {
        // Gezond BMI = 16.666666666666668
        BMIberekening berekening1 = new BMIberekening(4,24,1.20,"man",44,"Westen");
        assertTrue(berekening1.gezondBMI());
        assertTrue(berekening1.gezondeOmtrek());
        assertTrue(berekening1.gezond());

        // Ongezond BMI = 40.81632653061225
        BMIberekening berekening2 = new BMIberekening(18,80,1.40,"vrouw",89,"Westen");
        assertFalse(berekening2.gezondBMI());
        assertFalse(berekening2.gezondeOmtrek());
        assertFalse(berekening2.gezond());

        // Ongezond BMI = 10.380622837370243
        BMIberekening berekening3 = new BMIberekening(19,30,1.70,"man",110,"Westen");
        assertFalse(berekening3.gezondBMI());
        assertFalse(berekening3.gezondeOmtrek());
        assertFalse(berekening3.gezond());

        // Gezond BMI = 22.49134948096886
        BMIberekening berekening4 = new BMIberekening(28,65,1.70,"vrouw",63,"Westen");
        assertTrue(berekening4.gezondBMI());
        assertTrue(berekening4.gezondeOmtrek());
        assertTrue(berekening4.gezond());

        // Gezond BMI = 22.49134948096886
        BMIberekening berekening5 = new BMIberekening(82,65,1.70,"man",140,"Westen");
        assertTrue(berekening5.gezondBMI());
        assertFalse(berekening5.gezondeOmtrek());
        assertFalse(berekening5.gezond());

        // Ongezond BMI = 6.920415224913495
        BMIberekening berekening6 = new BMIberekening(89,20,1.70,"vrouw",60,"Westen");
        assertFalse(berekening6.gezondBMI());
        assertTrue(berekening6.gezondeOmtrek());
        assertFalse(berekening6.gezond());
    }

}

