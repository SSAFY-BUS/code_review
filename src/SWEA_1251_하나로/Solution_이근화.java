package SWEA_1251_하나로;

/**
 * 적용 알고리즘
 * 		시뮬레이션
 * 		브루트포스 / BFS
 * 
 * 메모리
 * 		107,320 kb
 * 
 * 실행시간
 * 		784 ms
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution_이근화 {
	private static int N;
	private static double E;
	
	private static int[] x;
	private static int[] y;
	
	private static Object result;
	private static int[] p;
	private static int[] rank;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt(); // 섬 갯수
			
			x = new int[N];
			y = new int[N];
			
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}
			
			
			E = sc.nextDouble(); // 세율
			
			int size = (N*(N-1))/2; // 간선 수
			
			Island[] island = new Island[size];
			
			int cntSize = 0;
			
			// 간선 수 어차피 (N*(N-1))/2 개 
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					
					double len = calcLen(x[i], y[i], x[j], y[j]);
					
					island[cntSize++] = new Island(i, j, len);
				}
			} // end of for
			
			
			p = new int[N];
			rank = new int[p.length];
			
			Arrays.sort(island);
			
			for (int i = 0; i < p.length; i++) {
				makeSet(i);
			}
			
			int cnt = 0;
			double MST = 0.0;
			
			// 가중치가 최소인 간선을 선택 : N-1
			for (int i = 0; i < size; i++) {
				Island is = island[i];
				
				int px = findSet(is.is_1);
				int py = findSet(is.is_2);
				
				if(px!=py) {
					union(px,py);
					cnt++;
					MST += is.val;
					
					if(cnt==N-1)
						break;
				}
				
			}
			
			result = E*MST;
			
			System.out.printf("#%d %.0f\n", tc, result);
		} // end of tc
		
	} // end of main
	
	
	public static void union(int px, int py) {

		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;

			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	} // end of union()

	public static int findSet(int x) {
		if(p[x]!=x)
			return findSet(p[x]);
		
		return p[x];
	}

	private static void makeSet(int x) {
		p[x] = x;
	}

	public static double calcLen(int x1, int y1, int x2, int y2) {
		
		double result;
		
		result = (double)(Math.pow(Math.abs(x1-x2), 2)+Math.pow(Math.abs(y1-y2), 2));
		
		return result;
	}

	public static class Island implements Comparable<Island> {

		int is_1;
		int is_2;
		double val;
		
		public Island() {
		}

		public Island(int is_1, int is_2, double val) {
			this.is_1 = is_1;
			this.is_2 = is_2;
			this.val = val;
		}
		
		@Override
		public int compareTo(Island o) {
			return (int)(this.val-o.val);
		}
		
	} // end of Island{}

}
