牛牛有两个字符串A和B,其中A串是一个01串,B串中除了可能有0和1,还可能有'?',B中的'?'可以确定为0或者1。 寻找一个字符串T是否在字符串S中出现的过程,称为字符串匹配。牛牛现在考虑所有可能的字符串B,有多少种可以在字符串A中完成匹配。

例如:A = "00010001", B = "??"
字符串B可能的字符串是"00","01","10","11",只有"11"没有出现在字符串A中,所以输出3

import java.util.*;
public class Main{
    public static int matchNum(String a,String b){
        int m=a.length();
        int n=b.length();
        if(n>m) return 0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<=m-n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(b.charAt(j)=='?'||b.charAt(j)==a.charAt(i+j)){
                    sb.append(a.charAt(i+j));
                }
            }
            if(sb.length()==n){
                set.add(sb.toString());
            }
        }
        return set.size();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String A=sc.nextLine();
            String B=sc.nextLine();
            int num=matchNum(A,B);
            System.out.println(num);
        }
    }
}