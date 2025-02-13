package com.gpsolutions.domas.hotelmicroservice.filter;

import com.gpsolutions.domas.hotelmicroservice.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class HotelFilter {

    public Predicate<Hotel> createFilter(String name, String brand, String city, String county, List<String> amenities) {
        return hotel -> matchesName(hotel, name) &&
                matchesBrand(hotel, brand) &&
                matchesCity(hotel, city) &&
                matchesCounty(hotel, county) &&
                matchesAmenities(hotel, amenities);
    }

    private boolean matchesName(Hotel hotel, String name) {
        return name == null || name.isEmpty() || hotel.getName().toLowerCase().contains(name.toLowerCase());
    }

    private boolean matchesBrand(Hotel hotel, String brand) {
        return brand == null || brand.isEmpty() || hotel.getBrand().toLowerCase().contains(brand.toLowerCase());
    }

    private boolean matchesCity(Hotel hotel, String city) {
        return city == null || city.isEmpty() || hotel.getAddress().getCity().toLowerCase().contains(city.toLowerCase());
    }

    private boolean matchesCounty(Hotel hotel, String county) {
        return county == null || county.isEmpty() || hotel.getAddress().getCounty().toLowerCase().contains(county.toLowerCase());
    }

    private boolean matchesAmenities(Hotel hotel, List<String> amenities) {
        if (amenities == null || amenities.isEmpty()) {
            return true;
        }
        return amenities.stream().allMatch(hotel.getAmenities()::contains);
    }

}
