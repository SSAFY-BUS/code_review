package SWEA_9325_백화점;
/**
	[미구현]
	시간 초과가 뜸.. ㅠㅠ
 */

import java.util.Scanner;

public class Solution_박형민 {
	static int N,D,answer;
	static long P;
	static int[] a;
	static int[] sub;
	static long prevSum,prevDiscount;
	static int prevIndex;
	static int dis;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			P = sc.nextLong();
			D = sc.nextInt();
			answer=D;
			dis=0;
			a = new int[N];
			sub = new int[N-D];
			for(int i=0;i<N;i++) {
				a[i] = sc.nextInt();
			}
			
			if(N>D) {
				for(int i=0;i<sub.length;i++) {
					for(int j=0;j<D;j++) {
						sub[i]+=a[i+j];
					}
				}
				
				prevIndex=D;
				prevDiscount=sub[0];
				for(int i=0;i<D;i++) {
					prevDiscount=Math.min(prevDiscount, sub[i]);
				}
				prevSum=sub[0];
				for(int i=0;i<N-D;i++) {
					if(i+answer>=N-1||prevIndex>=N-1) {
						break;
					}
					cal(i,prevIndex,prevSum+a[prevIndex],prevDiscount,prevIndex-i+1);
				}
				
			}
			else {
				answer = N;
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void cal(int start,int index, long sum, long discount,int count) {
		if(index>=N) {
			return;
		}
		
		if(index<N-D&&discount<sub[index]) {
			dis=index;
			discount = sub[index];
		}
		if(P<sum-discount) {
			answer = Math.max(answer, (count-1));
			prevSum = sum-a[start];
			prevIndex=start+1+answer+1;
			if(count<=D) {
				prevSum=sub[start+1];
				prevIndex=start+D+1;
			}
			if(dis>=start+1) {
				prevDiscount = discount;
			}else {
				prevDiscount=0;
				for(int i=start+1;i<=prevIndex-D;i++) {
					if(prevDiscount<sub[i]) {
						prevDiscount=sub[i];
					}
				}
			}
			return;
		}
		if(index==N-1) {
			return;
		}
		
		cal(start,index+1,sum+a[index+1],discount,count+1);
	}

}
