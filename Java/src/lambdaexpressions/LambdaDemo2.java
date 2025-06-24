package lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Printer{
    public void print(String str);
}
interface MyConsumer{
    public void accept(Object obj);
}
public class LambdaDemo2 {
    public static void main(String[] args){
        // anonymous class
        Printer p1=new Printer() {
            @Override
            public void print(String str) {
                System.out.println(str);
            }
        };
        p1.print("Hei");

        // lambda expression
        Printer p2=(str)-> System.out.println(str);
        p2.print("Bye");

        // calling the inbuilt print function since both do the same thing
        Printer p3=System.out::println;
        p3.print("Again");

        MyConsumer c1=(obj)-> System.out.println(obj.getClass());
        c1.accept(c1);

        MyConsumer c2=System.out::println;
        Printer p4=c2::accept;

        List<Integer>list=new ArrayList<>();
        for (int i=1;i<=5;i++) list.add(i);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        list.forEach(integer -> System.out.println(integer));


        for(int i=11;i<=20;i++) list.add(i);

//        for (int i=0;i<list.size();i++){
//            if(list.get(i)%2==1){
//                list.remove(i);
//                i--;
//            }
//        }

        System.out.println(list);

        // writing the above function using lambda expression with the help of inbuilt Predicate interface
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==1;
            }
        });

        System.out.println(list);
        for(int i=11;i<=20;i++) list.add(i);
        System.out.println(list);
        list.removeIf(t->t%2==1);
        System.out.println(list);

        // using list.forEach print all even elements in the list
        List<Integer>list2=new ArrayList<>();
        for (int i=0;i<=10000;i++) list2.add(i);
        list2.forEach(integer -> {
            if (integer%2==0) System.out.println(integer);
        });
        list2.removeIf(integer -> integer<6);
        System.out.println(list2);
        list2.replaceAll(integer->integer*integer);
        System.out.println(list2);
        System.out.println();
        System.out.println();
        List<Integer>list3=new ArrayList<>();
        for (int i=1;i<=20;i++) list3.add(i);
        list3.sort((integer1, integer2)->integer2-integer1);
        System.out.println(list3);
        System.out.println();
        System.out.println();
        List<Integer>list4=new ArrayList<>();
        for (int i=1;i<=20;i++) list4.add(i);
        list4.sort((integer1,integer2)-> firstDigit(integer1)-firstDigit(integer2));
        System.out.println(list4);
    }

    private static int firstDigit(Integer integer1) {
        String str=Integer.toString(integer1);
        String ans= String.valueOf(str.charAt(0));
        int res=Integer.parseInt(ans);
        return res;
    }
}
