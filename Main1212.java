import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 		Baekjoon Online Judge 1212번 - 8진수 2진수
 * 
 * 		https://www.acmicpc.net/problem/1212
 * 
 */

public class Main1212 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String data = br.readLine();
		int length = data.length();
		
		if(data.equals("0")) {
		
			System.out.println(0);
			return;
		} 
		
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			if(data.charAt(i) == '0') {
				sb.append("000");
			}else if(data.charAt(i)== '1') {
				sb.append("001");
			}else if(data.charAt(i)== '2') {
				sb.append("010");
			}else if(data.charAt(i)== '3') {
				sb.append("011");
			}else if(data.charAt(i)== '4') {
				sb.append("100");
			}else if(data.charAt(i)== '5') {
				sb.append("101");
			}else if(data.charAt(i)== '6') {
				sb.append("110");
			}else if(data.charAt(i)== '7') {
				sb.append("111");
			}
		} // 각 자리에 해당하는 이진수로 변환
		String output = sb.toString();
		int k = 0;
		while(output.charAt(k) == '0') {
			k++;
		} // 앞자리가 0인경우 시작지점을 밀어냄
	
		length = output.length();
		for (int i = k; i < length; i++) {
			bw.write(output.charAt(i));
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
