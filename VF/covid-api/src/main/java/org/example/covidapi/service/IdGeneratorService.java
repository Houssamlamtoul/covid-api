package org.example.covidapi.service;

import org.springframework.stereotype.Service;

@Service
public class IdGeneratorService {
    // a simple counter that will be used to generate unique ids
    private int counter1 = 1;
    private int counter2 = 1;
    private int counter3 = 1;

    public int generateId1() {
        return counter1++;
    }

    public int generateId2() {
        return counter2++;
    }

    public int generateId3() {
        return counter3++;
    }
}