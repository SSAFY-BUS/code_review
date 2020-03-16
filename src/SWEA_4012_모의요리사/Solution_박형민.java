package SWEA_4012_모의요리사;
/**
적용 알고리즘
	DP

메모리
	42,328 KB

실행시간
	198 ms


*/
import java.util.Scanner;

public class Solution_박형민 {
	static int N,answer,total;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int test_case = 1; test_case<=TC; test_case++) {
			N = sc.nextInt();
			answer = Integer.MAX_VALUE;
			total=0;
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
					total += arr[i][j];
				}
			}
			int[] a = new int[N/2];
			dp(0,0,a);
			System.out.println("#"+test_case+" "+answer);
			
		}

	}
	
	static void dp(int index, int count,int[] a) {
		if(index>=N) {
			return;
		}
		if(count==N/2) {
			int score=getScore(a);
			if(score<0) {
				score=-score;
			}
			answer = Math.min(answer, score);
			return;
		}
		dp(index+1,count,a);
		a[count]=index;
		dp(index+1,count+1,a);
	}
	
	static int getScore(int[] a) {
		int temp = total;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N/2;j++) {
				temp-=arr[i][a[j]];
				temp-=arr[a[j]][i];
			}
		}
		
		return temp;
	}
}

