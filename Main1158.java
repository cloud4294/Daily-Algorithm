import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 		Baekjoon Online Judge 1158�� - �����۽� ����
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
			if(k < m- 1) { // m��°�� �Ǳ������� ť���� ������ �ٽ� ť�� �ִ´�.
				int now = queue.poll();
				queue.offer(now);
				k++; 
			}else { // m��° ���� ť���� ���� ����Ѵ�.
				k = 0;
				
				String str = (queue.size() != 1) ? queue.poll()+", " : queue.poll()+""; 
					
				System.out.print(str);
			}
				
			
			
		}
		
		System.out.println(">");
	}

}
