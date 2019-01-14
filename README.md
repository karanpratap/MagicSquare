# MagicSquare
Magic Square Generator

CHANGELOG:
==========
INITIAL: Version 1.0 : *Generates magic square of order 3
UPDATE: Version 1.1 : *Generates magic square of any odd order as input by the user and displays the magic number as well
UPDATE: Version 1.2 : *Now generates magic square of any odd order as well as any doubly even order; i.e. n*4,n is an integer
				   	  *Command Line functionality added: Now the program accepts 1 command line arguement representing the
					  value of n;however giving an invalid value of n via the command line args shows the error and instantly
					  ends the execution unlike in case of user input; where the program repeatedly prompts the user until a
					  valid value for n is entered.
					  *The methods used to find the magic square returns the magic square as a matrix to the calling method
					  *The square is displayed using a newly implemented method specifically to display the matrix passed to it
MAJOR UPDATE: Version 2.0 : *Now generates magic square for ANY order(odd,4n,4n+2)
			  				*The magic square of order 2 does not exist
							*Implemented divide by constant factor algorithm to cover the 4n+2 order problem
							*That's pretty much it
NOTES:
*) Takes an integer n as input from the user and generates a magic square of order n
*) The value n must be an odd number or doubly even(n*4)
*) Value upto 23 is optimal as after this the full output is not visible on the screen or is distorted (At least on my screen)
*) Sample Outputs at end of the program file

AUTHOR: KP Singh
