import java.io.IOException;
import java.util.Scanner;
/**
 * 적용 알고리즘
 * 
 * 
 * 메모리
 * 			54,734 kb
 * 
 * 실행시간
 *			241 ms
 *
 */
public class Solution_SWEA_4012_요리사 {
	
	static int n; // 식재료 개수
	static int[][] arr; // 식재료 시너지
	static int min; // 두 음식 간의 맛의 최소 차이
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			
			arr = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			min = Integer.MAX_VALUE;
			
			comb(0, new int[n/2], new boolean[n], 0); // n/2개의 조합
			
			System.out.println("#" + tc + " " + min);
		} // end of tc
	}

	// 조합 구하기
	private static void comb(int r, int[] use, boolean[] v, int idx) {
		if(r == n/2) {
			cal(use, v); // 조합을 가지고 계산
		} else {
			for (int i = idx; i < n; i++) {
				if(!v[i]) {
					use[r] = i;
					
					v[i] = true;
					
					comb(r + 1, use, v, i + 1);
					v[i] = false;
				}
			}
		}
	}

	private static void cal(int[] use, boolean[] v) {
		int[] remain = new int[n/2]; // 조합으로 구해진 use에 해당하지 않은 나머지 식재료들
		int idx = 0;
		
		for (int i = 0; i < v.length; i++) {
			if(!v[i]) remain[idx++] = i;
		}
		
		int usum = 0;
		int rsum = 0;
		
		for (int i = 0; i < use.length; i++) {
			for (int j = 0; j < use.length; j++) {
				if(i == j) continue;
				
				usum += arr[use[i]][use[j]];
				rsum += arr[remain[i]][remain[j]];
			}
		}
		
		min = Math.min(min, Math.abs(usum - rsum));
		
	}
}
