import java.util.Arrays;

public class ConnectedComponents {

	public static void main(String[] args) {
		
		int [][] graph =  {{0, 1, 0, 1,  0, 0,  0},
						{1,  0,  0,  0,  1,  0,  0},
						{0,  0,  0,  0,  0,  0,	0},
						{1,  0,  0,  0,  1,  0,  0},
						{0,  1,  0,  1,  0,  0,  0},
						{0,  0,  0,  0,  0,  0,  1},
						{0,  0,  0,  0,  0,  1, 0}};
		
		

		int isolated = 0;
		//declare and array or a list that will store all of the isolated nodes.
		int isolatedNode;
		
		for(int row = 0; row < graph.length; row++)
		{
			for(int column = 0; column < graph.length; column++)
			{
				isolated += graph[row][column];
			}
			
			if(isolated == 0)
			{
				isolatedNode = (row + 1);
			}
			else
			{
				isolated = 0;
			}
		}
		
		
	}

}
