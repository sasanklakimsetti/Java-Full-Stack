package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapNameCity {
    public static void main(String[] args){
        Map<String,String>mp=new HashMap<>();
        mp.put("Amit","Delhi");
        mp.put("Sumit","Delhi");
        mp.put("Krishan","Chandigarh");
        mp.put("Sunita","Chandigarh");
        mp.put("Kartik","Jalandhar");

        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println(mp.get(name));

        Map<Integer,String>mp2=new HashMap<>();
        mp2.put(1,"One");
        mp2.put(2,"Two");
        mp2.put(3,"Three");
        mp2.put(4,"Four");
        mp2.put(5,"Five");
        mp2.put(6,"Six");
        mp2.put(7,"Seven");
        mp2.put(8,"Eight");
        mp2.put(9,"Nine");
        mp2.put(10,"Ten");
        mp2.put(11,"Eleven");
        mp2.put(12,"Twelve");
        mp2.put(13,"Thirteen");
        mp2.put(14,"Fourteen");
        mp2.put(15,"Fifteen");
        mp2.put(16,"Sixteen");
        mp2.put(17,"Seventeen");
        mp2.put(18,"Eighteen");
        mp2.put(19,"Nineteen");
        mp2.put(20,"Twenty");
        mp2.put(30,"Thirty");
        mp2.put(40,"Forty");
        mp2.put(50,"Fity");
        mp2.put(60,"Sixty");
        mp2.put(70,"Seventy");
        mp2.put(80,"Eighty");
        mp2.put(90,"Ninety");
        int num=sc.nextInt();
        int place=1;
        String ans="";
        while(num>0){
            int unit=num%10;
            if(unit==0) {
                num/=10;
                place*=10;
                continue;
            }
            if(place==100) ans = mp2.get(unit)+" Hundred and "+ans;
            else ans=mp2.get(unit*place)+" "+ans;
            place*=10;
            num/=10;
        }
        System.out.println(ans);
    }
}
