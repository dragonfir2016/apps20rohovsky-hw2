package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList emptyLst;
    private Object[] empty;
    private ImmutableArrayList oneElLst;
    private Object[] oneEl;
    private ImmutableArrayList commonLst;
    private Object[] common;

    @Before
    public void setUp() throws Exception {
        empty = new Object[0];
        emptyLst = new ImmutableArrayList();
        oneEl = new Object[]{"Supra"};
        oneElLst = new ImmutableArrayList(oneEl);
        common = new Object[]{1, "Tea", 12};
        commonLst = new ImmutableArrayList(common);
    }

    @Test
    public void testAddOneEl() {
        ImmutableArrayList actual = emptyLst.add("ss");
        assertArrayEquals(actual.toArray(), new Object[]{"ss"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testAddOneElId() {
        ImmutableArrayList actual = oneElLst.add(1, "Turbo");
        assertArrayEquals(actual.toArray(), new Object[]{"Supra", "Turbo"});
        assertArrayEquals(oneElLst.toArray(), oneEl);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOneElBadId() {
        ImmutableArrayList actual = commonLst.add(10, "SS");
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList actual = commonLst.addAll(new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", 12, "Toyota", "AE86"});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdStart() {
        ImmutableArrayList actual = commonLst.addAll(0, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{"Toyota", "AE86", 1, "Tea", 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdMid() {
        ImmutableArrayList actual = commonLst.addAll(1, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Toyota", "AE86", "Tea", 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testAddAllIdEnd() {
        ImmutableArrayList actual = commonLst.addAll(2, new Object[]{"Toyota", "AE86"});
        assertArrayEquals(actual.toArray(), new Object[]{1, "Tea", "Toyota", "AE86", 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllBadId() {
        ImmutableArrayList actual = emptyLst.addAll(1, new Object[]{"Toyota", "AE86"});
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
        ImmutableArrayList actual = commonLst.remove(1);
        assertArrayEquals(actual.toArray(), new Object[]{1, 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() {
        ImmutableArrayList actual = emptyLst.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveBadId() {
        ImmutableArrayList actual = commonLst.remove(-1);
    }

    @Test
    public void testSet() {
        ImmutableArrayList actual = commonLst.set(1, "Cake");
        assertArrayEquals(actual.toArray(), new Object[]{1, "Cake", 12});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testSetEmpty() {
        ImmutableArrayList actual = emptyLst.set(0, "Jojo");
        assertArrayEquals(actual.toArray(), new Object[]{"Jojo"});
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetBadId() {
        ImmutableArrayList actual = commonLst.set(5, "Jojo");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyBadId() {
        ImmutableArrayList actual = emptyLst.set(-1, "Jojo");
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
        assertEquals(actual, 3);
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
        ImmutableArrayList actual = commonLst.clear();
        assertArrayEquals(actual.toArray(), new Object[]{});
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testClearEmpty() {
        ImmutableArrayList actual = emptyLst.clear();
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
        assertEquals(actual, "1, Tea, 12");
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testToStringEmpty() {
        String actual = emptyLst.toString();
        assertEquals(actual, "");
        assertArrayEquals(emptyLst.toArray(), empty);
    }

    @Test
    public void testToArray(){
        Object[] actual = commonLst.toArray();
        assertArrayEquals(actual, common);
        assertArrayEquals(commonLst.toArray(), common);
    }

    @Test
    public void testToArrayEmpty(){
        Object[] actual = emptyLst.toArray();
        assertArrayEquals(actual, empty);
        assertArrayEquals(emptyLst.toArray(), empty);
    }
}
