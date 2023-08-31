package hexlet.code.schemas;

public abstract class BaseSchema {

    public BaseSchema() {
    }

    public abstract boolean isValid(Object obj);
}
