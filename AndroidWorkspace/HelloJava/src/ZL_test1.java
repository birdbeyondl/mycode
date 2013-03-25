
public class ZL_test1 {
	public static void main(String[] args){
		String x = new String();
		String y = new String();
		if(args.length == 0){
			x = y = "0";
		}
		else if(args.length==1){
				x = args[0];
				y = "0";
			}else{
				x = args[0];
				y = args[1];
			}	
		System.out.print(x+y);
	}
}
