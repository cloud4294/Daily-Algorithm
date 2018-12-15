import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 		Baekjoon Online Judge 11656번 - 접미사 배열
 * 	
 * 		https://www.acmicpc.net/problem/11656
 */


public class Main11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] sub = new String[input.length()];
		
		for (int i = 0; i < input.length(); i++) {
			sub[i] = input.substring(i, input.length());
		}// 앞에서 잘라나가면서 배열에 저장
		
		Arrays.sort(sub); // 배열을 정렬후 출력
		for (int i = 0;i < sub.length; i++) {
			System.out.println(sub[i]);
		}
		
	}

}
