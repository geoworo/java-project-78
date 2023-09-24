package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addPredicate("isRequired", o -> o instanceof String && !(o.equals("")));
    }

    @Override
    public StringSchema required() {
        this.isRequired = true;
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
        Predicate<Object> predicate = o -> o.toString().contains(addedRequiredString);
        addPredicate("contains", predicate);
        return this;
    }
}
