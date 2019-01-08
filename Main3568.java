import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 3568�� - iSharp
 * 
 * 		https://www.acmicpc.net/problem/3568
 */

public class Main3568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // ���ڿ��� ������ �������� �߶�
		int size = st.countTokens();
		String[] str = new String[size];
		
		for (int i = 0; i < size; i++) {
			str[i] = (st.nextToken().replaceAll(",", "")).replaceAll(";", "");
		} // �߶� ���ڿ����� ","�� ";"�� ������ 

		for (int i = 1; i < size; i++) {
			String output = str[0]; // �⺻������ 
			Deque<Character> deque = new ArrayDeque<>();
			
			for (int j = 0; j < str[i].length(); j++) {
				deque.offer(str[i].charAt(j));
			} // �� ���ڿ��� ��ũ�� ���� 
			
			while(!deque.isEmpty()) {
				char now = deque.getLast(); 
				if(!Character.isAlphabetic(now)) { // ��ũ�� ������ ���ڰ� ���ĺ��� �ƴϸ� 
					String push =  String.valueOf(deque.removeLast());
					if(push.equals("["))
						push = "]";
					else if(push.equals("]"))
						push = "["; // [] ¦�� ���߱� ���� �������� 
					output += push; // ��ũ�� �ں��� ��¿� �߰� 
				}else {
					output += " ";
					while(!deque.isEmpty()) {
						output += deque.removeFirst(); // ��¿� ������ �߰����� ��ũ�� �պ��� �߰�
					}
				}
			}
			output += ";";
			
			System.out.println(output);
		}
	}

}
