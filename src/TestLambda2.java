import org.junit.Test;

import java.util.Comparator;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/24
 * Description:
 */
public class TestLambda2 {

    @Test
    public void test1() {
        new Thread(()->{
            System.out.println("hello world!");
        },"thread1").start();
    }

    @Test
    public void test2(){

        Comparator<Integer> com = (x,y) -> {
            return  Integer.compare(x,y);
        };

        //简化成---->
        Comparator<Integer> com1 = (x,y) -> Integer.compare(x,y);

        //简化成---->
        Comparator<Integer> com2 = Integer::compare;

        System.out.println(com.compare(3,3));
    }
}
