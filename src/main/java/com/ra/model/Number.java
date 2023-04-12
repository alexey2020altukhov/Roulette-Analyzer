package com.ra.model;

import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@ToString
public class Number {

    private int order;

    private String name;

    private Colour colour;

    private Range range;

    private Parity parity;

    private Sector sector;

    private Row row;
}