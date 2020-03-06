package lambda;

/**
 * Created by 刘权 on 2020-3-2.
 */
@FunctionalInterface
interface MyInterface<T, R> {
    R strategy (T t, R r);
}
