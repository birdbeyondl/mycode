import java.util.Scanner;
public class Test2 {
	public static void main(String[] args){
		int flag=0;
		Scanner sc = new Scanner(System.in);
		while(true){
			
			if(!sc.hasNextInt())
				break;
			flag++;
			System.out.println(sc.nextInt());
		}
		System.out.println(flag);
		
	    }
}



