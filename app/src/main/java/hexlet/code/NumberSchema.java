package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class NumberSchema extends BaseSchema {
    private boolean positive;
    private Map<Integer, Integer> range;

    public NumberSchema() {
        super();
        this.positive = false;
        this.range = new HashMap<>();
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public void range(int lowest, int highest) {
        this.range.put(lowest, highest);
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj == null) {
            return !this.getRequired();
        }

        if (!(obj instanceof Integer)) {
            return false;
        }

        int number = (int) obj;

        if (positive && number < 0) {
            return false;
        }

        for (var key: this.range.keySet()) {
            if (!(number >= key && number <= this.range.get(key))) {
                return false;
            }
        }
        return true;
    }
}
