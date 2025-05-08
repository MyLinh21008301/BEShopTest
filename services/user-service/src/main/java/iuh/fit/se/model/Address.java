package iuh.fit.se.model;

import lombok.Data;

@Data
public class Address {
    private String addressId;
    private String recipientName;
    private String phoneNumber;
    private String fullAddress;
    private int defaultAddress;

    public Address() {}
}
