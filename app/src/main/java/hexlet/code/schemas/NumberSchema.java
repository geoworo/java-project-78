package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
    }

    public NumberSchema positive() {
        Predicate<Object> predicate = o -> (o == null) || !(o instanceof Integer) || ((int) o > 0);
        this.addPredicate(predicate);
        return this;
    }

    public NumberSchema range(int lowest, int highest) {
        Predicate<Object> predicate = o -> ((int) o >= lowest) && ((int) o <= highest);
        this.addPredicate(predicate);
        return this;
    }
}
