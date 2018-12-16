package Test;

import java.util.ArrayList;
import java.util.Collection;

public class rzz201807151 {

	public static void main(String[] args) {
        String str = "1+2-3*5";
        //将str以+ -号分开
        String regax="[0-9]";
        String regex="[+-]?";
        String[] s = str.split(regex);
        //找出有乘除号的String，先处理这些：将其计算出结果作为一项
        String cals="";
        for(int i=0;i<s.length;i++){
        	if(Integer.parseInt(s[i])%1==0){
        		
        	}else{
        		String regex1="[*/]?";
        		String[] ss = s[i].split(regex1);//数字数组
        		String[] sscal=s[i].split(regax);//运算符数组
        		int[] arr = new int[ss.length];
        		for(int j=0;j<ss.length;i++){
            		arr[i]=Integer.parseInt(ss[i]);
            	}
            	double reresult = arr[0];
        		for(int j=0;j<sscal.length;j++){
        			if(sscal[i].equals("*")){
        				reresult=reresult*arr[2*j];
        			}else if(sscal[i].equals("/")){
        				reresult=reresult/arr[2*j];
        			}
        		}
                 cals = reresult+"";
        	}
        	s[i]=cals;
        }
        //得到全部是数字的字符串，将其转为int型
        int[] finarr=new int[s.length];
        for(int i=0;i<s.length;i++){
        	finarr[i]=Integer.parseInt(s[i]);
        }
        //得到所有的+，-数组
        Collection fincals = new ArrayList();
        String[] ss=str.split(regax);
        for(int i=0;i<ss.length;i++){
        	int j=0;
        	if(ss[i].equals("+")||ss[i].equals("-")){
        	    fincals.add(ss[i]);	
        	}
        	j++;
        }
        String[] fincal = (String[])fincals.toArray(new String[fincals.size()]);
        double result=finarr[0];
        for(int i=0;i<fincal.length;i++){
        	if(fincal[i].equals("+")){
        		result= result+finarr[2*i+2];
        	}else if(fincal[i].equals("-")){
        		result= result-finarr[2*i+2];
        	}
        }
        System.out.println(result);
	}

}
