package com.ra.service;

import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import javafx.scene.paint.Color;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ColorService {

    public static Color getColorColour(Colour colour) {
        if (colour.equals(Colour.GREEN)) {
            return Color.GREEN;
        } else if (colour.equals(Colour.RED)) {
            return Color.valueOf("#E00006");
        } else {
            return Color.valueOf("#383838");
        }
    }

    public static Color getColorParity(Parity parity) {
        if (Parity.EVEN.equals(parity)) {
            return Color.valueOf("#C3F500");
        } else if (Parity.ODD.equals(parity)) {
            return Color.VIOLET;
        } else {
            return Color.GREEN;
        }
    }

    public static Color getColorRange(Range range) {
        if (Range.MANQUE.equals(range)) {
            return Color.valueOf("#7FFFD4");
        } else if (Range.PASSE.equals(range)) {
            return Color.valueOf("#0D7377");
        } else {
            return Color.GREEN;
        }
    }

    public static Color getColorSector(Sector sector) {
        if (Sector.FIRST.equals(sector)) {
            return Color.valueOf("#FFDF00");
        } else if (Sector.SECOND.equals(sector)) {
            return Color.valueOf("#FF8700");
        } else if (Sector.THIRD.equals(sector)) {
            return Color.valueOf("#CC5500");
        } else {
            return Color.GREEN;
        }
    }

    public static Color getColorRow(Row row) {
        if (Row.UPPER.equals(row)) {
            return Color.valueOf("#F66F89");
        } else if (Row.MIDDLE.equals(row)) {
            return Color.valueOf("#ED002F");
        } else if (Row.LOWER.equals(row)) {
            return Color.valueOf("#9A001E");
        } else {
            return Color.GREEN;
        }
    }
}