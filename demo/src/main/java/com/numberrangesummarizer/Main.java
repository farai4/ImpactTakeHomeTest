package demo.src.main.java.com.numberrangesummarizer;

import java.util.Collection;

public class Main {
     public static void main(String[] args) {
        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImp();
        String input = "1,3,6, 5,3,7,8,12,13,14,15, 2, 21,22,23,24,31";
       Collection<Integer> inputList = numberRangeSummarizer.collect(input);
       String result = numberRangeSummarizer.summarizeCollection(inputList);
        System.out.println(inputList);
        System.out.println(result);
    }
}
