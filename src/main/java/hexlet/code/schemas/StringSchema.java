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

        if (getIsRequired()) {
            setIsValid(str.length() > 0);
        }

        if (isContains) {
            setIsValid(str.contains(containedText));
        }

        if (isMinLength) {
            setIsValid(str.length() >= minLength);
        }

        return getIsValid();
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
