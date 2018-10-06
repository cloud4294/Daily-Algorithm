import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 
 * Baekjoon Online Judge 10799번 - 쇠막대기
 * 
 * https://www.acmicpc.net/problem/10799
 * 
 */

public class Main10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data = br.readLine();
		Stack<Integer> stack = new Stack<Integer>();
		
		
		int length = data.length();
		int sum = 0;
		
		for (int i = 0; i < length; i++) {
			if(data.charAt(i) == '(')
				stack.push(i);
			else if(data.charAt(i)== ')') {
				if(stack.lastElement() == i - 1) {// 괄호가 인접해 있으면 레이저에 의해 남은 쇠막대기가 잘림
					stack.pop();
					sum += stack.size();
				}else { // 괄호가 인접해 있지 않다면 쇠막대기가 단일로 잘림
					sum += 1;
					stack.pop();
				}
				
			}
		}
		
		System.out.println(sum);
	}

}
