package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		// TODO 
		// 
		// For every life form (i.e., a Living object) in the grid pOld, generate  
		// a Living object in the grid pNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
		
		int width = pOld.getWidth();
		for (int j = 0; j < width; j++)
			for (int k = 0; k < width; k++)
			{
				pOld.grid[j][k].next(pNew);
			}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		// 
		// Generate wildlife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two plains even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the plain 
		//    odd from the plain even; in an odd numbered cycle, generate even 
		//    from odd. 

		Plain even;   				 // the plain after an even number of cycles 
		Plain odd;                   // the plain after an odd number of cycles
		
		// 4. Print out initial and final plains only.  No intermediate plains should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate plains.)
		// 
		// 5. You may save some randomly generated plains as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain) 2 (file input) 3 (exit)");
		Scanner in = new Scanner(System.in);
		int trial = 1;
		
		while (true)
		{
			int cycles;
			System.out.print("Trial " + trial + ": ");
			String input = in.nextLine();
			System.out.println();
			
			if (input.equals("1"))
			{
				System.out.println();
				System.out.println("Random Plain");
				System.out.print("Enter grid width: ");
				int w = Integer.parseInt(in.nextLine());
				System.out.print("Enter the number of cycles: ");
				cycles = Integer.parseInt(in.nextLine());
				System.out.println();
				
				odd = new Plain(w);
				odd.randomInit();
			} 
			else if (input.equals("2")) 
			{
				System.out.println("Plain input from a file");
				System.out.print("File name: ");
				String file = in.nextLine();
				System.out.print("Enter the number of cycles: ");
				cycles = Integer.parseInt(in.nextLine());
				
				odd = new Plain(file);
			} 
			else
				break;
			
			even = new Plain(odd.getWidth());
			
			System.out.println("\nInitial plain:\n\n");
			System.out.println(odd);
			
			int count = 1;
			
			for (int j = 0; j < cycles; j++)
			{
				if ((count % 2) == 0)
				{
					System.out.println(even);
					updatePlain(even, odd);
				}
				else
				{
					System.out.println(odd);
					updatePlain(odd, even);
				}
				count++;
			}
			
			System.out.println("\nFinal plain:\n\n");
			
			if (count % 2 == 0)
				System.out.println(even);
			else
				System.out.println(odd);
			count++;
			
			
			trial++;
		}
		
		in.close();
	}
}
