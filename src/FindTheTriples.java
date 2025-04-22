/*****
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


import java.util.Arrays;

public class FindTheTriples {
	public static boolean findTriples(int[] A)
	{
		for (int i = 0; i < A.length; i++)
		{
			for(int j = i+1; j < A.length; j++)
			{
				for(int k = j + 1; k < A.length ; k++)
				{
					if(A[i] == A[j] && A[i] == A[k] && A[j] == A[k])
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean findATriple(int[] C)
	{
		Arrays.sort(C);					//QuickSort
		for(int i = 0; i < C.length; i += 2)
		{
			if((C.length - i) > 2)
			{
				if(C[i] == C[i+2])			//Compare elements
				{
					return true;
				}
			}
			
			else
			{
				return false;
			}
		}
		
		return false;
	}
	
	public static boolean findFirstTriple(int[] B)
	{
		int j, p, tmp;
		
		for(p = 1; p < B.length; p++)				//insertion sort
		{
			tmp = B[p];
			for(j = p; j>0 && tmp < B[j-1]; j--)
			{
				B[j] = B[j-1];
			}
			B[j] = tmp;
		}
		
		for(int i = 0; i < B.length; i++)
		{
			for(int k = i + 2; k < B.length; k++)
			{
				if(B[i] == B[k])					//Compare elements
				{
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = new int[]{1, 4, 1, 1, 4, 2};
		System.out.println(findTriples(array));				//Algorithm from part A
		System.out.println(findFirstTriple(array));			//Algorithm from part B
		System.out.println(findATriple(array));				//Algorithm from part C
	}

}
