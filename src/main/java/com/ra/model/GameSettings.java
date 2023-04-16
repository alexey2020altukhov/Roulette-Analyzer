package com.ra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@ToString
public class GameSettings {

    @Setter
    private int minSizeCombinations = 8;
    @JsonIgnore
    private int lowLimitMinSizeCombinations = 1;
    @JsonIgnore
    private int upLimitMinSizeCombinations = 100;

    @Setter
    private int maxSizePartsCombinationsX2 = 5;
    @JsonIgnore
    private int lowLimitMaxSizePartsCombinationsX2 = 1;
    @JsonIgnore
    private int upMaxSizePartsCombinationsX2 = 10;

    @Setter
    private int maxSizePartsCombinationsX3 = 6;
    @JsonIgnore
    private int lowLimitMaxSizePartsCombinationsX3 = 1;
    @JsonIgnore
    private int upMaxSizePartsCombinationsX3 = 10;

    @Setter
    private boolean exclusionSequencesOfIdenticalValues = false;
    @Setter
    private boolean zerosAsAnyValue = false;
    @Setter
    private boolean markingSameValuesSequences = true;
    @Setter
    private boolean automaticallySaveGameAfterExiting = false;
    @Setter
    private boolean statisticsLog = false;
    @Setter
    private boolean openingAppOnTopOfOtherWindows = true;

    @Setter
    private boolean betColour = true;
    @Setter
    private boolean betParity = true;
    @Setter
    private boolean betRange = true;
    @Setter
    private boolean betSector = true;
    @Setter
    private boolean betRow = true;
}
