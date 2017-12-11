// Source : https://leetcode.com/problems/guess-game
// Author : zhaohaiyuan
// Date   : 2017-12-11

/*
 * binary search
 * mid = min + (max-min)/2
 * do not use mid=(min+max)/2
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            } else if (guessResult > 0) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;

    }
}
