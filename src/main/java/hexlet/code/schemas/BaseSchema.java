package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean isRequired;
    public abstract boolean isValid(Object obj);

    public abstract BaseSchema required();

    public final boolean getIsRequired() {
        return isRequired;
    }

    public final void setIsRequired(boolean required) {
        isRequired = required;
    }
}
