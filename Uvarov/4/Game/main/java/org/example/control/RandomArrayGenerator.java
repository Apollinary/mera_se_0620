package org.example.control;

import java.util.Arrays;
import java.util.Collections;

public class RandomArrayGenerator {

    public static Integer[] getRandomIndexesSet(int length) {
        Integer[] randomIndexesSet = new Integer[length];
        for (int i = 0; i < randomIndexesSet.length; i++) {
            randomIndexesSet[i] = i;
        }
        Collections.shuffle(Arrays.asList(randomIndexesSet));
        return randomIndexesSet;
    }
}
