package TP1;

import java.util.*;
public class test {

	public static void main(String[] args) {		
		int x,y;
		
		System.out.println("Bonjour, Ceci est un premier test avec eclipse");
		System.out.println("donner deux entier: ");
		Scanner sc=new Scanner(System.in);
		x=sc.nextInt();
		y=sc.nextInt();
		
		System.out.println("La somme de "+x+" et "+y+" est "+(x+y)+"");
		sc.close();
	}

}
