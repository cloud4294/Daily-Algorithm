import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *    Baekjoon Online Judge 2698�� - ������ ��Ʈ�� ����
 * 
 * 	  https://www.acmicpc.net/problem/2386	
 * 
 */


public class Main2386 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String[] input = br.readLine().split(" ");

			if (input[0].equals("#"))
				return; // ù��° ���ڰ� #�̸� ����
			else {
				char alpha = input[0].toUpperCase().charAt(0);
				int count = 0;
				for (int i = 1; i < input.length; i++) {
					input[i] = input[i].toUpperCase();
					for (int j = 0; j < input[i].length(); j++) {
						if (input[i].charAt(j) == alpha)
							count++;
					}
				}
				System.out.println(input[0] + " " + count);

			} // �Է¹��� ���� ��� �빮�ڷ� �ٲ۵� ���� ���Ѵ�. 

		}

	}

}
