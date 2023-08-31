package hexlet.code.schemas;

public abstract class BaseSchema {
    private boolean required;

    public BaseSchema() {
        this.required = false;
    }

    public BaseSchema required() {
        this.required = true;
        return this;
    }

    public boolean getRequired() {
        return required;
    }

    public abstract boolean isValid(Object obj);
}
