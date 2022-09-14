package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean isValid = true;
    private boolean isRequired;
    public abstract boolean isValid(Object obj);

    public final BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public final boolean getIsValid() {
        return isValid;
    }

    public final void setIsValid(boolean valid) {
        isValid = valid;
    }

    public final boolean getIsRequired() {
        return isRequired;
    }
}
