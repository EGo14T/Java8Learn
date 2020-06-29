import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/24
 * Description:
 *
 * Java8 内置四大核心函数式接口
 *
 * 1. Consumer<T> 消费型接口 参数类型 T 返回类型 void
 *      void accept(T t);
 *
 * 2. Supplier<T> 供给型接口 参数类型 无 返回类型 T
 *      T get();
 *
 * 3. Function<T, R> 函数型接口 参数类型 T 返回类型 R
 *      R apply(T t);
 *
 * 4. Predicate<T> 断言型接口 参数类型 T  返回类型 boolean
 *      boolean test(T t);
 */
public class TestLambda3 {


    //Consumer<T> 消费型接口
    @Test
    public void test1(){
        ConsumerTest(100, x-> System.out.println(x*x));
    }

    public void ConsumerTest(Integer a, Consumer<Integer> consumer){
        consumer.accept(a);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2(){
        List<Integer> numList = SupplierTest(5, ()-> (int)(Math.random()*100));
        numList.forEach(System.out::println);
    }

    public List<Integer> SupplierTest(Integer a, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a ; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R> 函数型接口
    @Test
    public void test3(){
        Integer a = FunctionTest(10, x->{
            return x*200;
        });

        System.out.println(a);
    }

    public Integer FunctionTest(Integer a, Function<Integer,Integer> function){
        return function.apply(a);
    }

    //Predicate<T> 断言型接口
    @Test
    public void test4(){
        List<Integer> a = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> res = PredicateTest(a,x->{
            return x > 3;
        });

        res.forEach(System.out::println);
    }

    public List<Integer> PredicateTest(List<Integer> a, Predicate<Integer> predicate){
        List<Integer> list = new ArrayList<>();

        for (Integer b :
                a) {
            if (predicate.test(b)){
                list.add(b);
            }
        }
        return list;
    }
}
