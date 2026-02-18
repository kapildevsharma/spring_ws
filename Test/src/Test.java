
public class Test {

	public static void main(String[] args) {
		int arr[] = {2,5,9,7};
		int n = arr.length;
		
		int [] leftSum = new int[n];
		leftSum[0] = arr[0];
		int [] rightSum= new int[n];
		rightSum[n-1] = arr[n-1];
		
		for(int i=1; i<n; i++) {
			leftSum[i] = leftSum[i-1] + arr[i];
		}

		for(int i=n-2; i>=0; i--) {
			rightSum[i] = arr[i]+ rightSum[i+1];
		}
		
		for(int i=1; i<n; i++) {
			if(leftSum[i] == rightSum[i])
				System.out.println(i);
		}
		
	}
	
}
