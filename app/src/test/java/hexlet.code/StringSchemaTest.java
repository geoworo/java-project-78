package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private String empty = "";
    private String testcase1 = "One two three";
    private String testcase2 = "One two three four";
    private int wrongclass = 2;
    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema sch = v.string();

        assertTrue(sch.isValid(empty));

        sch.required();

        assertFalse(sch.isValid(empty));
        assertFalse(sch.isValid(wrongclass));
        assertTrue(sch.isValid(testcase1));

        assertTrue(sch.contains("One").isValid(testcase1));
        assertTrue(sch.contains("two").isValid(testcase2));
        assertTrue(sch.contains("four").isValid(testcase2));
        assertFalse(sch.isValid(testcase1));
    }
}
