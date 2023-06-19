package org.example.collections.exercitii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeadersChallange {
    //Am o lista de intregi. Un eleent al listei este un leader daca e mai mare decat toate elementele de dupa el.
    //[3,5,9,2,4,8,7,6] -> liderii sunt: 9.8.7.6
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 9, 2, 4, 8, 7, 6);
        findLeaders(list);
    }

    private static void findLeaders(List<Integer> list) {
        List<Integer> leaders = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Integer potentialLeader = list.get(i);

            boolean isLeader = true;
            for (int j = i + 1; j < list.size(); j++) {
                if (potentialLeader < list.get(j)) {
                    isLeader = false;
                    break;
                }
            }

            if (isLeader) {
                leaders.add(potentialLeader);
            }
        }

        System.out.println(leaders);
    }
}
