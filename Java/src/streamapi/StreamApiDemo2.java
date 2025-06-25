package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiDemo2 {
    public static void main(String[] args){List<String>names=List.of("Sachin Malhotra","Krishnan","Ram","Sunita","Rajan");
        // print the names which have length<5
        names.stream().filter(str->str.length()<5).forEach(System.out::println);
        // print the names which have length>5
        names.stream().filter(str->str.length()>5).forEach(System.out::println);

        int[] ar={1,2,3,4,5,4,4,5,4,54,6,4,4,646,84,1,54,687,2,0};
        // print distinct elements of the array using Stream API
        Arrays.stream(ar).distinct().forEach(t->System.out.print(t+" "));
        // generate 10 random numbers using Stream API

    }
}
