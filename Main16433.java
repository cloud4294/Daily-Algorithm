import java.util.Scanner;

/*
 *   Baekjoon Online Judge 16433�� - �ֵ�� ��ٳ���
 * 
 *   https://www.acmicpc.net/problem/16433
 */

public class Main16433 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int check = 0;
		
		if((R+C)%2 ==0)
			check = 0;
		else 
			check = 1;
		// �ɾ����ִ� ����� ��ǥ ���� Ȧ������ ¦������ Ȯ����
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if((i+j)%2 == check)
					System.out.print('v');
				else 
					System.out.print('.');
			}
			System.out.println();
		}// ��ǥ���� �������� Ȧ�� ¦���� �����Ͽ� ���
		
		
				
	}

}
