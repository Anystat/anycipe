package ru.anystat.anycipe.rest.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by ustits on 21.11.16.
 */
public class JsonUtils {

    private static final String JSON_ERROR =
            "{\"error\":\"400\",\"message\":\"Can't form json error\"}";

    public static ResponseEntity getErrorEntity(Integer code, String message, HttpStatus status) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("error", code);
            jsonObject.put("message", message);
        } catch (JSONException e) {
            return new ResponseEntity<>(JSON_ERROR, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jsonObject.toString(), status);
    }
}
