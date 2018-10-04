import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 2501번 - 약수 구하기
 * 
 * https://www.acmicpc.net/problem/2501
 * 
 */

public class Main2501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> count = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			if(N % i == 0)
				count.add(i);
		}
		
		if(K > count.size()) {
			System.out.println(0);
		}else {
			System.out.println(count.get(K-1));
		}
	
		
	}

}
