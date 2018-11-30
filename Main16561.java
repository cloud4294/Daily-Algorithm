import java.util.Scanner;
/*
 *    Baekjoon Online Judge 16561번 - 3의 배수 
 * 
 *    https://www.acmicpc.net/problem/16561
 *    
 */
public class Main16561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n % 3 != 0) {
			System.out.println(0);
			return;
		} // 3의 배수가 아니면 0을 출력
		int a = n / 3;
		int count = 0;

		for (int i = 1; i < a; i++) {
			for (int j = 1; j < a; j++) {
				if(i + j < a)
					count++;
			}
		} // 3의 배수중에서 두수의 합이 a보다 작으면 count증가
		
		System.out.println(count);

	}

}