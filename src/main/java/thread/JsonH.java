package thread;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonH {
    private Integer code;

    private List<JsonString> jsonStringList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<JsonString> getJsonStringList() {
        return jsonStringList;
    }

    public void setJsonStringList(List<JsonString> jsonStringList) {
        this.jsonStringList = jsonStringList;
    }

    static class JsonString {
        private String a;

        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

    public static void main(String[] args) {
        JsonH json=new JsonH();
        List<JsonString> jsonStringList=new ArrayList<>();
        json.setCode(200);

        JsonH.JsonString jsonString=new JsonH.JsonString();
        jsonString.setA("abc");
        jsonString.setB("123");
        jsonStringList.add(jsonString);

        json.setJsonStringList(jsonStringList);

        String json1=JSONObject.toJSONString(json);
        System.out.println(json1);
    }
}
