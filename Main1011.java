import java.util.Scanner;

/*
 *   Baekjoon Online Judge 1011¹ø - Fly me to the Alpah Centauri 
 * 
 *   https://www.acmicpc.net/problem/1011
 * 
 */


public class Main1011 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();

			long d = y - x;
			
			long count = 0;
			long ans  = 1;
			while(count < d) {
				ans++;
				count += (ans/2);
			}
			
			System.out.println(ans - 1);

		}
	}

}
