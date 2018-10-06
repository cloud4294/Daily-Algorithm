import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 
 * Baekjoon Online Judge 10799�� - �踷���
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
				if(stack.lastElement() == i - 1) {// ��ȣ�� ������ ������ �������� ���� ���� �踷��Ⱑ �߸�
					stack.pop();
					sum += stack.size();
				}else { // ��ȣ�� ������ ���� �ʴٸ� �踷��Ⱑ ���Ϸ� �߸�
					sum += 1;
					stack.pop();
				}
				
			}
		}
		
		System.out.println(sum);
	}

}
