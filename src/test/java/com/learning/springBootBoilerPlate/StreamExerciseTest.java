package com.learning.springBootBoilerPlate;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StreamExerciseTest {
    private StreamExercise streamExercise;
    private ArrayList<Integer> listOfIntegers;
    private List<List<String>> nestedList;

    @BeforeEach
    void setUp() {
        streamExercise = new StreamExercise();
        listOfIntegers = new ArrayList<>(Arrays.asList(1,4,6,3));

        List<String> list1 = Arrays.asList("Hello", "World");
        List<String> list2 = Arrays.asList("The", "Beginning");
        nestedList = Arrays.asList(list1, list2);
    }

    @Test
    void shouldReturnNumbersGreaterThan2FromGivenList() {
        List<Integer> expected = Arrays.asList(4, 6, 3);
        List<Integer> actual = streamExercise.filter(listOfIntegers);

        assertThat(actual, Is.is(expected));
    }

    @Test
    void shouldReturnMaxNumberFromGivenList() {
        Integer actual = streamExercise.max(listOfIntegers);

        assertThat(actual, Is.is(6));
    }

    @Test
    void shouldReturnMaxNumberAs0ForEmptyList() {
        Integer actual = streamExercise.max(new ArrayList<>());

        assertThat(actual, Is.is(0));
    }

    @Test
    void shouldReturnTrueIfAnyNumberFromListIsEven() {
        boolean actual = streamExercise.hasAnyEvenNumber(listOfIntegers);

        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfAllTheNumbersFromListAreEven() {
        boolean actual = streamExercise.hasAllEvenNumber(listOfIntegers);

        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseForNoneOfTheNumbersFromListAreEven() {
        boolean actual = streamExercise.hasNoEvenNumber(listOfIntegers);

        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueWhenInputNumberExistsInList() {
        boolean actual = streamExercise.hasNumber(listOfIntegers, 4);

        assertTrue(actual);
    }

    @Test
    void shouldConvertListOfIntegersToListOfDoubles() {
        ArrayList<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(4.0);
        expected.add(6.0);
        expected.add(3.0);
        List<Double> actual = streamExercise.convertToListOfDouble(listOfIntegers);

        assertThat(actual, Is.is(expected));
    }

    @Test
    void shouldConvertListOfIntegersToArrayOfDoubles() {
        double[] expected = new double[]{1.0, 4.0, 6.0, 3.0};
        double[] actual = streamExercise.convertToArrayOfDouble(listOfIntegers);

        assertThat(actual, Is.is(expected));
    }

    @Test
    void shouldRetunListOfNumbersGreaterThan5FromListAfterMuliplyingEveryBy2() {
        List<Integer> actual = streamExercise.mapAndFilter(listOfIntegers);

        assertThat(actual, Is.is(Arrays.asList(8, 12, 6)));
    }

    @Test
    void shouldReturnFlattenListOfStringFromNestedListOfString() {
        List<String> actual = streamExercise.flattenList(nestedList);

        assertThat(actual, Is.is(Arrays.asList("Hello", "World", "The", "Beginning")));
    }

    @Test
    void shouldReturnStringFromNestedListOfString() {
        String actual = streamExercise.flattenToString(nestedList);

        assertThat(actual, Is.is("Hello, World, The, Beginning"));
    }
}