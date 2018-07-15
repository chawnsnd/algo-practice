package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

class no1517 {
	static long count = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		String[] strArr = scanner.nextLine().split(" ");
		scanner.close();
		
		int[] arr = new int[strArr.length];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		mergeSort(arr, 0, arr.length-1);
		System.out.println(count);
	}
	
	// 머지소트
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                count += n1-i;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
 
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
 
            merge(arr, l, m, r);
        }
    }
    
	// 버블소트
	static int[] bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++)
			for(int j=0; j<arr.length-i-1; j++)
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
		return arr;
	}
	// 힙소트
	static int[] heapSort(int[] arr) {
		for(int i=(arr.length/2)-1; i>-0; i--)
			buildHeap(arr, arr.length, i);
		
		for(int i=arr.length-1; i>=0; i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			buildHeap(arr, i, 0);
		}
		return arr;
	}
	static void buildHeap(int arr[], int n, int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left<n && arr[left]>arr[largest]) largest = left;
		if(right<n && arr[right]>arr[largest]) largest = right;
		if(largest != i) {
			int tmp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = tmp;
			buildHeap(arr, n, right);
		}
	}
	// 퀵소트
	static int[] quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex-1);
			quickSort(arr, partitionIndex+1, high);
		}
		return arr;
	}
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for(int j=low; j<high; j++)
			if(arr[j] <= pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		int tmp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = tmp;
		
		return i+1;
	}

}
