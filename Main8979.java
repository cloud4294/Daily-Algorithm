import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 8979번 - 올림픽
 * 
 * https://www.acmicpc.net/problem/8979
 * 
 */

public class Main8979 {

	static class country {
		int gold;
		int silver;
		int bronze;

		country(int gold, int silver, int bronze) {
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		country[] data = new country[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			data[num] = new country(gold,silver,bronze);		
		}
		
		int rank = 1;
		for (int i = 1; i <= N; i++) {
			if(data[i].gold>data[K].gold)
				rank++;
			else if(data[i].gold == data[K].gold && data[i].silver > data[K].silver)
				rank++;
			else if(data[i].gold == data[K].gold && data[i].silver == data[K].silver && data[i].bronze > data[K].bronze)
				rank++;
		}
		
		System.out.println(rank);
		
		
	}

}
