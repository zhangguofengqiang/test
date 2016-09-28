package model;

import java.util.Scanner;

public class zhishu1 {

	public static boolean isZhishu(int a){
		for(int i=2;i<=Math.sqrt(a);i++){
			if(a%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		while(sc.hasNextInt()){
			int[] arr=new int[size];
			for(int i=0;i<size;i++){
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<size;i++){
				if(arr[i]<0){
					break;
				}
				if(arr[i]%2==1){
					break;
				}
				if(i!=size-1){
					if(arr[i]>=arr[i+1]){
						break;
					}
				}
			}
			int count=0;
			for(int i=0;i<size;i++){
				for(int j=i+1;j<size;j++){
					for(int k=arr[i];k<=arr[j];k++){
						if(isZhishu(k)){
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
	}

}
