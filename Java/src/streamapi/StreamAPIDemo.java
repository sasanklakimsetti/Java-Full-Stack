package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo {
    public static void main(String[] args){
        // without Stream API
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<50;i++){
            Random random=new Random();
            list.add(random.nextInt(100));  // the numbers will be within 1 to 100
        }
        System.out.println(list);
        List<Integer>sublist=new ArrayList<>();

        // for each loop
        for (int i:list){
            if(i%2==1) sublist.add(i);
        }
        System.out.println(sublist);

        // Stream is an on demand data structure that is used only once.
//        A stream is not a data structure; instead, it takes input from the Collections, Arrays, or I/O channels.
//        Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
//        Each intermediate operation is lazily executed and returns a stream as a result, hence, various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.
        // using stream api
        Stream<Integer>stream=list.stream();
        // check whether all the integers in this stream are less than 900 or not using Stream API
        boolean allMatch=stream.allMatch(integer -> integer<900);
        System.out.println(allMatch);

//        long count= stream.count();
//        System.out.println(count); // this will cause Exception since the stream has been used for allMatch. So we can't use this again

        long count=list.stream().count();
        // this will run, because it is a new stream. So it is recommended to use a stream like this instead storing.
        System.out.println(count);

        // if any element in the list is a multiple of 5
        System.out.println(list.stream().anyMatch(t->t%5==0));

        // distinct elements of the list
        list.stream().distinct().forEach(System.out::println);

        System.out.println();
        System.out.println();

        // Optional is a class which says that there is a value that can be present or can't be present
        Optional<Integer>min=list.stream().min((a,b)->a-b);
        if (min.isPresent()){
            Integer value=min.get();
            System.out.println(value);
        }
        else System.out.println("No elements provided");

        // filter odd integers out of the list
        Stream<Integer>filter=list.stream().filter(t->t%2==1);
        List<Integer>subListOdd=filter.collect(Collectors.toList());
        System.out.println(subListOdd);
    }
}
