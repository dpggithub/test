package designPattern;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 *
 * 责任链模式是一种把多个处理器组合在一起，依次处理请求的模式；
 *
 * 责任链模式的好处是添加新的处理器或者重新排列处理器非常容易；
 *
 * 责任链模式经常用在拦截、预处理请求等。
 */
public class ChainOfResponsibility {

    static class Request{
        private String name;

        private BigDecimal amount;

        public Request(String name, BigDecimal amount){
            this.amount=amount;
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }

    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
    interface Handler{
        Boolean process(Request request);
    }

    /**
     * Manager：只能审核1000元以下的报销；
     * Director：只能审核10000元以下的报销；
     * CEO：可以审核任意额度。
     * ManagerHandler、DirectorHandler和CEOHandler。
     * compareTo() =0 ->等于; =-1 ->小于; >0 ->大于
     */
    static class ManagerHandler implements Handler{

        @Override
        public Boolean process(Request request) {
            // 如果超过1000元，处理不了，交下一个处理:
            if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
                System.out.println("金额大于1000,请交由下游处理!");
                return null;
            }
            return request.getName().equalsIgnoreCase("Bob");
        }
    }

    static class DirectorHandler implements Handler{

        @Override
        public Boolean process(Request request) {
            if(request.getAmount().compareTo(BigDecimal.valueOf(10000)) >0) {
                System.out.println("金额大于10000,请交由下游处理!");
               return null;
            }
            return request.getName().equalsIgnoreCase("张三");
        }
    }

    static class CEOHandler implements Handler{

        @Override
        public Boolean process(Request request) {
            return true;
        }
    }

    public static class HandlerChain {
        // 持有所有Handler:
        private final List<Handler> handlers = new ArrayList<>();

        public void addHandler(Handler handler) {
            this.handlers.add(handler);
        }

        public boolean process(Request request) {
            // 依次调用每个Handler:
            for (Handler handler : handlers) {
                Boolean r = handler.process(request);
                if (r != null) {
                    // 如果返回TRUE或FALSE，处理结束:
                    System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                    return r;
                }
            }
            throw new RuntimeException("Could not handle request: " + request);
        }
    }

    public static void main(String[] args) {
// 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
// 处理请求:
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("张三", new BigDecimal("1234.56")));
        chain.process(new Request("张三", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));
    }
}
