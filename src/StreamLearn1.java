import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/29
 * Description: Stream流学习
 */
public class StreamLearn1 {

    @Test
    public void test1(){
        List<String> list = new ArrayList<>();

        //获取Stream流的三种方法
        //1. 通过Collection 系列集合提供的 stream() 和 parallelStream() 获得 流
        Stream<String> stream1 = list.stream();


        //2. 通过Arrays中的静态方法stream()获得 流
        Music[] music = new Music[10];
        Stream<Music> stream2 = Arrays.stream(music);

        //3. 通过Stream类中得静态方法 of()获得 流
        Stream<String> stream3 = Stream.of("abc","a","b");

        //4. 创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);

        //生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());

    }

}
