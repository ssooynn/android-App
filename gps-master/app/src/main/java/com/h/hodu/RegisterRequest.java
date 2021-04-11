package com.h.hodu;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.AuthFailureError;

import java.util.HashMap;
import java.util.Map;


public class RegisterRequest extends StringRequest {

    //서버 url 설정 (php 파일 연동)
    final static private String URL = "http://hodu1009.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, int userDate, int userPhone, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userDate", userDate + "");
        map.put("userPhone", userPhone + "");
    }

    @Override
    public Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
