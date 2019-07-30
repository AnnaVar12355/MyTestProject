package annatest.memory;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemoryTest {

	@Test
	public void test() {
		Memory memory = new Memory(100);
		
		assertEquals(100, memory.length);
		
		assertEquals(0, memory.read(0));
		int[] expectedArray = new int[3];
		int[] read = memory.read(0, 3);
		assertArrayEquals(expectedArray,read);
		
		memory.write(10, 4);
		assertEquals(4, memory.read(10));
		
		int array[] = {10,9,8,7};

		memory.write(array, 10);
		
		assertArrayEquals(array, memory.read(10, 4));
	}

}
