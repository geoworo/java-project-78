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

    @Test
    public void testShape() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Jack");
        human1.put("age", 12);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "");
        human2.put("age", 12);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "Jane");
        human3.put("age", null);
        assertTrue(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "John");
        human4.put("age", -6);
        assertFalse(schema.isValid(human4));
    }
}
