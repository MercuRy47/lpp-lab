import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackArrayTest {

    private StackArray stack;

    @BeforeEach
    public void setUp() {
        stack = new StackArray(5);
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        stack.push(5);
        stack.push(15);
        stack.push(25);

        assertEquals(25, stack.peek());
        assertEquals(25, stack.peek());
        assertEquals(25, stack.pop());
        assertEquals(15, stack.pop());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testSize() {
        stack.push(7);
        stack.push(14);

        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());

        stack.push(21);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Test
    public void testPeekEmptyStack() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.peek());
    }

    @Test
    public void testPushFullStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertThrows(ArrayStoreException.class, () -> stack.push(6));
    }

    @Test
    public void testShow() {
        stack.push(100);
        stack.push(200);
        stack.push(300);

        //String expectedOutput = "[100, 200, 300]";
        //assertEquals(expectedOutput, getStackContent());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(10);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.isFull());
    }

    @Test
    public void testPushPopMixed() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());

        stack.push(30);
        stack.push(40);

        assertEquals(40, stack.pop());
        stack.pop();
        assertEquals(10, stack.pop());

        assertTrue(stack.isEmpty());
    }

    private String getStackContent() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        stack.show();

        System.setOut(System.out);
        return outContent.toString().trim();
    }
}