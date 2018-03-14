package com.ua.goit.gojava7.ryzhkov.mapper;

import com.ua.goit.gojava7.ryzhkov.writer.IJsonWriter;

import java.util.Arrays;

public class ObjectArrayMapper extends AbstractMapper {

    @Override
    public void write(Object obj, IJsonWriter writer) throws ClassCastException {
        if (obj == null) {
            writer.writeNull();
        } else {
            Class clazz = obj.getClass().getComponentType();
            if (clazz == Object.class) {
                throw new ClassCastException("Object[] can't serialize correctly");
            }
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












