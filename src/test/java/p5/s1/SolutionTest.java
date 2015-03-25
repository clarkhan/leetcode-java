package p5.s1; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/** 
* Solution Tester. 
* 
* @author khan 
* @version 1.0 
*/ 
public class SolutionTest { 

/** 
* 
* Method: longestPalindrome(String s) 
* 
*/ 
@Test
public void testLongestPalindrome() throws Exception {
    Map<String, String> expected = new HashMap<String, String>();
    expected.put("abcdefghijklmnmlkjihhijkjihhijklmnmlkjihgf", "fghijklmnmlkjihhijkjihhijklmnmlkjihgf");
    expected.put("abcdefghijklmnmlkjihhijkkjihhijklmnmlkjihgf", "fghijklmnmlkjihhijkkjihhijklmnmlkjihgf");
    expected.put("abcdefghijklmnmlkjihhijkihhijklmnmlkjihgf", "hijklmnmlkjih");
    expected.put("abcdee", "ee");
    expected.put("aabcdee", "aa");
    expected.put("abcde", "a");
    expected.put("abadda", "adda");

    Solution solution = new Solution();

    for (Map.Entry<String, String> expect : expected.entrySet()) {
        String result = solution.longestPalindrome(expect.getKey());
        assertEquals(expect.getValue(), result);
    }

}


} 
