import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class JUnitTester {
	static File f;
	
	@BeforeAll
	static void setUpBefore() throws IOException {
		f = new File("Erik's test file");
		FileWriter ike = new FileWriter(f);
		ike.write("this is erik's new test file");
		ike.close();
		
	}
	
//	@AfterAll
//	static void shutDownAfter() throws IOException {
//		f.delete();
//	}
	
	@Test
	static void testBlob() throws IOException {
		
		Blob b = new Blob("Erik's test file");
		
		String temp = "";
		File test = new File(".\\objects\\"+b.getSha1FileName());
		assertTrue(test.exists());
		
		BufferedReader mike = new BufferedReader(new FileReader(".\\objects\\"+b.getSha1FileName()));
		while (mike.ready())
			temp += (char)mike.read();
		mike.close();
		
		System.out.print(temp);
		assertTrue(!temp.equals("this is erik's new test file"));
		
	}
	
	@Test
	static void testIndex() throws IOException {
		FileWriter ike = new FileWriter(f);
		Index i = new Index();
		i.init();
		
		File testIndex = new File("index");
		assertTrue(testIndex.exists());
		
		File testObject = new File(".\\object\\");
		assertTrue(testObject.exists());
		
		i.add("something");
		File testBlob = new File(".\\object\\94e66df8cd09d410c62d9e0dc59d3a884e458e05");
		assertTrue(testBlob.exists());
		i.add("bar.txt");
		testBlob = new File(".\\object\\78c9a53e2f28b543ea62c8266acfdf36d5c63e61");
		assertTrue(testBlob.exists());
		i.remove("bar.txt");
		assertTrue(!testBlob.exists());
	}
	
	@Test
	void test() throws IOException {
		testBlob();
		testIndex();
//		fail("Not yet implemented");
	}
	
}
