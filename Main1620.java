import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 *   Baekjoon Online Judge 1620번 - 나는야 포켓몬 마스터 이다솜
 * 
 * 	 https://www.acmicpc.net/problem/1620
 * 
 */

public class Main1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		String[] poket = new String[N+1];		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for (int i = 1; i <= N; i++) {
			poket[i] = br.readLine();
			map.put(poket[i], i);
		}
		
		for (int i = 0; i < M; i++) {
			String data = br.readLine();
			if(data.charAt(0) >= 65 && data.charAt(0) <= 90) {	
				System.out.println(map.get(data)); // 해쉬맵을 사용하여 문자열을 입력받았을때는 문자열에 해당하는 순서인 키값 출력
			}else {
				int k = Integer.parseInt(data);
				System.out.println(poket[k]); // 숫자를 입력받았을때는 String배열의 해당 문자열을 출력
			}
		}
		
	}

}
