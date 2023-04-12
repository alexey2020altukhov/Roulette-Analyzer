package com.ra.service;

import com.ra.enums.TypeSequence;
import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import com.ra.model.Number;
import com.ra.model.Sequence;
import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceSearchService {

    private static int lowLimit = 8;

    private static int maxSizeCombinationsX2 = 5;
    private static int maxSizeCombinationsX3 = 6;

    private static List<List<Colour>> combinationsColours;
    private static List<List<Parity>> combinationsParities;
    private static List<List<Range>> combinationsRanges;
    private static List<List<Sector>> combinationsSectors;
    private static List<List<Row>> combinationsRows;

    static {
        combinationsColours = getAllCombinations(List.of(Colour.RED, Colour.BLACK), maxSizeCombinationsX2);
        combinationsParities = getAllCombinations(List.of(Parity.EVEN, Parity.ODD), maxSizeCombinationsX2);
        combinationsRanges = getAllCombinations(List.of(Range.MANQUE, Range.PASSE), maxSizeCombinationsX2);
        combinationsSectors = getAllCombinations(List.of(Sector.FIRST, Sector.SECOND, Sector.THIRD), maxSizeCombinationsX3);
        combinationsRows = getAllCombinations(List.of(Row.UPPER, Row.MIDDLE, Row.LOWER), maxSizeCombinationsX3);
    }

    public static LinkedList<Sequence<?>> getSequences(LinkedList<Number> history) {
        List<Sequence<?>> sequences = new ArrayList<>();
        if (!history.isEmpty() && !history.getFirst().getColour().equals(Colour.GREEN)) {
            sequences.addAll(searchSequencesColours(history));
            sequences.addAll(searchSequencesParities(history));
            sequences.addAll(searchSequencesRanges(history));
            sequences.addAll(searchSequencesSectors(history));
            sequences.addAll(searchSequencesRows(history));
        }
        return sequences.stream().filter(a -> a != null && a.getSequenceLength() >= lowLimit)
                .distinct()
                .sorted((a, b) -> b.getSequenceLength() - a.getSequenceLength())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    //Поиск последовательностей цветов
    private static List<Sequence<Colour>> searchSequencesColours(LinkedList<Number> history) {
        List<Sequence<Colour>> sequences = new ArrayList<>();
        int historySize = history.size();
        for (List<Colour> combination : combinationsColours) {
            int combinationSize = combination.size();

            Colour colourBet = null;
            LinkedList<Number> values = new LinkedList<>();

            for (int i = 0; i < combinationSize; i++) {
                Colour colourTemp = combination.get(0);
                combination.remove(0);
                combination.add(combinationSize - 1, colourTemp);
                LinkedList<Number> tempValues = new LinkedList<>();
                for (int k = 0, j = combinationSize - 1; k < historySize; k++, j = j == 0 ? combinationSize - 1 : j - 1) {
                    Colour colour = combination.get(j);
                    if (colour.equals(history.get(k).getColour())) {
                        tempValues.add(history.get(k));
                    } else {
                        break;
                    }
                }
                if (tempValues.size() > values.size()) {
                    values = new LinkedList<>(tempValues);
                    colourBet = combination.get(0).equals(Colour.RED) ? Colour.BLACK : Colour.RED;
                }
            }

            Sequence<Colour> sequence = new Sequence<Colour>()
                    .setType(TypeSequence.COLOUR)
                    .setValues(values)
                    .setSequenceLength(values.size())
                    .setBetOn(colourBet == null ? List.of() : List.of(colourBet));
            sequences.add(sequence);
        }
        return sequences.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Поиск последовательностей чётности
    private static List<Sequence<Parity>> searchSequencesParities(LinkedList<Number> history) {
        List<Sequence<Parity>> sequences = new ArrayList<>();
        int historySize = history.size();
        for (List<Parity> combination : combinationsParities) {
            int combinationSize = combination.size();

            Parity parityBet = null;
            LinkedList<Number> values = new LinkedList<>();

            for (int i = 0; i < combinationSize; i++) {
                Parity parityTemp = combination.get(0);
                combination.remove(0);
                combination.add(combinationSize - 1, parityTemp);
                LinkedList<Number> tempValues = new LinkedList<>();
                for (int k = 0, j = combinationSize - 1; k < historySize; k++, j = j == 0 ? combinationSize - 1 : j - 1) {
                    Parity parity = combination.get(j);
                    if (parity.equals(history.get(k).getParity())) {
                        tempValues.add(history.get(k));
                    } else {
                        break;
                    }
                }
                if (tempValues.size() > values.size()) {
                    values = new LinkedList<>(tempValues);
                    parityBet = combination.get(0).equals(Parity.EVEN) ? Parity.ODD : Parity.EVEN;
                }
            }

            Sequence<Parity> sequence = new Sequence<Parity>()
                    .setType(TypeSequence.PARITY)
                    .setValues(values)
                    .setSequenceLength(values.size())
                    .setBetOn(parityBet == null ? List.of() : List.of(parityBet));
            sequences.add(sequence);
        }
        return sequences.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Поиск последовательностей диапозонов
    private static List<Sequence<Range>> searchSequencesRanges(LinkedList<Number> history) {
        List<Sequence<Range>> sequences = new ArrayList<>();
        int historySize = history.size();
        for (List<Range> combination : combinationsRanges) {
            int combinationSize = combination.size();

            Range rangeBet = null;
            LinkedList<Number> values = new LinkedList<>();

            for (int i = 0; i < combinationSize; i++) {
                Range rangeTemp = combination.get(0);
                combination.remove(0);
                combination.add(combinationSize - 1, rangeTemp);
                LinkedList<Number> tempValues = new LinkedList<>();
                for (int k = 0, j = combinationSize - 1; k < historySize; k++, j = j == 0 ? combinationSize - 1 : j - 1) {
                    Range range = combination.get(j);
                    if (range.equals(history.get(k).getRange())) {
                        tempValues.add(history.get(k));
                    } else {
                        break;
                    }
                }
                if (tempValues.size() > values.size()) {
                    values = new LinkedList<>(tempValues);
                    rangeBet = combination.get(0).equals(Range.MANQUE) ? Range.PASSE : Range.MANQUE;
                }
            }

            Sequence<Range> sequence = new Sequence<Range>()
                    .setType(TypeSequence.RANGE)
                    .setValues(values)
                    .setSequenceLength(values.size())
                    .setBetOn(rangeBet == null ? List.of() : List.of(rangeBet));
            sequences.add(sequence);
        }
        return sequences.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Поиск последовательностей секторов
    private static List<Sequence<Sector>> searchSequencesSectors(LinkedList<Number> history) {
        List<Sequence<Sector>> sequences = new ArrayList<>();
        int historySize = history.size();
        for (List<Sector> combination : combinationsSectors) {
            int combinationSize = combination.size();

            LinkedList<Number> values = new LinkedList<>();
            List<Sector> combinationFinal = null;

            for (int i = 0; i < combinationSize; i++) {
                Sector sectorTemp = combination.get(0);
                combination.remove(0);
                combination.add(combinationSize - 1, sectorTemp);
                LinkedList<Number> tempValues = new LinkedList<>();
                for (int k = 0, j = combinationSize - 1; k < historySize; k++, j = j == 0 ? combinationSize - 1 : j - 1) {
                    Sector sector = combination.get(j);
                    if (sector.equals(history.get(k).getSector())) {
                        tempValues.add(history.get(k));
                    } else {
                        break;
                    }
                }
                if (tempValues.size() > values.size()) {
                    values = new LinkedList<>(tempValues);
                    combinationFinal = new ArrayList<>(combination);
                }
            }

            List<Sector> sectorBet = null;
            if (combinationFinal != null) {
                if (combinationFinal.contains(Sector.FIRST) && combinationFinal.contains(Sector.SECOND) &&
                        !combinationFinal.contains(Sector.THIRD)) {
                    sectorBet = List.of(combinationFinal.get(0).equals(Sector.SECOND) ?
                            Sector.FIRST : Sector.SECOND, Sector.THIRD);
                } else if (combinationFinal.contains(Sector.SECOND) && combinationFinal.contains(Sector.THIRD) &&
                        !combinationFinal.contains(Sector.FIRST)) {
                    sectorBet = List.of(Sector.FIRST, combinationFinal.get(0).equals(Sector.SECOND) ?
                            Sector.THIRD : Sector.SECOND);
                } else if (combinationFinal.contains(Sector.FIRST) && combinationFinal.contains(Sector.THIRD) &&
                        !combinationFinal.contains(Sector.SECOND)) {
                    Sector sector = combinationFinal.get(0).equals(Sector.FIRST) ? Sector.THIRD : Sector.FIRST;
                    sectorBet = sector.equals(Sector.FIRST) ? List.of(Sector.FIRST, Sector.SECOND) :
                            List.of(Sector.SECOND, Sector.THIRD);
                } else {
                    if (combinationFinal.get(0).equals(Sector.FIRST)) {
                        sectorBet = List.of(Sector.SECOND, Sector.THIRD);
                    } else if (combinationFinal.get(0).equals(Sector.SECOND)) {
                        sectorBet = List.of(Sector.FIRST, Sector.THIRD);
                    } else {
                        sectorBet = List.of(Sector.FIRST, Sector.SECOND);
                    }
                }
            }

            Sequence<Sector> sequence = new Sequence<Sector>()
                    .setType(TypeSequence.SECTOR)
                    .setValues(values)
                    .setSequenceLength(values.size())
                    .setBetOn(sectorBet);
            sequences.add(sequence);
        }
        return sequences.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    //Поиск последовательностей строк
    private static List<Sequence<Row>> searchSequencesRows(LinkedList<Number> history) {
        List<Sequence<Row>> sequences = new ArrayList<>();
        int historySize = history.size();
        for (List<Row> combination : combinationsRows) {
            int combinationSize = combination.size();

            LinkedList<Number> values = new LinkedList<>();
            List<Row> combinationFinal = null;

            for (int i = 0; i < combinationSize; i++) {
                Row rowTemp = combination.get(0);
                combination.remove(0);
                combination.add(combinationSize - 1, rowTemp);
                LinkedList<Number> tempValues = new LinkedList<>();
                for (int k = 0, j = combinationSize - 1; k < historySize; k++, j = j == 0 ? combinationSize - 1 : j - 1) {
                    Row row = combination.get(j);
                    if (row.equals(history.get(k).getRow())) {
                        tempValues.add(history.get(k));
                    } else {
                        break;
                    }
                }
                if (tempValues.size() > values.size()) {
                    values = new LinkedList<>(tempValues);
                    combinationFinal = new ArrayList<>(combination);
                }
            }

            List<Row> rowBet = null;
            if (combinationFinal != null) {
                if (combinationFinal.contains(Row.LOWER) && combinationFinal.contains(Row.MIDDLE) &&
                        !combinationFinal.contains(Row.UPPER)) {
                    rowBet = List.of(combinationFinal.get(0).equals(Row.MIDDLE) ?
                            Row.LOWER : Row.MIDDLE, Row.UPPER);
                } else if (combinationFinal.contains(Row.MIDDLE) && combinationFinal.contains(Row.UPPER) &&
                        !combinationFinal.contains(Row.LOWER)) {
                    rowBet = List.of(Row.LOWER, combinationFinal.get(0).equals(Row.MIDDLE) ?
                            Row.UPPER : Row.MIDDLE);
                } else if (combinationFinal.contains(Row.LOWER) && combinationFinal.contains(Row.UPPER) &&
                        !combinationFinal.contains(Row.MIDDLE)) {
                    Row row = combinationFinal.get(0).equals(Row.LOWER) ? Row.UPPER : Row.LOWER;
                    rowBet = row.equals(Row.LOWER) ? List.of(Row.LOWER, Row.MIDDLE) :
                            List.of(Row.MIDDLE, Row.UPPER);
                } else {
                    if (combinationFinal.get(0).equals(Row.LOWER)) {
                        rowBet = List.of(Row.MIDDLE, Row.UPPER);
                    } else if (combinationFinal.get(0).equals(Row.MIDDLE)) {
                        rowBet = List.of(Row.LOWER, Row.UPPER);
                    } else {
                        rowBet = List.of(Row.LOWER, Row.MIDDLE);
                    }
                }
            }

            Sequence<Row> sequence = new Sequence<Row>()
                    .setType(TypeSequence.ROW)
                    .setValues(values)
                    .setSequenceLength(values.size())
                    .setBetOn(rowBet);
            sequences.add(sequence);
        }
        return sequences.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static <T> List<List<T>> getAllCombinations(List<T> values, int lengthOfList) {
        return IntStream.range(1, lengthOfList + 1)
                .mapToObj(e -> Generator.permutation(values).withRepetitions(e).stream()
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}