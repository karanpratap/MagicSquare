/*

LOG:
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


AUTHOR: KP Singh

*/

//imports go here

import java.util.Scanner;

//=================================

public class MagicSquare{

	static int[][] magicSquareOdd(int n){
		int num=1,row,col;
		int[][] square=new int[n][n];
		row=n/2;
		col=n-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				square[i][j]=0;
			}
		}
		while(num<=n*n){
	
			if(row<0 && col>=n){
				row=0;
				col=n-2;
			}
			else{
				if(row<0){
					row=row+n;
				}
				else if(col>=0){
					col=col%n;
				}
				
			}
			if(square[row][col]!=0){
				row=row+1;
				col=col-2;
				continue;
			}
			else{
				square[row][col]=num++;
			}
			row=row-1;
			col=col+1;
		}
		return square;
	}
	
	static int[][]  magicSquareDoublyEven(int n){
		int[][] square=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				square[i][j]=4*i+j+1;
		for(int i=0;i<n/4;i++)
			for(int j=0;j<n/4;j++)
				square[i][j]=n*n+1-square[i][j];
		for(int i=0;i<n/4;i++)
			for(int j=3*n/4;j<n;j++)
				square[i][j]=n*n+1-square[i][j];
		for(int i=3*n/4;i<n;i++)
			for(int j=0;j<n/4;j++)
				square[i][j]=n*n+1-square[i][j];
		for(int i=3*n/4;i<n;i++)
			for(int j=3*n/4;j<n;j++)
				square[i][j]=n*n+1-square[i][j];
		for(int i=n/4;i<3*n/4;i++)
			for(int j=n/4;j<3*n/4;j++)
				square[i][j]=n*n+1-square[i][j];
		return square;
	}

	static void displaySquare(int[][] square){
		int n=square.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(square[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	static int[][] magicSquareSinglyEven(int n){
		if(n==2){
			System.out.println("No normal magic square of order 2 exists!");
			System.exit(0);
		}
		int[][] square=new int[n][n];
		int[][] quarter;
		quarter=magicSquareOdd(n/2);
		
		//for top left quarter square
		for(int i=0;i<n/2;i++)
			for(int j=0;j<n/2;j++){
				square[i][j]=quarter[i][j];
				square[n/2+i][n/2+j]=quarter[i][j]+(n*n)/4;
				square[i][n/2+j]=quarter[i][j]+(n*n)/2;
				square[n/2+i][j]=quarter[i][j]+3*(n*n)/4;
		}
		int k=(n-1)/4;
	
		for(int i=0;i<k;i++){
			for(int j=0;j<n/2;j++){
				int temp=square[j][i];
				square[j][i]=square[j+n/2][i];
				square[j+n/2][i]=temp;
				if((i+1)<k){
					temp=square[j][n-i-1];
					square[j][n-i-1]=square[j+n/2][n-i-1];
					square[j+n/2][n-i-1]=temp;
				}
			}
		}

		//undo the unneccessary swap
		int temp=square[n/4][k-1];
		square[n/4][k-1]=square[3*n/4][k-1];
		square[3*n/4][k-1]=temp;
		
		//swap the diagonal elements
		temp=square[n/4][k];
		square[n/4][k]=square[3*n/4][k];
		square[3*n/4][k]=temp;
		
		return square;
	}

	public static void main(String args[]){ 
		int n=0,square[][];
		if(args.length==0){
			System.out.print("Enter the value of n:");
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			sc.close();
		}
		else if(args.length==1){
			n=Integer.parseInt(args[0]);
		}
		else{
			System.out.println("Invalid number of command line arguements given!");
			System.out.println("The command line arguement must be a single integer");
			System.exit(0);
		}
		System.out.println();
		if(n%4==0)
			square=magicSquareDoublyEven(n);
		else if(n%2!=0)
			square=magicSquareOdd(n);
		else
			square=magicSquareSinglyEven(n);
		displaySquare(square);
		System.out.println();
		System.out.println("The magic number is: "+(n*(n*n+1))/2);
	}	
}	

