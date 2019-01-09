import java.lang.Math.*;

public class MagicSquare{
	static void  magicSquare(){
		int num=1,row,col;
		int[][] square=new int[3][3];
		row=1;
		col=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				square[i][j]=0;
			}
		}
		while(num<=9){
	
			if(row>=3 && col<0){
				row=2;
				col=1;
				continue;
			}
			else{
				if(row>2){
					row=row%3;
					continue;
				}
				else if(col<0){
					col=java.lang.Math.abs((3+col));
					continue;
				}
			}
			if(square[row][col]!=0){
				row=row-1;
				col=col+2;
				continue;
			}
			else{
				square[row][col]=num++;
			}
			row=row+1;
			col=col-1;
		}	
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(square[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]){ 
		magicSquare();
	}
}
