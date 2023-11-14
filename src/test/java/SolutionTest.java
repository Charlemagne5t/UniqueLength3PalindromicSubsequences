import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void countPalindromicSubsequenceTest1(){
        String s = "aabca";
        int expected = 3;
        int actual = new Solution().countPalindromicSubsequence(s);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countPalindromicSubsequenceTest2(){
        String s = "adc";
        int expected = 0;
        int actual = new Solution().countPalindromicSubsequence(s);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void countPalindromicSubsequenceTest3(){
        String s = "bbcbaba";
        int expected = 4;
        int actual = new Solution().countPalindromicSubsequence(s);

        Assert.assertEquals(expected, actual);
    }

}
