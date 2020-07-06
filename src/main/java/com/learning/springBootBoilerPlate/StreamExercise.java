package com.learning.springBootBoilerPlate;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {
    public List<Integer> filter(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream().filter(num -> num > 2).collect(Collectors.toList());
    }

    public Integer max(ArrayList<Integer> listOfIntegers) {
        Optional<Integer> maxNumber = listOfIntegers.stream().max(Comparator.naturalOrder());
        return maxNumber.orElse(0);
    }

    public boolean hasAnyEvenNumber(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream().anyMatch(num -> num%2 == 0);
    }

    public boolean hasAllEvenNumber(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream().allMatch(num -> num%2 == 0);
    }

    public boolean hasNoEvenNumber(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream().noneMatch(num -> num%2 == 0);
    }

    public boolean hasNumber(ArrayList<Integer> listOfIntegers, int inputNumber) {
        return listOfIntegers.contains(inputNumber);
    }

    public List<Double> convertToListOfDouble(ArrayList<Integer> listOfIntegers) {

        return listOfIntegers.stream()
                .map(num -> num.doubleValue())
                .collect(Collectors.toList());
    }

    public double[] convertToArrayOfDouble(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream().mapToDouble(num -> num.doubleValue()).toArray();
    }

    public List<Integer> mapAndFilter(ArrayList<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .map(num -> num*2)
                .filter(num -> num > 5)
                .collect(Collectors.toList());
    }

    public List<String> flattenList(List<List<String>> nestedList) {
        return nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public String flattenToString(List<List<String>> nestedList) {
        return nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining(", "));
    }
}
