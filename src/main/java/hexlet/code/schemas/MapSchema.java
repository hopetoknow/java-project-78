package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Map<String, BaseSchema> shapeMap;
    private boolean isSizeOf;
    private boolean isShape;
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

        if (isShape) {
            boolean tempBool = true;
            for (String key: shapeMap.keySet()) {
                BaseSchema schema = shapeMap.get(key);
                if (schema instanceof StringSchema stringSchema) {
                    tempBool = stringSchema.isValid(map.get(key));
                } else {
                    NumberSchema numberSchema = (NumberSchema) schema;
                    tempBool = tempBool && numberSchema.isValid(map.get(key));
                }
            }

            setIsValid(tempBool);
        }
        return getIsValid();
    }

    public MapSchema sizeof(int size) {
        this.isSizeOf = true;
        this.sizeof = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        this.isShape = true;
        this.shapeMap = map;
        return this;
    }
}
