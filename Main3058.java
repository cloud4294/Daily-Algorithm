import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *    Baekjoon Online Judge 3058¹ø - Â¦¼ö¸¦ Ã£¾Æ¶ó
 * 
 *    https://www.acmicpc.net/problem/3058
 */

public class Main3058 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split(" ");
			int[] data = new int[7];
			for (int j = 0; j < 7; j++) {
				data[j] = Integer.parseInt(input[j]);
			}
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int j = 0; j < 7; j++) {
				if(data[j] % 2 ==0) { // Â¦¼ö¸¦ °ñ¶ó³¿
					sum += data[j];
					if(data[j] < min)
						min = data[j]; //ÃÖ¼Ò°ªÀ» Ã£À½
				}
			}
			
			System.out.println(sum +" " + min);
		}

	}

}
