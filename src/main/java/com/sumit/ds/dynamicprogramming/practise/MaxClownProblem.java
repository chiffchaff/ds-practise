package com.sumit.ds.dynamicprogramming.practise;
/**
 * A circus is designing a tower routine consisting of people standing atop one another’s
 shoulders. For practical and aesthetic reasons, each person must be both shorter
 and lighter than the person below him or her. Given the heights and weights of each person in the circus,
 write a method to compute the largest possible number of people
 in such a tower.
 EXAMPLE:
 Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 * @author sumijaiswal
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class MaxClownProblem {

    public Pair getMaxHeight(List <Person> persons){
        if(persons == null || persons.size() == 0) {
            return new Pair(0, 0);
        }
        if(persons.size() == 1){
            return new Pair(persons.get(0).height, 1);
        }

        Pair pair = new Pair(-1,1);
        int maxCount = -1;
        for(Person p: persons){
            List <Person> eligible = new ArrayList<>();
            for(int i = 0; i < persons.size(); i++) {
                if (isEligible(p, persons.get(i))){
                    eligible.add(persons.get(i));
                }
            }
            Pair ret = getMaxHeight(eligible);
            int thisBaseCount = ret.peopleCount + 1;

            if(thisBaseCount > maxCount){
                maxCount = thisBaseCount;
            }
        }
        return new Pair(-1,maxCount);
    }

    public boolean isEligible(Person p,Person k){
        return (p.height > k.height && p.weight > k.weight);
    }

    public  static void main(String[] args){
        // (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
        List<Person> persons = Arrays.asList(new Person(65,100),new Person(70,150), new Person(56,90),new Person(75,190),new Person(60,95),new Person(68,110));
        MaxClownProblem cp = new MaxClownProblem();
        System.out.println(cp.getMaxHeight(persons).peopleCount);
    }

    /**
     * Created by root on 10/1/16.
     */
    public static class Pair {
        Pair(int height, int peopleCount) {
            this.height = height;
            this.peopleCount = peopleCount;
        }

        int height;
        int peopleCount;
    }

    static class Person{
        int height;
        int weight;

        public Person(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
}

