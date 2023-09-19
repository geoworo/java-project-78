package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private String testcase1 = "One two three";
    private String testcase2 = "One two three four";
    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema sch = v.string();

        assertTrue(sch.isValid(""));

        sch.required();

        assertFalse(sch.isValid(""));
        assertFalse(sch.isValid(2));
        assertTrue(sch.isValid(testcase1));

        assertFalse(sch.minLength(4).isValid("st"));
        assertTrue(sch.isValid("stri"));
        assertTrue(sch.isValid("string"));

        assertTrue(sch.contains("One").isValid(testcase1));
        assertTrue(sch.contains("two").isValid(testcase2));
        assertTrue(sch.contains("four").isValid(testcase2));
        assertFalse(sch.isValid(testcase1));
    }
}
