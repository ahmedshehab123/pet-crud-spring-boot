package org.paymob.onlineshop.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodes {
    public static class Pet {

        public static final Map<String, String> Pet_Not_exist = new HashMap<String, String>() {{
            put("en", "Pet Not Exist");
            put("ar", "هذه البيانات غير موجوده او تم حذفها بالفعل ");
        }};

        public static final Map<String, String> FAILED_TO_DELETE = new HashMap<String, String>() {{
            put("en", "Failed To Delete");
            put("ar", " ");
        }};

    }

    public static class PetType {

        public static final Map<String, String> Missing_Pet_type = new HashMap<String, String>() {{
            put("en", "Pet Should Have Type");
            put("ar", "لابد من اختيار نوع");
        }};

    }
}
