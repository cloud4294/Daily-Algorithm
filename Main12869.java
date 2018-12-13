import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *   	Baekjoon Online Judge 12869�� - ��Ż����ũ
 * 
 * 		https://www.acmicpc.net/problem/12869
 */

public class Main12869 {

	static int N;
	static int[][] D = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };
	static int[][][][] check;
	static int min;

	static class step {
		int count;
		int hp1;
		int hp2;
		int hp3;

		step(int count, int hp1, int hp2, int hp3) {
			this.count = count;
			this.hp1 = hp1;
			this.hp2 = hp2;
			this.hp3 = hp3;
		}

	}

	public static void attack(int count, int[] hp) {

		step first = new step(count, hp[0], hp[1], hp[2]);

		Queue<step> queue = new LinkedList<step>();
		queue.offer(first);

		while (!queue.isEmpty()) {
			step now = queue.poll();
			if(now.hp1 <= 0 && now.hp2 <= 0 && now.hp3 <= 0) {
				if(now.count < min)
					min = now.count;
			} // 3�� ü�¸�� 0�� �Ǿ����� Ÿ��Ƚ���� �����Ѵ�.
			
			int next = now.count+1;
			for (int i = 0; i < 6; i++) {
				int hp1 = now.hp1 - D[i][0];
				int hp2 = now.hp2 - D[i][1];
				int hp3 = now.hp3 - D[i][2];
				if(hp1 < 0) hp1 = 0;
				if(hp2 < 0) hp2 = 0;
				if(hp3 < 0) hp3 = 0;
				if(next == 20) // 3�� �ִ� ü���� 60�̱� ������ 20ȸ ������ Ÿ��Ƚ���� ��� ���Ű����ϴ�. 
					break;
				
				if(check[hp1][hp2][hp3][next] == 0) { // �̹� Ȯ���� ������ ü�»�Ȳ�� ť�� ��������
					check[hp1][hp2][hp3][next] = 1;
					
					
					queue.offer(new step(next,hp1,hp2,hp3));
				}
			}

		}

	} // bfs ����

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] hp = new int[3];
		check = new int[61][61][61][21];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			hp[i] = sc.nextInt();
		}

		attack(0, hp);

		System.out.println(min);
	}

}
