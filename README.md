# Java8Learn
# 学习Java8新特性
## Lambda表达式 √
### 四大核心函数式接口
1. Consumer<T> 消费型接口 参数类型 T 返回类型 void
```java
    void accept(T t);
```
2. Supplier<T> 供给型接口 参数类型 无 返回类型 T
```java
    T get();
```
3. Function<T, R> 函数型接口 参数类型 T 返回类型 R
```java
    R apply(T t);
```
4. Predicate<T> 断言型接口 参数类型 T  返回类型 boolean

## Stream 流 √
### 创建流的方法
1. 通过Collection系列集合提供的stream() 和 parallelStream() 获得流
```java
    Stream<String> stream = list.stream();
```
2. 通过Arrays中的静态方法stream() 获得流
```java
    Stream<String> strean = Arrays.stream(list);
```
3. 通过Stream类中的静态方法of() 获得流
```java
    Stream<String> stream = Stream.of("a","b","c");
```
4. 创建无限流
   
    1. 迭代
    
       ```java
       Stream<String> stream = Stream.iterate(0,(x)->x+2);
       ```
    
       
    
    2. 生成
    
       ```java
       Stream<Double> stream = Stream.generate(() -> Math.random());
       ```

### Stream流的中间操作

1. 筛选与切片
2. 映射
3. 排序

### Stream流的终止操作

1. 查找与匹配
2. 规约
3. 收集

#### 收集Collectors

1. 分组
2. 分区
3. 连接

## Optional容器类