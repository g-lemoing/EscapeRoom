package DAO;

import classes.EscapeRoom;
import connections.callback.CallBack;
import connections.query.resultAttribute.Attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser<T> {

    CallBack<T> callback;

    public Parser(CallBack<T> callback) {
        this.callback = callback;
    }

    public void method(T object, HashMap<String, Attribute> values) {
        for (Map.Entry<String, Attribute> set: values.entrySet()) {
            Attribute attribute = set.getValue();
            switch (attribute.getType()) {
                case STRING -> callback.onCallbackString(object, attribute);
                case INT -> callback.onCallbackInt(object, attribute);
                default -> {
                }
            }
        }
    }
}
