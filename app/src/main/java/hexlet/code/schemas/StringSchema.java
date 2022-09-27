package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addRequirement("initial", string -> string == null || string instanceof String);
    }

    public StringSchema required() {
        addRequirement("required", string -> string instanceof String && !((String) string).isEmpty());
        return this;
    }

    public StringSchema contains(String str) {
        addRequirement("contains", string -> string instanceof String && ((String) string).contains(str));
        return this;
    }

    public StringSchema minLength(int length) {
        addRequirement("minLength", string -> string instanceof String && ((String) string).length() >= length);
        return this;
    }
}
