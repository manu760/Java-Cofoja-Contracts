import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.google.java.contract.PreconditionError;

class NaturalTest {

	// test constructor pre-condition error
	@Test // (expected = PreconditionError.class)
	public void testConstructorFalsifiesPreconditon() {
		PreconditionError preconditionError = assertThrows(PreconditionError.class, () -> {
			Natural natural = new Natural(-11);
		});

	}

	// test constructor post condition error
	@Test
	public void testConstructorPositiveValue() {
		assertDoesNotThrow(() -> {
			Natural natural = new Natural(10);
		});
	}

	// Increment Pre Condition Error
	@Test
	public void testIncrementPreCondition() {
		PreconditionError preConditionError = assertThrows(PreconditionError.class, () -> {
			int number = Integer.MAX_VALUE;
			Natural natural = new Natural(number);
			natural.increment();
		});

	}

	//Increment Post condition 
	@Test
	public void testIncrementPostCondition() {
		assertDoesNotThrow(() -> {
			Natural natural = new Natural(10);
			natural.increment();
		});
	}

	//decrement Pre condition
	@Test
	public void testDecrementPreConditionError() {
		PreconditionError preConditionError = assertThrows(PreconditionError.class, () -> {
			int number = -1;
			Natural natural = new Natural(number);
			natural.decrement();
		});
	}

	//decrement Post condition
	@Test
	public void testDecrementPostConditionError() {
		assertDoesNotThrow(() -> {
			Natural natural = new Natural(8);
			natural.decrement();
		});
	}

	//ADDITION
	
	@Test 
	public void testAdditionPreCondition() {
		int number1 = 1;
		int number2 = Integer.MAX_VALUE;
		PreconditionError preConditionError = assertThrows(PreconditionError.class,() -> {
			
			Natural natural1 = new Natural(number1);
			Natural natural2 = new Natural(number2);
			natural1.add(natural2);
		});
		
	}
	
	@Test
	public void testAdditionPostCondition() {
		int number1 = Integer.MAX_VALUE / 2;
		int number2 = 1;
		int addition = number1 + number2;

		Natural natural1 = new Natural(number1);
		Natural natural2 = new Natural(number2);
		natural1.add(natural2);
		
	}

	//SUBTRACTION
	@Test 
	public void testSubtractionPreCondition() {
		int number1 = Integer.MAX_VALUE;
		int number2 = Integer.MAX_VALUE;
		PreconditionError preConditionError = assertThrows(PreconditionError.class,() -> {
			
			Natural natural1 = new Natural(number1);
			Natural natural2 = new Natural(number2);
			natural1.subtract(natural2);
		});
		
		
	}
	
	@Test
	public void testSubstractionPostConditionError() {
		int number1 = Integer.MAX_VALUE;
		int number2 = Integer.MAX_VALUE - 1;
		int subtraction = number1 - number2;
		Natural natural1 = new Natural(number1);
		Natural natural2 = new Natural(number2);
		natural1.subtract(natural2);
		String expected = Integer.toString(subtraction);
		String actual = natural1.toString();
		assertEquals(expected,actual);

	}

	//MULTIPLICATION
	@Test 
	public void testMultiplicationPreCondition() {
		int number1 = Integer.MAX_VALUE;
		int number2 = 0;
		Natural natural1 = new Natural(number1);
		Natural natural2 = new Natural(number2);
		PreconditionError preConditionError = assertThrows(PreconditionError.class,() -> {
			natural1.multiply(natural2);
		});
		
		
	}
	
	@Test
	public void testMultiplicationPostConditionError() {
		int number1 = 2;
		int number2 = Integer.MAX_VALUE / 2;

		int multiplication = number1 * number2;
		Natural natural1 = new Natural(number1);
		Natural natural2 = new Natural(number2);
		natural1.multiply(natural2);
		String expected = Integer.toString(multiplication);
		String actual = natural1.toString();

		assertEquals(expected,actual);

	}
	
	//DIVIDE
	@Test 
	public void testDivisonPreCondition() {
		int number1 = Integer.MAX_VALUE;
		int number2 = 0;
		PreconditionError preConditionError = assertThrows(PreconditionError.class,() -> {
			Natural natural1 = new Natural(number1);
			Natural natural2 = new Natural(number2);
			natural1.divide(natural2);
		});
	}
	
	@Test 
	public void testDivisonPostConditionError() {
		int number1 = 10;
		int number2 = 2;
		int division = number1 / number2;
		Natural natural1 = new Natural(number1);
		Natural natural2 = new Natural(number2);
		natural1.divide(natural2);
		String expected = Integer.toString(division);
		String actual = natural1.toString();
		
		assertEquals(expected,actual);
	}

}
