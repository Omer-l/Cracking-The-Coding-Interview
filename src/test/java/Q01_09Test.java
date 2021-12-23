import org.junit.Test;
import static org.junit.Assert.*;

public class Q01_09Test {

    @Test
    public void testIsRotation() {
        Q01_09 q01_09 = new Q01_09("waterbottle", "erbottlewat");
        assertTrue(q01_09.isRotation());
    }
}