package de.neuefische.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SecurityUtils20200925Test {

    @Test
    public void testLengthTooShort() {
        //GIVEN
        String testStr = "1234567";
        //WHEN
        boolean valReturn = SecurityUtils_20200925.isLongEnough(testStr);
        //THEN
        assertFalse(valReturn);
    }

    @Test
    public void testLengthExact() {
        //GIVEN
        String testStr = "12345678";
        //WHEN
        boolean valReturn = SecurityUtils_20200925.isLongEnough(testStr);
        //THEN
        assertTrue(valReturn);
    }

    @ParameterizedTest(name = "when {0} enthalten, dann {1}")
    @CsvSource({
            "0, true",
            "1, true",
            "2, true",
            "3, true",
            "4, true",
            "5, true",
            "6, true",
            "7, true",
            "8, true",
            "9, true",
            "abc9, true",
            "jfhfhfjf, false",
            "//*4ab, true"
    })
    public void containsNumberTest (String ziffer, boolean expected) {

        //WHEN
        boolean valReturn = SecurityUtils_20200925.containsNumber(ziffer);
        //THEN
        assertEquals(expected, valReturn);
    }

    @ParameterizedTest(name = "when {0} enthalten, dann {1}")
    @CsvSource({
            "a, false",
            "A, true",
            "B, true",
            "X, true",
            "abd, false",
            "abD, true"
    })

    public void containsUpperCaseTest (String password, boolean expected) {
        boolean valReturn = SecurityUtils_20200925.containsUpperCase(password);
        assertEquals(expected, valReturn);
    }

    @ParameterizedTest(name = "when {0} enthalten, dann {1}")
    @CsvSource({
            "a, true",
            "A, false",
            "B, false",
            "X, false",
            "abd, true",
            "abD, true"
    })

    public void containsLowerCaseTest (String password, boolean expected) {
        boolean valReturn = SecurityUtils_20200925.containsLowerCase(password);
        assertEquals(expected, valReturn);
    }

    @ParameterizedTest(name = "when {0} enthalten, dann {1}")
    @CsvSource({
            "abd1, false",
            "/U3abdefjfjhnf, true",
            "hsjagljhgahbhfgahgh, false"
    })

    public void validatePasswordTest (String password, boolean expected) {
        boolean valReturn = SecurityUtils_20200925.validatePassword(password);
        assertEquals(expected, valReturn);
    }

    @Test
    public void arrayPasswordTest () {
        //GIVEN
        String[] arrayPassword = {"abd1234A", "rrjrjrknv5Anjj"};

        //WHEN
        boolean [] valReturn = SecurityUtils_20200925.arrayPassword(arrayPassword);

        //THEN
        boolean [] expected = {true, true};
        assertArrayEquals(expected, valReturn);
    }
}