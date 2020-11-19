package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StackTest {
    private Stack stack;

    @Before
    public void setUp(){
        stack = new Stack();
        stack.push("Toyota");
        stack.push("AE86");
        stack.push("Sprinter");
        stack.push(29);
    }

    @Test
    public void testPeek() {
        assertEquals(stack.peek(), 29);
    }

    @Test
    public void testPop1() {
        assertEquals(stack.pop(), 29);
    }

    @Test
    public void testPop2() {
        stack.pop();
        stack.pop();
        assertEquals(stack.pop(), "AE86");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPop3(){
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
