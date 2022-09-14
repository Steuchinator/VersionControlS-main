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
		if(!test.exists()) {
			fail("File not found in objects folder");
		}
		
		BufferedReader mike = new BufferedReader(new FileReader(".\\objects\\"+b.getSha1FileName()));
		while (mike.ready())
			temp += (char)mike.read();
		mike.close();
		
		System.out.print(temp);
		if (!temp.equals("this is erik's new test file")) {
			fail("File contents don't match");
		}
	}
	
	@Test
	static void testIndex() throws IOException {
		FileWriter ike = new FileWriter(f);
		Index i = new Index();
		i.init();
		
		File testIndexFileExists = new File("index");
		if(!testIndexFileExists.exists()) {
			fail("Index file not found");
		}
		
		File testObjectFolderExists = new File(".\\objects\\");
		if(!testObjectFolderExists.exists()) {
			fail("Object folder not found");
		}
		
		
	}
	
	@Test
	void test() throws IOException {
		testBlob();
//		fail("Not yet implemented");
	}
	
}
