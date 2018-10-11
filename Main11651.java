import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 	 Baekjoon Online Judge 11651�� - ��ǥ �����ϱ�2	
 * 
 *   https://www.acmicpc.net/problem/11651
 * 
 */

public class Main11651 {

	static class point {
		int x;
		int y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	} // ��ǥ Ŭ���� ����

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<point> list = new ArrayList<point>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			list.add(new point(x,y));
		}
		
		Collections.sort(list, new Comparator<point>() { // �͸�Ŭ������ ����Ͽ� ����

			@Override
			public int compare(point p1, point p2) {
				if(p1.y > p2.y) {
					return 1; // ����̸� �ڸ��ٲ�O
				}else if(p1.y == p2.y ) {
					if(p1.x > p2.x)
						return 1;
					else 
						return -1;
				}else {
					return -1; // �����̸� �ڸ��ٲ�X
				}
			}
			
			
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).x +" " + list.get(i).y);
		}
		
	}

}
