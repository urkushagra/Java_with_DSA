package pattern;
import java.util.*;

public class HPwithNumbers {
     public static void main(String[] args){
         Scanner ku =new Scanner(System.in);
         System.out.print("enter the number: ");
         int n = ku.nextInt();

         int i,j;

         for(i=1;i<=n;i++){ //outer loops

             for(j=1;j<=i;j++){  //inner loops
                 System.out.print(j+" ");
             }
             System.out.println();
         }

     }
}