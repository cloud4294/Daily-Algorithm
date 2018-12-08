import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 11383�� - ��
 * 
 * 		https://www.acmicpc.net/problem/11689
 */

public class Main11689 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		long pi = n;
		long prime = 2;

		while (prime * prime <= n) {
			if (n % prime == 0)
				pi = pi / prime * (prime - 1);
			while (n % prime == 0)
				n = n / prime;
			prime++;
		} // ���Ϸ� ���Լ� ������ �����Ͽ� �ذ�

		if (n != 1)
			pi = pi / n * (n - 1);
		
		System.out.println(pi);

	}

}
