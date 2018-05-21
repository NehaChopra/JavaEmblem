package LamdaExpressions;

@FunctionalInterface
public interface Generic<T> {
	public abstract T computation(T t);
}
