package SWEA_1251_하나로;
/**
적용 알고리즘
	MST - Prim

메모리
	112,536 KB

실행시간
	1,052 ms


*/
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_박형민 {
	static int N;
	static double[] dist;
	static boolean[] isVisited;
	static XY[] list;
	static double E;
	static double answer;
	public static void main(String[] args) {
		Scanner ㅡsc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T; test_case++) {
			answer=0;
			N = sc.nextInt();
			dist = new double[N];
			isVisited = new boolean[N];
			list = new XY[N];
			for(int i=0;i<N;i++) {
				list[i]=new XY();
				dist[i]=Double.MAX_VALUE;
				list[i].x=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				list[i].y=sc.nextInt();
			}
			E=sc.nextDouble();
			MST();
			for(int i=0;i<N;i++) {
				answer+=E*dist[i]*dist[i];
			}
			
			
			System.out.printf("#%d %.0f\n",test_case,answer);
		}
	}
	
	static void MST() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				if(n1.v>n2.v) {
					return 1;
				}
				else {
					return -1;
					
				}
			}
		});
		Deque<Integer> q = new ArrayDeque<Integer>(); 
		q.add(0);
		dist[0]=0;
		int pos;
		Node temp;
		while(!q.isEmpty()) {
			pos = q.poll();
			isVisited[pos]=true;
			for(int i=0;i<N;i++) {
				if(i!=pos) {
					pq.add(new Node(pos,i,calDist(list[i].x,list[i].y,list[pos].x,list[pos].y)));
				}
			}
			while(!pq.isEmpty()) {
				temp = pq.poll();
				if(!isVisited[temp.e]) {
					isVisited[temp.e]=true;
					dist[temp.e]=temp.v;
					q.add(temp.e);
					break;
				}
			}
		}
	}
	
	static double calDist(int x,int y, int x2, int y2) {
		
		
		return Math.sqrt(Math.pow(x-x2, 2)+Math.pow(y-y2, 2));
	}
	

}
class XY{
	int x;
	int y;
	
}
class Node {
	int s;
	int e;
	double v;
	public Node(int s, int e, double v) {
		this.s=s;
		this.e=e;
		this.v=v;
	}
	
}