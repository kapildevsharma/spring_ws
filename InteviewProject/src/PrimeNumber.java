
public class PrimeNumber {
	public static void main(String[] args) {

		for(int i = 2;i<=100;i++){
			
			boolean isPrime = true;
			for(int j = i;j>=2;j--){
				if(i%j == 0 && i!=j){
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				System.out.print(i+" ");
		}
		
	}
}
