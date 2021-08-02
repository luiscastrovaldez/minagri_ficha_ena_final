package pe.gob.minagri.ena.util;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringArrayConverter implements PropertyConverter<List<String>, String> {

    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return new LinkedList<>();
        } else {
            return new LinkedList<>(Arrays.asList(databaseValue.split(",")));
        }
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        if (entityProperty == null || entityProperty.size() == 0) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < entityProperty.size(); i++) {
                if (i != 0) sb.append(',');
                if (entityProperty.get(i) != null) sb.append(entityProperty.get(i));
            }
            return sb.toString();
        }
    }
}
