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

    public boolean isValidRequired(Object obj) {
        return !(this.getRequired() && (obj.toString().isEmpty() || obj == null));
    }

    public boolean isValidLength(Object obj) {
        String string = obj.toString();
        for (var length : this.minLength) {
            if (string.length() < length) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidContains(Object obj){
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
        return (obj instanceof String && this.isValidContains(obj) &&
                this.isValidLength(obj) && this.isValidRequired(obj));
    }
}
