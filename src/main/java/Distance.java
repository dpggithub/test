import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Distance {
         /**
         * 地球半径（这里取的是平均半径）
         */
        private static final double EARTH_RADIUS = 6370.996;

        /**
         * @param lng1 地点A的经度
         * @param lat1 地点A的纬度
         * @param lng2 地点B的经度
         * @param lat2 地点B的纬度
         * @return 返参 double 单位千米（km）
         */
        public static double calculateDistance(double lng1, double lat1, double lng2, double lat2) {

            double x = (lng2 - lng1) * 3.1415 * EARTH_RADIUS * Math.cos(((lat1 + lat2) / 2) * 3.1415 / 180) / 180;
            double y = (lat1 - lat2) * 3.1415 * EARTH_RADIUS / 180;
            System.out.println(x);
            System.out.println(y);
            //返回千米
            return Math.hypot(x, y);
        }

    private static double rad(double d) {
        return d * 3.1415 / 180.0;
    }

    public static double GetDistance(double long1, double lat1, double long2, double lat2) {
        double a, b, d, sa2, sb2;
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        a = lat1 - lat2;
        b = rad(long1 - long2);

        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

        public static void main(String[] args) {

            // 信阳的经度
            Double lng1 = 113.54342;
            // 信阳的纬度
            Double lat1 = 22.26666;

            // 佳木斯的经度
            Double lng2 = 113.572871;
            // 佳木斯的纬度
            Double lat2 = 22.242796;

            // 运行后，控制台打印：佳木斯到信阳的距离：2142.6376176855483千米
            System.out.println(GetDistance(lng1,lat1,lng2,lat2));

            Map<String, String> map = new HashMap<>();
            map.put("spuUniqueId", "12345");
            map.put("source", "qr");
            JSONObject jsonObject =new JSONObject();
            jsonObject.putAll(map);
            String data =jsonObject.toJSONString();
            System.out.println(data);

        }
    }
