package stream;

import java.util.*;

/**
 * Copyright (C), 2018-2019, copyright info. DAMU., Ltd.
 * FileName: com Test
 * <p>TODO</p>
 *
 * @author <a href="http://blog.csdn.net/muwenbin_flex">大牧莫邪</a>
 * @version 1.00
 */
public class Test4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        Random random = new Random(Integer.MAX_VALUE);

        for (int i = 0; i < 1000000; i ++) {
            list.add(random.nextInt());
        }

        // 开始计时
        Date begin = new Date();
        System.out.println(begin.getTime());

        // 传统处理模式
//        System.out.println(commenDeal(list));
        // lambda处理模式
        System.out.println(lambdaDeal(list));

        Date end = new Date();
        System.out.println(end.getTime());

        System.out.println("最终用时：" + (end.getTime() - begin.getTime()));
    }

    public static Integer commenDeal(List<Integer> list) {
        Integer result = Integer.MIN_VALUE;

//        for(int i = 0; i < list.size(); i++) {
//            result = Integer.max(result, list.get(i));
//        } // 44

        for (Integer temp : list) {
            result = Integer.max(result, temp);
        } // 46

        return result;
    }

    public static Integer lambdaDeal(List<Integer> list) {

//        Optional<Integer> optional = list.parallelStream().reduce(Integer::max);
//        return optional.get(); // 152

//        Optional<Integer> optional = list.parallelStream().max((x, y) -> x - y);
//        return optional.get(); // 120

        return list.stream().reduce(Integer.MIN_VALUE, (x, y) -> Integer.max(x, y)); // 109

//        Optional<Integer> optional = list.stream().max((x, y)->(x - y));
//        return optional.get(); // 117
    }
}
