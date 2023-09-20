package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        this.addPredicate("required", o -> o instanceof Map<?, ?>);
    }
    @Override
    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int sizeRequirement) {
        Predicate<Object> predicate = o -> {
            Map<Object, Object> map = (Map<Object, Object>) o;
            return map.size() == sizeRequirement;
        };
        this.addPredicate("sizeof", predicate);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schema) {
        Predicate<Object> predicate = o -> {
            if (o instanceof Map) {
                for (var key : schema.keySet()) {
                    if (((Map<?, ?>) o).containsKey(key)) {
                        if (!(schema.get(key).isValid(((Map<?, ?>) o).get(key)))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        };
        this.addPredicate("shape", predicate);
        return this;
    }
}
