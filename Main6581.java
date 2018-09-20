import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 6581�� - HTML
 * ������ <br>, <hr> �±׿� �� �� �����θ� �־����� HTML ������ ���� ��, �� ����� �����ִ� �ڵ带 �ۼ��Ͻÿ�.
 * �� �ٿ��� 80�ں��� ���� ���ڰ� ��µǾ�� �� �ȴ�.
 */


public class Main6581 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input;
		int length = 0;
		Queue<String> queue = new LinkedList<String>();

		while ((input = br.readLine()) != null) {

			String[] current = input.split(" |	");
			for (int i = 0; i < current.length; i++) {
				if (current[i].length() == 0) {
					continue;
				}
				if (current[i].equals("<br>")) {
					queue.offer("\n");
					length = 0;
				} else if (current[i].equals("<hr>")) {
					if (length != 0) {
						length = 0;
						queue.offer("\n");
					}
					queue.offer("--------------------------------------------------------------------------------\n");

				} else if (!current[i].equals("")) {

					if (length + current[i].length() <= 80) {
						length += current[i].length();
					} else {
						length = current[i].length();
						queue.offer("\n");
					}
					queue.offer(current[i]);
					if (length < 80)
						queue.offer(" ");
					length++;
				}
			}
		}

		for (String out : queue) {
			bw.write(out);
		}
		bw.write("\n");
		bw.flush();
		bw.close();

	}
}
