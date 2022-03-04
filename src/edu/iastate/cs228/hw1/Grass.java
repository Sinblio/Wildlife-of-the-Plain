package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		// TODO
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		Living res;
		int[] pop = new int[5];
		
		for (int j = 1; j < 5; j++)
			pop[j] = 0;
		
		census(pop);
		
		if (pop[4] > pop[3] * 3)
			res = new Empty(plain, row, column);
		else if (pop[4] >= 3)
			res = new Rabbit(plain, row, column, 0);
		else
			res = new Grass(plain, row, column);
		
		pNew.grid[row][column] = res;
		return res; 
	}
}
