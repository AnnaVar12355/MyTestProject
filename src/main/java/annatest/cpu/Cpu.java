package annatest.cpu;

import java.util.Map;

import annatest.memory.Memory;

public abstract class Cpu {
	protected Memory memory;
	protected Map<Integer, Instruction> instructionSet;
	
	public int ip;	// instruction pointer
	public int ci;	// current instruction
	public Instruction instruction; 
	public int acc;
	
	
	
	public Cpu(Memory memory, Map<Integer, Instruction> instructionSet) {
		this.memory = memory;
		this.instructionSet = instructionSet;
	}
	public abstract void load();
	public abstract void fetch();
	public abstract void decode();
	public abstract void execute();
	
	
	
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}

}
