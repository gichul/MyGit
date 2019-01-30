package Day12;

public class Kakaocode1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] picture=new int[][] {
			{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}
		};
		int answ[]=new int[2];
		Solution M=new Solution();
		answ=M.solution(6,4,picture);
//		show
		for(int i=0; i<6; i++) {
			System.out.println(picture[i][0]+" "+picture[i][1]+" "+picture[i][2]+" "+picture[i][3]);
		}
		System.out.println(answ[0]+"  "+answ[1]);
	}

}

class Solution {
    int count=0;
  public int[] solution(int m, int n, int[][] picture) {
	  int temp;
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
        	 count=0;
             if(picture[i][j]==0)continue;
             else numberOfArea++;
             temp=sizeOfArea(i,j,picture,picture[i][j],m,n);
             if(temp>maxSizeOfOneArea)
                 maxSizeOfOneArea=temp;
          }
      }
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
  		//picture[i][j]와 picture정보, 초기값의 picture값, 
  public int sizeOfArea(int i,int j,int[][] picture,int val,int m,int n){
    	//System.out.println(val+ " "+i+" "+j+" "+picture[1][0]);
    	
    	if((j+1<n)&&picture[i][j+1]==val) {
    		//System.out.println("1");
    		picture[i][j+1]=0;
    		count++;
    		sizeOfArea(i,j+1,picture,val,m,n);
    		
    	}
    	
    	if((j-1>=0)&&picture[i][j-1]==val) {
    		//System.out.println("2");
    		picture[i][j-1]=0;
    		count++;
    		sizeOfArea(i,j-1,picture,val,m,n);
    		
    	}
    	
    	if((i+1<m)&&picture[i+1][j]==val) {
        	//System.out.println("3");

    		picture[i+1][j]=0;
    		count++;
    		sizeOfArea(i+1,j,picture,val,m,n);
    		
    	}
    	
    	if((i-1>=0)&&picture[i-1][j]==val) {
    		//System.out.println("4");
    		picture[i-1][j]=0;
    		count++;
    		sizeOfArea(i-1,j,picture,val,m,n);
    		
    	}

    	return count;
    }
        
}





//if(m-1>=0)
//	recur(m-1,n,picture,picture[m][n],maxM,maxN);
//if(n+1<maxN)
//	recur(m,n+1,picture,picture[m][n],maxM,maxN);
//if(n-1>=0)
//	recur(m,n-1,picture,picture[m][n],maxM,maxN);