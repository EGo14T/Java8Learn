import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/29
 * Description: Stream流的中间操作
 *
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，
 * 否则中间操作不会执行任何的处理，而在终止操作时一次性全部处理
 * 称为“惰性求值”
 */
public class StreamLearn2 {

    List<Music> music = Arrays.asList(
            new Music("歌1","手1",1),
            new Music("歌2","手2",20),
            new Music("歌3","手3",30),
            new Music("歌4","手4",40),
            new Music("歌5","手5",50),
            new Music("歌6","手6",60),
            new Music("歌6","手6",70),
            new Music("歌6","手6",60)
    );


    //一、筛选与切片

    //filter——接收Lambda，从流中排除某些元素
     @Test
    public void test1(){
         //内部迭代：迭代操作由Stream API完成
         music.stream()
                 .filter((e)->e.getNum()>10)
                 .forEach(System.out::println);
     }

     //limit——截断流，使其元素不超过给定数量
    @Test
    public void test2(){
         music.stream()
                 .filter((e)->{
                     System.out.println("短路！ limit操作拿到给定数量的值后，就不再继续执行称为短路操作");
                     return e.getNum()>10;
                 })
                 .limit(2)
                 .forEach(System.out::println);
    }

    //skip(n)——跳过元素，返回一个扔掉了前n个元素的流，
    // 若流中元素不足n个，则返回一个空流，与limit(n)互补
    @Test
    public void test3(){
         music.stream()
                 .filter((e)->e.getNum()>10)
                 .skip(2)
                 .forEach(System.out::println);

    }

    //distinct——筛选，通过流生成元素的hashCode()和equals()去除重复元素
    @Test
    public void test4(){
        music.stream()
                .filter((e)->e.getNum()>10)
                .skip(2)
                .distinct()
                .forEach(System.out::println);

    }


    //二、映射
    //map——接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
    @Test
    public void test5(){
         List<String> list = Arrays.asList("aaa","bbb","ccc");
         list.stream()
                 .map(s -> s.toUpperCase())
                 .forEach(System.out::println);

        System.out.println("------------------------");

        music.stream()
                .map(Music::getName)
                .forEach(System.out::println);
    }

    //flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream()
                .flatMap(StreamLearn2::filterCharater)
                .forEach(System.out::println);

    }

    public static Stream<Character> filterCharater(String str){
         List<Character> list = new ArrayList<>();

        for (Character ch :
                str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    //三、排序
    //sorted()——自然排序（Comparable）
    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    //sorted(Comparator com)——定制排序（Comparator）
    @Test
    public void test8(){
        music.stream()
                .sorted((e1,e2)->{
                    if (e1.getName().equals(e2.getName())){
                        return e1.getNum().compareTo(e2.getNum());
                    }else {
                        return e1.getName().compareTo(e2.getName());
                    }
                })
                .forEach(System.out::println);
    }

}
