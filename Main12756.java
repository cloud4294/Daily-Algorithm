import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 12756�� - ��� �������
 * 
 * 		https://www.acmicpc.net/problem/12756
 */

public class Main12756 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int aa = sc.nextInt();
		int ad = sc.nextInt();
		int ba = sc.nextInt();
		int bd = sc.nextInt();

		while (ad > 0 && bd > 0) {
			ad -=ba;
			bd -=aa;
		}// ���÷��̾��� ī���� �ϳ��� ������� 0���� �۾��������� ��ȯ�Ѵ�.
		
		if(ad > 0)
			System.out.println("PLAYER A");
		else if(bd > 0)
			System.out.println("PLAYER B");
		else 
			System.out.println("DRAW");

	}

}
