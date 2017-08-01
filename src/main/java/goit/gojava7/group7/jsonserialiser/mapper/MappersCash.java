package goit.gojava7.group7.jsonserialiser.mapper;

import java.util.HashMap;
import java.util.Map;

public class MappersCash {

    private static MappersCash instanceMapperCash = new MappersCash();
    private Map<String, AbstractMapper> cash;

    public static final String STRING_MAPPER_NAME = "stringMapper";
    public static final String NUMBER_MAPPER_NAME = "numberMapper";
    public static final String BOOLEAN_MAPPER_NAME = "booleanMapper";
    public static final String COLLECTION_MAPPER_NAME = "collectionMapper";
    public static final String MAP_MAPPER_NAME = "mapMapper";
    public static final String OBJECT_ARRAY_MAPPER_NAME = "objectArrayMapper";
    public static final String PRIMITIVE_ARRAY_MAPPER_NAME = "primitiveArrayMapper";
    public static final String CHARACTER_MAPPER_NAME = "characterMapper";

    private MappersCash() {
        cash = new HashMap<>();
        putAllStandardMappers();
    }

    private void putAllStandardMappers() {
        putMapper(STRING_MAPPER_NAME, new StringMapper());
        putMapper(CHARACTER_MAPPER_NAME, new CharacterMapper());
        putMapper(NUMBER_MAPPER_NAME, new NumberMapper());
        putMapper(BOOLEAN_MAPPER_NAME, new BooleanMapper());
        putMapper(COLLECTION_MAPPER_NAME, new CollectionMapper());
        putMapper(MAP_MAPPER_NAME, new MapMapper());
        putMapper(OBJECT_ARRAY_MAPPER_NAME, new ObjectArrayMapper());
        putMapper(PRIMITIVE_ARRAY_MAPPER_NAME, new PrimitiveArrayMapper());
    }

    public static MappersCash getInstance() {
        return instanceMapperCash;
    }

    public void putMapper(String mapperName, AbstractMapper mapper) {
        cash.put(mapperName, mapper);
    }

    public AbstractMapper getMapper(String mapperName) {
        return cash.get(mapperName);
    }

}