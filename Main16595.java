import java.util.Scanner;


/*
 * 
 *   Baekjoon Online Judge 16395�� - �Ľ�Į�� �ﰢ�� 
 * 
 *   https://www.acmicpc.net/problem/16395
 * 
 */

public class Main16595 {

	public static int solve(int n,int k) {
		
		if(k == 1 || k == n)
			return 1;
		else {
			
			return solve(n-1,k-1) + solve(n-1,k);
		}
		
	}// ���� ���� ������ �μ��� ��������� ȣ����
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(solve(n,k));
		
	}

}
