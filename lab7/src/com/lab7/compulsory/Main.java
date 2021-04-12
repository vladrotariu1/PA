package com.lab7.compulsory;

import java.util.Collections;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> map = Collections.singletonMap(1, 2);
        int key = map.keySet().iterator().next();
        System.out.println(map.get(key));
    }
}
