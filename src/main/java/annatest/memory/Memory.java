package annatest.memory;

public class Memory {

	public final int length;
	private final int[] data;

	public Memory(int length) {
		this.length = length;
		data = new int[this.length];
	}

	/**
	 * Return element from data at position index
	 * 
	 * @param index
	 * @return
	 */
	public int read(int index) {
		return data[index];
	}

	/**
	 * Return sub-array from data from index and with size bytes
	 * 
	 * @param index
	 * @param bytes
	 * @return
	 */
	public int[] read(int index, int bytes) {
       int[]array = new int[bytes];
       for(int i=0; i<bytes; i++) {
    	   array[i] = data[index+i];
       }
       return array;
	}

	/**
	 * Writes value into position index
	 * 
	 * @param index
	 * @param value
	 */
	public void write(int index, int value) {
      data[index] = value;
	}

	/**
	 * Copy array into data form position offset
	 * 
	 * @param array
	 * @param offset
	 */
	public void write(int[] array, int offset) {
       for(int i=0; i<array.length; i++) {
    	   data[offset+i] = array[i];
       }
	}

}
