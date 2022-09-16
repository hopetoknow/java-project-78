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

        if (isSizeOf && !(map.size() == sizeof)) {
            return false;
        }

        if (isShape) {
            for (String key: shapeMap.keySet()) {
                if (!isMapValueValid(map, key)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public MapSchema required() {
        setIsRequired(true);
        return this;
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

    private boolean isMapValueValid(Map map, String key) {
        BaseSchema schema = shapeMap.get(key);
        if (schema instanceof StringSchema stringSchema) {
            return stringSchema.isValid(map.get(key));
        } else {
            NumberSchema numberSchema = (NumberSchema) schema;
            return numberSchema.isValid(map.get(key));
        }
    }
}
