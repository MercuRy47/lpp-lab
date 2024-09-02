import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackLinkTest {

    private StackLink stack;

    @BeforeEach
    public void setUp() {
        stack = new StackLink();
    }

    @Test
    public void testPush() {
        stack.push(10);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);

        Object popped = stack.pop();
        assertEquals(20, popped);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(10);
        stack.push(20);

        Object peeked = stack.peek();
        assertEquals(20, peeked);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPeekEmptyStack() {
        assertThrows(RuntimeException.class, () -> stack.peek());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push(10);
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
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
    public void testShow() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Redirect stdout to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        stack.show();
        assertEquals("[10, 20, 30]", outputStream.toString().trim());

        // Reset stdout
        System.setOut(System.out);
    }

    @Test
    public void testShowEmpty() {
        // Redirect stdout to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        stack.show();
        assertEquals("[]", outputStream.toString().trim());

        // Reset stdout
        System.setOut(System.out);
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
    public void testPushAndPeek() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(10, stack.peek());
    }

    @Test
    public void testPushAndSize() {
        assertEquals(0, stack.size());

        stack.push(10);
        assertEquals(1, stack.size());

        stack.push(20);
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testEmptyStackPopAndPeek() {
        assertThrows(RuntimeException.class, () -> stack.pop());
        assertThrows(RuntimeException.class, () -> stack.peek());
    }


}