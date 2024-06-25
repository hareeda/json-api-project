package karateclasses;


import com.intuit.karate.junit5.Karate;

public class KarateRunner {
	
	@Karate.Test
	Karate karateTest() {
		return Karate.run().relativeTo(getClass());
	}
}
