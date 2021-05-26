import com.lyentech.bdc.exception.BusinessException;

/**
 * 查找小于n的整数中，与m的最大公约数为1的整数个数并打印
 */
public class Test111323 {
    public static void main(String[] args) {
        System.out.println(get(1200,420));
    }

    public static int get(int n,int m){
        if(n<=0){
            throw new BusinessException("n不小于等于0");
        }
        int j=0;
        for(int i=1;i< 1200;i++){
            if((i%2!=0) && (i % m) % 3 !=0 && (i % m) % 5 !=0 && (i % m) % 7 !=0){
                j++;
                System.out.println(i);
            }
        }
        return j;
    }
}
