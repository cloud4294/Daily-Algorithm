import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 		Baekjoon Online Judge 10989번 - 수 정렬하기 3
 * 
 * 		https://www.acmicpc.net/problem/10989
 */


public class Main10989 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//BufferedReader,Writer로 빠른 입출력 가능, 제한시간에 걸리지 않음
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}

}
