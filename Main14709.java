import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 		Baekjoon Online Judge 14709번 - 여우 사인
 * 
 * 		https://www.acmicpc.net/problem/14709
 * 
 */

public class Main14709 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer>[] list = new ArrayList[6];
		list[1] = new ArrayList<Integer>();
		list[3] = new ArrayList<Integer>();
		list[4] = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 2 || a == 5) {
				System.out.println("Woof-meow-tweet-squeek");
				return;
			}
			
			if(b == 2 || b == 5) {
				System.out.println("Woof-meow-tweet-squeek");
				return;
			}
			list[a].add(b);
			list[b].add(a);
		
		}// 2번 5번은 제외, 1-3, 1-4, 3-4 가되야되므로 list를 이용하여 구현
		
		if(list[1].contains(3) && list[1].contains(4) && list[3].contains(1) && list[3].contains(4) && list[4].contains(3) && list[4].contains(1))
			System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
		else 
			System.out.println("Woof-meow-tweet-squeek");
				
		
	}

}
