package edu.iastate.cs228.hw1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

public class PlainTest 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//No Difference but fails???
		Plain p = new Plain("public1-3x3.txt");
		String test = "G  B0 F0 \nF0 F0 R0 \nF0 E  G  \n";
		assertEquals(p ,test);
	}
}
