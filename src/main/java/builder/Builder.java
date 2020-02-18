package builder;

public interface Builder<T> {
    void reset();
    T getResult();
}
