package pattern;

import java.util.*;

public class RectanglePattern {

    public static void Main (String[] args){
        Scanner cs= new Scanner(System.in);
        System.out.print("rows you want :");
        int m=cs.nextInt();
        System.out.print("column you want :");
        int n =cs.nextInt();
        System.out.print("your name :");
        String v= cs.next();
        System.out.println("welcome "+" "+ v);

        int k,j;

        for(k=1;k<=m;k++){ //outer loop

            for(j=1;j<=n;j++){  //inner loop
                System.out.print(" * ");
            }
            System.out.println( );
        }
    }

    public static void main(String[] args){
        Scanner ku = new Scanner(System.in);
        System.out.print("what is your age ?  ");
        int age= ku.nextInt();
        System.out.print("What is your name ?  ");
        String name= ku.next();

        if (age>=18) {
            System.out.println(name + " is eligible for applying passport");
        } else{
            System.out.println(name + " is not eligible for applying passport");
        }
    }
}