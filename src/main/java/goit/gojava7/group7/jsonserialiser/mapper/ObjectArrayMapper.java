package goit.gojava7.group7.jsonserialiser.mapper;

import goit.gojava7.group7.jsonserialiser.writer.IJsonWriter;

import java.util.Arrays;

public class ObjectArrayMapper extends AbstractMapper {

    @Override
    public void write(Object obj, IJsonWriter writer) {
        if (obj == null) {
            writer.writeNull();
        } else {
            Class clazz = obj.getClass().getComponentType();
            Object[] array = (Object[]) obj;
            AbstractMapper elementMapper = jsonSerializer.getMapper(clazz);
            writer.writeArrayBegin();
            Arrays.stream(array).forEach((element) -> {
                elementMapper.write(element, writer);
                writer.writeSeparator();
            });
            writer.writeArrayEnd();
        }
    }

}












