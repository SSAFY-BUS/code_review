package SWEA_1952_수영장;

import java.util.Scanner;

/**
 * 적용 알고리즘
 * 		(이걸 무슨 알고리즘이라고 하나..)
 * 
 * 메모리
 * 		33,680 kb
 *
 * 실행시간
 * 		172 ms
 */

public class Solution_이근화 {
	private static int minPrice;
	private static int[] fee;
	private static int[] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			fee = new int[4];
			plan = new int[13];
			
			// 이용요금
			for (int i = 0; i < fee.length; i++) {
				fee[i] = sc.nextInt();
			}
			
			// 1년 이용권 금액을 가장 적은 지출로 초기화
			minPrice = fee[3];
			
			
			// 12개월 이용 계획
			for (int i = 1; i < plan.length; i++) {
				plan[i] = sc.nextInt();
			}
			
			// 1월 요금부터 계산
			solve(1, 0);
			
			System.out.printf("#%d %d\n", tc, minPrice);
			
		} // end of testcase
		
	} // end of main

	public static void solve(int month, int price) {

		if(month>12) { // 12월까지 다 계산했으면
			minPrice = Math.min(price, minPrice);
			return;
		}
		
		if(price>minPrice)
			return;
		
		if(plan[month]==0) { // 0일 이용시, 다음 달로..
			solve(month+1, price);
			return;
		}
		
		// 1일 이용권
		solve(month+1, price + fee[0]*plan[month]);
		
		// 1달 이용권
		solve(month+1, price + fee[1]);
		
		// 3달 이용권
		solve(month+3, price + fee[2]);
		
		
	} // end of solve()
} // end of class