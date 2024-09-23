import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyUnimprovedArrayListTest {

    private MyUnimprovedArrayList<String> list;

    // This method will run before each test
    @BeforeEach
    public void setup() {
        list = new MyUnimprovedArrayList<>();
    }

    @Test
    public void testAddElements() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals(3, list.size(), "Size should be 3 after adding 3 elements.");
        assertEquals("One", list.get(0), "First element should be 'One'.");
        assertEquals("Two", list.get(1), "Second element should be 'Two'.");
        assertEquals("Three", list.get(2), "Third element should be 'Three'.");
    }

    @Test
    public void testGetWithValidIndex() {
        list.add("One");
        list.add("Two");

        assertEquals("One", list.get(0), "First element should be 'One'.");
        assertEquals("Two", list.get(1), "Second element should be 'Two'.");
    }

    @Test
    public void testGetWithInvalidIndex() {
        list.add("One");

        Exception exception = assertThrows(MyArrayIndexOutOfBounds.class, () -> {
            list.get(2);  // Out of bounds
        });

        assertEquals("Index 2 is out of bounds. Valid index range: 0 to 0", exception.getMessage());
    }

    @Test
    public void testRemoveElement() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Two", list.remove(1), "Removed element should be 'Two'.");
        assertEquals(2, list.size(), "Size should be 2 after removal.");
        assertEquals("One", list.get(0), "First element should still be 'One'.");
        assertEquals("Three", list.get(1), "Second element should now be 'Three'.");
    }

    @Test
    public void testRemoveWithInvalidIndex() {
        list.add("One");
        list.add("Two");

        Exception exception = assertThrows(MyArrayIndexOutOfBounds.class, () -> {
            list.remove(5);  // Out of bounds
        });

        assertEquals("Index 5 is out of bounds. Valid index range: 0 to 1", exception.getMessage());
    }

    @Test
    public void testResizeArray() {
        MyUnimprovedArrayList<Integer> intList = new MyUnimprovedArrayList<>();

        // Add more elements than the initial capacity (10)
        for (int i = 0; i < 20; i++) {
            intList.add(i);
        }

        assertEquals(20, intList.size(), "Size should be 20 after adding 20 elements.");
        assertEquals(19, intList.get(19), "The last element should be 19.");
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size(), "Initial size should be 0.");
        list.add("One");
        assertEquals(1, list.size(), "Size should be 1 after adding one element.");
        list.add("Two");
        assertEquals(2, list.size(), "Size should be 2 after adding two elements.");
        list.remove(0);
        assertEquals(1, list.size(), "Size should be 1 after removing one element.");
    }

    @Test
    public void testAddAndRemoveMultipleTimes() {
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Two", list.remove(1), "Removed element should be 'Two'.");
        assertEquals("One", list.get(0), "First element should still be 'One'.");
        assertEquals("Three", list.get(1), "Second element should now be 'Three'.");

        list.add("Four");
        list.add("Five");

        assertEquals(4, list.size(), "Size should be 4 after adding more elements.");
        assertEquals("Five", list.get(3), "The last element should be 'Five'.");
    }
}
