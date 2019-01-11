/*

LOG:
INITIAL: Version 1.0 : Generates magic square of order 3
UPDATE: Version 1.1 : Generates magic square of any odd order as input by the user and displays the magic number as well

NOTES:
*) Takes an integer n as input from the user and generates a magic square of order n
*) The value n must be an odd number
*) Value upto 23 is optimal as after this the full output is not visible on the screen or is distorted (At least on my screen)


AUTHOR: KP Singh

*/

//imports go here

import java.util.Scanner;

//=================================

public class MagicSquare{
	static void magicSquare(int n){
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
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(square[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){ 
		int n;
		System.out.print("Enter the value of n (odd):");
		Scanner sc=new Scanner(System.in);
		while((n=sc.nextInt())%2==0){
			System.out.println("Entered number must be odd!");
			System.out.print("Enter a valid ODD number:");
		}
		System.out.println();
		magicSquare(n);
		System.out.println();
		System.out.println("The magic number is: "+(n*(n*n+1))/2);
		sc.close();
	}
}

