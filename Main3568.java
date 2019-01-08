import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 		Baekjoon Online Judge 3568번 - iSharp
 * 
 * 		https://www.acmicpc.net/problem/3568
 */

public class Main3568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 공백을 기준으로 잘라냄
		int size = st.countTokens();
		String[] str = new String[size];
		
		for (int i = 0; i < size; i++) {
			str[i] = (st.nextToken().replaceAll(",", "")).replaceAll(";", "");
		} // 잘라낸 문자열에서 ","와 ";"를 제거함 

		for (int i = 1; i < size; i++) {
			String output = str[0]; // 기본변수형 
			Deque<Character> deque = new ArrayDeque<>();
			
			for (int j = 0; j < str[i].length(); j++) {
				deque.offer(str[i].charAt(j));
			} // 각 문자열을 데크에 넣음 
			
			while(!deque.isEmpty()) {
				char now = deque.getLast(); 
				if(!Character.isAlphabetic(now)) { // 데크의 마지막 문자가 알파벳이 아니면 
					String push =  String.valueOf(deque.removeLast());
					if(push.equals("["))
						push = "]";
					else if(push.equals("]"))
						push = "["; // [] 짝을 맞추기 위해 뒤집어줌 
					output += push; // 데크의 뒤부터 출력에 추가 
				}else {
					output += " ";
					while(!deque.isEmpty()) {
						output += deque.removeFirst(); // 출력에 공백을 추가한후 데크의 앞부터 추가
					}
				}
			}
			output += ";";
			
			System.out.println(output);
		}
	}

}
