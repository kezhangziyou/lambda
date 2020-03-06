package performance;


import java.util.*;

/**
 *  性能测试：基本数据类型
 * @author 刘权
 */
public class Test0 {

    public static void main(String[] args) {

        Random random = new Random();
        // 1. 基本数据类型：整数
        List<Integer> integerList = new ArrayList<Integer>();

        for(int i = 0; i < 1000000; i++) {
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }

        // 1) stream
        testStream(integerList);
        // 2) parallelStream
        testParallelStream(integerList);
        // 3) 普通for
        testForloop(integerList);
        // 4) 增强型for
        testStrongForloop(integerList);
        // 5) 迭代器
        testIterator(integerList);



    }

    public static void testStream(List<Integer> list) {
        long start = System.currentTimeMillis();

        Optional optional = list.stream().max(Integer::compare);
        System.out.println(optional.get());

        long end = System.currentTimeMillis();
        System.out.println("testStream:" + (end - start) + "ms");
    }

    public static void testParallelStream(List<Integer> list) {
        long start = System.currentTimeMillis();

        Optional optional = list.parallelStream().max(Integer::compare);
        System.out.println(optional.get());

        long end = System.currentTimeMillis();
        System.out.println("testParallelStream:" + (end - start) + "ms");
    }

    public static void testForloop(List<Integer> list) {
        long start = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current > max) {
                max = current;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testForloop:" + (end - start) + "ms");
    }

    public static void testStrongForloop(List<Integer> list) {
        long start = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if(integer > max) {
                max = integer;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testStrongForloop:" + (end - start) + "ms");
    }

    public static void testIterator(List<Integer> list) {
        long start = System.currentTimeMillis();

        Iterator<Integer> it = list.iterator();
        int max = it.next();

        while(it.hasNext()) {
            int current = it.next();
            if(current > max) {
                max = current;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testIterator:" + (end - start) + "ms");
    }




}

