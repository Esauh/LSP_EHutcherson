package org.howard.edu.lsp.finale;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.howard.edu.lsp.finale.MapUtilities;
import org.howard.edu.lsp.finale.NullMapException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MapUtilitiesTest {



	@Test
	@DisplayName("Tests when one or both maps NULL")
	void NullTest_THROWSEXCEPTION() throws NullMapException{
		HashMap<String, String> map1 = new HashMap<String, String>() {{
			put("Mary", "Ecastic");
			put("Bob", "Healthy");
			put("Chuck", "Fine");
			put("Felix", "Sick");
		}};
		
		
	
		//One Map is full of key/value pairs and another is null
		NullMapException thrown = assertThrows(NullMapException.class, () -> MapUtilities.commonKeyValuePairs(map1, null));
		assertTrue(thrown.getMessage().contains("One or both maps are null!"));
		
		
	
		//both maps passed in are null
		NullMapException tossed = assertThrows(NullMapException.class, () -> MapUtilities.commonKeyValuePairs(null, null));
		assertTrue(tossed.getMessage().contains("One or both maps are null!"));

	}


@Test
@DisplayName("Tests correct value is given")
void CorrectValue() throws NullMapException {
	
	HashMap<String, String> fullmap1 = new HashMap<String, String>() {{
		put("Alice", "Healthy");
		put("Mary", "Ecastic");
		put("Bob", "Healthy");
		put("Chuck", "Fine");
		put("Felix", "Sick");

	}};
	HashMap<String, String> fullmap2 = new HashMap<String, String>(){{
		put("Mary", "Ecastic");
		put("Felix", "Healthy");
		put("Ricardo", "Superb");
		put("Felix", "Sick");
		put("Bob", "Happy");
		

	}};
	
	HashMap<String, String> fullmap3 = new HashMap<String, String>() {{
		put("Alice", "Healthy");
		put("Mary", "Ecastic");
		put("Bob", "Healthy");
		put("Chuck", "Fine");
		put("Felix", "Sick");

	}};
	HashMap<String, String> fullmap4 = new HashMap<String, String>(){{
		put("Mary", "Jaden");
		put("Felix", "Esau");
		put("Ricardo", "Superb");
		put("Felix", "Bobby");
		put("Bob", "Happy");
		

	}};
	
	HashMap<String, String> valuediffmap1 = new HashMap<String, String>() {{
		put("1", "Healthy");
		put("2", "Ecastic");
		put("3", "Healthy");
		put("4", "Fine");
		put("5", "Sick");
		

	}};
	HashMap<String, String> valuediffmap2 = new HashMap<String, String>(){{
		put("1", "A");
		put("2", "B");
		put("3", "C");
		put("4", "D");
		put("5", "E");
		

	}};
	
	HashMap<String, String> keydiffmap1 = new HashMap<String, String>() {{
		put("Esau", "Healthy");
		put("Jaden", "Ecastic");
		put("Malachi", "Healthy");
		put("Ivory", "Fine");
		put("Richard", "Sick");
		

	}};
	HashMap<String, String> keydiffmap2 = new HashMap<String, String>(){{
		put("A", "Healthy");
		put("B", "Ecastic");
		put("C", "Healthy");
		put("D", "Fine");
		put("E", "Healthy");
		

	}};
	//Hash Maps have 2 key/value pairs in common "Mary:Ecastic" and "Felix:Sick" "Felix:Healthy should not count" 
	assertEquals(MapUtilities.commonKeyValuePairs(fullmap1, fullmap2), 2);
	//Neither hash maps contain any key value pairs should return 0
	assertEquals(MapUtilities.commonKeyValuePairs(fullmap3, fullmap4), 0);
	//maps when keys are all the same but values are different should be zero when method is ran of them
	assertEquals(MapUtilities.commonKeyValuePairs(valuediffmap1, valuediffmap2), 0);
	//maps when values are all the same but keys are different
	assertEquals(MapUtilities.commonKeyValuePairs(keydiffmap1, keydiffmap2), 0);


}


@Test
@DisplayName("Tests when one or both maps are empty")
void EmprtyMapReturnZero() throws NullMapException {
	HashMap<String, String> fullmap1 = new HashMap<String, String>() {{
		put("Alice", "Healthy");
		put("Mary", "Ecastic");
		put("Bob", "Healthy");
		put("Chuck", "Fine");
		put("Felix", "Sick");

	}};
	HashMap<String, String> emptymap = new HashMap<String, String>(){{
		

	}};
	

	
HashMap<String, String> emptymap2 = new HashMap<String, String>(){{
		

	}};
	
	//tests returning zero when one map is full and one is empty
	assertEquals(MapUtilities.commonKeyValuePairs(fullmap1, emptymap), 0);
	//tests when both maps are empty
	assertEquals(MapUtilities.commonKeyValuePairs(emptymap2, emptymap), 0);

}
}


