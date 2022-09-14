package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringSchemaTest {

    private StringSchema schema;

    /**
     * Initializes a schema and a validator.
     */
    @BeforeAll
    public void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    public void isValid() {
        assertFalse(schema.isValid(2));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid("four out of five"));
        assertTrue(schema.isValid("brainstorm"));
        assertFalse(schema.isValid(2));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        assertTrue(schema.contains("fo").isValid("four out of five"));
        assertTrue(schema.contains("five").isValid("four out of five"));
        assertFalse(schema.contains("fourout").isValid("four out of five"));
        assertFalse(schema.isValid("four out of five"));

        assertTrue(schema.minLength(2).isValid("fiction"));
        assertFalse(schema.minLength(2).isValid("f"));
        assertTrue(schema.minLength(0).isValid(""));
    }
}
