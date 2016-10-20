package se.nackademin.examination.examination_jacoco;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;


public class GameTest {
	
	@Test
	public void testRun() {
		Game game = new Game();
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(Arrays.asList("Football", "Siamak", "Shoja", "M", "35", "Tehran"));
		game.run(arr);
	}
	
	@Test
	public void testGetGenderFromInputValues(){
		Game game = new Game();
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(Arrays.asList("Football", "Siamak", "Shoja", "M", "35", "Tehran"));
		assertEquals("The result should be M", 'M', game.getGenderFromInputValues(arr));
	}
	
	@Test
	public void testGetAgeFromInputValues(){
		Game game = new Game();
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(Arrays.asList("Football", "Siamak", "Shoja", "M", "35", "Tehran"));
		assertEquals("The result should be 35", 35, game.getAgeFromInputValues(arr));
	}

	@Test
	public void testCalculateOutPutBasedOnNames() {
		Game game = new Game();
		String firstName1 = UUID.randomUUID().toString().substring(0, 6);
		String lastName1 = UUID.randomUUID().toString().substring(0, 4);
		int i = game.calculateOutPutBasedOnNames(firstName1, lastName1);
		assertEquals("The result should be 1", i, 1);
		
		String firstName2 = UUID.randomUUID().toString().substring(0, 4);
		String lastName2 = UUID.randomUUID().toString().substring(0, 6);
		int j = game.calculateOutPutBasedOnNames(firstName2, lastName2);
		assertEquals("The result should be 0", j, 0);
		
		String firstName3 = UUID.randomUUID().toString().substring(0, 6);
		String lastName3 = UUID.randomUUID().toString().substring(0, 6);
		int z = game.calculateOutPutBasedOnNames(firstName3, lastName3);
		assertEquals("The result should be 2", z, 2);
	}
	
	@Test
	public void testCalculateOutPutBasedOnGender() {
		Game game = new Game();
		
		int i = game.calculateOutPutBasedOnGender('M');
		assertEquals("The result should be 0", i, 0);
		
		int j = game.calculateOutPutBasedOnGender('F');
		assertEquals("The result should be 1", j, 1);
		
		int z = game.calculateOutPutBasedOnGender('c');
		assertEquals("The result should be 2", z, 2);
	}
	
	@Test
	public void testCalculateOutPutBasedOnAge() {
		Game game = new Game();
		Random random = new Random();
		
		int i = game.calculateOutPutBasedOnAge(random.nextInt(26));
		assertEquals("The result should be 0 (age <=25)", i, 0);
		
		int j = game.calculateOutPutBasedOnAge(random.nextInt(26)+26);
		assertEquals("The result should be 1(age >25)", j, 1);
	}
	
	@Test
	public void testCalculateOutPutBasedOnHomeCity() {
		Game game = new Game();

		String[] arr = {"a","b","c","d","e","f","g","h","i","j"};
		for (int i = 0; i < 10; i++){
			int j = game.calculateOutPutBasedOnHomeCity(arr[i]);
			assertEquals("The result should be" +i, j, i);	
		}
		int z = 0;
		do {
			String city = UUID.randomUUID().toString().substring(0, 6);
			z = game.calculateOutPutBasedOnHomeCity(city);
			//System.out.println(city+"z: "+z);
		}while (z != 10);
		assertEquals("The result should be 10", z, 10);
	}
	
	@Test
	public void testBuildFinalString() {
		Game game = new Game();
		ResultFromInputs res = new ResultFromInputs();
		Conversor cc = new Conversor();
		game.buildFinalString("Siamak", "Shoja", res, cc);
	}
	
	
	
	
	

}
