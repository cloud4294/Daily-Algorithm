import java.util.Scanner;

/*
 *   Baekjoon Online Judge 14429번 - 배스킨라빈스 31
 * 
 *   https://www.acmicpc.net/problem/14429
 *   
 */

public class Main14429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int length = Integer.MAX_VALUE;
		int num = 0;
		for (int i = 0; i < n; i++) {
			int j = sc.nextInt();
			int m = sc.nextInt();

			int k = (j - 1) % (m + 1);

			int count = 0;
			for (int k2 = k; k2 < j; k2 += (m + 1)) {
				count += 2;
				if (k2 == j - 1 && count < length) {
					length = count;
					num = i + 1;
				}
			}
		} // 주어진 문제에 따라 공식을 만들어 해결
		System.out.println(num + " " + length);
	}

}
