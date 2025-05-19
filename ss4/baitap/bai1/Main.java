package ss4.baitap.bai1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand=new Random();
        double a= rand.nextDouble(10);
        double b=  rand.nextDouble(10);
        double c= rand.nextDouble(10);
        QuadraticEquation q = new QuadraticEquation(a,b,c);
        double delta=q.getDiscriminant(a,b,c);

        if(delta>0){
            System.out.println("Phuong trinh co 2 nghiem phan biet ");
            System.out.println("Nghiem x1 = " + q.getRoot1(a,b,c));
            System.out.println("Nghiem x1 = " + q.getRoot2(a,b,c));
        }
        else  if(delta==0){
            System.out.println("Phuong trinh co nghiem kep x1=x2= " + q.getRoot1(a,b,c) );
        }
        else
            System.out.println("Ptrinh vo nghiem ");

    }
}
