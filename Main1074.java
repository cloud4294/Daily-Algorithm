import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 1074번 - Z
 * 
 * 문제 
 * 한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
 * 
 * 만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.
 * 다음 예는 2^2 * 2^2 크기의 배열을 방문한 순서이다.
 * 
 * N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
 * 다음 그림은 N=3일 때의 예이다.
 * 
 * 입력 
 * 첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다
 * 
 * 출력 
 * 첫째 줄에 문제의 정답을 출력한다.
 * 
 * 
 */


public class Main1074 {

	static long count;
	static int r;
	static int c;

	static long solve(int n, int i, int j) {

		if (i == r && j == c) {
			count += 0;
			return count;
		} else if (i == r && j + 1 == c) {
			count += 1;
			return count;
		} else if (i + 1 == r && j == c) {
			count += 2;
			return count;
		} else if (i + 1 == r && j + 1 == c) {
			count += 3;
			return count;
		} else {
			int power = (int) Math.pow(2, n - 1); //배열의 크기가 n일때 타일 묶음의 간격
			int area = power * power;	// 타일 묶음의 전체 갯수
			if (r < i + power && c < j + power)
				return solve(n - 1, i, j);
			else if (r < i + power) {
				count += area;
				return solve(n - 1, i, power + j);
			} else if (c < j + power) {
				count += area * 2;
				return solve(n - 1, power + i, j);
			} else {
				count += area * 3;
				return solve(n - 1, power + i, power + j);
			}	// 전체를 모두 탐색하면 메모리 초과가 발생하기 때문에 찾는 위치의 타일을 재귀적으로 탐색

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		count = 0;

		System.out.println(solve(N, 0, 0));
	}

}
