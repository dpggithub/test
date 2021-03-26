package src.collection;

import java.util.Arrays;

public class Array01 {
    public static void main(String[] args) {
        String[] array1 =new String[]{"apple","banana","watermelon","orange","strawberry"};
        System.out.println(Arrays.asList(delElement(array1,4)).toString());
    }

    public static String[] delElement(String[] arrays, int index) {
        int length = arrays.length;
        //判断数据合理性
        if (index >= 0 && index < length) {
            String[] arrays_result = new String[arrays.length - 1];
            //将arrays数组在index前的元素都复制到新数组arrays_result中
            System.arraycopy(arrays, 0, arrays_result, 0, index);
            //判断index之后是否还有元素，有则将index后的元素从index位置复制到新数组中
            if (index < length - 1) {
                System.arraycopy(arrays, index + 1, arrays_result, index, arrays_result.length - index);
            }
            return arrays_result;
        } else {
            //不合理，抛越界异常
            throw new IndexOutOfBoundsException("index :" + index + ", length: " + length);
        }
    }
}
