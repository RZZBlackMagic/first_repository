package Test;

public class rzz201803220 {

	public static void main(String[] args) {
    String word="this is a text";
    String key ="is";
    rzz201803220  t = new rzz201803220();
    t.keyWordSearch(word,key);
    
	}
	public void keyWordSearch(String word,String key){
		int index = word.indexOf(key);
		String returnstr ="";
		int flag=0;
		while(index!=-1){
			returnstr = returnstr+index+" ";
			flag++;
			index = word.indexOf(key,index+1);
		}
		String str = flag+":"+returnstr;
		System.out.println(str);
	}

}

	
