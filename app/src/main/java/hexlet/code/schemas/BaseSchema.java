package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean required;
    private List<Predicate> predicates;

    public BaseSchema() {
        this.required = false;
        this.predicates = new ArrayList<>();
    }

    public final void addPredicate(Predicate predicate) {
        this.predicates.add(predicate);
    }

    public BaseSchema required() {
        this.required = true;
        return this;
    }

    public final boolean isValid(Object obj) {
        if (required) {
            if (obj == null || obj.toString().isEmpty()) {
                return false;
            }
            if (this instanceof MapSchema && !(obj instanceof Map<?,?>)) {
                return false;
            } else if (this instanceof NumberSchema && !(obj instanceof Integer)) {
                return false;
            } else if (this instanceof StringSchema && !(obj instanceof String)) {
                return false;
            }
        }
        for (Predicate predicate: this.predicates) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
