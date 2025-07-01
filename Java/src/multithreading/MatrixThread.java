package multithreading;

// multithreading: one program executes multiple tasks
// Use multithreading to add two matrices
class RowAdder extends Thread{
    int[][] a, b, c;
    int row;
    public RowAdder(int[][] a, int[][] b, int[][] c, int row){
        this.a=a;
        this.b=b;
        this.c=c;
        this.row=row;
    }
    public void run(){
        System.out.println("Adding row "+(row+1));
        for(int i=0;i<5;i++) c[row][i]=a[row][i]+b[row][i];
    }
}
public class MatrixThread {
    public static void main(String[] args){
        int a[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int b[][]={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int c[][]=new int[5][5];
        RowAdder[] threads=new RowAdder[5];
        for(int i=0;i<5;i++){
            threads[i]=new RowAdder(a,b,c,i);
            threads[i].start();
        }
        // wait for all threads to finish
        for(int i=0;i<5;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(c[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
