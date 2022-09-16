package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean isRequired;
    public abstract boolean isValid(Object obj);

    public final BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public final boolean getIsRequired() {
        return isRequired;
    }
}
