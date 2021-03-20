package designPattern;

/**
 * 创建者模式
 */
public class UrlBuilder {
    private StringBuilder stringBuilder= new StringBuilder();

    public UrlBuilder() {
    }

    public static UrlBuilder builder(){
        return new UrlBuilder();
    }

    public UrlBuilder setDomain(String domain){
        this.stringBuilder.append(domain);
        return this;
    }

    public UrlBuilder setSchema(String schema){
        this.stringBuilder.append(schema).append("://");
        return this;
    }

    public UrlBuilder setPath(String path){
        this.stringBuilder.append(path);
        return this;
    }

    public UrlBuilder setOther(String other){
        this.stringBuilder.append(other);
        return this;
    }

    public String build(){
        return this.stringBuilder.toString();
    }

    public static void main(String[] args) {
        String url  =UrlBuilder.builder()
                    .setSchema("https")
                    .setDomain("www.baidu.com")
                    .setPath("/")
                    .setOther("?a=123&cid=67382hGfdFRsdkHD")
                    .build();
        System.out.println(url);
    }
}
