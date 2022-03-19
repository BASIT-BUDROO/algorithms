package com.company;

public class Main {
    static int top_of_stack = -1;

    void push(int[] arr, int num) {
        top_of_stack++;
        arr[top_of_stack] = num;
    }

    void pop(int[] arr) {
        arr[top_of_stack] = 0;
        top_of_stack--;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] validation_array = new int[pushed.length];
        int i = 0;
        int j = 0;

        while (j < popped.length) {
            if (pushed[i] != popped[j]) {
                push(validation_array, pushed[i]);
                i++;
            }
            if (pushed[i] == popped[j]) {
                push(validation_array, pushed[i]);
                i++;
                while (validation_array[top_of_stack] == popped[j]) {
                    pop(validation_array);
                    j++;
                    if (j == popped.length) {
                        return true;
                    }
                    if (top_of_stack == -1) {
                        break;
                    }
                }
                if (i == pushed.length && (validation_array[top_of_stack] != popped[j])) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] pushed = {0, 1, 2};
        int[] popped = {2, 0, 1};
        Main validator = new Main();
    }
}
