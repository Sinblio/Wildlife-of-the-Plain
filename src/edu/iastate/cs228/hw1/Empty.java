package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		// TODO
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		// TODO 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		Living res;
		int[] pop = new int[5];
		
		for (int j = 1; j < 5; j++)
			pop[j] = 0;
		
		census(pop);

		if (pop[4] > 1)
			res = new Rabbit(plain, row, column, 0);
		else if (pop[2] > 1)
			res = new Fox(plain, row, column, 0);
		else if (pop[0] > 1)
			res = new Badger(plain, row, column, 0);
		else if (pop[3] >= 1)
			res = new Grass(plain, row, column);
		else
			res = new Empty(plain, row, column);
		
		pNew.grid[row][column] = res;
		return res;
	}
}
