package com.ra.model;

import com.ra.enums.TypeSequence;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class Log {

    private TypeSequence typeSequence;

    private int sequenceLength;

    private int wins;

    private int totalGames;

    public Log(Log log) {
        this.typeSequence = log.getTypeSequence();
        this.sequenceLength = log.getSequenceLength();
        this.wins = log.getWins();
        this.totalGames = log.getTotalGames();
    }
}