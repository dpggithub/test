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

            //返回千米
            return Math.hypot(x, y);
        }

        public static void main(String[] args) {

            // 信阳的经度
            Double lng1 = 113.54342;
            // 信阳的纬度
            Double lat1 = 22.26666;

            // 佳木斯的经度
            Double lng2 = 113.554521;
            // 佳木斯的纬度
            Double lat2 = 22.270823;

            // 运行后，控制台打印：佳木斯到信阳的距离：2142.6376176855483千米
            System.out.println(calculateDistance(lng1, lat1, lng2, lat2));
        }

    }
