import java.util.Scanner;

/*
 *    Baekjoon Online Judge 2530번 - 인공지능 시계
 * 
 *    https://www.acmicpc.net/problem/2530
 */

public class Main2530 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int time = sc.nextInt();
		
		int ah = (time / 3600) % 24; // 24시간을 넘게 더하는 경우도 있기 때문에 24로나눈 나머지를 더함
		time = time % 3600;
		int am = time / 60;
		time = time % 60;
		int as = time ;
		
		if(s + as >= 60) {
			am++;
			s = s + as - 60;
		}else {
			s += as;
		} // 초단위를 계산하여 60초이상이면 분단위를 올림
		
		if(m + am >= 60) {
			ah++;
			m = m + am - 60;
		}else {
			m += am;
		} // 분단위 계산
		
		if(h + ah >= 24) {
			
			h = h + ah - 24;
		}else {
			h += ah;
		} //시간 단위 계산
		
		System.out.println(h +" "+ m +" "+ s);

	}

}
