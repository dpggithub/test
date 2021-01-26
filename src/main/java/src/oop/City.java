package src.oop;

class City {
    private String name;
    private double latitude;
    private double longitude;

    public void setName(String name){this.name=name;}
    public void setLatitude(double latitude){this.latitude=latitude;}
    public void setLongitude(double longitude){this.longitude=longitude;}

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

