import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


/*
 * Baekjoon Online Judge 11003번 - 최솟값 찾기
 * 
 * 
 * 문제 
 * N개의 수 A1, A2, ..., AN과 L이 주어진다.
 * Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 * 
 * 입력 
 * 첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
 * 둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
 * 
 * 출력 
 * 첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
 * 
 */



public class Main11003 {
	static class data {
		int data;
		int idx;

		data(int data, int idx) {
			this.data = data;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		Deque<data> window = new ArrayDeque<data>();
		data[] current = new data[N];
		int[] output = new int[N];
		for (int i = 0; i < N; i++) {
			current[i] = new data(Integer.parseInt(st.nextToken()), i);
		}

		for (int i = 0; i < N; i++) {

			if (!window.isEmpty() && i - window.peekFirst().idx >= L) {
				window.remove();
			} // 데크의 첫번째 값이 윈도우 사이즈에 벗어나면 제거

			while (!window.isEmpty() && window.peekLast().data >= current[i].data) {
				window.removeLast();
			} // 데크의 마지막 값이 현재값보다 크거나 같으면 제거

			window.addLast(current[i]); // 데크에 현재 값 추가

			output[i] = window.peekFirst().data;
		}

		for (int i = 0; i < output.length; i++) {
			bw.write(output[i] + " ");
		}
		bw.flush();
		bw.close();
	}

}
