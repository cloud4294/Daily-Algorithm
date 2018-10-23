import java.io.IOException;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 14225번 - 부분수열의 합
 * 
 *   https://www.acmicpc.net/problem/14225
 * 
 */

public class Main14225 {

	static int[] data;
	static int N;
	static int[] check = new int[2000001];

	static void solve(int i,int sum) {

		if(i == N) {
			check[sum]++;
			return;
		}
		solve(i+1,sum); // i번째 수를 선택하지 않는 경우 
		solve(i+1,sum + data[i]); // i번째 수를 선택하는 경우
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		solve(0,0);
		for (int i = 0; i < 2000001; i++) {
			if(check[i] == 0) { // 숫자 i가 조합으로 만들어 지지않았으므로  i를 출력하고 끝냄
				System.out.println(i);
				break;
				
			}
		}

	}

}
