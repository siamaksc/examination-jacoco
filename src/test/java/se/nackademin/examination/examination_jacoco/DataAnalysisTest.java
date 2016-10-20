package se.nackademin.examination.examination_jacoco;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.Random;

import org.junit.Test;

public class DataAnalysisTest {
	Random ran = new Random();
		

	@Test
	public void test1() {
		String name1   = UUID.randomUUID().toString().substring(0, 7);
		String name2   = UUID.randomUUID().toString().substring(0, 4);
		String firstName1 = UUID.randomUUID().toString().substring(0, 6);
		String lastName1  = UUID.randomUUID().toString().substring(0, 6);
		String firstName2 = UUID.randomUUID().toString().substring(0, 4);
		String lastName2  = UUID.randomUUID().toString().substring(0, 4);
		Random ran = new Random();
		String ageYoung = Integer.toString(ran.nextInt(30));
		String ageOld   = Integer.toString(ran.nextInt(30)+30);
		
		DataAnalysis dataAnalysis = new DataAnalysis();
		ArrayList<String> values = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		values.addAll(Arrays.asList(name2, firstName2, lastName1, "M", ageYoung, name1));
		result.add(dataAnalysis.buildFinalString(values));
		//String result1 = dataAnalysis.buildFinalString(values);
		assertTrue("The result should contain 'The first name is smaller or equals in size to the last name and the participant is 30 or younger' ",
				result.get(0).contains("The first name is smaller or equals in size to the last name and the participant is 30 or younger"));
		values.clear();
		
		values.addAll(Arrays.asList(name2, firstName1, lastName2, "M", "31", name1));
		result.add(dataAnalysis.buildFinalString(values));
		assertTrue("The result should contain 'The first name is greater or equals in size to the last name and the participant older than 30' ",
				result.get(1).contains("The first name is greater or equals in size to the last name and the participant older than 30"));
		values.clear();
		
		values.addAll(Arrays.asList(name1, firstName2, lastName1, "M", ageOld, name2));
		result.add(dataAnalysis.buildFinalString(values));
		assertTrue("The result should contain 'The name of the homecity is small and the participant is 30 or older' ",
				result.get(2).contains("The name of the homecity is small and the participant is 30 or older"));
		values.clear();
		
		values.addAll(Arrays.asList(name2, firstName1, lastName2, "M", ageYoung, name2));
		result.add(dataAnalysis.buildFinalString(values));
		assertTrue("The result should contain 'The name of the homecity is small and the participant is younger than 30' ",
				result.get(3).contains("The name of the homecity is small and the participant is younger than 30"));
		values.clear();
		
		values.addAll(Arrays.asList(name1, firstName1, lastName1, "M", ageOld, name1));
		result.add(dataAnalysis.buildFinalString(values));
		assertTrue("The result should contain 'The name of the homecity is big and the participant is 30 or older' ",
				result.get(4).contains("The name of the homecity is big and the participant is 30 or older"));
		values.clear();
		
		values.addAll(Arrays.asList(name1, firstName2, lastName2, "M", ageYoung, name1));
		result.add(dataAnalysis.buildFinalString(values));
		assertTrue("The result should contain 'The name of the homecity is big and the participant is younger than 30' ",
				result.get(5).contains("The name of the homecity is big and the participant is younger than 30"));
	}
}
