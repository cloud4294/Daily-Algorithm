import java.util.Scanner;

/*
 *   Baekjoon Online Judge 1085�� - ���簢������ Ż��
 * 
 *   https://www.acmicpc.net/problem/1085
 */

public class Main1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = 1001;
		if (y < min) {
			min = y;
		}

		if (x < min) {
			min = x;
		}

		if (h - y < min) {
			min = h - y;
		}

		if (w - x < min) {
			min = w - x;
		}
		// �簢���� ������ ���̺�
		System.out.println(min);

	}

}
