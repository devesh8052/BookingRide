package com.thinkify.bookingride.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindRideModel {
    private  String userName;
    private  Location location;
}
