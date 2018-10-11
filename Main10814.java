import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *   Baekjoon Online Judge 10841번 - 나이순 정렬
 * 
 *   https://www.acmicpc.net/problem/10814
 * 
 */

public class Main10814 {

	static class customer {
		int age;
		String name;
		int order;

		customer(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;

		}
		
		public String toString() {
			return this.age + " " + this.name;
		}
	} // 고객 데이터 클래스 구현

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<customer> list = new ArrayList<customer>();
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			String name = input[1];
			list.add(new customer(age,name,i));
		}
		
		Collections.sort(list,new Comparator<customer>(){ 
			
			public int compare(customer c1,customer c2){
				
				if(c1.age > c2.age) // 나이순 오름차순 정렬
					return 1;
				else if(c1.age == c2.age) {
					if(c1.order > c2.order) // 나이가 같을때 순서별로 오름차순 정렬
						return 1;
					else 
						return -1;
				}
				else 
					return -1;
				
			}
			
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
