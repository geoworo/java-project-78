package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
        Predicate<Object> predicate = o -> {
            if (o instanceof Integer) {
                return true;
            } else {
                return false;
            }
        };
        this.addPredicate("required", predicate);
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
