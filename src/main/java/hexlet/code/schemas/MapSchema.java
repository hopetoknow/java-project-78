package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private boolean isSizeOf;
    private int sizeof;

    @Override
    public boolean isValid(Object obj) {
        if (!getIsRequired() && obj == null) {
            return true;
        }

        if (!(obj instanceof Map map)) {
            return false;
        }

        if (isSizeOf) {
            setIsValid(map.size() == sizeof);
        }

        return getIsValid();
    }

    public MapSchema sizeof(int size) {
        this.isSizeOf = true;
        this.sizeof = size;
        return this;
    }
}
