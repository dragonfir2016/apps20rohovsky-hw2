package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList emptyLst;
    private Object[] empty;
    private ImmutableLinkedList oneElLst;
    private Object[] oneEl;
    private ImmutableLinkedList commonLst;
    private Object[] common;

    @Before
    public void setUp() throws Exception {
        empty = new Object[0];
        emptyLst = new ImmutableLinkedList();
        ImmutableLinkedList emptyLst2 = new ImmutableLinkedList(new Object[]{});
        oneEl = new Object[]{"Supra"};
        oneElLst = new ImmutableLinkedList(oneEl);
        common = new Object[]{1, "Tea", 12, "Cake"};
        commonLst = new ImmutableLinkedList(common);
    }

    @Test
    public void testAddOneEl() {
        ImmutableLinkedList actual = emptyLst.add("ss");
        assertArrayEquals(actual.toArray(), new Object[]{"ss"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testAddOneElId() {
        ImmutableLinkedList actual = oneElLst.add(1, "Turbo");
        assertArrayEquals(actual.toArray(), new Object[]{"Supra", "Turbo"});
        assertArrayEquals(oneElLst.toArray(), oneEl);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOneElBadId() {
        ImmutableLinkedList actual = commonLst.add(10, "SS");
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList actual = commonLst.addAll(new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", 12, "Cake", "Toyota", "AE86"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdStart() {
        ImmutableLinkedList actual = commonLst.addAll(0, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{"Toyota", "AE86", 1, "Tea", 12, "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdMid() {
        ImmutableLinkedList actual = commonLst.addAll(1, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Toyota", "AE86", "Tea", 12, "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdEnd() {
        ImmutableLinkedList actual = commonLst.addAll(3, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", 12, "Toyota", "AE86", "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllBadId() {
        ImmutableLinkedList actual = emptyLst.addAll(1, new Object[]{"Toyota", "AE86"});
    }

    @Test
    public void testGet() {
        Object actual = commonLst.get(1);
        assertEquals(actual, "Tea");
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCommonBadId() {
        Object actual = commonLst.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyBadId() {
        Object actual = emptyLst.get(0);
    }


    @Test
    public void testRemove() {
        ImmutableLinkedList actual = commonLst.remove(2);
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testRemoveOneEl() {
        ImmutableLinkedList actual = oneElLst.remove(0);
        assertArrayEquals(actual.toArray(), new Object[]{});
        assertArrayEquals(oneElLst.toArray(), oneEl);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() {
        ImmutableLinkedList actual = emptyLst.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveBadId() {
        ImmutableLinkedList actual = commonLst.remove(-1);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList actual = commonLst.set(1, "Cake");
        assertArrayEquals(actual.toArray(), new Object[]{1, "Cake", 12, "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testSetOneEl() {
        ImmutableLinkedList actual = oneElLst.set(0, "Jojo");
        assertArrayEquals(actual.toArray(), new Object[]{"Jojo"});
        assertArrayEquals(oneElLst.toArray(), oneEl);
    }

    @Test
    public void testSetEmpty() {
        ImmutableLinkedList actual = emptyLst.set(0, "Jojo");
        assertArrayEquals(actual.toArray(), new Object[]{"Jojo"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetBadId() {
        ImmutableLinkedList actual = commonLst.set(5, "Jojo");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyBadId() {
        ImmutableLinkedList actual = emptyLst.set(-1, "Jojo");
    }

    @Test
    public void testIndexOf() {
        int actual = commonLst.indexOf("Tea");
        assertEquals(actual, 1);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testIndexOfBad() {
        int actual = commonLst.indexOf("Tear");
        assertEquals(actual, -1);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testIndexOfEmpty() {
        int actual = emptyLst.indexOf("Tear");
        assertEquals(actual, -1);
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testSize() {
        int actual = commonLst.size();
        assertEquals(actual, 4);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testSizeEmpty() {
        int actual = emptyLst.size();
        assertEquals(actual, 0);
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList actual = commonLst.clear();
        assertArrayEquals(actual.toArray(), new Object[]{});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testClearEmpty() {
        ImmutableLinkedList actual = emptyLst.clear();
        assertArrayEquals(actual.toArray(), new Object[]{});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testIsEmptyNotEmpty() {
        boolean actual = commonLst.isEmpty();
        assertFalse(actual);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testIsEmptyEmpty() {
        boolean actual = emptyLst.isEmpty();
        assertTrue(actual);
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testToString() {
        String actual = commonLst.toString();
        assertEquals(actual, "1, Tea, 12, Cake");
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testToStringEmpty() {
        String actual = emptyLst.toString();
        assertEquals(actual, "");
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testToArray() {
        Object[] actual = commonLst.toArray();
        assertArrayEquals(actual, common);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testToArrayEmpty() {
        Object[] actual = emptyLst.toArray();
        assertArrayEquals(actual, empty);
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList actual = commonLst.addFirst("SS");
        assertArrayEquals(actual.toArray(), new Object[]{"SS", 1, "Tea", 12, "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddFirstEmpty() {
        ImmutableLinkedList actual = emptyLst.addFirst("SS");
        assertArrayEquals(actual.toArray(), new Object[]{"SS"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList actual = commonLst.addLast("SS");
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", 12, "Cake", "SS"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddLastEmpty() {
        ImmutableLinkedList actual = emptyLst.addLast("SS");
        assertArrayEquals(actual.toArray(), new Object[]{"SS"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testGetFirst() {
        Object actual = commonLst.getFirst();
        assertEquals(actual, 1);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstEmpty() {
        Object actual = emptyLst.getFirst();
    }

    @Test
    public void testGetLast() {
        Object actual = commonLst.getLast();
        assertEquals(actual, "Cake");
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastEmpty() {
        Object actual = emptyLst.getFirst();
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList actual = commonLst.removeFirst();
        assertArrayEquals(actual.toArray(), new Object[]{"Tea", 12, "Cake"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstEmpty() {
        ImmutableLinkedList actual = emptyLst.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList actual = commonLst.removeLast();
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastEmpty() {
        ImmutableLinkedList actual = emptyLst.removeLast();
    }
}