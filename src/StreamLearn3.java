import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/29
 * Description: Stream流 终止操作
 */
public class StreamLearn3 {

    List<Music> music = Arrays.asList(
            new Music("歌1","手1",1, Music.Status.BUSY),
            new Music("歌2","手2",20,Music.Status.FREE),
            new Music("歌3","手3",30,Music.Status.BUSY),
            new Music("歌4","手4",40,Music.Status.BUSY),
            new Music("歌5","手5",50,Music.Status.FREE),
            new Music("歌6","手6",60,Music.Status.FREE)
    );

    //查找与匹配
    //allMatch——检查是否匹配所有元素      必须全部都满足才会返回true
    @Test
    public void test1(){
        boolean b1 = music.stream()
                .allMatch(e->e.getStatus().equals(Music.Status.BUSY));
        System.out.println(b1);
    }

    //anyMatch——检查是否匹配至少一个元素    只要有一个条件满足即返回true
    @Test
    public void test2(){
        boolean b2 = music.stream()
                .anyMatch(e->e.getStatus().equals(Music.Status.BUSY));
        System.out.println(b2);
    }

    //noneMatch——检查是否没有匹配所有元素   全部不满足返回true
    @Test
    public void test3(){
        boolean b3 = music.stream()
                .noneMatch(e->e.getStatus().equals(Music.Status.BUSY));
        System.out.println(b3);
    }

    //findFirst——返回第一个元素
    @Test
    public void test4(){
        Optional<Music> optional = music.stream()
                .sorted((e1, e2) -> e1.getNum().compareTo(e2.getNum()))
                .findFirst();

        System.out.println(optional.get());
    }

    //findAny——返回任意一个元素
    @Test
    public void test5(){
        Optional<Music> optional = music.stream()
                .filter(e -> e.getStatus().equals(Music.Status.FREE))
                .findAny();

        System.out.println(optional.get());
    }

    //count——返回流中元素的总个数
    @Test
    public void test6(){
        long count = music.stream()
                .filter(e -> e.getStatus().equals(Music.Status.FREE))
                .count();

        System.out.println(count);
    }

    //max——返回流中元素的最大值
    @Test
    public void test7(){
        Optional<Music> max = music.stream()
                .max((e1, e2) -> Integer.compare(e1.getNum(), e2.getNum()));
        System.out.println(max.get());
    }

    //min——返回流中元素的最大值
    @Test
    public void test8(){
        Optional<Integer> min = music.stream()
                .map(Music::getNum)
                .min(Integer::compare);
        System.out.println(min.get());
    }

    //规约
    //reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ————可以将流中的元素反复结合起来，得到一个值。
    @Test
    public void test9(){
        //计算num之和
        Integer reduce = music.stream()
                .map(Music::getNum)
                .reduce(0, (x, y) -> x + y);

        // ↑ 不会为null，起始为0
        // ↓ 可能为null 所以返回Optional

        Optional<Integer> optional = music.stream()
                .map(Music::getNum)
                .reduce(Integer::sum);

        System.out.println(reduce);
        System.out.println(optional.get());
    }

    //收集
    //collect——将流转化为其他形式。接受一个Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test10(){
        List<String> collect = music.stream()
                .map(Music::getName)
                .collect(Collectors.toList());

        HashSet<String> collect1 = music.stream()
                .map(Music::getName)
                .collect(Collectors.toCollection(HashSet::new));

        collect.forEach(System.out::println);
        collect1.forEach(System.out::println);
    }

    //分组 groupingBy
    @Test
    public void test11(){

        Map<Music.Status, List<Music>> collect = music.stream()
                .collect(Collectors.groupingBy(Music::getStatus));

        System.out.println(collect);
    }

    //多级分组 groupingBy
    @Test
    public void test12(){
        Map<Music.Status, Map<String, List<Music>>> collect = music.stream()
                .collect(Collectors.groupingBy(Music::getStatus, Collectors.groupingBy(e -> {
                    if (e.getNum() >= 30) {
                        return "高产";
                    } else {
                        return "低产";
                    }
                })));

        System.out.println(collect);
    }

    //分区 partitioningBy
    @Test
    public void test13(){
        Map<Boolean, List<Music>> collect = music.stream()
                .collect(Collectors.partitioningBy(e -> e.getNum() > 30));

        System.out.println(collect);
    }

    //连接 join
    @Test
    public void test14(){
        String collect = music.stream()
                .map(Music::getName)
                .collect(Collectors.joining(",", "[", "]"));

        System.out.println(collect);
    }


}
