import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * Baekjoon Online Judge 1406번 - 에디터
 * 
 * https://www.acmicpc.net/problem/1406
 * 
 */

public class Main1406 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> Lstack = new Stack<Character>();
		Stack<Character> Rstack = new Stack<Character>();
		int length = input.length();
		for (int i = 0; i < length; i++) {
			Lstack.push(input.charAt(i));
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			if (data.charAt(0) == 'P')
				Lstack.push(data.charAt(2));
			else if (data.charAt(0) == 'L' && !Lstack.isEmpty())
				Rstack.push(Lstack.pop());
			else if (data.charAt(0) == 'D' && !Rstack.isEmpty())
				Lstack.push(Rstack.pop());
			else if (data.charAt(0) == 'B' && !Lstack.isEmpty())
				Lstack.pop();

		} // 커서를 기준으로 왼쪽 스택과 오른쪽 스택으로 나누어 명령을 수행한다.

		while (!Lstack.isEmpty()) {
			Rstack.push(Lstack.pop());
		}

		while (!Rstack.isEmpty()) {
			System.out.print(Rstack.pop());
		}

	}

}
