import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
@Invariant({ "data >= 0", "data <= Integer.MAX_VALUE", "(data % 1) == 0" })
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Natural))
			return false;
		Natural n = (Natural) o;
		return data == n.data;
	}

	public int compareTo(Natural n) {
		return Integer.compare(data, n.data);
	}

	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data);
	}

	// Add contracts to all following methods.

	@Requires("d >= 0")
	@Ensures("d == data")
	public Natural(int d) {
		data = d;
	}

	@Requires("data < Integer.MAX_VALUE")
	@Ensures("old(data) + 1 == data")
	public void increment() {
		data++;
	}

	@Requires("data > 0")
	@Ensures("old(data) - 1 == data")
	public void decrement() {
		data--;
	}

	@Requires("n.data < Integer.MAX_VALUE")
	@Ensures("addition(n,old(data))")
	public void add(Natural n) {
		data += n.data;
	}

	@Requires("n.data < Integer.MAX_VALUE")
	@Ensures("subtraction(n,old(data))")
	public void subtract(Natural n) {
		data -= n.data;
	}

	@Requires("n.data != 0 && n.data <= Integer.MAX_VALUE")
	@Ensures("multiplication(n,old(data))")
	public void multiply(Natural n) {
		data *= n.data;
	}

	@Requires("n.data < Integer.MAX_VALUE")
	@Ensures("division(n,old(data)) && result(old(data), n.data)")
	public void divide(Natural n) {
		data /= n.data;
	}

	/**
	 * 
	 * IMPLEMENTED ADDITIONAL METHODS
	 */
	private boolean addition(Natural natural, int newData) {
		int result = 0;
		result = result + newData;
		result = result + natural.data;
		return data == result;
	}

	private boolean subtraction(Natural natural, int newData) {
		int result = 0;
		result = result + newData;
		result = result - natural.data;
		return data == result;
	}

	private boolean multiplication(Natural natural, int newData) {
		int result = 1;
		result = result * newData;
		result = result *  natural.data;
		return data == result;
	}

	private boolean division(Natural natural, int newData) {
		return data == newData / natural.data;
	}
	
	private boolean result(int number1, int number2) {
		return number1 % number2 == 0;
	}

}
