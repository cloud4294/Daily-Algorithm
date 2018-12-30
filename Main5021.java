import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 5021�� - ���� ���
 * 	
 * 		https://www.acmicpc.net/problem/5021
 */


public class Main5021 {

	static String king;
	static List<blood> blist;

	static class blood {
		String name;
		String f;
		String m;

		public blood(String name, String f, String m) {
			super();
			this.name = name;
			this.f = f;
			this.m = m;
		}
	}

	public static double solve(String son) {

		blood s = null;
		for (int i = 0; i < blist.size(); i++) {
			if (blist.get(i).name.equals(son)) {
				s = blist.get(i);
			}
		} // ���ڿ��� �Է¹޾� ��������Ʈ���� ��ü�� ã�� 
		if (son.equals(king)) {
			return 1.0; // �ش� ��尡 ���� �̸��� ������ �����̹Ƿ� 1�� ���� 
		} else if (s == null) {
			return 0.0; // �θ� ���̻� ������ 0�� ����
		}

		return (solve(s.f) + solve(s.m)) / 2.0; // ��������� �θ� ã�� 

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double max = 0.0;
		String output = null;
		
		king = br.readLine();
		blist = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			blist.add(new blood(st.nextToken(), st.nextToken(), st.nextToken()));

		} // �ʱ� ���� ����Ʈ ����

		for (int i = 0; i < M; i++) {
			String find = br.readLine();

			double rank = solve(find); 
			if(rank > max) {
				max = rank;
				output = find;
			}
		} // �ִ밪 ����

		System.out.println(output);
	}

}
