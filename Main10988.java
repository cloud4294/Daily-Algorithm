import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Baekjoon Online Judge 10988�� - �Ӹ�������� Ȯ���ϱ�
 * 
 * ���ĺ� �ҹ��ڷθ� �̷���� �ܾ �־�����. �̶�, �� �ܾ �Ӹ�������� �ƴ��� Ȯ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * �Ӹ�����̶� ������ ���� ���� �Ųٷ� ���� �� �Ȱ��� �ܾ ���Ѵ�. 
 * level, noon�� �Ӹ�����̰�, baekjoon, online, judge�� �Ӹ������ �ƴϴ�.
 * 
 * 
 * 
 */

public class Main10988 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int length = input.length() / 2;
		boolean check = false;

		for (int i = 0; i < length; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				check = true;
			}
		}

		if (check == false)
			System.out.println(1);
		else
			System.out.println(0);
	}

}
