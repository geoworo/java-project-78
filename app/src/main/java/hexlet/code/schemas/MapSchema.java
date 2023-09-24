package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        this.addPredicate("isRequired", o -> o instanceof Map<?, ?>);
    }
    @Override
    public MapSchema required() {
        this.isRequired = true;
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
            return schema.keySet()
                    .stream()
                    .filter(k -> ((Map) o).containsKey(k))
                    .allMatch(k -> schema.get(k).isValid(((Map) o).get(k)));

        };
        this.addPredicate("shape", predicate);
        return this;
    }
}
