package hill.weatherconfidence.ingest.model;


/*
 * [{"name":"Hemel Hempstead","local_names":{"en":"Hemel Hempstead","ru":"Хемел-Хемпстед"},"lat":51.7511784,"lon":-0.472528,"country":"GB","state":"England"}]
 * */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeItem {

    private String name;
    private Double lat;
    private Double lon;
    private String country;

    public static GeocodeItem defaultLocation() {
        // London
        GeocodeItem item = new GeocodeItem();
        item.setCountry("UK");
        item.setLat(Double.parseDouble("51.5073219"));
        item.setLon(Double.parseDouble("-0.1276474"));
        item.setCountry("GB");
        return item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeocodeItem that = (GeocodeItem) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getLat(), that.getLat()) && Objects.equals(getLon(), that.getLon()) && Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLat(), getLon(), getCountry());
    }
}
