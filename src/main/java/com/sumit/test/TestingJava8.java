package com.sumit.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestingJava8 {
    public static void main(String[] args) {
        String names[] = {"sumit","amit"};
        List<String> namesList = Arrays.asList(names).stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(namesList);
    }
}
