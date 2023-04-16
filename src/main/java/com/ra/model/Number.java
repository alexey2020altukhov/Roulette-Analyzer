package com.ra.model;

import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Number {

    private int order;

    private String name;

    private Colour colour;

    private Range range;

    private Parity parity;

    private Sector sector;

    private Row row;

    public Number(Number number) {
        this.order = number.getOrder();
        this.name = number.getName();
        this.colour = number.getColour();
        this.range = number.getRange();
        this.parity = number.getParity();
        this.sector = number.getSector();
        this.row = number.getRow();
    }
}