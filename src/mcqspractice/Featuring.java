package mcqspractice;

import java.util.Arrays;

public class Featuring {
    public static void main(String[] args) {
        int[] feature = {45,14,78,8,6,9,50,-3};
        Arrays.parallelSort(feature,2,5);
        for(int i : feature) {
            System.out.println(i+" ");
        }
    }
}
