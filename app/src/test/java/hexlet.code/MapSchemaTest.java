package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {
    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        Map<String, String> data = new HashMap<>();
        assertTrue(schema.isValid(data));
        data.put("one", "two");

        schema.sizeOf(2);

        assertFalse(schema.isValid(data));
        data.put("three", "four");
        assertTrue(schema.isValid(data));
    }
}
