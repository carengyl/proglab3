import java.util.function.Function;

public class testClass {
    public static void main(String[] args) {
        Operationable operation;
        operation = (x,y)->x+y;

        int result = operation.calculate(10, 20);
        System.out.println(result); //30
        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("5");
        System.out.println(integer == 5);
    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
interface Operationable{
    int calculate(int x, int y);
}

