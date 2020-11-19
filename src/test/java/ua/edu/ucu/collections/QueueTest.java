package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class QueueTest {
    private Queue queue;
    
    @Before
    public void setUp(){
        queue = new Queue();
        queue.enqueue("Toyota");
        queue.enqueue("AE86");
        queue.enqueue("Sprinter");
        queue.enqueue(29);
    }

    @Test
    public void testPeek() {
        assertEquals(queue.peek(), "Toyota");
    }

    @Test
    public void testDequeue1() {
        assertEquals(queue.dequeue(), "Toyota");
    }

    @Test
    public void testDequeue2() {
        queue.dequeue();
        queue.dequeue();
        assertEquals(queue.dequeue(), "Sprinter");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeue3(){
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
