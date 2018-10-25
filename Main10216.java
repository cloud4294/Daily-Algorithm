import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *   Baekjoon Online Judge 10216�� - Count Circle Groups
 * 
 *   https://www.acmicpc.net/problem/10216
 * 
 */

public class Main10216 {
	
	static class point{
		int x;
		int y;
		int r;
		boolean check;
		ArrayList<point> adj;
		point(int x,int y,int r){
			this.x = x;
			this.y = y;
			this.r = r;
			this.check = false;
			this.adj = new ArrayList<point>();
		}
		
	} // �� ������ ��ġ������ �ݰ�,�湮 ����, ��Ű����� ������ Ŭ������ ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			ArrayList<point> P = new ArrayList<point>();
			for (int j = 0; j < N; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int r = sc.nextInt();
				point now = new point(x,y,r);
				for (int k = 0; k < P.size(); k++) {
					if(Math.sqrt((now.x - P.get(k).x) * (now.x - P.get(k).x) + (now.y - P.get(k).y) * (now.y - P.get(k).y)) <= now.r + P.get(k).r ) {
						P.get(k).adj.add(now);
						now.adj.add(P.get(k));
					}
				}// ���ο� ������ ���������� ���ᰡ���ϸ� ����Ʈ�� �߰� 
				P.add(now);
			}
			int count = 0;
			
			
			for (int j = 0; j < P.size(); j++) { 
				
				if(P.get(j).check == false) { // �湮���� ���� ��� ������ �湮
					Queue<point> queue = new LinkedList<point>();
					queue.offer(P.get(j));
					P.get(j).check = true;
					while(!queue.isEmpty()) {
						point now = queue.poll();
						for (int k = 0; k < now.adj.size(); k++) {
							if(now.adj.get(k).check == false) {
								now.adj.get(k).check = true;
								queue.offer(now.adj.get(k));
							}
						}
					} // bfs�� ����� ��������� �湮
					count++;
				}
			}
			
			System.out.println(count);
		}
	}

}
