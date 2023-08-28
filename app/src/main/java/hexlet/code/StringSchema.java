package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {

    private boolean required;
    private List<Integer> minLength;
    private List<String> contains;

    public StringSchema() {
        required = false;
        minLength = new ArrayList<>();
        contains = new ArrayList<>();
    }

    public void required() {
        this.required = true;
    }

    public void minLength(int addedMinLength) {
        this.minLength.add(addedMinLength);
    }

    public StringSchema contains(String addedRequiredString) {
        this.contains.add(addedRequiredString);
        return this;
    }

    public boolean isValid(Object obj) {
        if (obj instanceof String) {
            String string = obj.toString();
            if (this.required && (string.isEmpty())) {
                return false;
            }
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
        } else {
            return false;
        }
    }
}
