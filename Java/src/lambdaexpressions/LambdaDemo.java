package lambdaexpressions;

// functional interface : an interface with just one abstract method, remaining default methods, static methods

interface Calc{
    int add(int x, int y);
}

class MyCalcClass implements Calc{
    public int add(int x, int y){
        return x+y;
    }
}

public class LambdaDemo {
    static class MyCalcInner implements Calc{
        public int add(int x, int y){return x+y;}
    }
    public static void main(String[] args){
        MyCalcClass c1=new MyCalcClass();
        System.out.println(c1.add(4,5));
        MyCalcInner i1=new MyCalcInner();
        i1.add(1,3);

        // We cannot instantiate interfaces directly,
        // but functional interfaces can be implemented using lambda expressions or anonymous classes because they contain exactly one abstract method.
        // When we implement using an anonymous class, it will override the abstract method in the functional interface.
        // if we do that for normal interface, it will become ambiguous for compiler since there will be multiple abstract methods.
        // We need to implement the abstract method in the instance
        // When we create an anonymous implementation of an interface, Java generates an anonymous class behind the scenes.
        Calc calc1=new Calc() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };
        System.out.println(calc1.add(4,1));


        // creating an instance for functional interface using lambda expression
        // only works with functional interface since the functional interface contains only one abstract method.
        // so it will be easy to implement the abstract method
        Calc calc3=(int a, int b)->{return a+b;};
        Calc calc4=(a,b)->{return a+b;};
        Calc calc5=(a,b)->a+b;


    }
}
