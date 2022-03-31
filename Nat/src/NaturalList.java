import java.util.ArrayList;
import java.util.Collections;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@ContractImport("java.util.ArrayList")

//Add an invariant here.
@Invariant({ "numbers != null", "!(containsNull(numbers))", }) // numbers array list must not be null
public class NaturalList {
	private ArrayList<Natural> numbers;

	// No contracts required for the following methods.
	public NaturalList(NaturalList o) {
		numbers = new ArrayList<Natural>();
		for (Natural n : o.numbers)
			numbers.add(new Natural(n));
	}

	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof NaturalList))
			return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	// Add contracts to all following methods.

	@Requires("n != null && numbers.size() < Integer.MAX_VALUE")
	@Ensures({ "numbers.get(numbers.size() - 1).compareTo(n) == 0",
			"listEqualsSkippingOne(numbers,old(new ArrayList<>(numbers)))" })
	public void push(Natural n) {
		numbers.add(n);
	}

	@Requires("!isEmpty() && i < numbers.size()")
	@Ensures({ "this.equals(old (new NaturalList(this)))", "checkIndex(result,i)" })
	public Natural get(int i) {
		return numbers.get(i);
	}

	@Requires("n != null && i <= numbers.size()")
	@Ensures("n.equals(numbers.get(i)) && checkElements(i,old(new NaturalList(this)))")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}

	@Requires("!isEmpty()")
	@Ensures("isSortedOrder() && sameSize(old(new NaturalList(this)))")
	public void sort() {
		Collections.sort(numbers);
	}

	@Requires("n != null")
	@Ensures("numbers.size() == old(numbers).size() && numbers.equals(old(numbers))")
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}

	/**
	 * IMPLEMENTED ADDITIONAL METHODS
	 */
	private boolean checkIndex(Natural natural, int i) {
		return natural.equals(numbers.get(i));
	}

	private boolean containsNull(ArrayList<Natural> numbers) {
		for (Natural natural : numbers) {
			if (natural == null)
				return true;
		}
		return false;
	}

	public boolean isEmpty() {
		return numbers.isEmpty();
	}

	private static boolean listEqualsSkippingOne(ArrayList<Natural> natural1, ArrayList<Natural> natural2) {
		ArrayList<Natural> askip = new ArrayList<Natural>(natural1);
		askip.remove(askip.size() - 1);
		return askip.equals(natural2);
	}

	private boolean checkElements(int i, NaturalList naturalList) {
		ArrayList<Natural> listMissingElementAtGivenIndex = new ArrayList<Natural>(numbers);
		listMissingElementAtGivenIndex.remove(i);
		naturalList.numbers.remove(i);
		return listMissingElementAtGivenIndex.equals(naturalList.numbers);
	}

	private boolean isSortedOrder() {
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i).compareTo(numbers.get(i - 1)) == -1)
				return false;

		}
		return true;
	}

	private boolean sameSize(NaturalList naturalList) {
		return numbers.size() == naturalList.numbers.size();
	}

}
