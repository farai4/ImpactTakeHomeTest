package com.test.TakeHomeTest.numberrangesummarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberRangeSummarizerImp implements NumberRangeSummarizer {

    /**
     *
     * @param input String of numbers
     * @return a collection of sorted integers
     */
    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        String[] numbers = input.split(",");
        return Stream.of(numbers)
                .map(String::trim) // Trim white spaces
                .filter(NumberRangeSummarizerImp::isNumeric)
                .map(Integer::parseInt)//parse each string to an int
                .sorted()//sort the stream
                .distinct()//Eliminate duplicates
                .collect(Collectors.toCollection(ArrayList::new)); //collect to ArrayList
    }


    /**
     * method to summaries list of numbers
     *  Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
     *  Result: "1, 3, 6-8, 12-15, 21-24, 31"
     * @param input collection that is sorted
     * @return String result in desired format
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        List<Integer> numbers = (ArrayList<Integer>) input;
        StringBuilder result = new StringBuilder();

        int left = numbers.getFirst();
        int right = left;
        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current == right + 1) {
                right = current;
            } else {
                appendRange(result, left, right);
                left = current;
                right = left;
            }

        }
        appendRange(result, left, right);
        return result.toString();
    }

    private void appendRange(StringBuilder result, int left, int right) {
        if (!result.isEmpty()) {
            result.append(", ");
        }
        if (left == right) {
            result.append(left);
        } else {
            result.append(left).append("-").append(right);
        }
    }

    /**
     * checks if a string can be converted to numeral
     * @param s string
     * @return boolean
     */
    static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
