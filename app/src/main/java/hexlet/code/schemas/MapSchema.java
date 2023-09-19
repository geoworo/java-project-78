package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private Map<String, BaseSchema> schemas;

    public MapSchema() {
        super();
        this.schemas = new HashMap<>();
        Predicate<Object> predicate = o -> o instanceof Map<?, ?>;
        this.addPredicate("required", predicate);
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
        this.schemas = schema;
        Predicate<Object> predicate = o -> {
            if (o instanceof Map) {
                for (var key : this.schemas.keySet()) {
                    if (((Map<?, ?>) o).containsKey(key)) {
                        if (!(this.schemas.get(key).isValid(((Map<?, ?>) o).get(key)))) {
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
