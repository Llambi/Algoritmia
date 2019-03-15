package alg77777777.p4;

import java.util.Map;

public class HuffmanPrueba {
	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();	
	}
	
	public static void testCase1() {
		String file = "resources/case1.txt";
    	Huffman huffman = new Huffman(file);
    	huffman.run();
    	Map<String, String> codes = huffman.getCodes();
    	
    	assertEquals("0", codes.get("f"));
    	assertEquals("100", codes.get("c"));  //c
    	assertEquals("101", codes.get("d"));
    	assertEquals("1100", codes.get("a"));
    	assertEquals("1101", codes.get("b"));
    	assertEquals("111", codes.get("e"));
    	System.out.println("testCase1 - ejecutado");
	}
	
	private static void assertEquals(String cad1, String cad2) {
		if(!cad1.equals(cad2)) {
    		System.err.println("Error en el código: correcto: "+cad1+" generado: "+cad2);
    		System.exit(-1);
		}
		
	}

	public static void testCase2() {
		String file = "resources/case2.txt";
    	Huffman huffman = new Huffman(file);
    	huffman.run();
    	Map<String, String> codes = huffman.getCodes();
    	
    	assertEquals("00", codes.get("f"));
    	assertEquals("01", codes.get("d"));
    	assertEquals("100", codes.get("c"));
    	assertEquals("1010", codes.get("e"));
    	assertEquals("1011", codes.get("a"));
    	assertEquals("11", codes.get("b"));
    	System.out.println("testCase2 - ejecutado");
	}
	
	public static void testCase3() {
		String file = "resources/case3.txt";
    	Huffman huffman = new Huffman(file);
    	huffman.run();
    	Map<String, String> codes = huffman.getCodes();
    	
    	assertEquals("111", codes.get("j"));
    	assertEquals("110", codes.get("a"));
    	assertEquals("10", codes.get("s"));
    	assertEquals("01", codes.get("o"));
    	assertEquals("00", codes.get("n"));
    	System.out.println("testCase3 - ejecutado");
	}
	
	public static void testCase4() {
		String file = "resources/case4.txt";
    	Huffman huffman = new Huffman(file);
    	huffman.run();
    	Map<String, String> codes = huffman.getCodes();
    	
    	assertEquals("001000", codes.get("123123"));
    	assertEquals("0010010", codes.get("qwertyuiop"));
    	assertEquals("0010011", codes.get("987654321"));
    	assertEquals("00101", codes.get("1234567890"));
    	assertEquals("00110", codes.get("111111"));
    	assertEquals("00111", codes.get("12345678"));
    	assertEquals("00000", codes.get("password"));
    	assertEquals("00001", codes.get("1234567"));
    	assertEquals("0001", codes.get("qwerty"));
    	assertEquals("01", codes.get("123456790"));
    	assertEquals("1", codes.get("123456")); 	   	
    	System.out.println("testCase4 - ejecutado");
	}

}
