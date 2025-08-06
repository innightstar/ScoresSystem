package Tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> {
    private int code;
    private String msg;
    private T data;
    private int count;
    public Map<String, Object> getMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("msg", msg);
        result.put("data",data);
        result.put("count", count);
        return result;
    }
}
