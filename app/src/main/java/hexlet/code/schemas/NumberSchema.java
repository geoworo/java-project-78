package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        this.addPredicate("isRequired", o -> o instanceof Integer);
    }

    @Override
    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.addPredicate("positive",  o -> o == null || (int) o > 0);
        return this;
    }

    public NumberSchema range(int lowest, int highest) {
        Predicate<Object> predicate = o -> ((int) o >= lowest) && ((int) o <= highest);
        this.addPredicate("range", predicate);
        return this;
    }
}
