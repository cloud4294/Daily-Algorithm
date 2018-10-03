import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon Online Judge 2858¹ø - ±â¼÷»ç ¹Ù´Ú
 * 
 * https://www.acmicpc.net/problem/2858
 * 
 */

public class Main2858 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int outputX = 0;
		int outputY = 0;
		
		for (int i = 3; i < B + R; i++) {
			int y = i;
			int x = (int) ((B + R) / (int) i);	
			if (((x - 2) * (y - 2)) == B) {
				outputX = x;
				outputY = y;
				break;
			}

		}
		
		if(outputX > outputY)
			System.out.println(outputX +" "+ outputY);
		else
			System.out.println(outputY +" "+ outputX);
	}

}
