package SWEA_4012_모의요리사;

/**
 * 적용 알고리즘
 * 		
 * 
 * 메모리
 * 		28,208 kb
 * 
 * 실행시간
 * 		515 ms
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_이근화 {
	
	
	private static int N;
	private static int[][] s;
	private static int minDiff;
	private static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			minDiff = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			s = new int[N+1][N+1];
			
			check = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve(1, 0);
			
			sb.append('#').append(tc).append(' ').append(minDiff).append('\n');
			
		} // end of tc
		
		System.out.println(sb);
	} // end of main

	public static void solve(int index, int cnt) {
		
		if(cnt==N/2) {
			int diff = calcTasteDiff();
			
			minDiff = diff<minDiff ? diff : minDiff;
		}
		
		if(index>N || cnt>N/2)
			return;

		
		// A음식에 포함
		check[index] = true;
		solve(index+1, cnt+1);
		
		
		check[index] = false;
		// A음식에 미포함(==B음식에 포함)
		solve(index+1, cnt);
		
	} // end of solve()

	public static int calcTasteDiff() {

		int aTaste = 0;
		int bTaste = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				
				if(i==j)
					continue;
				
				if(check[i] && check[i]==check[j]) {
					aTaste += s[i][j];
				}
				
				else if(!check[i] && check[i]==check[j]) {
					bTaste += s[i][j];
				}
				
			}
		} // end of i-for
		
		return Math.abs(aTaste-bTaste);
	}

}
