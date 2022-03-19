**Nuts and Bolts Problem**

Date: 15-01-2022

Difficulty Level: Hard

Problem: You are given N nuts of different sizes and N bolts of different sizes. You have to produce a one-to-one mapping 
between the nuts and bolts.

Constraints: Comparison between any two nuts is not allowed and Comparison between any two bolts id not allowed. A nut 
can only be compared to a bolt and vice-versa.

Solution:

Brute Force Approach: Iterate through nuts array and compare the first element of the nuts array to each element of the 
bolts array, that would be n comparisons for first element of nuts array, at most. When element is found in bolts array
swap it with first element of the array.

For next element of the nuts array, you will have to compare it with n-1 elements of the bolts array, that would be n-1 
comparisons, at most.

T(n) = n + n-1 + n-2 + n-3 ... 1 = O(n^2)

Efficient Approach: Divide and Conquer using Quick Sort

First create a hashmap of the character set. Assign each character a number according to its precedence in increasing order.
This hashmap will be used for comparing element of nuts array to element of bolts array.

HashMap<Character, Integer> = {'!' : 1, '#' : 2, '$' : 3, '%' : 4, '&' : 5, '*' : 6, '@' : 7, '^' : 8, '~' : 9}












