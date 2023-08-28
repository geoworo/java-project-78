package hexlet.code;

public abstract class BaseSchema {
    private boolean required;

    public BaseSchema() {
        this.required = false;
    }

    public void required() {
        this.required = true;
    }

    public boolean getRequired() {
        return required;
    }

    public abstract boolean isValid(Object obj);
}
