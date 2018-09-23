import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 10988번 - 팰린드롬인지 확인하기
 * 
 * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
 * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 
 * level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.
 * 
 * 
 * 
 */

public class Main10988 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int length = input.length() / 2;
		boolean check = false;

		for (int i = 0; i < length; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				check = true;
			}
		}

		if (check == false)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
