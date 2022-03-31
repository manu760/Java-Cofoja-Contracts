import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.google.java.contract.PreconditionError;

class NaturalListTest {

	/**
	 * PUSH PRECONDITION AND POSTCONDITION TESTS
	 */
	@Test
	public void pushPreConditionTest() {
		Natural nat = null;
		NaturalList natList = new NaturalList();
		
		PreconditionError preconditionError = assertThrows(PreconditionError.class, () -> {
			natList.push(nat);
		});
	}
	
	@Test 
	public void pushPostconditionErrorTest() {
		Natural natural = new Natural(10);
		NaturalList naturalListl = new NaturalList();
			naturalListl.push(natural);
		
	}
	
	/**
	 * GET PRECONDITION AND POSTCONDITION TESTS
	 */
	@Test 
	public void getPreConditionErrorTest() {
		NaturalList naturalList = new NaturalList();
		
	 PreconditionError preconditionError = assertThrows(PreconditionError.class, () -> {
			naturalList.get(1);
		});

	}
	
	@Test 
	public void getPostConditionErrorTest() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(3);
		Natural natural3 = new Natural(5);
		NaturalList naturalList = new NaturalList();
		naturalList.push(natural1);
		naturalList.push(natural2);
		naturalList.push(natural3);
		naturalList.get(2);
	
	}
	
	/**
	 * SET PRECONDITION AND POSTCONDITION TESTS
	 */
	@Test 
	public void setPreConditionTest() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(3);
		Natural natural3 = new Natural(5);
		NaturalList naturalList = new NaturalList();
		naturalList.push(natural1);
		naturalList.push(natural2);
		naturalList.push(natural3);
		Natural naturalListTest = new Natural(4);
		
		PreconditionError preconditionError = assertThrows(PreconditionError.class, () -> {
			naturalList.set(5, naturalListTest);
		});
	}
	
	@Test 
	public void setPostConditionTest() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(3);
		Natural natural3 = new Natural(5);
		NaturalList naturalList = new NaturalList();
			naturalList.push(natural1);
			naturalList.push(natural2);
			naturalList.push(natural3);
			Natural testList = new Natural(4);
			naturalList.set(2, testList);
	}
	
	/**
	 * SORT PRECONDITION AND POSTCONDITION TESTS
	 */
	@Test 
	public void sortPreConditionTest() {
     NaturalList naturalList = new NaturalList();
		
		PreconditionError preconditionError = assertThrows(PreconditionError.class, () -> {
			naturalList.sort();
		});
	}
	@Test 
	public void sortPostConditionTest() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(10);
		Natural natural3 = new Natural(6);
		NaturalList naturalList = new NaturalList();
		naturalList.push(natural1);
		naturalList.push(natural2);
		naturalList.push(natural3);
		naturalList.sort();
		
	}
	
	/**
	 * SEARCH PRECONDITION AND POSTCONDITION TESTS
	 */
	@Test 
	public void searchPreConditionErrorTest() {
		PreconditionError preconditionError   = assertThrows(PreconditionError.class, () -> {
			NaturalList naturalList = new NaturalList();
			naturalList.search(null);
		});
	}
	
	@Test
	public void searchPostConditionErrorTest() {
		Natural natural1 = new Natural(1);
		Natural natural2 = new Natural(5);
		Natural natural3 = new Natural(6);
		Natural natural4 = new Natural(9);
		Natural natural5 = new Natural(1);
		NaturalList nList = new NaturalList();
		nList.push(natural1);
		nList.push(natural2);
		nList.push(natural3);
		nList.push(natural4);
		nList.push(natural5);
		nList.sort();
		nList.search(new Natural(6));
	}
}
