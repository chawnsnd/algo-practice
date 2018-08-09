package practice;

public class SegmentTree {
	int n;
	int[] rangeMin;
	
	public SegmentTree(int[] array){
		n = array.length;
		rangeMin = new int[n*4];
		init(array, 0, n-1, 1);
	}
	
	private int init(int[] array, int left, int right, int node) {
		if(left==right) return rangeMin[node] = array[left];
		int mid = (left+right)/2;
		int leftMin = init(array, left, mid, node*2);
		int rightMin = init(array, mid+1, right, node*2+1);
		return rangeMin[node] = Math.min(leftMin, rightMin);
	}
	
	private int min(int left, int right, int node, int nodeLeft, int nodeRight) {
		if(right<nodeLeft||nodeRight<left) return Integer.MAX_VALUE;
		if(left<=nodeLeft&&nodeRight<=right) return rangeMin[node];
		int mid = (nodeLeft+nodeRight)/2;
		return Math.min(min(left, right, node*2, nodeLeft, mid),
				min(left, right, node*2+1, mid+1, nodeRight));
	}
	
	public int min(int left, int right) {
		return min(left, right, 1, 0, n-1);
	}
	
	private void update(int node, int left, int right, int index, int value) {
		if(index<left||right<index) return;
		rangeMin[node] = Math.min(value, rangeMin[node]);
		if(left != right) {
			int mid = (left+right)/2;
			update(node*2, left, mid, index, value);
			update(node*2+1, mid+1, right, index, value);
		}
	}
	
	public void update(int index, int value) {
		update(1, 0, n-1, index, value);
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		SegmentTree segmentTree = new SegmentTree(array);
		System.out.println(segmentTree.min(4, 7));
		segmentTree.update(5, 1);
		System.out.println(segmentTree.min(4, 7));
	}
}
