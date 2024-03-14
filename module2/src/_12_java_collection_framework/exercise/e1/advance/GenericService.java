package _12_java_collection_framework.exercise.e1.advance;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericService {
    private List<Object> list = new ArrayList<>();

    public void create(Object o) {
        list.add(o);
    }

    public void update(Object o) {
        Object t = getValueByField(o, "id");

        for (int i = 0; i < list.size(); i++) {
            Object s = getValueByField(list.get(i), "id");

            if (t.equals(s)) {
                list.set(i, o);
                break;
            }
        }
    }

    public List findAll() {
        return list;
    }

    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            Object s = getValueByField(list.get(i), "id");
            if (s.equals(id)) {
                list.remove(i);
                break;
            }
        }
    }

    public List search(String field, String val){
        List<Object> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object s = getValueByField(list.get(i), field);
            String sVal = (String) s;
            if (sVal.contains(val)) {
                result.add(list.get(i));
            }
        }

        return result;
    }

    public void sort(String field, boolean isDESC){
        Collections.sort(list, (o1, o2) -> {
            double f1 = (Double) getValueByField(o1, field);
            double f2 = (Double) getValueByField(o2, field);

            return isDESC ? (int)(f2 -f1) : (int)(f1 -f2);
        });
    }

    private Object getValueByField(Object o, String field) {
        Object result = null;

        try {
            Class<?> clazz = o.getClass();
            Field f = clazz.getDeclaredField(field);
            f.setAccessible(true);
            result = f.get(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
