import java.io.IOException;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 14225�� - �κм����� ��
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
		solve(i+1,sum); // i��° ���� �������� �ʴ� ��� 
		solve(i+1,sum + data[i]); // i��° ���� �����ϴ� ���
		
		
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
			if(check[i] == 0) { // ���� i�� �������� ����� �����ʾ����Ƿ�  i�� ����ϰ� ����
				System.out.println(i);
				break;
				
			}
		}

	}

}
