package pattern;
import java.util.*;

public class FloydsTriangle {
    public static void main(String[] args){
        Scanner up= new Scanner(System.in);
        System.out.print("Enter the value: ");
        int n = up.nextInt();

        int number=1;

        int i,j;

        for(i=1;i<=n;i++){
            for (j=1;j<=i;j++){
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
