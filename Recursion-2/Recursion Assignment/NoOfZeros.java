/*

Given an integer N, count and return the number of zeros that are present in the given integer using recursion.
Input Format :
Integer N
Output Format :
Number of zeros in N
Constraints :
0 <= N <= 10^9
Sample Input 1 :
0
Sample Output 1 :
1
Sample Input 2 :
00010204
Sample Output 2 :
2
Explanation for Sample Output 2 :
Even though "00010204" has 5 zeros, the output would still be 2 because when you convert it to an integer, it becomes 10204.
Sample Input 3 :
708000
Sample Output 3 :
4

*/

import java.util.*;
public class NoOfZeros {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(countZerosRec(n));
	}
    public static int countZerosRec(int input){
            if(input==0) return 1;  // this is to handle if starting number is zero then it must return 1
            if(input/10 == 0 && input!=0) return 0; // but we want to return 0 when we reach a single digit number !=0
            if(input%10 == 0) return 1 + countZerosRec(input/10);
            else return countZerosRec(input/10);
	}
}
