package pu.fmi.designpattern.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShipmentPackage {

    private final ShipmentType type;

    public ShipmentPackage(ShipmentType type) {
        this.type = type;
    }
}
