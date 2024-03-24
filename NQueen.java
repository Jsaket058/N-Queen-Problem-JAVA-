import java.util.*;
class NQueen{
	static boolean isValid(char x[][],int row,int col){
//		horizontal condition
		int j;
		for(j=col;j>=0;j--){
			if(x[row][j]=='Q')return false;
		}
//		vertical condition
		int i;
		for(i=row;i>=0;i--){
			if(x[i][col]=='Q')return false;
		}
//      diagonal condition			
        for(i=row,j=col;i>=0 && j>=0;i--,j--){
			if(x[i][j]=='Q')return false;
		}
        for(i=row,j=col;i>=0 && j<x.length;i--,j++){
			if(x[i][j]=='Q')return false;
		}
        return true;		
	}
	
	static boolean nQueen(char x[][],int row){
		if(row>=x.length)return true;
		int i,j;
		for(j=0;j<x.length;j++){
			if(isValid(x,row,j)){
				x[row][j]='Q';
				if(nQueen(x,row+1))return true;
                x[row][j]=' ';			
			}
		}
		return false;
	}
	public static void main(String[] args){
		char x[][]=new char[4][4];
	  	for(char z[]:x){
		Arrays.fill(z,' ');
	    }
		int i,j;
		nQueen(x,0);
		for(i=0;i<x.length;i++){
            for(j=0;j<x[i].length;j++){
				System.out.print(x[i][j]);
			}
		System.out.println();	
		}
	}
}