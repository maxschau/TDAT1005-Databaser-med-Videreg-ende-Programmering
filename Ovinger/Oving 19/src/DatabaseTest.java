import static org.junit.Assert.*;

public class DatabaseTest {
    Bok instance;
    Bok instance2;
    Database d;

    @org.junit.Before
    public void setUp() throws Exception {
        instance = new Bok("1-04-241163-5", "Åndenes makt", "Anders Jacobsen");
        instance2 = new Bok("0-596-00123-1", "Gullet", "Guri Malla");
        d = new Database();
    }

    @org.junit.Test
    public void regNyBok() {
        boolean expResult = true;
        boolean result = d.regNyBok(instance);
        assertEquals(expResult,result);
    }

    @org.junit.Test
    public void regNyBok2() {
        boolean expResult = false;
        boolean result = d.regNyBok(instance2);
        assertEquals(expResult,result);
    }

    @org.junit.Test
    public void regNyttEksemplar() {
        int expResult = 2;
        int result = d.regNyttEksemplar("1-04-241163-5");
        assertEquals(expResult,result);
    }

    @org.junit.Test
    public void lånUtEksemplar() {
        boolean expResult = true;
        boolean result = d.lånUtEksemplar("0-201-50998-X", "Max", 1);
        assertEquals(expResult,result);
    }
    @org.junit.After
    public void tearDown() {

    }
}