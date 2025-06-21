package strings;

public class Strings1 {
    public static void main(String[] args){
        String str="    this    is  a   string  ";
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str);
        str=str.trim();
        System.out.println(str);
        str=str.concat(" new string added");
        System.out.println(str);
        System.out.println(str.contains("is"));
        System.out.println(str.startsWith("this"));
        System.out.println(str.endsWith("string"));
        System.out.println(str.substring(2));
        System.out.println(str.substring(2,7));
        System.out.println(str.equals("this"));
        System.out.println(str.indexOf("is"));
        System.out.println(str.toUpperCase());

        // regrex defines the delimiter the string should be split upon
        String[] words=str.split(" ");
        for (String word: words) System.out.println(word);
        String names = "amit, sumit, rajan,dinesh,deepak,sunita,deepti,krishna, ram";
        String[] namesArr=names.split(",");
        for (String name:namesArr) System.out.println(name);


    }
}
