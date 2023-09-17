package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        Predicate<Object> predicate = o -> !(o == null) && !(o.toString().isEmpty()) && (o instanceof String);
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema minLength(int addedMinLength) {
        Predicate<Object> predicate = o -> {
            if (this.toString().length() < addedMinLength) {
                return false;
            }
            return true;
        };
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema contains(String addedRequiredString) {
        Predicate<Object> predicate = o -> {
            if (!o.toString().contains(addedRequiredString)) {
                return false;
            }
            return true;
        };
        addPredicate(predicate);
        return this;
    }
}
