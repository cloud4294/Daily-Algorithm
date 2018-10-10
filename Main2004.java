import java.util.Scanner;

/*
 * 	 Baekjoon Online Judge 2004번 - 조합 0의 개수	
 * 
 *   https://www.acmicpc.net/problem/2004
 * 
 */


public class Main2004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long m = scan.nextLong();
		long k = n - m;

		long counttwo = 0;
		long countfive = 0;
		
		for (long i = 2; i <= n; i *= 2) {
			counttwo += n / i;
		}
		
		for (long i = 5; i <= n; i *=5) {
			countfive += n / i;	
		} // n!에서 2의 갯수와 5의 갯수를 구함
		
		for (long i = 2; i <= m; i *= 2) {
			counttwo -= m / i;
		}
		
		for (long i = 5; i <= m; i *=5) {
			countfive -= m / i;	
		} // m!에서 2의 갯수와 5의 갯수만큼 뺀다.
		
		for (long i = 2; i <= k; i *= 2) {
			counttwo -= k / i;
		}
		
		for (long i = 5; i <= k; i *=5) {
			countfive -= k / i;	
		} // (n - m)! 에서 2의 갯수와 5의 갯수만큼 뺀다.
		
		
		System.out.println(Math.min(counttwo, countfive));// 5의 갯수와 2의 갯수중 작은것 출력

	}

}
