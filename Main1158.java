import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 		Baekjoon Online Judge 1158번 - 조세퍼스 문제
 * 
 * 		https://www.acmicpc.net/problem/1158
 */


public class Main1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		int k = 0;
		System.out.print("<");
		while(!queue.isEmpty()) {
			if(k < m- 1) { // m번째가 되기전까지 큐에서 뺀것을 다시 큐에 넣는다.
				int now = queue.poll();
				queue.offer(now);
				k++; 
			}else { // m번째 수를 큐에서 빼고 출력한다.
				k = 0;
				
				String str = (queue.size() != 1) ? queue.poll()+", " : queue.poll()+""; 
					
				System.out.print(str);
			}
				
			
			
		}
		
		System.out.println(">");
	}

}
