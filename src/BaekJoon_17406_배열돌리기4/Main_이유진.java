package BaekJoon_17406_배열돌리기4;
/**
 * 		적용 알고리즘
 * 			시뮬레이션..? 순열 이용
 * 	
 * 		메모리
 *			21,724 KB
 *		실행 시간
 *			196 ms
 *
 *		기타 사항
 *			- rot() 함수 이해는 첨부파일 참고 바람.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int r;
	int c;
	public Point() {}

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main_이유진 {

	static int N; // 행 크기
	static int M; // 열 크기
	static int K; // 회전 수
	static int[][] arr; // 배열 저장
	static int[][] rotation; // 회전 명령 저장
	static int MIN; // 최솟값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 행 크기
		M = Integer.parseInt(st.nextToken()); // 열 크기
		K = Integer.parseInt(st.nextToken()); // 회전 수
		
		// 초기 배열 저장
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new int[K][3];
		
		// 회전 저장
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			rotation[i][0] = Integer.parseInt(st.nextToken())-1; // r
			rotation[i][1] = Integer.parseInt(st.nextToken())-1; // c
			rotation[i][2] = Integer.parseInt(st.nextToken()); //s
		}
		
		MIN = Integer.MAX_VALUE;
		perm(0,0);
		
		System.out.println(MIN);
		
	} // end of main
	

	private static void perm(int cnt, int visited) {
		if(cnt==K) { // 순서가 다 정해지면
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum+=arr[i][j];
				}
				MIN = Math.min(MIN, sum); // 최솟값 찾기
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if((visited & 1<<i) == 0) {
				rot(rotation[i][0],rotation[i][1],rotation[i][2]); // 돌리기
				perm(cnt+1, visited | 1<<i);
				rerot(rotation[i][0], rotation[i][1], rotation[i][2]); // 되돌리기
			}
		}
	}
	
	
	private static void rot(int r, int c, int s) {
		for (int j = 1; j <= s; j++) {
			
			int tmp = arr[r-j][c-j];
			
			// 좌
			for (int y = r-j; y < r+j; y++) {
				arr[y][c-j] = arr[y+1][c-j];
			}
			
			// 하
			for (int x = c-j; x < c+j; x++) {
				arr[r+j][x] = arr[r+j][x+1];
			}

			// 우
			for (int y = r+j; y > r-j; y--) {
				arr[y][c+j] = arr[y-1][c+j];
			}
			
			// 상
			for (int x = c+j; x > c-j+1; x--) {
				arr[r-j][x] = arr[r-j][x-1];
			}
			arr[r-j][c-j+1] = tmp;
		}
	}
	
	private static void rerot(int r, int c, int s) {
		for (int j = 1; j <= s; j++) {
			
			int tmp = arr[r-j][c-j];

			// 상
			for (int x = c-j; x < c+j; x++) {
				arr[r-j][x] = arr[r-j][x+1];
			}
			
			// 우
			for (int y = r-j; y < r+j; y++) {
				arr[y][c+j] = arr[y+1][c+j];
			}
			
			// 하
			for (int x = c+j; x > c-j; x--) {
				arr[r+j][x] = arr[r+j][x-1];
			}
			
			// 좌
			for (int y = r+j; y > r-j+1; y--) {
				arr[y][c-j] = arr[y-1][c-j];
			}
			
			arr[r-j+1][c-j] = tmp;
		}
		
	}
} // end of class
