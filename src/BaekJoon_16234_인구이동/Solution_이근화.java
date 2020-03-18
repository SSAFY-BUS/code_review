package BaekJoon_16234_인구이동;

/**
 * 적용 알고리즘
 * 		시뮬레이션
 * 		브루트포스 / BFS
 * 
 * 메모리
 * 		280,552 kb
 * 
 * 실행시간
 * 		664 ms
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_이근화 {
	
	static class Pair {

		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	private static int N;
	private static int L;
	private static int R;
	private static int[][] arr;
	private static int[][] visited;

	private static Queue<Pair> q;
	private static Queue<Pair> country;

	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N][N];
		visited = new int[N][N];
		q = new LinkedList<>();
		country = new LinkedList<>();

		// 각 나라 인구수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		boolean flag = true;
		
		int result = -1;
		int cnt = 0;

		while (flag) { // 하루동안 인구이동
			cnt++;
			flag = false;
			result++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(visited[i][j]==cnt)
						continue;
					
					int sum = arr[i][j];
					
					visited[i][j] = cnt;
					q.offer(new Pair(i, j));
					country.offer(new Pair(i,j));
					
					// 큐가 빌 때까지
					// 한 연합 구하기
					while(!q.isEmpty()) {
						
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(!isInBound(nx, ny) || visited[nx][ny]==cnt || !isPossible(x, y, nx, ny))
								continue;
							
							flag = true;
							
							sum += arr[nx][ny];
							visited[nx][ny] = cnt;
							
							q.offer(new Pair(nx, ny));
							country.offer(new Pair(nx, ny));
							
						}
						
					} // end of while
					
					// 평균 구해서 연합했던 국가에 인구수 update
					int avg = sum/country.size();
					
					while(!country.isEmpty()) {
						Pair p = country.poll();
						arr[p.x][p.y] = avg;
					}
					

				} // end of j-for
			} // end of i-for

		} // end of while
		
		// 결과 출력
		System.out.println(result);

	} // end of main

	// 두 국가가 연합 가능한지 범위 체크
	public static boolean isPossible(int x1, int y1, int x2, int y2) {

		if(Math.abs(arr[x1][y1]-arr[x2][y2])>=L && Math.abs(arr[x1][y1]-arr[x2][y2])<=R)
			return true;
		
		else
			return false;
	}

	public static boolean isInBound(int x, int y) {

		if (x < 0 || y < 0 || x >= N || y >= N)
			return false;

		return true;
	}
}
