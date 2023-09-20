package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean required;
    protected LinkedHashMap<String, Predicate> predicates;

    public BaseSchema() {
        this.required = false;
        this.predicates = new LinkedHashMap<>();
    }

    protected final void addPredicate(String name, Predicate predicate) {
        this.predicates.put(name, predicate);
    }

    public abstract BaseSchema required();

    public final boolean isValid(Object obj) {
        for (var key: predicates.keySet()) {
            if ((key.equals("required"))) {
                if (this.required && !(predicates.get(key).test(obj))) {
                    return false;
                }
            } else {
                if (!(predicates.get(key)).test(obj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
