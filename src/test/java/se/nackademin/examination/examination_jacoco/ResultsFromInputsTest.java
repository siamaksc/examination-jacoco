package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultsFromInputsTest {
	ResultFromInputs resultsFromInputs = new ResultFromInputs();

	@Test
	public void testNameLengthGettersAndSettersMethods() {
		resultsFromInputs.setResultForNameLenght(10);
		assertEquals("The result should be 10", resultsFromInputs.getResultForNameLenght(), 10);
	}
	
	@Test
	public void testGenderGettersAndSettersMethods() {
		resultsFromInputs.setResultForGender('M');
		assertEquals("The result should be M", resultsFromInputs.getResultForGender(), 'M');
	}
	
	@Test
	public void testAgeGettersAndSettersMethods() {
		resultsFromInputs.setResultForAge(35);
		assertEquals("The result should be 35", resultsFromInputs.getResultForAge(), 35);
	}
	
	@Test
	public void testHomeCityGettersAndSettersMethods() {
		resultsFromInputs.setResultForHomeCity(10);
		assertEquals("The result should be 35", resultsFromInputs.getResultForHomeCity(), 10);
	}

}
