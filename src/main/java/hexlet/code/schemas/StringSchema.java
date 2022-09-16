package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private String containedText;
    private boolean isContains;
    private boolean isMinLength;
    private int minLength;

    @Override
    public boolean isValid(Object obj) {
        if (!getIsRequired() && obj == null) {
            return true;
        }

        if (!(obj instanceof String str)) {
            return false;
        }

        if (getIsRequired() && !(str.length() > 0)) {
            return false;
        }

        if (isContains && !str.contains(containedText)) {
            return false;
        }

        if (isMinLength && !(str.length() >= minLength)) {
            return false;
        }

        return true;
    }

    @Override
    public StringSchema required() {
        setIsRequired(true);
        return this;
    }

    public StringSchema contains(String str) {
        this.isContains = true;
        this.containedText = str;
        return this;
    }

    public StringSchema minLength(int length) {
        this.isMinLength = true;
        this.minLength = length;
        return this;
    }
}
