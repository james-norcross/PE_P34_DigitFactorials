package projecteuler.problem34;

public class DigitFactorials {

	/**
	 * Author: James Norcross
	 * Date: 1/16/15
	 * Purpose: Project Euler problem 34
	 * Description:  Finds the sum of all numbers that meet the criterion that for a given number the sum of the factorials 
	 * of each of its digits is equal to the number itself
	 */
	public static void main(String[] args) {
		// note: the largest number that needs be considered is less than 2177280.  7 is the maximum digits for which a 
		// number can equal the sum of the factorial of its digits since 8*9! is only 2903040 (a 7 digit number). 7*9! is 
		// 2540160 which is less than 9999999 so obviously the largest possible number that need be considered is 6*9! which is
		// 2177280.  Further refinement of this maximum value could be made, but it is unlikely to limit the execution time
		// of the program
		
		// create and populate an array of factorials for digits 0-9
		int[] factorial = new int[10];
		factorial[0] = 1;
		for(int i = 1; i < 10; i++)
			factorial[i] = i * factorial[i-1];
		
		int total = 0;
		
		// step through all possible candidates, note 1 and 2 are not candidates as per problem specification
		for (int i = 3; i < 2177280; i++) 
		{
			int num = i;
			int sum = 0;
			
			// seperate off each digit of number and sum factorials, if num reaches 0 have considered all digits
			// if sum ever is greater than i then i can't meet criterion
			while((num > 0) && (sum <= i))
			{
				int temp = num/10;
				int digit = num - (temp * 10);
				sum += factorial[digit];
				num = temp;
			}
			
			if (sum == i)
			{
				total += i;
			}
			
		}
		
		System.out.println("The total of the numbers meeting the criterion is " + total);
	}

}
