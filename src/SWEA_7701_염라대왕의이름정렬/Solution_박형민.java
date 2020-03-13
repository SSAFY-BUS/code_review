package SWEA_7701_염라대왕의이름정렬;
/**
적용 알고리즘
	Comparator를 이용해 정렬 (Priority Queue 사용.)

메모리
	123,216 KB

실행시간
	2,917 ms


*/
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_박형민 {
	static int N;
	static PriorityQueue<String> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T; test_case++) {
			pq = new PriorityQueue<String>(new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					if(s1.length()>s2.length()) {
						return 1;
					}
					else if(s1.length()<s2.length()) {
						return -1;
					}
					else {
						if(s1.compareTo(s2)>0) {
							return 1;
						}else {
							return -1;
						}
					}
				}
			});
			
			
			N = sc.nextInt();
			for(int i=0;i<N;i++) {
				String s = sc.next();
				pq.add(s);
			}
			
			System.out.println("#"+test_case);
			while(!pq.isEmpty()) {
				String print = pq.poll();
				while(true) {
					if(print.equals(pq.peek())) {
						pq.poll();
					}else {
						break;
					}
				}
				System.out.println(print);
			}
		}
	}
	

}