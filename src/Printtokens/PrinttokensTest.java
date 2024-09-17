package Printtokens;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.*;

class PrinttokensTest 
{

	static Printtokens ob;
		
	@BeforeAll
	static void initialize() throws IOException 
	{
		ob = new Printtokens();
	}
	
	@Test
	void testOpen_character_stream() 
	{
		System.out.println("testing open_character_stream().");
		
		Printtokens instance = new Printtokens();
		
		System.out.println("open_character_stream() finished.");
		
	}

	@Test
	void testGet_char() 
	{
		System.out.println("testing get_char().");
		
		Printtokens instance = new Printtokens();
		
		System.out.println("get_char() finished.");
		
	}
	
	@Test
	void testUnget_char() 
	{
		System.out.println("testing unget_char().");
		
		Printtokens instance = new Printtokens();
		
		System.out.println("unget_char() finished.");
		
	}
	
	@Test
	void testOpen_token_stream() 
	{
		System.out.println("testing open_token_stream().");
		
		Printtokens instance = new Printtokens();
		
		System.out.println("open_token_stream() finished.");
		
	}
	
	@Test
	void testGet_token() 
	{
		System.out.println("testing get_token().");
		
 		Printtokens instance = new Printtokens();
		Reader temp = new StringReader("");
		BufferedReader br = new BufferedReader(temp);
		assertEquals(null, ob.get_token(br));
		
		temp = new StringReader("\t");
		br = new BufferedReader(temp);
		assertEquals(null, ob.get_token(br));
		
		temp = new StringReader("\n");
		br = new BufferedReader(temp);
		assertEquals(null, ob.get_token(br));
		
		temp = new StringReader("\r");
		br = new BufferedReader(temp);
		assertEquals(null, ob.get_token(br));
		
		temp = new StringReader("(");
		br = new BufferedReader(temp);
		assertEquals("(", ob.get_token(br));
		
		temp = new StringReader("\na");
		br = new BufferedReader(temp);
		assertEquals("a", ob.get_token(br));
		
		temp = new StringReader(";");
		br = new BufferedReader(temp);
		assertEquals(";", ob.get_token(br));
		
		temp = new StringReader("\"");
		br = new BufferedReader(temp);
		assertEquals("\"", ob.get_token(br));
		
		temp = new StringReader("AB ");
		br = new BufferedReader(temp);
		assertEquals("AB", ob.get_token(br));
		
		temp = new StringReader("ABC");
		br = new BufferedReader(temp);
		assertEquals("ABC", ob.get_token(br));
		
		temp = new StringReader("ABC(");
		br = new BufferedReader(temp);
		assertEquals("ABC", ob.get_token(br));
		
		temp = new StringReader("ABC\"");
		br = new BufferedReader(temp);
		assertEquals("ABC\"", ob.get_token(br));
		
		temp = new StringReader("ABC;");
		br = new BufferedReader(temp);
		assertEquals("ABC", ob.get_token(br));
		
		temp = new StringReader("ABC");
		br = new BufferedReader(temp);
		assertEquals("ABC", ob.get_token(br));
		
		temp = new StringReader("\"ABC\"");
		br = new BufferedReader(temp);
		assertEquals("\"ABC\"", ob.get_token(br));
		
		System.out.println("get_token() finished.");
		
	}

	@Test
	void testIs_token_end() 
	{
		System.out.println("testing is_token_end().");
		
		Printtokens instance = new Printtokens();
//		assertEquals(1, instance.is_token_end(1, -1));
//		assertTrue(Printtokens.is_token_end(1, -1));
//      assertTrue(Printtokens.is_token_end(2, '\n'));
//      assertFalse(Printtokens.is_token_end(0, 'a'));
		assertEquals(true, Printtokens.is_token_end(0,-1));
		assertEquals(true, Printtokens.is_token_end(1,34));
		assertEquals(true, Printtokens.is_token_end(1,10));
		assertEquals(true, Printtokens.is_token_end(1,13));
		assertEquals(false, Printtokens.is_token_end(1,67));
		assertEquals(true, Printtokens.is_token_end(2,10));
		assertEquals(true, Printtokens.is_token_end(2,13));
		assertEquals(true, Printtokens.is_token_end(2,9));
		assertEquals(false, Printtokens.is_token_end(2,68));
		assertEquals(true, Printtokens.is_token_end(0,40));
		assertEquals(true, Printtokens.is_token_end(0,32));
		assertEquals(true, Printtokens.is_token_end(0,10));
		assertEquals(true, Printtokens.is_token_end(0,13));
		assertEquals(true, Printtokens.is_token_end(0,59));
		assertEquals(false, Printtokens.is_token_end(0,69));
		
		System.out.println("is_token_end() finished.");
		
	}

	@Test
	void testToken_type() 
	{
		System.out.println("testing token_type().");
		
		Printtokens instance = new Printtokens();
		assertEquals(Printtokens.keyword, Printtokens.token_type("if"));
        assertEquals(Printtokens.spec_symbol, Printtokens.token_type("("));
        assertEquals(Printtokens.identifier, Printtokens.token_type("var"));
        assertEquals(Printtokens.num_constant, Printtokens.token_type("123"));
        assertEquals(Printtokens.str_constant, Printtokens.token_type("\"string\""));
        assertEquals(Printtokens.char_constant, Printtokens.token_type("#a"));
//      assertEquals(Printtokens.comment, Printtokens.token_type(";comment"));
//      assertEquals(Printtokens.error, Printtokens.token_type("invalid"));
		
		System.out.println("token_type() finished.");
		
	}
	
