package com.ra.service;

import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DesignationService {

    public static String getColorDesignation(Colour colour) {
        if (colour.equals(Colour.GREEN)) {
            return "GREEN";
        } else if (colour.equals(Colour.RED)) {
            return "RED";
        } else {
            return "BLACK";
        }
    }

    public static String getParityDesignation(Parity parity) {
        if (parity.equals(Parity.EVEN)) {
            return "EVEN";
        } else if (parity.equals(Parity.ODD)) {
            return "ODD";
        } else {
            return "-";
        }
    }

    public static String getRangeDesignation(Range range) {
        if (range.equals(Range.MANQUE)) {
            return "1-18";
        } else if (range.equals(Range.PASSE)) {
            return "19-36";
        } else {
            return "-";
        }
    }

    public static String getSectorDesignation(Sector sector) {
        if (sector.equals(Sector.FIRST)) {
            return "1st";
        } else if (sector.equals(Sector.SECOND)) {
            return "2nd";
        } else if (sector.equals(Sector.THIRD)) {
            return "3rd";
        } else {
            return "-";
        }
    }

    public static String getRowDesignation(Row row) {
        if (row.equals(Row.UPPER)) {
            return "UP";
        } else if (row.equals(Row.MIDDLE)) {
            return "MID";
        } else if (row.equals(Row.LOWER)) {
            return "LOW";
        } else {
            return "-";
        }
    }
}