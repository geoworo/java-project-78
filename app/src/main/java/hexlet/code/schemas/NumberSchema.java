package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class NumberSchema extends BaseSchema {
    private boolean required;
    private boolean positive;
    private Map<Integer, Integer> range;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.range = new HashMap<>();
    }

    public NumberSchema required() {
        this.required = true;
        return this;
    }
    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int lowest, int highest) {
        this.range.put(lowest, highest);
        return this;
    }

    private boolean isValidRequired(Object obj) {
        if (obj == null) {
            return !this.required;
        } else {
            return true;
        }
    }

    private boolean isValidPositive(Object obj) {
        int num = (int) obj;
        if (positive) {
            return num > 0;
        } else {
            return true;
        }
    }

    private boolean isValidInRange(Object obj) {
        int num = (int) obj;
        for (var key: this.range.keySet()) {
            if (!(num >= key && num <= this.range.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj == null) {
            return isValidRequired(obj);
        } else {
            return obj instanceof Integer && isValidInRange(obj) && isValidPositive(obj);
        }
    }
}
