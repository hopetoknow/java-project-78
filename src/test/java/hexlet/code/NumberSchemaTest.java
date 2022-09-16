package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberSchemaTest {

    public static final Integer MINUS_TEN = -10;
    public static final Integer FOUR = 4;
    public static final Integer FIVE = 5;
    public static final Integer TEN = 10;
    public static final Integer ELEVEN = 11;

    private NumberSchema schema;

    /**
     * Initializes a schema and a validator.
     */
    @BeforeAll
    public void init() {
        Validator v = new Validator();
        schema = v.number();
    }

    @Test
    public void isValid() {
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(TEN));
        assertFalse(schema.isValid("5"));

        schema.positive();

        assertTrue(schema.isValid(TEN));
        assertFalse(schema.isValid(MINUS_TEN));

        schema.range(FIVE, TEN);

        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(TEN));
        assertFalse(schema.isValid(FOUR));
        assertFalse(schema.isValid(ELEVEN));

        schema.range(MINUS_TEN, TEN);

        assertFalse(schema.isValid(-1));
    }
}
