import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TripleTest {

    @org.junit.Test
    @Test
    public void testTripleWithStrings() {
        Triple<String, String, String> triple = new Triple<>("Left", "Middle", "Right");
        assertEquals("Left", triple.getLeft());
        assertEquals("Middle", triple.getMiddle());
        assertEquals("Right", triple.getRight());

        triple.setLeft("NewLeft");
        triple.setMiddle("NewMiddle");
        triple.setRight("NewRight");

        assertEquals("NewLeft", triple.getLeft());
        assertEquals("NewMiddle", triple.getMiddle());
        assertEquals("NewRight", triple.getRight());

        assertEquals("NewLeft NewMiddle NewRight", triple.toString());
    }

    @Test
    public void testTripleWithDifferentTypes() {
        Triple<String, Integer, Double> triple = new Triple<>("Text", 123, 45.67);
        assertEquals("Text", triple.getLeft());
        assertEquals(123, triple.getMiddle());
        assertEquals(45.67, triple.getRight());

        triple.setLeft("NewText");
        triple.setMiddle(456);
        triple.setRight(89.01);

        assertEquals("NewText", triple.getLeft());
        assertEquals(456, triple.getMiddle());
        assertEquals(89.01, triple.getRight());

        assertEquals("NewText 456 89.01", triple.toString());
    }

    @Test
    public void testTripleWithBooleanAndChar() {
        Triple<Boolean, Character, Integer> triple = new Triple<>(true, 'A', 99);
        assertTrue(triple.getLeft());
        assertEquals('A', triple.getMiddle());
        assertEquals(99, triple.getRight());

        triple.setLeft(false);
        triple.setMiddle('B');
        triple.setRight(100);

        assertFalse(triple.getLeft());
        assertEquals('B', triple.getMiddle());
        assertEquals(100, triple.getRight());

        assertEquals("false B 100", triple.toString());
    }

    @Test
    public void testTripleWithNullValues() {
        Triple<String, Integer, Double> triple = new Triple<>(null, null, null);
        assertNull(triple.getLeft());
        assertNull(triple.getMiddle());
        assertNull(triple.getRight());

        triple.setLeft("NonNull");
        triple.setMiddle(789);
        triple.setRight(12.34);

        assertEquals("NonNull", triple.getLeft());
        assertEquals(789, triple.getMiddle());
        assertEquals(12.34, triple.getRight());

        assertEquals("NonNull 789 12.34", triple.toString());
    }
}

