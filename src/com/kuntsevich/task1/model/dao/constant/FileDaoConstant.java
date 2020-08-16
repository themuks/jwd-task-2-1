package com.kuntsevich.task1.model.dao.constant;

import java.util.ResourceBundle;

public class FileDaoConstant {
    public static final String DB_FILE_PATH;
    static {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        DB_FILE_PATH = resource.getString("path").concat(resource.getString("name"));
    }
    public static final char VALUE_DELIMITER = '=';
    public static final String PARAM_DELIMITER = ", ";
    public static final char CLASS_NAME_DELIMITER = ':';
}
