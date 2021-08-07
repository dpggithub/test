import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TongJiChar {
    public static void main(String[] args) {
        TongJiChar tongJiChar =new TongJiChar();
        tongJiChar.TJChars("dhuwhduhqduhujjgvsfsw,dcbhha哈哈哈无额虎屋哈哈哈各地");
    }

    /**
     * 统计字符串中各字符的个数
     * @param str 输入的字符串
     */
    public void TJChars(String str){
        Map<String,Integer> map =new HashMap<>();
        Set<String> set =new HashSet<>();
        char[] chars =str.toCharArray();
        for(char c:chars){
            set.add(String.valueOf(c));
        }
        int k=0;
        for(String c:set) {
            for (int i=0;i<chars.length;i++) {
                if (c.equals(String.valueOf(chars[i]))) {
                    map.put(c, ++k);
                }
                if(i==chars.length-1){
                    k=0;
                }
            }
        }
        for(Map.Entry<String,Integer> m: map.entrySet()) {
            System.out.println("字符 "+m.getKey()+" 有"+m.getValue()+"个");
        }
    }
}
