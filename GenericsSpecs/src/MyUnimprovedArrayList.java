import java.util.Arrays;

public class MyUnimprovedArrayList<E> {
    private Object[] elements;  // array to store elements
    private int size;  // current number of elements

    // Initial capacity
    private static final int INITIAL_CAPACITY = 10;

    // Constructor
    public MyUnimprovedArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Get an element at a specific index
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new MyArrayIndexOutOfBounds("Index " + index + " is out of bounds. Valid index range: 0 to " + (size - 1));
        }
        return (E) elements[index];
    }

    // Add an element to the list
    public void add(E obj) {
        if (size == elements.length) {
            resizeArray();  // resize if array is full
        }
        elements[size++] = obj;
    }

    // Remove an element at a specific index
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new MyArrayIndexOutOfBounds("Index " + index + " is out of bounds. Valid index range: 0 to " + (size - 1));
        }
        E removedElement = (E) elements[index];

        // Shift the elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;  // Clear the last element and reduce size
        return removedElement;
    }

    // Get the current size of the list
    public int size() {
        return size;
    }

    // Helper method to resize the array (double the size)
    private void resizeArray() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
