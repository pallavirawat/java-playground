package LeetCode.longestSubWithoutRep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubWithoutRepTest {

    @Test
    void name() {
        int actual = new LongestSubWithoutRep().optimisedonereqrite("abcabcbb");

        Assertions.assertEquals(3, actual);
    }
}