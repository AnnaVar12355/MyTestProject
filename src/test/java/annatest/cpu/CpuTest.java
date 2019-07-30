package annatest.cpu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import annatest.memory.Memory;

public class CpuTest {

	public class MyCpu extends Cpu {

		public MyCpu(Memory memory, Map<Integer, Instruction> instructionSet) {
			super(memory, instructionSet);
			ip = 0;
		}

		@Override
		public void load() {
			acc = memory.read(ip);
			ip++;

		}

		@Override
		public void fetch() {
			ci = memory.read(ip);
			ip++;

		}

		@Override
		public void decode() {
			instruction = instructionSet.get(ci);

		}

		@Override
		public void execute() {
			instruction.execute(this);

		}

	}

	@Test
	public void test() {

		Memory mem = new Memory(100);

		Map<Integer, Instruction> myInstructionSet = new HashMap<Integer, Instruction>();
		myInstructionSet.put(0, InstructionSet.nop);
		myInstructionSet.put(1, InstructionSet.readFromMemory);
		myInstructionSet.put(2, InstructionSet.writeIntoMemory);
		myInstructionSet.put(3, InstructionSet.addFromMtoAcc);
		int[] myCode = { 1, 10, 3, 11 };

		mem.write(myCode, 0);
		mem.write(10, 543);
		mem.write(11, 97);

		Cpu myCpu = new MyCpu(mem, myInstructionSet);

		for (int i = 0; i < 5; i++) {
			myCpu.fetch();
			myCpu.decode();
			myCpu.execute();
		}
	}

}
