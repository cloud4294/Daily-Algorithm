import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 		Baekjoon Online Judge 1373�� - 2���� 8����
 * 
 * 		https://www.acmicpc.net/problem/1373
 * 
 */

public class Main1373 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String num = br.readLine();
		int length = num.length();
		int current = 0;
		int bin = 1;
		StringBuilder output = new StringBuilder();
		if(num.equals("0")) {
			System.out.println(0);
			return;
		}
		

		for (int i = length - 1; i >= 0; i--) {

			current += Integer.parseInt(num.substring(i, i + 1)) * bin;
			if (bin < 4) {
				bin *= 2;
			} else {
				output.append(Integer.toString(current));
				current = 0;
				bin = 1;
			}
		} // �Է¹��� 2������ �ڿ��� ���� 3�ڸ��� �߶󳻾� 8������ ��ȯ�Ѵ�.
		if(current != 0)
			output.append(Integer.toString(current)); // ������ �ڸ����� ���Ҵٸ�  ��¿� �߰��Ѵ�.
		
		length = output.length() - 1;
		for (int i = length; i >= 0; i--) { // ����� ����� ����Ѵ�.
			bw.write(output.charAt(i));
		}
		bw.flush();
		bw.close();
		

	}

}
