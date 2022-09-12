package hexlet.code;

public final class StringSchema {

    private String containedText = "";
    private int minLength;
    private boolean isRequired;
    private boolean isContains;
    private boolean isMinLength;

    public boolean isValid(String str) {
        boolean isValid = true;

        if (isRequired) {
            if (str == null) {
                return false;
            }
            isValid = str.length() > 0;
        }

        if (isContains) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            isValid = str.contains(containedText);
        }

        if (isMinLength) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            isValid = str.length() >= minLength;
        }

        return isValid;
    }

    public void required() {
        this.isRequired = true;
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
