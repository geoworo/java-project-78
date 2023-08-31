package hexlet.code.schemas;

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

    public StringSchema minLength(int addedMinLength) {
        this.minLength.add(addedMinLength);
        return this;
    }

    public StringSchema contains(String addedRequiredString) {
        this.contains.add(addedRequiredString);
        return this;
    }

    private boolean isValidRequired(Object obj) {
        return !(this.getRequired() && (obj.toString().isEmpty() || obj == null));
    }

    private boolean isValidLength(Object obj) {
        String string = obj.toString();
        for (var length : this.minLength) {
            if (string.length() < length) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidContains(Object obj) {
        String string = obj.toString();
        for (var neededString : this.contains) {
            if (!string.toLowerCase().contains(neededString.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Object obj) {
        return (obj instanceof String && this.isValidContains(obj)
                && this.isValidLength(obj) && this.isValidRequired(obj));
    }
}
