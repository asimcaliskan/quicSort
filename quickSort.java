package practise;


public class quickSort {
	
	public void swap( int[] arr , int in1 , int in2 ) {
		int temp = arr[ in1 ];
		arr[ in1 ] = arr[ in2 ];
		arr[ in2 ] = temp;
	}
	
	public void threeWay( int[] arr , int low , int high ) {//for duplicate keys
		if( high <= low ) return;//base case
		int lt = low; 
		int gt = high;
		int index = low;
		int pivot = arr[ low ];
		while( index <= gt ) {
			int cmp = arr[ index ] > pivot ? 1 : ( arr[ index ] ==  pivot ? 0 : -1 );
			if( cmp < 0 ) swap( arr , lt++ , index++ );
			else if( cmp > 0 ) swap( arr , index , gt-- );
			else index ++;
		}
		threeWay( arr , low , lt - 1 );
		threeWay( arr , gt + 1 , high);
	}
	
	public int partition( int[] arr , int low , int high ) {//DO NOR STOPS ON EQUAL KEYS!!!!!!!!!
		//pivot point is arr[ low ];
		int leftPtr = low;
		int rightPtr = high + 1;//+ 1 because of to stop first while
		while( true ) {
			while( arr[ ++ leftPtr ] < arr[ low ] ) {//from left to right
				if( leftPtr == high ) break;//when no alert in pointer.
			}
			
			while( arr[ --rightPtr ] > arr[ low ] ) {//from right to left
				if( rightPtr == low ) break;//when no alert in pointer.
			}
			
			if( leftPtr >= rightPtr )break;
			swap( arr, leftPtr, rightPtr );//swap from index
			
		}
		swap( arr , low , rightPtr );
		return rightPtr;
	}
	
	public void sort( int[] arr , int low , int high , int code ) {
		if( low < high ) {//recursion base case.
			int partIndex = partition( arr , low , high );//select a number from the array and to partied the array
			sort( arr , low , partIndex - 1 , 1 );//for left
			sort( arr , partIndex + 1 , high , 2 );//for right
		}
	}
	
	public int select( int[] arr , int k ) {
		int low = 0;
		int high = arr.length - 1;
		while( low < high ) {
			int partIndex = partition( arr, low, high);
			if( k < partIndex ) high = partIndex - 1; //in left
			else if( k > partIndex ) low = partIndex + 1;//in right
			else return arr[ k ];
		}
		return arr[ k ];
	} 
	
	public void printArr( int[] arr ) {
		for( int i = 0 ; i < arr.length ; i ++ ) {
			System.out.print( " " + arr[i] );
		}
		System.out.println();
	}
	
	public static void main( String[] args ) {
		quickSort qS = new quickSort();
		int[] arr = { 2 , 2 , 3 , 3 , 4 , 4 , 5 , 5 , 6 , 6 , 5 };
		int[] arr1 = { 1 , 2 , 3 , 1 , 4 , 4 , 5 , 9 , 6 , 6 , 5 };
		qS.sort( arr, 0, arr.length - 1 , 0);
		System.out.println( qS.select( arr, 10) );
		qS.threeWay( arr1, 0, arr1.length - 1);
		qS.printArr( arr1);
		
	}
}
