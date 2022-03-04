package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done.
		
		File file = new File("C:\\Temp\\public\\" + inputFileName);
	    Scanner sc = new Scanner(file);
	    
	    int w = 0;
	    int j = 0;
	    int k = 0;
	    String in = sc.nextLine();
	    String[] str= in.split(" ");
	    
	    for(String s:  str)
	    {
	    	if (s.length() > 0)
	    		w ++;
	    }
	    
	    int a;
	    width = w;
		grid = new Living[width][width];
	    
		
		for(String s:  str)
	    {
	    	if (s.length() > 0)
	    	{
	    		switch (s.substring(0, 1))
				{	
					case "B":
						a = Integer.parseInt(s.substring(1, 2));
						grid[j][k] = new Badger(this, j, k, a);
						break;
					case "F":
						a = Integer.parseInt(s.substring(1, 2));
						grid[j][k] = new Fox(this, j, k, a);
						break;
					case "R":
						a = Integer.parseInt(s.substring(1, 2));
						grid[j][k] = new Rabbit(this, j, k, a);
						break;
					case "G":
						grid[j][k] = new Grass(this, j, k);
						break;
					case "E":
						grid[j][k] = new Empty(this, j, k);
						break;
				} 
	    		k++;
	    	}
	    }
		
		j++;
		
	    while (sc.hasNextLine()) 
	    {
	    	k = 0;
	    	in = sc.nextLine();
		    str= in.split(" ");
		    
		    for(String s:  str)
		    {
		    	if (s.length() > 0)
		    	{
		    		switch (s.substring(0, 1))
					{	
						case "B":
							a = Integer.parseInt(s.substring(1, 2));
							grid[j][k] = new Badger(this, j, k, a);
							break;
						case "F":
							a = Integer.parseInt(s.substring(1, 2));
							grid[j][k] = new Fox(this, j, k, a);
							break;
						case "R":
							a = Integer.parseInt(s.substring(1, 2));
							grid[j][k] = new Rabbit(this, j, k, a);
							break;
						case "G":
							grid[j][k] = new Grass(this, j, k);
							break;
						case "E":
							grid[j][k] = new Empty(this, j, k);
							break;
					} 
		    		k++;
		    	}
		    }
			
			j++;
	    }
	    sc.close();
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		// TODO 
		width = w;
		grid = new Living[width][width];
	}
	
	
	public int getWidth()
	{
		// TODO  
		return width;  // to be modified 
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		// TODO
		Random generator = new Random(); 
		
		for (int j = 0; j < width; j++)
		{
			for (int k = 0; k < width; k++)
			{
				int rand = generator.nextInt(5);
				
				switch (rand)
				{	
					case 0:
						grid[j][k] = new Badger(this, j, k, 0);
						break;
					case 1:
						grid[j][k] = new Fox(this, j, k, 0);
						break;
					case 2:
						grid[j][k] = new Rabbit(this, j, k, 0);
						break;
					case 3:
						grid[j][k] = new Grass(this, j, k);
						break;
					case 4:
						grid[j][k] = new Empty(this, j, k);
						break;
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		// TODO
		String out = "";
		
		for (int j = 0; j < width; j++)
		{
			for (int k = 0; k < width; k++)
			{
				State who = grid[j][k].who();
				
				switch (who)
				{
				case BADGER:
					out += "B";
					out += ((Animal)grid[j][k]).myAge();
					break;
				case FOX:
					out += "F";
					out += ((Animal)grid[j][k]).myAge(); 
					break;
				case RABBIT:
					out += "R";
					out += ((Animal)grid[j][k]).myAge();
					break;
				case GRASS:
					out += "G ";
					break;
				case EMPTY:
					out += "E ";
					break;
				}
				out += " ";
			}
			out += "\n";
		}
		
		return out; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		PrintWriter file = new PrintWriter("C:\\Temp\\public\\" + outputFileName);
		String out = toString();
		file.print(out);
	    file.close();
	}			
}
