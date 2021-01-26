package thread.mail;

public class MailReceive {
    public static void main(String[] args) {
        String str="ABCDEFGHFhjhhgghjjyjygkii";
        new MailReceive().pingJie(str);

    }

    private String pingJie(String str){
        StringBuilder stringBuilder=new StringBuilder();
        int length=str.length();
        int x=0,y=0;
        int time=length % 2 ==0 ? length/2 : length/2 +1;
        for(int i=2;i<=length;) {
            int j=2*x;
            String str1="";
            if(j<i) {
                str1 = str.substring(j, i);
            }else {
                break;
            }
            if (y<time-1) {
                stringBuilder.append(str1).append("-");
            }else if(y==time-1) {
                stringBuilder.append(str1);
            }
            y++;
            x++;
            if(y<time-1) {
                i = i + 2;
            }else if(y==time-1) {
                i=length;
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
