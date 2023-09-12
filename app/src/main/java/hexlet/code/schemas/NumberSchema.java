package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    private boolean required;
    private boolean positive;
    private Map<Integer, Integer> range;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.range = new HashMap<>();
    }

    @Override
    public NumberSchema required() {
        this.required = true;
        Predicate<Object> predicate = o -> !(o == null) && (o instanceof Integer);
        this.addPredicate(predicate);
        return this;
    }
    public NumberSchema positive() {
        this.positive = true;
        Predicate<Object> predicate = o -> (o == null) || !(o instanceof Integer) || ((int) o > 0);
        this.addPredicate(predicate);
        return this;
    }

    public NumberSchema range(int lowest, int highest) {
        this.range.put(lowest, highest);
        Predicate<Object> predicate = o -> ((int) o >= lowest) && ((int) o <= highest);
        this.addPredicate(predicate);
        return this;
    }
}
