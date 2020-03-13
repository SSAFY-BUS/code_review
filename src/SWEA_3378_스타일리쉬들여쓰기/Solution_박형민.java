package SWEA_3378_스타일리쉬들여쓰기;
/**
적용 알고리즘
	완전 탐색

메모리
	42,168 KB

실행시간
	182 ms


*/
import java.util.Scanner;

public class Solution_박형민 {
	static int R,C,S,r,c,s;
	static int P,Q;
	static String[] style,mycode;
	static RCS[] rcs;
	static int[] answer;
	static boolean [] check;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			P=sc.nextInt();
			Q=sc.nextInt();
			R=C=S=r=c=s=0;
			style = new String[P];
			rcs = new RCS[P];
			mycode = new String[Q];
			answer = new int[Q];
			check = new boolean[Q];
			arr = new int[Q][3];

			for(int i=0;i<P;i++) {
				style[i] = sc.next();
			}
			for(int i = 0; i<Q;i++) {
				mycode[i] = sc.next();
			}

			stylish(0);
			r=c=s=0;
			findRCS(0);

			System.out.print("#"+test_case);
			for(int i=0;i<Q;i++) {
				System.out.print(" "+answer[i]);
			}
			System.out.println();
		}
	}
	static void stylish(int row) {
		if(row==Q) {
			return;
		}

		arr[row][0]=r;
		arr[row][1]=c;
		arr[row][2]=s;

		for(int i=0;i<mycode[row].length();i++) {
			if(mycode[row].charAt(i)=='(') {
				r++;
			}
			else if(mycode[row].charAt(i)==')') {
				r--;
			}
			else if(mycode[row].charAt(i)=='{') {
				c++;
			}
			else if(mycode[row].charAt(i)=='}') {
				c--;
			}
			else if(mycode[row].charAt(i)=='[') {
				s++;
			}
			else if(mycode[row].charAt(i)==']') {
				s--;
			}
		}

		stylish(row+1);

	}
	static void findRCS(int row) {
		int space = 0;
		int tr=r,tc=c,ts=s;
		if(row==P) {
			cal();
			return;
		}
		boolean isSpace = true;
		for(int i=0;i<style[row].length();i++) {
			if(style[row].charAt(i)=='.'&&isSpace) {
				space ++;
			}
			else if(style[row].charAt(i)=='(') {
				isSpace=false;
				r++;
			}
			else if(style[row].charAt(i)==')') {
				isSpace=false;
				r--;
			}
			else if(style[row].charAt(i)=='{') {
				isSpace=false;
				c++;
			}
			else if(style[row].charAt(i)=='}') {
				isSpace=false;
				c--;
			}
			else if(style[row].charAt(i)=='[') {
				isSpace=false;
				s++;
			}
			else if(style[row].charAt(i)==']') {
				isSpace=false;
				s--;
			}
			else {
				isSpace=false;
			}
		}
		if(space!=0) {
			int gcd = getgcd(tr,tc,ts);
		}

		rcs[row]=new RCS(tr,tc,ts,space);
		findRCS(row+1);

	}
	static int getgcd(int x,int y, int z) {
		int min = Math.min(Math.min(x, y),z);
		if(x==0) {
			if(y==0) {
				return z;
			}else if(z==0) {
				return y;
			}
			else {
				min=Math.min(y, z);
			}
		}
		else if(y==0) {
			if(z==0) {
				return x;
			}else if(x==0) {
				return z;
			}
			else {
				return getgcd(x,z);
			}
		}
		else if(z==0) {
			if(y==0) {
				return x;
			}else if(x==0) {
				return y;
			}
			else {
				return getgcd(y,x);
			}
		}
		while(true) {
			if(x%min==0&&y%min==0&&z%min==0) {
				break;
			}
			min--;
		}
		return min;
	}

	static int getgcd(int x,int y) {
		if(y>x) {
			int temp=x;
			x=y;
			y=temp;
		}
		if(y==0) {
			return x;
		}else {
			return getgcd(y,x%y);
		}
	}

	static void cal() {
		int tr,tc,ts;

		for(int x=1;x<=20;x++) {
			for(int y=1;y<=20;y++) {
				for(int z=1;z<=20;z++) {
					boolean flag=true;
					for(int i=1;i<P;i++) {
						tr = rcs[i].r;
						tc = rcs[i].c;
						ts = rcs[i].s;
						if(x*tr+y*tc+z*ts!=rcs[i].space) {
							flag=false;
							break;
						}
					}
					if(flag) {
						for(int i=0;i<Q;i++) {
							if(answer[i]<0) {
								continue;
							}
							if(!check[i]) {
								answer[i]=x*arr[i][0]+y*arr[i][1]+z*arr[i][2];
								check[i]=true;
							}
							else if(check[i]) {
								if(answer[i]!=x*arr[i][0]+y*arr[i][1]+z*arr[i][2]) {
									answer[i]=-1;
								}
							}
						}

					}

				}
			}
		}


	}

}
class RCS{
	int r;
	int c;
	int s;
	int space;
	public RCS(int r, int c, int s,int space) {
		this.r=r;
		this.c=c;
		this.s=s;
		this.space = space;

	}
	public RCS(int r, int c, int s) {
		this.r=r;
		this.c=c;
		this.s=s;
		this.space=0;
	}
}

