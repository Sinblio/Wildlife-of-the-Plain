package edu.iastate.cs228.hw1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException; 

public class AnimalTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Plain p = new Plain("public1-3x3.txt");
		Badger b = new Badger(p, 0, 1, 0);
		
		assertEquals(0, b.myAge());
	}
}
