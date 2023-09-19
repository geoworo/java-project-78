package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        Predicate<Object> predicate = o -> !(o == null) && o instanceof String && !(o.equals(""));
        this.addPredicate("required", predicate);
    }

    @Override
    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int addedMinLength) {
        Predicate<Object> predicate = o -> {
            String string = o.toString();
            return string.length() >= addedMinLength;
        };
        this.addPredicate("minLength", predicate);
        return this;
    }

    public StringSchema contains(String addedRequiredString) {
        Predicate<Object> predicate = o -> {
            if (!o.toString().contains(addedRequiredString)) {
                return false;
            }
            return true;
        };
        addPredicate("contains", predicate);
        return this;
    }
}
