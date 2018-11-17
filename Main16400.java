import java.util.ArrayList;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16400번 - 소수화폐
 * 
 *   https://www.acmicpc.net/problem/16400
 */

public class Main16400 {

	static int MAX = 40001;
	static int[] findprime;
	static int mod = 123456789;
	static ArrayList<Integer> prime = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		findprime = new int[MAX];
		for (int i = 2; i < MAX; i++) {
			for (int j = i * 2; j < MAX; j += i) {
				findprime[j] = 1;
			}
		} // 에라스토테네스의 체를 이용, 소수를 찾아냄
		
		for (int i = 2; i < MAX; i++) {
			if (findprime[i] == 0)
				prime.add(i);
		} // 소수를 리스트에 넣어둠

		int[] count = new int[MAX];
		count[0] = 1;
		for (int i = 0; i < prime.size(); i++) {
			for (int j = prime.get(i); j <= N; j++) {
				count[j] = (count[j] + count[j - prime.get(i)]) % mod;
			}
		} // 다이나믹 프로그래밍으로 누적 값을 구함

		System.out.println(count[N]);

	}

}
