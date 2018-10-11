import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 *   Baekjoon Online Judge 10825번 - 국영수
 * 
 *   https://www.acmicpc.net/problem/10825
 * 
 */

public class Main10825 {

	static class student {
		String name;
		int kor;
		int eng;
		int math;

		student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

	} // student 클래스 구현

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<student> list = new ArrayList<student>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new student(name, kor, eng, math));
		}

		Collections.sort(list, new Comparator<student>() {

			public int compare(student s1, student s2) {

				if(s1.kor != s2.kor)
					return s2.kor - s1.kor; // 국어 점수 내림차순 정렬
				else if(s1.eng != s2.eng)
					return s1.eng - s2.eng; // 영어 점수 오름차순 정렬
				else if(s1.math != s2.math)
					return s2.math - s1.math; // 수학 점수 내림차순 정렬
				else 
					return s1.name.compareTo(s2.name); // 이름 알파벳순 정렬
			}

		});
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).name);
		}

	}

}
