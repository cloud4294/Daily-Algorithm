import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 *   Baekjoon Online Judge 3184�� - ��
 * 
 *   https://www.acmicpc.net/problem/3184
 * 
 */


public class Main3184 {

	static char[][] map;
	static int r;
	static int c;

	static int[] mx = {-1,1,0,0};
	static int[] my = {0,0,-1,1};
	
	static int V = 0;
	static int O = 0;
	
	static class point {
		int y;
		int x;

		point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	static void bfs(int y, int x) {

		int countV = 0;
		int countO = 0;
		Queue<point> queue = new LinkedList<point>();
		
		queue.offer(new point(y,x));
		if(map[y][x] == 'v') {
			countV++;
		}else if(map[y][x] == 'o') {
			countO++;
		} // ���������� ���̳� ���밡 �ִ��� Ȯ��
		
		map[y][x] = '#';
		while(!queue.isEmpty()) {
			point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				if(now.x + mx[i] >= 0 && now.x + mx[i] < c && now.y + my[i] >= 0 && now.y + my[i] < r && map[now.y+my[i]][now.x+mx[i]] != '#') {
					if(map[now.y+my[i]][now.x+mx[i]] == 'v') {
						countV++;
					}else if(map[now.y+my[i]][now.x+mx[i]] == 'o') {
						countO++;
					}
					map[now.y+my[i]][now.x+mx[i]] = '#';
					queue.offer(new point(now.y+my[i],now.x+mx[i]));
				}
			}
		}// bfs�� �����ϸ鼭 ��� ������ ���� Ȯ��
		
		if(countV >= countO) {
			V += countV;
		}else {
			O += countO;
		} // ���밡 �������� ��ü �����Ǽ��� �߰�, ���� �������� ��ü ���� ���� �߰�
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		r = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] != '#') {
					bfs(i,j);
				}
			}
		}// �������� �湮�Ͽ� ���̾ƴϸ� bfs ����
		
		System.out.println(O + " "+ V);

	}

}
