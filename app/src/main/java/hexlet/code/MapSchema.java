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

    public boolean isValid(Object obj) {
        if (obj == null) {
            return !(this.getRequired());
        }

        if (obj instanceof Map<?, ?>) {
            Map<?, ?> map = (Map<?, ?>) obj;
            if (sizeRestricted) {
                int num = 0;
                for (var entry: map.entrySet()) {
                    num++;
                }
                return num == this.size;
            }
            return true;
        }

        return false;
    }
}
