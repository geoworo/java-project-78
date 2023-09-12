package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private boolean required;
    private boolean sizeRestricted;
    private int size;
    private Map<String, BaseSchema> schemas;

    public MapSchema() {
        this.required = false;
        this.sizeRestricted = false;
        this.size = 0;
        this.schemas = new HashMap<>();
    }

    @Override
    public MapSchema required() {
        this.required = true;
        Predicate<Object> predicate = o -> (o instanceof Map<?, ?>) && !(o == null);
        this.addPredicate(predicate);
        return this;
    }

    public MapSchema sizeof(int sizeRequirement) {
        this.sizeRestricted = true;
        this.size = sizeRequirement;
        Predicate<Object> predicate = o -> {
            Map<Object, Object> map = (Map<Object, Object>) o;
            return map.size() == sizeRequirement;
        };
        this.addPredicate(predicate);
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
        this.addPredicate(predicate);
        return this;
    }
}
