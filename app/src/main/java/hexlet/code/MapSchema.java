package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private boolean sizeRestricted;
    private int size;

    public MapSchema() {
        super();
        this.sizeRestricted = false;
        this.size = 0;
    }

    public void sizeOf(int sizeRequirement) {
        this.sizeRestricted = true;
        this.size = sizeRequirement;
    }

    public boolean isValidRequired(Object obj) {
        if (obj == null) {
            return !(this.getRequired());
        } else {
            return true;
        }
    }

    public boolean isValidSize(Object obj) {
        if (obj instanceof Map<?, ?>) {
            Map<?, ?> map = (Map<?, ?>) obj;
            return map.size() == size;
        }
        return true;
    }

    public boolean isValid(Object obj) {
        return isValidSize(obj) && isValidRequired(obj);
    }
}
