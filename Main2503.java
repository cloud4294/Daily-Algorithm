import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * Baekjoon Online Judge 2503�� - ���� �߱�
 * 
 * ������ȭ����� ���� ���� ���Ƹ����� ���Ƹ� Ȱ���� �ϴ� ������ �����̴� ���� �ð��� ƴŸ ���ھ߱� ������ �ϱ�� �ߴ�.
 * ������ 1���� 9������ ���� �ٸ� ���� �� ���� ������ �� �ڸ� ���� ���������� �����Ѵ�. (��: 324)
 * �����̴� 1���� 9������ ���� �ٸ� ���� �� ���� ������ �� �ڸ� ���� �������� ���´�. (��: 123)
 * �����̰� ���� �� �ڸ� ���� �ִ� ���ڵ� �� �ϳ��� ������ �� �ڸ� ���� ������ �ڸ��� ��ġ�ϸ� ��Ʈ����ũ �� ������ ����. ���ڰ� ������ �� �ڸ� ���� �ֱ� �ϳ� �ٸ� �ڸ��� ��ġ�ϸ� �� �� ������ ����.
 * ��) ������ 324�� ���� ������ 
 * 429�� 1 ��Ʈ����ũ 1 ���̴�.
 * 241�� 0 ��Ʈ����ũ 2 ���̴�.
 * 924�� 2 ��Ʈ����ũ 0 ���̴�.
 * ������ �����̰� ���� ���� �� ��Ʈ����ũ �� �������� �����ش�.
 * �����̰� ������ �� �ڸ� ���� ��Ȯ�ϰ� ���߾� 3 ��Ʈ����ũ�� �Ǹ� ������ ������. �ƴ϶�� �����̴� ���ο� ���� ������ �ٽ� �������� ���´�.
 * ���� �����̿� ������ ������ �ϰ� �ִ� ���߿� �ִ�. �����̰� �������� � ������ ����Ҵ���, �׸��� ������ ������ ������ � ����� �ߴ����� �Է����� �־�����. �� �Է��� �������� �������� ������ �����ϰ� ���� ���ɼ��� �ִ� ���� �� �� �������� �˾Ƹ����� �Ѵ�.
 * �Ʒ��� ���� ��츦 �����غ���.  
 * ����: 123
 * ����: 1 ��Ʈ����ũ 1 ��.
 * ����: 356
 * ����: 1 ��Ʈ����ũ 0 ��.
 * ����: 327
 * ����: 2 ��Ʈ����ũ 0 ��.
 * ����: 489
 * ����: 0 ��Ʈ����ũ 1 ��.
 * �̶� ������ ���� 324�� 328, �̷��� �� �����̴�.
 * ������ ���Ƹ��� ������ �� ������ ���� ���̶� �������� ������ ���̰��� �����ϰ� ���Ѵ�. �׷��Ƿ� ������ ��鿡�� ����� ����.
 * �������� ������� ������ ������ ���� ������ ���� �Է����� �־��� �� ������ �����ϰ� ���� ���ɼ��� �ִ� ���� �� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * 
 * 
 */



public class Main2503 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] data = new String[N];
		int[] strike = new int[N];
		int[] ball = new int[N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			data[i] = input[0];
			strike[i] = Integer.parseInt(input[1]);
			ball[i] = Integer.parseInt(input[2]);
		}
		int count = 0;

		for (int i = 123; i <= 987; i++) { // ���Ʈ ����, 123���� 987���� ����� ���� �Է¹��� �� ��
			String current = Integer.toString(i);
			int check = 0;
			if (current.charAt(1) == '0' || current.charAt(2) == '0' || current.charAt(0) == current.charAt(1)
					|| current.charAt(1) == current.charAt(2) || current.charAt(0) == current.charAt(2)) // 0�� ���Ե� ���� ���ڸ��� �ߺ��� ���� ���� ��� ���� 
				continue;
			else {
				for (int j = 0; j < N; j++) {
					int countstrike = 0;
					int countball = 0;
					for (int j2 = 0; j2 < data[j].length(); j2++) {
						if (data[j].charAt(j2) == current.charAt(j2))
							countstrike++;
						else if (data[j].contains(current.substring(j2, j2 + 1)))
							countball++;	
					}
					if (countstrike == strike[j] && countball == ball[j])
						check++; // �Է¹��� ���� ���Ͽ� strike�� ball�� ������ ��ġ�ϴ��� Ȯ��
				}
			}

			if (check == N) {
				count++; // N���� �Է°��� strike, ball ������ ��� ��ġ�ϸ� ���� ����Ǽ� 1����
			}

		}

		System.out.println(count);

	}

}
