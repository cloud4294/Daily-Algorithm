import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * 		Baekjoon Online Judge 2698�� - ������ ��Ʈ�� ����
 * 
 * 		https://www.acmicpc.net/problem/11728
 */


public class Main11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		int[] B = new int[M+1];
		int[] output = new int[N+M];
		A[N] = Integer.MAX_VALUE;
		B[M] = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		} // �迭 A �ʱ�ȭ 
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		} // �迭 B �ʱ�ȭ 
		
		int pa = 0;
		int pb = 0;
		
		for (int i = 0; i < N+M; i++) {
			if(A[pa] <= B[pb]) {
				output[i] = A[pa];
				pa++;
			}else {
				output[i] = B[pb];
				pb++;
			}
		} // �ι迭�� ���Ͽ� ���� ���� �� �迭�� �ְ� ���� �迭�� �ε����� ��������
		
		for (int i = 0; i < output.length; i++) {
			bw.write(output[i]+" ");
		}
		bw.flush();
		bw.close();
	}

}
