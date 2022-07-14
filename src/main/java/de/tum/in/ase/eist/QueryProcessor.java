package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QueryProcessor {

    public String process(String query) {
        try {
            query = query.toLowerCase();
            if (query.contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            } else if (query.contains("name")) {
                return "Simson";
            } else if (query.contains("plus")) {
                String[] s = query.split(" ");

                AtomicInteger sum = new AtomicInteger();
                for (String el : s) {
                    try {
                        sum.addAndGet(Integer.parseInt(el));
                    } catch (Exception ignored) {
                    }
                }
            } else if (query.contains("largest")) { // TODO extend the programm here
                String[] s = query.split(" ");
                List<Integer> a = new ArrayList<>();
                for (String value : s) {
                    if (value.contains(",")) {
                        a.add(Integer.parseInt(value.substring(0, s.length - 1)));
                    }
                }
                a.add(Integer.parseInt(s[s.length - 1].substring(0, s.length - 1)));
                OptionalInt max = a.stream().mapToInt(t -> t).max();
                return max.toString();
            } else if (query.contains("film") && query.contains("played")) {
                return "Sean Connery";
            } else if (query.contains("color") && query.contains("banana")) {
                return "yellow";
            } else if (query.contains("")) {

            }
        } catch (Exception ignored) {
        }
        return "";
    }
}

