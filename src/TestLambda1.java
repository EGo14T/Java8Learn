import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/24
 * Description:
 */
public class TestLambda1 {

    //匿名内部类写法
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

    }


    //Lambda表达式写法
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }


    //匿名内部类写法
    @Test
    public void test3(){
        List<Integer> a = Arrays.asList(1,2,3,4,5);
        List<Integer> b = filter(a, new Predicate<Integer>() {
            @Override
            public boolean filter(Integer integer) {
                return integer>4;
            }
        });
        for (int c :
                b)
            System.out.println(c);
    }

    //Lambda表达式写法
    @Test
    public void test4(){
        List<Integer> a = Arrays.asList(1,2,3,4,5);
        List<Integer> b = filter(a, x -> x>4);
        b.forEach(System.out::println);
    }


    //Stream流 写法
    @Test
    public void test5(){
        List<Integer> a = Arrays.asList(1,2,3,4,5);
        a.stream().filter(x->x>3).forEach(System.out::println);
    }



    public List<Integer> filter(List<Integer> list , Predicate<Integer> predicate){
        List<Integer> list1 = new ArrayList<>();
        for (int b :
                list) {
            if (predicate.filter(b)){
                list1.add(b);
            }
        }
        return list1;
    }

    public static Integer test6(){
        return 123;
    }


    @Test
    public void test7(){
        Supplier<Integer> supplier = TestLambda1::test6;
        System.out.println(supplier.get());
        System.out.println(TestLambda1.test6());
    }
}
