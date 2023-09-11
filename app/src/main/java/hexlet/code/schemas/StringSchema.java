package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    private boolean required;
    private List<Integer> minLength;
    private List<String> contains;

    public StringSchema() {
        this.required = false;
        this.minLength = new ArrayList<>();
        this.contains = new ArrayList<>();
    }

    public StringSchema required() {
        this.required = true;
        Predicate<Object> predicate = o -> !(o == null) && !(o.toString().isEmpty()) && (o instanceof String);
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema minLength(int addedMinLength) {
        this.minLength.add(addedMinLength);
        Predicate<Object> predicate = o -> {
            for (var length : this.minLength) {
                if (o.toString().length() < length) {
                    return false;
                }
            }
            return true;
        };
        this.addPredicate(predicate);
        return this;
    }

    public StringSchema contains(String addedRequiredString) {
        this.contains.add(addedRequiredString.toLowerCase());
        Predicate<Object> predicate = o -> {
            for (var content: contains) {
                if (!o.toString().toLowerCase().contains(content)) {
                    return false;
                }
            }
            return true;
        };
        addPredicate(predicate);
        return this;
    }
}
