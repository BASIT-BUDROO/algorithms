package NutsAndBolts;

import java.util.HashMap;

public class NutsAndBolts {
    public static void main(String[] args) {
        char[] precedence = {'!', '#', '$', '%', '&', '*', '@', '^', '~'};
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < precedence.length; i++) {
            hashMap.put(precedence[i], i + 1);
        }
        char[] nuts = {'^', '&', '%', '@', '#', '*', '$', '~', '!', '@', '*', '@', '&', '^', '~', '!', '!', '!'};
        char[] bolts = {'~', '#', '@', '%', '&', '*', '$', '^', '!', '&', '@', '*', '@', '~', '^', '!', '!', '!'};
        int N = nuts.length;
        Solution nuts_bolts = new Solution();
        nuts_bolts.matchNutsBolts(nuts, bolts, hashMap, 0, N - 1);

        for (char nut : nuts) {
            System.out.print(nut + " ");
        }
        System.out.println("\n");
        for (char bolt : bolts) {
            System.out.print(bolt + " ");
        }
    }
}

class Solution {
    void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    int partitionArray(char[] array, char pivot, HashMap<Character, Integer> hm, int start, int end) {
        int p = start - 1; // [0 .. p] --> These elements are less than or equal to pivot.
        int q = end + 1; // [q .. array.length - 1] --> These elements are greater than pivot.
        int curr_position = start; // Index of current position in the array.
        int partition_position = -1; // Index of the partition element.
        int pivotValue = hm.get(pivot);


        while (curr_position < q) {
            if (hm.get(array[curr_position]) < pivotValue) {
                p++;
                curr_position++;
            } else if (hm.get(array[curr_position]) > pivotValue) {
                q--;
                swap(array, curr_position, q);
            } else if (hm.get(array[curr_position]) == pivotValue) {
                partition_position = curr_position;
                p++;
                curr_position++;
            }
        }
        swap(array, partition_position, p);
        return p;
    }

    void matchNutsBolts(char[] nuts, char[] bolts, HashMap<Character, Integer> hm, int low, int high) {
        // Handling Base case, when there is only one element then there already is a one-to-one mapping
        if (low >= high) {
            return;
        }
        // Pick the last element of the nuts array and partition bolts array using this element.
        // Pivot should be at its correct position in the bolts array.
        char pivot_nuts = nuts[high];
        int pivot_bolts_index = partitionArray(bolts, pivot_nuts, hm, low, high);

        // Pick the pivot from the bolts array that is at its correct position.
        // Partition the nuts array using this pivot.
        char pivot_bolts = bolts[pivot_bolts_index];
        int pivot_nuts_index = partitionArray(nuts, pivot_bolts, hm, low, high);

        // At this point both nuts and bolts have equal elements on either side of the pivot and one-to-one mapping exists.
        // between pivot.

        // 1. First Recursive Call
        matchNutsBolts(nuts, bolts, hm, low, pivot_nuts_index - 1);
        // 2. Second Recursive Call
        matchNutsBolts(nuts, bolts, hm, pivot_bolts_index + 1, high);
    }
}