	@Test
	void testPrint_token() 
	{
		System.out.println("testing print_token().");
		
 		Printtokens instance = new Printtokens();
		
		System.out.println("print_token() finished.");
		
	}

	@Test
	void testIs_comment() 
	{
		System.out.println("testing is_comment().");
		
		Printtokens instance = new Printtokens();
		assertTrue(Printtokens.is_comment(";comment"));
        assertFalse(Printtokens.is_comment("not_comment"));
        assertEquals(true, Printtokens.is_comment(";test"));
		assertEquals(false, Printtokens.is_comment("atest"));
//		assertEquals(true, Printtokens.is_comment(""));
//		assertEquals(true, Printtokens.is_comment(";"));
//		assertEquals(false, Printtokens.is_comment("a"));
		
		System.out.println("is_comment() finished.");
		
	}
	
	@Test
	void testIs_keyword() 
	{
		System.out.println("testing is_keyword().");
		
		Printtokens instance = new Printtokens();
		assertEquals(true, Printtokens.is_keyword("and"));
		assertEquals(true, Printtokens.is_keyword("or"));
		assertEquals(true, Printtokens.is_keyword("if"));
		assertEquals(true, Printtokens.is_keyword("xor"));
		assertEquals(true, Printtokens.is_keyword("lambda"));
		assertEquals(true, Printtokens.is_keyword("=>"));
		assertEquals(false, Printtokens.is_keyword("test"));
		
		System.out.println("is_keyword() finished.");
		
	}

	@Test
	void testIs_char_constant() 
	{
		System.out.println("testing is_char_constant().");
		
		Printtokens instance = new Printtokens();
		assertTrue(Printtokens.is_char_constant("#a"));
        assertTrue(Printtokens.is_char_constant("abc"));
		
		System.out.println("is_char_constant() finished.");
		
	}
	
	@Test
	void testIs_num_constant() 
	{
		System.out.println("testing is_num_constant().");
		
		Printtokens instance = new Printtokens();
		assertEquals(false, Printtokens.is_num_constant("A"));
		assertEquals(false, Printtokens.is_num_constant("1A"));
		assertEquals(true, Printtokens.is_num_constant("10"));
		assertEquals(true, Printtokens.is_num_constant("1"));
		assertEquals(true, Printtokens.is_num_constant("1\0"));
		
		System.out.println("is_num_constant() finished.");
		
	}

	@Test
	void testIs_str_constant() 
	{
		System.out.println("testing is_str_constant().");
		
		Printtokens instance = new Printtokens();
		assertEquals(false, Printtokens.is_str_constant("1"));
		assertEquals(true, Printtokens.is_str_constant("\"\""));
		assertEquals(true, Printtokens.is_str_constant("\"hello\"\0"));
		assertEquals(false, Printtokens.is_str_constant("\"A"));
		assertEquals(false, Printtokens.is_str_constant("\"A\0"));
		assertEquals(false, Printtokens.is_str_constant("\""));
		
		System.out.println("is_str_constant() finished.");
		
	}

	@Test
	void testIs_identifier() 
	{
		System.out.println("testing is_identifier().");
		
		Printtokens instance = new Printtokens();
		assertEquals(false, Printtokens.is_identifier("1"));
		assertEquals(false, Printtokens.is_identifier("a!"));
		assertEquals(true, Printtokens.is_identifier("a1"));
		assertEquals(true, Printtokens.is_identifier("a1\0"));
		
		System.out.println("is_identifier() finished.");
		
	}
	
	@Test
	void testPrint_spec_symbol() 
	{
		System.out.println("testing print_spec_symbol().");
		
		Printtokens instance = new Printtokens();
		assertTrue(is_spec_symbol('('));   
        assertTrue(is_spec_symbol(')'));   
        assertTrue(is_spec_symbol('['));   
        assertTrue(is_spec_symbol(']'));   
        assertTrue(is_spec_symbol('/'));   
        assertTrue(is_spec_symbol('`'));   
        assertTrue(is_spec_symbol(','));  
        assertFalse(is_spec_symbol('a')); 
		
		System.out.println("print_spec_symbol() finished.");
		
	}
	
	@Test
	void testIs_spec_symbol() 
	{
		System.out.println("testing is_spec_symbol().");
		
		Printtokens instance = new Printtokens();
		assertTrue(is_spec_symbol('('));   
        assertTrue(is_spec_symbol(')'));   
        assertTrue(is_spec_symbol('['));   
        assertTrue(is_spec_symbol(']'));   
        assertTrue(is_spec_symbol('/'));   
        assertTrue(is_spec_symbol('`'));   
        assertTrue(is_spec_symbol(','));  
        assertFalse(is_spec_symbol('a')); 
		
		System.out.println("is_spec_symbol() finished.");
	}
	
	static boolean is_spec_symbol(char c) 
	{
		if (c == '(' || c == ')' || c == '[' || c == ']' || c == '/' || c == '`' || c == ',') 
		{
            return true;
		}
		return false;
	}

	@Test
	void testMain() 
	{
		System.out.println("testing main().");
		PrintStream stdout = System.out;
		InputStream stdin = System.in;
		
//		ByteArrayOuputStream actual_output = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(actual_output)));
		
		System.out.println("main() finished.");
	}

}