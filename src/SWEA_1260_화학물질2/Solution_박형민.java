package SWEA_1260_화학물질2;
/**
적용 알고리즘
	DP(Memoization), Greedy, HashSet
	Hash을 이용하여 첫번째 행렬을 찾은 뒤 가능한 행렬의 경우를 하나로 추려서 완전 탐색을 하되, (Greedy)
	Memoization을 통해 평균 시간 복잡도를 줄임.
	
메모리
	70,668 KB

실행시간
	213 ms


*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class Solution_박형민 {
	static int N;
	static int answer;
	
	static int[][] arr;
	static ArrayList<Matrix> list;
	static boolean[] b;
	static HashMap<Integer, Integer> hash;
	static int max;
	static int[][][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(isr);
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			max=0;
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			list = new ArrayList<Matrix>();
			hash = new HashMap<Integer,Integer>();
			for(int i=0;i<N;i++) {
				String[] srr =br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(srr[j]);
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]>0) {
						findMatrix(i, j);
					}
				}
			}
			
			b = new boolean[list.size()];
			Set<Integer> key = hash.keySet();
			int index=-1;
			for(int i : key) {
				if(hash.get(i)>=0) {
					index=hash.get(i);
					break;
				}
			}
			arr = new int[list.size()][2];
			int end = arr[0][1]=list.get(index).w;
			
			index=0;
			while(true) {
				if(index==list.size()-1) {
					break;
				}
				for(int i=0;i<list.size();i++) {
					if(list.get(i).h==end) {
						end=list.get(i).w;
						arr[++index][0]=list.get(i).h;
						arr[index][1]=list.get(i).w;
					}
				}
			}
			memo = new int[arr.length][max+1][max+1];
			
			getMin(arr,0);
			
			
			System.out.println("#"+test_case+" "+answer);
		}

	}
	static void getMin(int[][] temp,int val) {
		
		if(temp.length==1) {
			answer=Math.min(answer, val);
			return;
		}
		for(int i=0;i<temp.length-1;i++) {
			if(val+temp[i][0]*temp[i][1]*temp[i+1][1]<memo[temp.length-1][temp[i][0]][temp[i+1][1]]||(memo[temp.length-1][temp[i][0]][temp[i+1][1]]==0)) {
				int[][] tmp = new int[temp.length-1][2];
				for(int j=0;j<i;j++) {
					tmp[j][0]=temp[j][0];
					tmp[j][1]=temp[j][1];
				}
				tmp[i][0]=temp[i][0];
				tmp[i][1]=temp[i+1][1];
				
				for(int j=i+1;j<temp.length-1;j++) {
					tmp[j][0]=temp[j+1][0];
					tmp[j][1]=temp[j+1][1];
				}
				memo[temp.length-1][temp[i][0]][temp[i+1][1]]=val+temp[i][0]*temp[i][1]*temp[i+1][1];
				getMin(tmp, val+temp[i][0]*temp[i][1]*temp[i+1][1]);
				
			}
		}
		
	}
	
	static void findMatrix(int r, int c) {
		int nr=r,nc=c;
		int w=0,h=0;
		while(true) {
			if(nr>=N) {
				break;
			}
			if(arr[nr][c]<=0) {
				break;
			}
			nr++;
			h++;
		}
		while(true) {
			if(nc>=N) {
				break;
			}
			if(arr[r][nc]<=0) {
				break;
			}
			nc++;
			w++;
		}
		for(int i=r;i<nr;i++) {
			for(int j=c;j<nc;j++) {
				arr[i][j]=-1;
			}
		}
		max=Math.max(Math.max(w, h), max);
		hash.put(w, -1);
		hash.putIfAbsent(h, list.size());
		list.add(new Matrix(h,w));
	}

}

class Matrix {
	int h;
	int w;
	public Matrix(int h,int w) {
		this.h=h;
		this.w=w;
	}
	
}









