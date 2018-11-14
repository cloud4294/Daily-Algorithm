import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16396�� - �� �׸���
 * 
 *   https://www.acmicpc.net/problem/16396
 *    
 */

public class Main16396 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] length = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			length[i] = false; 
		}// ��ü�� false�� �ʱ�ȭ
		
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j < b; j++) {
				length[j] = true;
			}
		}// �� ������ �ش��ϴ� �κ��� true�� ���� 
		
		int result = 0;
		for (int i = 1; i <= 10000; i++) {
			if(length[i] == true)
				result++;
		}// true�� �κи� Ȯ���Ͽ� ���̸� ����
		
		System.out.println(result);
		
	}

}
