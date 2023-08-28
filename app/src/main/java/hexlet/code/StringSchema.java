package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema extends BaseSchema {
    private List<Integer> minLength;
    private List<String> contains;

    public StringSchema() {
        super();
        minLength = new ArrayList<>();
        contains = new ArrayList<>();
    }

    public void minLength(int addedMinLength) {
        this.minLength.add(addedMinLength);
    }

    public StringSchema contains(String addedRequiredString) {
        this.contains.add(addedRequiredString);
        return this;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }

        if (this.getRequired() && (obj.toString().isEmpty() || obj == null)) {
            return false;
        }

        String string = obj.toString();
        for (var length : this.minLength) {
            if (string.length() < length) {
                return false;
            }
        }
        for (var neededString : this.contains) {
            if (!string.toLowerCase().contains(neededString.toLowerCase())) {
                return false;
            }
        }

        return true;
    }
}
