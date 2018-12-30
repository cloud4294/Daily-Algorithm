import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 5021번 - 왕위 계승
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
		} // 문자열을 입력받아 왕족리스트에서 객체를 찾음 
		if (son.equals(king)) {
			return 1.0; // 해당 노드가 왕의 이름을 가지면 순혈이므로 1을 리턴 
		} else if (s == null) {
			return 0.0; // 부모가 더이상 없으면 0을 리턴
		}

		return (solve(s.f) + solve(s.m)) / 2.0; // 재귀적으로 부모를 찾음 

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

		} // 초기 왕족 리스트 구성

		for (int i = 0; i < M; i++) {
			String find = br.readLine();

			double rank = solve(find); 
			if(rank > max) {
				max = rank;
				output = find;
			}
		} // 최대값 저장

		System.out.println(output);
	}

}
