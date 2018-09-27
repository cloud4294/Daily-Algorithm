import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

/*
 * 
 * Baekjoon Online Judge 1793�� - Ÿ�ϸ�
 * 
 * ���� 
 * 2��n ���簢���� 2��1�� 2��2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Ʒ� �׸��� 2��17 ���簢���� ä�� �Ѱ��� ���̴�.
 * 
 * �Է� 
 * �Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, ���� 0 �� n �� 250�� �־�����. 
 * 
 * ��� 
 * �Է����� �־����� ������ n����, 2��n ���簢���� ä��� ����� ���� ����Ѵ�.
 * 
 * 
 */


public class Main1793 {

	static BigInteger[] data;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		ArrayList<BigInteger> output = new ArrayList<BigInteger>();
		while ((input = br.readLine()) != null) { // ���̻� �Է��� ������ ���� �ݺ��Ѵ�.

			int n = Integer.parseInt(input);
			data = new BigInteger[n + 1]; // ��°��� long�� ������ �Ѿ�� ������ BigInteger Ŭ������ ����Ѵ�.

			data[0] = BigInteger.ONE;
			if (n > 0) {
				data[1] = BigInteger.ONE;
			}

			int togle = 1;
			for (int i = 2; i <= n; i++) {
				if(data[i] == null) {
					data[i] = data[i - 1].multiply(BigInteger.valueOf(2));
					if (togle == 1) {
						data[i] = data[i].add(BigInteger.ONE);
						togle = -1;
					} else if (togle == -1) {
						data[i] = data[i].subtract(BigInteger.ONE);
						togle = 1;
					}
				}
			} // ��Ģ�� ã�� ���̳��� ���α׷����� �����Ѵ�. 

			output.add(data[n]);
		}
		for (int i = 0; i < output.size(); i++) {
			bw.write(output.get(i).toString()+"\n");
		}
		bw.flush();
		bw.close();
	}

}
