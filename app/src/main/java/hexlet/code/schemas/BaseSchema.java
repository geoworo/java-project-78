package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate> predicates;

    public BaseSchema() {
        this.predicates = new ArrayList<>();
    }

    public void addPredicate(Predicate predicate) {
        this.predicates.add(predicate);
    }

    public abstract BaseSchema required();

    public boolean isValid(Object obj) {
        for (Predicate predicate: this.predicates) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
