package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
        Predicate<Object> predicate = o -> {
            return o instanceof Integer;
        };
        this.addPredicate("required", predicate);
    }

    @Override
    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> predicate = o -> (o == null) || !(o instanceof Integer) || ((int) o > 0);
        this.addPredicate("positive", predicate);
        return this;
    }

    public NumberSchema range(int lowest, int highest) {
        Predicate<Object> predicate = o -> ((int) o >= lowest) && ((int) o <= highest);
        this.addPredicate("range", predicate);
        return this;
    }
}
