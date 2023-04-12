package com.ra.controller;

import com.ra.service.GameService;
import com.ra.service.SequenceSearchService;
import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import com.ra.model.Number;
import com.ra.model.Sequence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FormController {

    @FXML
    private Button b00;

    @FXML
    private Button b0;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b10;

    @FXML
    private Button b11;

    @FXML
    private Button b12;

    @FXML
    private Button b13;

    @FXML
    private Button b14;

    @FXML
    private Button b15;

    @FXML
    private Button b16;

    @FXML
    private Button b17;

    @FXML
    private Button b18;

    @FXML
    private Button b19;

    @FXML
    private Button b20;

    @FXML
    private Button b21;

    @FXML
    private Button b22;

    @FXML
    private Button b23;

    @FXML
    private Button b24;

    @FXML
    private Button b25;

    @FXML
    private Button b26;

    @FXML
    private Button b27;

    @FXML
    private Button b28;

    @FXML
    private Button b29;

    @FXML
    private Button b30;

    @FXML
    private Button b31;

    @FXML
    private Button b32;

    @FXML
    private Button b33;

    @FXML
    private Button b34;

    @FXML
    private Button b35;

    @FXML
    private Button b36;

    @FXML
    private Button bback;

    @FXML
    private Button bSaveGame;

    @FXML
    private ListView<String> historyThisGameLV;

    @FXML
    private ListView<String> numberOfDropsThisGameLV;

    @FXML
    private ListView<String> numberOfDropsLV;

    @FXML
    private ListView<String> numberOfNonDropsThisGameLV;

    @FXML
    private ListView<String> numberOfDropsFollowingNumbersLV;

    @FXML
    private GridPane sequencesGP;

    @FXML
    void onClickB00(ActionEvent event) {
        addNumber("00");
    }

    @FXML
    void onClickB0(ActionEvent event) {
        addNumber("0");
    }

    @FXML
    void onClickB1(MouseEvent event) {
        addNumber("1");
    }

    @FXML
    void onClickB2(MouseEvent event) {
        addNumber("2");
    }

    @FXML
    void onClickB3(MouseEvent event) {
        addNumber("3");
    }

    @FXML
    void onClickB4(MouseEvent event) {
        addNumber("4");
    }

    @FXML
    void onClickB5(MouseEvent event) {
        addNumber("5");
    }

    @FXML
    void onClickB6(MouseEvent event) {
        addNumber("6");
    }

    @FXML
    void onClickB7(MouseEvent event) {
        addNumber("7");
    }

    @FXML
    void onClickB8(MouseEvent event) {
        addNumber("8");
    }

    @FXML
    void onClickB9(MouseEvent event) {
        addNumber("9");
    }

    @FXML
    void onClickB10(MouseEvent event) {
        addNumber("10");
    }

    @FXML
    void onClickB11(MouseEvent event) {
        addNumber("11");
    }

    @FXML
    void onClickB12(MouseEvent event) {
        addNumber("12");
    }

    @FXML
    void onClickB13(MouseEvent event) {
        addNumber("13");
    }

    @FXML
    void onClickB14(MouseEvent event) {
        addNumber("14");
    }

    @FXML
    void onClickB15(MouseEvent event) {
        addNumber("15");
    }

    @FXML
    void onClickB16(MouseEvent event) {
        addNumber("16");
    }

    @FXML
    void onClickB17(MouseEvent event) {
        addNumber("17");
    }

    @FXML
    void onClickB18(MouseEvent event) {
        addNumber("18");
    }

    @FXML
    void onClickB19(MouseEvent event) {
        addNumber("19");
    }

    @FXML
    void onClickB20(MouseEvent event) {
        addNumber("20");
    }

    @FXML
    void onClickB21(MouseEvent event) {
        addNumber("21");
    }

    @FXML
    void onClickB22(MouseEvent event) {
        addNumber("22");
    }

    @FXML
    void onClickB23(MouseEvent event) {
        addNumber("23");
    }

    @FXML
    void onClickB24(MouseEvent event) {
        addNumber("24");
    }

    @FXML
    void onClickB25(MouseEvent event) {
        addNumber("25");
    }

    @FXML
    void onClickB26(MouseEvent event) {
        addNumber("26");
    }

    @FXML
    void onClickB27(MouseEvent event) {
        addNumber("27");
    }

    @FXML
    void onClickB28(MouseEvent event) {
        addNumber("28");
    }

    @FXML
    void onClickB29(MouseEvent event) {
        addNumber("29");
    }

    @FXML
    void onClickB30(MouseEvent event) {
        addNumber("30");
    }

    @FXML
    void onClickB31(MouseEvent event) {
        addNumber("31");
    }

    @FXML
    void onClickB32(MouseEvent event) {
        addNumber("32");
    }

    @FXML
    void onClickB33(MouseEvent event) {
        addNumber("33");
    }

    @FXML
    void onClickB34(MouseEvent event) {
        addNumber("34");
    }

    @FXML
    void onClickB35(MouseEvent event) {
        addNumber("35");
    }

    @FXML
    void onClickB36(MouseEvent event) {
        addNumber("36");
    }

    @FXML
    void onClickBBack(MouseEvent event) {
        removeNumber();
    }

    @FXML
    void onClickBSaveGame(MouseEvent event) throws IOException {
        GameService.saveGame();
        historyThisGameLV.getItems().clear();
        updateStatistics();
    }

    @FXML
    private void initialize() throws IOException {
        GameService.init();
        setCellFactoryLV(historyThisGameLV);
        setCellFactoryLV(numberOfDropsThisGameLV);
        setCellFactoryLV(numberOfDropsLV);
        setCellFactoryLV(numberOfNonDropsThisGameLV);
        setCellFactoryLV(numberOfDropsFollowingNumbersLV);
        updateStatistics();
    }

    private void setCellFactoryLV(ListView<String> lv) {
        lv.setCellFactory(cell -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    String name = lv.getId().equals("historyThisGameLV") ?
                            null : item.substring(0, 2).replace(" ", "");
                    Number number = GameService.findNumber(lv.getId().equals("historyThisGameLV") ? item : name);
                    setTextFill(getColorColour(number.getColour()));
                    setText(item);
                } else {
                    setText("");
                    textFillProperty().unbind();
                }
            }
        });
    }

    private Color getColorColour(Colour colour) {
        if (colour.equals(Colour.GREEN)) {
            return Color.GREEN;
        } else if (colour.equals(Colour.RED)) {
            return Color.valueOf("#E00006");
        } else {
            return Color.valueOf("#383838");
        }
    }

    private Color getColorParity(Parity parity) {
        if (parity.equals(Parity.EVEN)) {
            return Color.valueOf("#C3F500");
        } else if (parity.equals(Parity.ODD)) {
            return Color.VIOLET;
        } else {
            return Color.valueOf("#383838");
        }
    }

    private Color getColorRange(Range range) {
        if (range.equals(Range.MANQUE)) {
            return Color.valueOf("#7FFFD4");
        } else if (range.equals(Range.PASSE)) {
            return Color.valueOf("#0D7377");
        } else {
            return Color.valueOf("#383838");
        }
    }

    private Color getColorSector(Sector sector) {
        if (sector.equals(Sector.FIRST)) {
            return Color.valueOf("#FFDF00");
        } else if (sector.equals(Sector.SECOND)) {
            return Color.valueOf("#FF8700");
        } else if (sector.equals(Sector.THIRD)) {
            return Color.valueOf("#CC5500");
        } else {
            return Color.valueOf("#383838");
        }
    }

    private Color getColorRow(Row row) {
        if (row.equals(Row.UPPER)) {
            return Color.valueOf("#F66F89");
        } else if (row.equals(Row.MIDDLE)) {
            return Color.valueOf("#ED002F");
        } else if (row.equals(Row.LOWER)) {
            return Color.valueOf("#9A001E");
        } else {
            return Color.valueOf("#383838");
        }
    }

    private String getColorDesignation(Colour colour) {
        if (colour.equals(Colour.GREEN)) {
            return "GREEN";
        } else if (colour.equals(Colour.RED)) {
            return "RED";
        } else {
            return "BLACK";
        }
    }

    private String getParityDesignation(Parity parity) {
        if (parity.equals(Parity.EVEN)) {
            return "EVEN";
        } else if (parity.equals(Parity.ODD)) {
            return "ODD";
        } else {
            return "-";
        }
    }

    private String getRangeDesignation(Range range) {
        if (range.equals(Range.MANQUE)) {
            return "1-18";
        } else if (range.equals(Range.PASSE)) {
            return "19-36";
        } else {
            return "-";
        }
    }

    private String getSectorDesignation(Sector sector) {
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

    private String getRowDesignation(Row row) {
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

    private void addNumber(String name) {
        GameService.addNumber(name);
        historyThisGameLV.getItems().add(0, name);
        updateStatistics();
    }

    private void removeNumber() {
        if (!GameService.getHistoryThisGame().isEmpty()) {
            GameService.removeNumber();
            historyThisGameLV.getItems().remove(0);
            updateStatistics();
        }
    }

    private void updateStatistics() {
        updateLV();
        updateGP();
    }

    private void updateLV() {
        numberOfDropsThisGameLV.getItems().clear();
        numberOfDropsThisGameLV.getItems().addAll(GameService.getNumberOfDropsThisGame().entrySet().stream()
                .map(a -> a.getKey().getName()
                        .concat(a.getKey().getName().length() < 2 ? "  " : "")
                        .concat(" - ")
                        .concat(a.getValue().toString()))
                .collect(Collectors.toList()));

        numberOfDropsLV.getItems().clear();
        numberOfDropsLV.getItems().addAll(GameService.getNumberOfDrops().entrySet().stream()
                .map(a -> a.getKey().getName()
                        .concat(a.getKey().getName().length() < 2 ? "  " : "")
                        .concat(" - ")
                        .concat(a.getValue().toString()))
                .collect(Collectors.toList()));

        numberOfNonDropsThisGameLV.getItems().clear();
        numberOfNonDropsThisGameLV.getItems().addAll(GameService.getNumberOfNonDropsThisGame().entrySet().stream()
                .map(a -> a.getKey().getName()
                        .concat(a.getKey().getName().length() < 2 ? "  " : "")
                        .concat(" - ")
                        .concat(a.getValue().toString()))
                .collect(Collectors.toList()));

        numberOfDropsFollowingNumbersLV.getItems().clear();
        numberOfDropsFollowingNumbersLV.getItems().addAll(GameService.getChanceNumbersFallingOut().entrySet().stream()
                .map(a -> a.getKey().getName()
                        .concat(a.getKey().getName().length() < 2 ? "  " : "")
                        .concat(" - ")
                        .concat(a.getValue().toString())
                        .concat("%"))
                .collect(Collectors.toList()));
    }


    private void updateGP() {
        sequencesGP.getChildren().clear();
        LinkedList<Sequence<?>> sequences = SequenceSearchService.getSequences(GameService.getHistoryThisGame());
        int i = 0;
        for (Sequence<?> sequence : sequences) {
            List<?> betOn = sequence.getBetOn();
            if (i == sequencesGP.getRowCount()) {
                break;
            }
            switch (sequence.getType()) {
                case COLOUR: {
                    Colour colourBet1 = (Colour) betOn.get(0);
                    Colour colourBet2 = betOn.size() > 1 ? (Colour) betOn.get(1) : null;

                    Label labelLength = new Label();
                    labelLength.setText(String.valueOf(sequence.getSequenceLength()));
                    labelLength.setTextFill(Color.WHITE);
                    sequencesGP.add(labelLength, 2, i);

                    Label labelBetOn1 = new Label();
                    labelBetOn1.setText(getColorDesignation(colourBet1));
                    labelBetOn1.setTextFill(getColorColour(colourBet1));
                    labelBetOn1.setFont(new Font("Serif", 10));
                    sequencesGP.add(labelBetOn1, 0, i);

                    if (colourBet2 != null) {
                        Label labelBetOn2 = new Label();
                        labelBetOn2.setText(getColorDesignation(colourBet2));
                        labelBetOn2.setTextFill(getColorColour(colourBet2));
                        labelBetOn2.setFont(new Font("Serif", 10));
                        sequencesGP.add(labelBetOn2, 1, i);
                    }

                    for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
                        Number value = sequence.getValues().remove();
                        Label labelValue = new Label();
                        labelValue.setText(value.getName());
                        labelValue.setTextFill(getColorColour(value.getColour()));
                        sequencesGP.add(labelValue, j, i);
                    }
                    break;
                }
                case PARITY: {
                    Parity parityBet1 = (Parity) betOn.get(0);
                    Parity parityBet2 = betOn.size() > 1 ? (Parity) betOn.get(1) : null;

                    Label labelLength = new Label();
                    labelLength.setText(String.valueOf(sequence.getSequenceLength()));
                    labelLength.setTextFill(Color.WHITE);
                    sequencesGP.add(labelLength, 2, i);

                    Label labelBetOn1 = new Label();
                    labelBetOn1.setText(getParityDesignation(parityBet1));
                    labelBetOn1.setTextFill(getColorParity(parityBet1));
                    labelBetOn1.setFont(new Font("Serif", 10));
                    sequencesGP.add(labelBetOn1, 0, i);

                    if (parityBet2 != null) {
                        Label labelBetOn2 = new Label();
                        labelBetOn2.setText(getParityDesignation(parityBet2));
                        labelBetOn2.setTextFill(getColorParity(parityBet2));
                        labelBetOn2.setFont(new Font("Serif", 10));
                        sequencesGP.add(labelBetOn2, 1, i);
                    }

                    for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
                        Number value = sequence.getValues().remove();
                        Label labelValue = new Label();
                        labelValue.setText(value.getName());
                        labelValue.setTextFill(getColorParity(value.getParity()));
                        sequencesGP.add(labelValue, j, i);
                    }
                    break;
                }
                case RANGE: {
                    Range rangeBet1 = (Range) betOn.get(0);
                    Range rangeBet2 = betOn.size() > 1 ? (Range) betOn.get(1) : null;

                    Label labelLength = new Label();
                    labelLength.setText(String.valueOf(sequence.getSequenceLength()));
                    labelLength.setTextFill(Color.WHITE);
                    sequencesGP.add(labelLength, 2, i);

                    Label labelBetOn1 = new Label();
                    labelBetOn1.setText(getRangeDesignation(rangeBet1));
                    labelBetOn1.setTextFill(getColorRange(rangeBet1));
                    labelBetOn1.setFont(new Font("Serif", 10));
                    sequencesGP.add(labelBetOn1, 0, i);

                    if (rangeBet2 != null) {
                        Label labelBetOn2 = new Label();
                        labelBetOn2.setText(getRangeDesignation(rangeBet2));
                        labelBetOn2.setTextFill(getColorRange(rangeBet2));
                        labelBetOn2.setFont(new Font("Serif", 10));
                        sequencesGP.add(labelBetOn2, 1, i);
                    }

                    for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
                        Number value = sequence.getValues().remove();
                        Label labelValue = new Label();
                        labelValue.setText(value.getName());
                        labelValue.setTextFill(getColorRange(value.getRange()));
                        sequencesGP.add(labelValue, j, i);
                    }
                    break;
                }
                case SECTOR: {
                    Sector sectorBet1 = (Sector) betOn.get(0);
                    Sector sectorBet2 = betOn.size() > 1 ? (Sector) betOn.get(1) : null;

                    Label labelLength = new Label();
                    labelLength.setText(String.valueOf(sequence.getSequenceLength()));
                    labelLength.setTextFill(Color.WHITE);
                    sequencesGP.add(labelLength, 2, i);

                    Label labelBetOn1 = new Label();
                    labelBetOn1.setText(getSectorDesignation(sectorBet1));
                    labelBetOn1.setTextFill(getColorSector(sectorBet1));
                    labelBetOn1.setFont(new Font("Serif", 10));
                    sequencesGP.add(labelBetOn1, 0, i);

                    if (sectorBet2 != null) {
                        Label labelBetOn2 = new Label();
                        labelBetOn2.setText(getSectorDesignation(sectorBet2));
                        labelBetOn2.setTextFill(getColorSector(sectorBet2));
                        labelBetOn2.setFont(new Font("Serif", 10));
                        sequencesGP.add(labelBetOn2, 1, i);
                    }

                    for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
                        Number value = sequence.getValues().remove();
                        Label labelValue = new Label();
                        labelValue.setText(value.getName());
                        labelValue.setTextFill(getColorSector(value.getSector()));
                        sequencesGP.add(labelValue, j, i);
                    }
                    break;
                }
                case ROW: {
                    Row rowBet1 = (Row) betOn.get(0);
                    Row rowBet2 = betOn.size() > 1 ? (Row) betOn.get(1) : null;

                    Label labelLength = new Label();
                    labelLength.setText(String.valueOf(sequence.getSequenceLength()));
                    labelLength.setTextFill(Color.WHITE);
                    sequencesGP.add(labelLength, 2, i);

                    Label labelBetOn1 = new Label();
                    labelBetOn1.setText(getRowDesignation(rowBet1));
                    labelBetOn1.setTextFill(getColorRow(rowBet1));
                    labelBetOn1.setFont(new Font("Serif", 10));
                    sequencesGP.add(labelBetOn1, 0, i);

                    if (rowBet2 != null) {
                        Label labelBetOn2 = new Label();
                        labelBetOn2.setText(getRowDesignation(rowBet2));
                        labelBetOn2.setTextFill(getColorRow(rowBet2));
                        labelBetOn2.setFont(new Font("Serif", 10));
                        sequencesGP.add(labelBetOn2, 1, i);
                    }

                    for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
                        Number value = sequence.getValues().remove();
                        Label labelValue = new Label();
                        labelValue.setText(value.getName());
                        labelValue.setTextFill(getColorRow(value.getRow()));
                        sequencesGP.add(labelValue, j, i);
                    }
                    break;
                }
                default:
                    break;
            }
            i++;
        }
    }
}