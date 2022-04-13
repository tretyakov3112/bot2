package com.example.demo;

import java.util.ArrayList;

public class Action {
    ArrayList<Integer> countNumber = new ArrayList();


    public String action(int n, int k){
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            if ((n % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1))) == (k % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1)))){
                ++count;
            }
        }
        countNumber.add(countNumber.size(), count);
        return "Bulls: "+count+"\n"+"Cows: "+ (4-count);
    }

    public int action1(int n, int k){
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            if ((n % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1))) == (k % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1)))){
                ++count;
            }
        }
        return count;
    }

    public int findNumber(int count, int limit, int n){
        int number = -1;

        for (int k = limit; k <10000 ; k++) {
            int count1 = 0;
            for (int i = 1; i <= 4; i++) {
                if ((n % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1))) == (k % (int)(Math.pow(10,i)))/((int)(Math.pow(10,i-1)))){
                    ++count1;
                }
            }
            if (count1==count) {
                number = k;
                break;
            }
        }
        return number;

    }

    public int scam(ArrayList<Integer> cN, ArrayList<Integer> aN){
        int x = 0;
        for (int i = 1000; i <10000 ; i++) {
            int n = findNumber(cN.get(cN.size()-1),i,aN.get(aN.size()-1));
            for (int j = 0; j < aN.size(); j++) {
                if (j == aN.size() -1) x = n;
                if (cN.get(j) == action1(n, aN.get(j))){
                    continue;
                } else {
                    break;
                }

            }
        }
        return x;
    }
}
