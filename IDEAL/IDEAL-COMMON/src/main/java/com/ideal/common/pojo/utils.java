package com.ideal.common.pojo;



import java.util.ArrayList;
import java.util.List;

public class utils {

    public static List<String> SplitString(String id ){
        String flag = "";
        List<String> stringList = new ArrayList<String>();
        for(int i=0;i<id.length();i++){
            char a = id.charAt(i);
            char b = ',';
            if(a==b){
                stringList.add(flag);
                flag = "";
            }else{
                flag = flag + id.charAt(i);
            }

        }
        return stringList;
    }
}
