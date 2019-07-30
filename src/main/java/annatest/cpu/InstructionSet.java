package annatest.cpu;

public class InstructionSet {

	public static Instruction nop = new Instruction() {

		public void execute(Cpu cpu) {
			cpu.load();
		}

	};
	public static Instruction readFromMemory = new Instruction() {

		public void execute(Cpu cpu) {
			cpu.load();
			int memoryIndex = cpu.acc;
			cpu.acc = cpu.memory.read(memoryIndex);
		}
	};

	public static Instruction writeIntoMemory = new Instruction() {

		public void execute(Cpu cpu) {
			int value = cpu.acc;
			cpu.load();
			int memoryIndex = cpu.acc;
			cpu.memory.write(memoryIndex, value);
		}
	};

	public static Instruction addFromMtoAcc = new Instruction() {
		public void execute(Cpu cpu) {
			int value = cpu.acc;	//save value from accumulator
			cpu.load();	// get 
			int memoryIndex = cpu.acc;
			cpu.acc = value + cpu.memory.read(memoryIndex);

		}

	};
}
