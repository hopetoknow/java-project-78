package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addRequirement("initial", number -> number == null || number instanceof Integer);
    }

    public NumberSchema required() {
        addRequirement("required", number -> number instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addRequirement("positive", number -> number instanceof Integer && (Integer) number > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        addRequirement("range", number -> number instanceof Integer
                && (Integer) number >= start && (Integer) number <= end);
        return this;
    }
}
