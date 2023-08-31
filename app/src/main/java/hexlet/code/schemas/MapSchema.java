package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

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

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int sizeRequirement) {
        this.sizeRestricted = true;
        this.size = sizeRequirement;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        this.schemas = map;
        return this;
    }

    private boolean isValidRequired(Object obj) {
        if (obj == null) {
            return !(this.required);
        } else {
            return true;
        }
    }

    private boolean isValidSize(Object obj) {
        if (sizeRestricted) {
            if (obj instanceof Map<?, ?> map) {
                return map.size() == size;
            }
        }
        return true;
    }

    private boolean isValidSchemas(Object obj) {
        if (obj instanceof Map) {
            HashMap<String, BaseSchema> map = (HashMap<String, BaseSchema>) obj;
            for (var key : this.schemas.keySet()) {
                if (map.containsKey(key)) {
                    if (!(this.schemas.get(key).isValid(map.get(key)))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(Object obj) {
        return isValidSize(obj) && isValidRequired(obj) && isValidSchemas(obj);
    }
}
