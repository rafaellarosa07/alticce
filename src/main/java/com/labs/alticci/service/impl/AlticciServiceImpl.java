package com.labs.alticci.service.impl;

import com.labs.alticci.service.AlticciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class AlticciServiceImpl implements AlticciService {

    @Autowired
    CacheManager cacheManager;



    /**
     * Calculate the alticci sequence
     *
     * @param n
     * @return List<Integer>
     */
    public Integer getValueByIndex(Integer n) {
        cacheManager.getCache("numbers").get("numbers");
        Map<Integer, Integer> numbers = initializeMap(n);
        if (ObjectUtils.isEmpty(numbers.get(n))) {
            numberReturn(numbers, n);
        }
        return numbers.get(n);
    }


    @Cacheable(value = "numbers", key = "#numbers")
    public Map<Integer, Integer> initializeMap(Integer n) {
        Map<Integer, Integer> numbers = new HashMap<>();
        if (numbers.isEmpty()) {
            numbers.put(0, 0);
            numbers.put(1, 1);
            numbers.put(2, 1);
        }
        return numbers;
    }

    public int numberReturn(Map<Integer, Integer> numbers, Integer n) {
        if (n > 2) {
            int valueOne = numberReturn(numbers, n - 3);
            int valueTwo = numberReturn(numbers, n - 2);
            numbers.put(n, valueOne + valueTwo);
        }
        return numbers.get(n);
    }


}
