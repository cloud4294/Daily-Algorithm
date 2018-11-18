import java.util.Arrays;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16435�� - ������ũ����
 * 
 *   https://www.acmicpc.net/problem/16435
 */

public class Main16435 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] h = new int[N];
		for (int i = 0; i < N; i++) {
			h[i] = sc.nextInt();
		}
		Arrays.sort(h); // ��� ������ ���̸� ������������ ����
		
		for (int i = 0; i < N; i++) {
			if(h[i] <= L)
				L++;
		} //���� ������ ���̰� ������ũ ������ ���̺��� �۰ų� ������ ������ũ ������ ���̸� ����
		
		System.out.println(L);
	}

}
