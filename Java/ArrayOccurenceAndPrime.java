package edu.csupmona.cs.cs140.assgmnt3;

import java.util.Arrays;

public class Assgmnt3 {


	/*
	 * The program is set to return the number of times the value set for x occurs.
	 * In this case, x is set to 3 and it correctly returns '4' as the number of times 3 occurs.
	 */
	public static void main(String[] args) { 
	int x = 3;
	System.out.println(occr(new int[] {1,3,3,3,3,4,4,5,5,6,7,8,9}, x));
	}
		
		public static int occr(int[] number, int x) {
			int occr = 0;
			for (int i = 0; i < number.length; i++) {
				if (number[i] == x)
					occr++;
			}
			return occr;
	}


		/*
		 * The program sets two variables.
		 * If the remainder of the two equals 0, it will return prime
		 * Otherwise, it will return null.
		 */
		public static int primes(int[] numbers) {
			for (int i = 0; i < numbers.length; i++) {
				int primes = 0;
				for (int j = 0; j < numbers.length; j++) {	
					if (numbers[i]%numbers[j] == 0);
					return primes;
			}
				return (Integer) null;
		}
			return 0;
	}
		
		/*
		 * Setting the variable count equal to MaxCount, and maxValue 
		 * to the integers in the array.
		 * It will return the integer that occurs the most times.
		 */
		public static int mode(int[] numbers) {
			int maxValue, maxCount = 0;
			
			for (int i = 0; i < numbers.length; i++) {
				int count = 0;
				for (int j = 0; j < numbers.length; ++j) {
					if (numbers[j] == numbers[i]) ++count;
				}
				if (count > maxCount) {
					maxCount = count;
					maxValue = numbers[i];
				}
			}
			return maxCount;
		
		}


		/*
		 * A pyramid will be displayed by using the print function.
		 */
		public static void prettyPrint(int[] numbers) {
			System.out.println("     4");
			System.out.println("   3   5");
			System.out.println("  6  7  8");
		}

		/*
		 * Returns the highest valued integer by setting maxIndex equal to 
		 * the variable i.
		 */
		public static int indexOfMax(int[] numbers) {	
			int x = 0;
				if (x <= 0)
					return -1;
			int maxIndex = 0;
			int maxValue = numbers[0];
			for (int i = 1; i < x; i++) {
				maxValue = numbers[i];
				maxIndex = i;
			}
			return maxIndex;
					
		}
		
		/*
		 * Returns the prime factors for x after figuring out if the
		 * remainder of i and x equals 0 and they are not equal.
		 */
		public static int[] primeFactors(int x) {
			int i;
			int j = 0;
			int[] primeFactors = new int[j];
			if(x <= 1) return null;
			for(i = 2; i <= x; i++) {
				if(x % i == 0) {
					x /= i;
					primeFactors[j] = i;
					i--;
					j++;
				}
			}
			return primeFactors;
		}

		/*
		 * Reverses the integers in the array and returns the array
		 */
		public static int[] reverse(int[] numbers) {
			int[] x = numbers;
			for (int i = 0; i < (numbers.length) / 2; i++) {
				int temp = x[i];
				x[i] = x[numbers.length - i -1];
				x[numbers.length - i - 1] = temp;
			}
			return x;
		}
		/*
		 * Combines the integers in both arrays into a single array.
		 */
		public static int[] append(int[] xs, int ys){
			int[] result = Arrays.copyOf(xs, xs.length +1);
			result[xs.length] = ys;
			return result;
		}

		public static int[] subArray(int[] numbers, int first, int last) {
			int numbersLen = numbers.length;
			int[] x = new int[numbersLen - last - first];
			System.arraycopy(numbers, 0, x, 0, first); 
			System.arraycopy(numbers, last, x, first, numbersLen - last);
			return x;
		}
	}