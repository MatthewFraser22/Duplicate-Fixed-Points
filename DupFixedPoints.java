import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DupFixedPoints {
	
	static int binary_search(int A[], int low, int high) {
		if(low > high) {
			return -1;
		}else {
			
			int mid_point = (low+high)/2;
			int mid_value = A[mid_point];
			
			if (mid_point == A[mid_point]) {
				return mid_point;
			}
			
			int low_search = Math.min(mid_point -1, mid_value);
			int LS = binary_search(A,low,low_search);
			
			
			if (LS >= 0) {
				return LS;
			}
			
			int high_search = Math.max(mid_point+1, mid_value);
			int HS = binary_search(A,high_search, high);
			
			if (HS >= 0) {
				return HS;
			}
			return -1;	
		}
		
	}
	static int Distinctness(int A[],int n) {
		int values = 0;
		for (int i = 0; i < n-1; i ++) {
			if (A[i] == A[i+1]  && A[i] != -1 && A[i] != 0) {
				values = A[i];
				return values;
			}
		}
		return values;
		
	}
	
	static int[] add_start(int A[],int length, int value) {
		
		int new_array[] = new int[length+1];
		
		for(int i = 0; i < length+1;i++) {
			if(i==0) {
				new_array[i] = value;
			}else {
				new_array[i] = A[i-1];
			}
		}
		
		
		
		return new_array;
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int s = 0;
		int count = 0;
		
		s = scan.nextInt();
		
		if (s==0 || s == 1) {
			System.out.println("NO");
		}else {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int A[][] = new int[s][1000];
			
			for (int i = 0; i < s;i++) {

				//reads user input
				String lines = br.readLine();
				String[] st = lines.trim().split("\\s+");
				
				int inner[] = new int[st.length];
				
				
				for(int j = 0; j < st.length; j++) {
					inner[j] = Integer.parseInt(st[j]);
				}

				inner = add_start(inner,inner.length, 0);
				
				A[i] = inner;
				
				
				
			}

			int load_values[] = new int[s];
			
			for(int i = 0; i < A.length;i++) {
				int x = binary_search(A[i],0,A[i].length-1);
				load_values[i] = x;
			}
			

			
			int values = Distinctness(load_values, load_values.length);
			
			if (values == 0) {
				System.out.print("NO");
			}else {
				for(int i = 0; i < load_values.length;i++) {
					if (values == load_values[i] && count < 2) {
						System.out.print((i+1)+ " ");
						count++;
					}
					
				}
			}

			
		}
		
		scan.close();

	}

}
