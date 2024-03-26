package com.manindra.unittest;

import com.manindra.leetcode.Solution1859;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTheSentenceTest {

    @Test
    void testSortSentence1() {
        Solution1859 sortingTheSentence = new Solution1859();
        String s = "sentence4 a3 is2 This1";
        String expected = "This is a sentence";
        String actual = sortingTheSentence.sortSentence(s);
        assertEquals(expected, actual);
    }

    @Test
    void testSortSentence2() {
        Solution1859 sortingTheSentence = new Solution1859();
        String s = "is2 sentence4 This1 a3";
        String expected = "This is a sentence";
        String actual = sortingTheSentence.sortSentence(s);
        assertEquals(expected, actual);
    }

    @Test
    void testSortSentence3() {
        Solution1859 sortingTheSentence = new Solution1859();
        String s = "Myself2 Me1 I4 and3";
        String expected = "Me Myself and I";
        String actual = sortingTheSentence.sortSentence(s);
        assertEquals(expected, actual);
    }
}
