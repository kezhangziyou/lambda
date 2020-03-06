package performance;


import java.util.*;

/**
 * 性能测试：复杂数据类型：对象
 *
 * @author 刘权
 */
public class Test1 {

    public static void main(String[] args) {

        Random random = new Random();

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            productList.add(new Product("pro" + i, i, random.nextInt(Integer.MAX_VALUE)));
        }

        // 调用执行
        testProductStream(productList);
        testProductParallelStream(productList);
        testProductForloop(productList);
        testProductStrongForloop(productList);
        testProductIterator(productList);

    }


    public static void testProductStream(List<Product> list) {
        long start = System.currentTimeMillis();

        Optional optional = list.stream().max((p1, p2) -> p1.hot - p2.hot);
        System.out.println(optional.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductStream:" + (end - start) + "ms");
    }

    public static void testProductParallelStream(List<Product> list) {
        long start = System.currentTimeMillis();

        Optional optional = list.stream().max((p1, p2) -> p1.hot - p2.hot);
        System.out.println(optional.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductParallelStream:" + (end - start) + "ms");
    }

    public static void testProductForloop(List<Product> list) {
        long start = System.currentTimeMillis();

        Product maxHot = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Product current = list.get(i);
            if (current.hot > maxHot.hot) {
                maxHot = current;
            }
        }
        System.out.println(maxHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductForloop:" + (end - start) + "ms");
    }

    public static void testProductStrongForloop(List<Product> list) {
        long start = System.currentTimeMillis();

        Product maxHot = list.get(0);
        for (Product product : list) {
            if (product.hot > maxHot.hot) {
                maxHot = product;
            }
        }
        System.out.println(maxHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductStrongForloop:" + (end - start) + "ms");
    }

    public static void testProductIterator(List<Product> list) {
        long start = System.currentTimeMillis();

        Iterator<Product> it = list.iterator();
        Product maxHot = it.next();

        while (it.hasNext()) {
            Product current = it.next();
            if (current.hot > maxHot.hot) {
                maxHot = current;
            }
        }
        System.out.println(maxHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductIterator:" + (end - start) + "ms");
    }

}

