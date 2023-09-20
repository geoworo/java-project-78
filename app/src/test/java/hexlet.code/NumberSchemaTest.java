package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {
    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));

        schema.required().positive();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertFalse(schema.isValid(-5));

        schema.range(5, 10);
        assertTrue(schema.isValid(6));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(89));
        schema.range(6, 9);
        assertTrue(schema.isValid(6));
    }
}
