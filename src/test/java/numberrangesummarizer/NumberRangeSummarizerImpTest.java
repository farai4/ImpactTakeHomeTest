package numberrangesummarizer;

import com.test.TakeHomeTest.numberrangesummarizer.NumberRangeSummarizer;
import com.test.TakeHomeTest.numberrangesummarizer.NumberRangeSummarizerImp;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;

class NumberRangeSummarizerImpTest {

    private final NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImp();

    @org.junit.jupiter.api.Test
    void testCollectInputWithDuplicates() {
        Collection<Integer> numbers = numberRangeSummarizer.collect("1,3,3,6,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,12,13,14,14,15,15,21,22,23,24,31");
        Assertions.assertEquals(14, numbers.size());
    }

    @org.junit.jupiter.api.Test
    void testCollectInputWithWhiteSpaces() {
        Collection<Integer> numbers = numberRangeSummarizer.collect(" 1,3,6,7,8, 12,13,14,15,21,22,23,24,31 ");
        Assertions.assertEquals(14, numbers.size());
    }

    @org.junit.jupiter.api.Test
    void testCollectInputWithNothing() {
        Collection<Integer> numbers = numberRangeSummarizer.collect("     ");
        Assertions.assertEquals(0, numbers.size());
    }

    @org.junit.jupiter.api.Test
    void testCollectInputWithMissingNumbers() {
        Collection<Integer> numbers = numberRangeSummarizer.collect(" 1,3,,7,8, 12,13,14,15,21,22,23,24,31 ");
        Assertions.assertEquals(13, numbers.size());
    }

    @org.junit.jupiter.api.Test
    void testCollectInputWithInvalidNumbers() {
        Collection<Integer> numbers = numberRangeSummarizer.collect(" 1,3,5,abc,8, 12,13,14,15,21,22,23,24,31 ");
        Assertions.assertEquals(13, numbers.size());
    }

    @org.junit.jupiter.api.Test
    void testSummarizeCollection() {
        Collection<Integer> numbers = numberRangeSummarizer.collect(" 1,3,6,7,8, 12,13,14,15,21,22,23,24,31 ");
       String result = numberRangeSummarizer.summarizeCollection(numbers);
       Assertions.assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }
}