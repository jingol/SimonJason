package simonJason;

public class Test {
	
	public static String[] words = {"puma", "penguin", "zebra", "aardvark", "iguana", "yak"};
	public static String result = "";

	
	
	public static void main(String[] args){
		mystery();
	}
	
	public static String mystery(){
		for(int i = words.length - 1; i > 0 ; i--){
		if(words[i].substring(0,1).compareTo(words[i-1].substring(0,1)) >= 0){
				result += words[i].substring(0,words[i].length()/2);
					if(result.length() != 1){
						if(result.substring(0,1).compareTo(
							result.substring(1,2))>= 0){
								String first = result.substring(0,result.length()/2);
								String last = result.substring(result.length()/2); 
								result = last + first;
							}
							else{
								result = result.substring(2);
							}	
					}
				}
				
			}
		System.out.println(result);
		return result;
	}
}
