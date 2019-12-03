/* [Test.java]
 * A small program showing how to use the MatrixDisplayWithMouse class
 *  NOTE - A lot of things to fix here!
 * @author Mangat
 */

class TestProgram { 
  
  public static void main(String[] args) { 
    
    int[][] testMap = new int[10][10];// { {0,1,2},{2,1,0},{2,1,2}};
    MatrixDisplayWithMouse display = new MatrixDisplayWithMouse("Testing 123...", testMap);
    
    while(true) {     
      display.refresh();      
      
      //Small delay
      try{ Thread.sleep(500); }catch(Exception e) {};    
      randomizeArray(testMap);
    }
  }
  
  
  public static void randomizeArray(int[][] data) { 
    
    for(int i = 0; i<data[0].length;i++)        {
      for(int j = 0; j<data.length;j++)     { 
        
        data[i][j]=((int)(Math.random()* 3));
      }
    }
  }
  
}


