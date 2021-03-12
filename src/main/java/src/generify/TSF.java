package src.generify;

import java.util.Arrays;

public class TSF<R> implements Comparable<TSF<R>> {
  private String name;
  private Integer score;
  private R r;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    private TSF(){}

    private TSF(String name, Integer score, R r) {
        this.name = name;
        this.score = score;
        this.r = r;
    }

    public static <R> TSF success(){
        TSF<R> tsf=new TSF<>();
        tsf.setName(ResultCode.SUCCESS.getMsg());
        tsf.setScore(ResultCode.SUCCESS.getCode());
        return tsf;
    }

    public static <R> TSF success(R data){
        TSF<R> tsf=new TSF<>();
        tsf.setName(ResultCode.SUCCESS.getMsg());
        tsf.setScore(ResultCode.SUCCESS.getCode());
        tsf.setR(data);
        return tsf;
    }

    public static <R> TSF failed(R data){
        TSF<R> tsf=new TSF<>();
        tsf.setName(ResultCode.FAILED.getMsg());
        tsf.setScore(ResultCode.FAILED.getCode());
        tsf.setR(data);
        return tsf;
    }

    public static TSF failed(ResultCode code,String msg){
        TSF tsf=new TSF();
        tsf.setScore(code.getCode());
        tsf.setName(msg);
        return tsf;
    }

    public static <R> TSF failed(ResultCode code,R data){
        TSF tsf=new TSF();
        tsf.setScore(code.getCode());
        tsf.setName(code.getMsg());
        tsf.setR(data);
        return tsf;
    }

    public static <R> TSF failed(Integer code,R data,String msg){
        TSF<R> tsf=new TSF<>();
        tsf.setName(msg);
        tsf.setScore(code);
        tsf.setR(data);
        return tsf;
    }




    @Override
    public String toString() {
        return "TSF{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", r=" + r +
                '}';
    }

    @Override
    public int compareTo(TSF<R> o) {
        return this.score.compareTo(o.score);
    }

    public static void main(String[] args) {
        TSF[] tsf=new TSF[] {
                new TSF("2",2,new TSF<>()),
                new TSF("ni",1,new TSF<>()),
                new TSF("nsnasj",34,new TSF<>())

        };
        Arrays.sort(tsf);
        System.out.println(Arrays.toString(tsf));
        //System.out.printf("%s\n",Arrays.toString(tsf));
    }
}
