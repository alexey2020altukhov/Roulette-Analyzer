package com.ra.controller;

import com.ra.App;
import com.ra.enums.Colour;
import com.ra.enums.Parity;
import com.ra.enums.Range;
import com.ra.enums.Row;
import com.ra.enums.Sector;
import com.ra.enums.TypeSequence;
import com.ra.model.GameSettings;
import com.ra.model.Number;
import com.ra.model.Sequence;
import com.ra.service.ColorService;
import com.ra.service.DesignationService;
import com.ra.service.GameService;
import com.ra.service.SequenceSearchService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FormController {

    private static final Font font = new Font("Serif", 10);

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
    private Pane pSettings;

    @FXML
    private Label bSettings;

    @FXML
    private TextField tMinSizeCombinations;

    @FXML
    private TextField tMaxSizePartsCombinationsX2;

    @FXML
    private TextField tMaxSizePartsCombinationsX3;

    @FXML
    private CheckBox cExclusionSequencesOfIdenticalValues;

    @FXML
    private CheckBox cZerosAsAnyValue;

    @FXML
    private CheckBox cMarkingSameValuesSequences;

    @FXML
    private CheckBox cAutomaticallySaveGameAfterExiting;

    @FXML
    private CheckBox cStatisticsLog;

    @FXML
    private CheckBox cOpeningAppOnTopOfOtherWindows;

    @FXML
    private CheckBox cBetColour;

    @FXML
    private CheckBox cBetParity;

    @FXML
    private CheckBox cBetRange;

    @FXML
    private CheckBox cBetSector;

    @FXML
    private CheckBox cBetRow;

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
    void onActionMSaveGame(ActionEvent event) throws IOException {
        GameService.saveGame();
        historyThisGameLV.getItems().clear();
        updateFormData();
    }

    @FXML
    void onActionMNewGame(ActionEvent event) throws IOException {
        GameService.newGame();
        historyThisGameLV.getItems().clear();
        updateFormData();
    }

    @FXML
    void onClickBSettings(MouseEvent event) {
        pSettings.setVisible(true);
        bSettings.setVisible(false);
    }

    @FXML
    void onClickBSaveSettings(MouseEvent event) throws IOException {
        saveSettings();
        pSettings.setVisible(false);
        bSettings.setVisible(true);
        SequenceSearchService.findCombinations();
        updateFormData();
    }

    @FXML
    private void initialize() throws IOException {
        GameService.init();
        loadSettings();
        pSettings.setVisible(false);
        setCellFactoryLV(historyThisGameLV);
        setCellFactoryLV(numberOfDropsThisGameLV);
        setCellFactoryLV(numberOfDropsLV);
        setCellFactoryLV(numberOfNonDropsThisGameLV);
        setCellFactoryLV(numberOfDropsFollowingNumbersLV);
        updateFormData();
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
                    setTextFill(ColorService.getColorColour(number.getColour()));
                    setText(item);
                } else {
                    setText("");
                    textFillProperty().unbind();
                }
            }
        });
    }

    private Label getLabelLength(Sequence<?> sequence) {
        Label labelLength = new Label();
        labelLength.setText(GameService.getGameSettings().isMarkingSameValuesSequences() && sequence.isIdenticalValues() ?
                sequence.getSequenceLength() + "!" : String.valueOf(sequence.getSequenceLength()));
        labelLength.setTextFill(Color.WHITE);
        return labelLength;
    }

    private void addNumber(String name) {
        GameService.addNumber(name);
        historyThisGameLV.getItems().add(0, name);
        updateFormData();
    }

    private void removeNumber() {
        if (!GameService.getHistoryThisGame().isEmpty()) {
            GameService.removeNumber();
            historyThisGameLV.getItems().remove(0);
            updateFormData();
        }
    }

    private void updateFormData() {
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
        int row = 0;
        for (Sequence<?> sequence : sequences) {
            if (row == sequencesGP.getRowCount()) {
                break;
            }
            writeSequenceToRowGP(sequence, row);
            row++;
        }
    }

    private void writeSequenceToRowGP(Sequence<?> sequence, int row) {
        List<?> betOn = sequence.getBetOn();
        switch (sequence.getType()) {
            case COLOUR: {
                writeSequenceColorsToRow(sequence, betOn, row);
                break;
            }
            case PARITY: {
                writeSequenceParitiesToRow(sequence, betOn, row);
                break;
            }
            case RANGE: {
                writeSequenceRangesToRow(sequence, betOn, row);
                break;
            }
            case SECTOR: {
                writeSequenceSectorsToRow(sequence, betOn, row);
                break;
            }
            case ROW: {
                writeSequenceRowsToRow(sequence, betOn, row);
                break;
            }
            default:
                break;
        }
    }

    private void writeSequenceColorsToRow(Sequence<?> sequence, List<?> betOn, int row) {
        Colour colourBet1 = (Colour) betOn.get(0);
        Colour colourBet2 = betOn.size() > 1 ? (Colour) betOn.get(1) : null;

        sequencesGP.add(getLabelLength(sequence), 2, row);

        Label labelBetOn1 = new Label();
        labelBetOn1.setText(DesignationService.getColorDesignation(colourBet1));
        labelBetOn1.setTextFill(ColorService.getColorColour(colourBet1));
        labelBetOn1.setFont(font);
        sequencesGP.add(labelBetOn1, 0, row);

        if (colourBet2 != null) {
            Label labelBetOn2 = new Label();
            labelBetOn2.setText(DesignationService.getColorDesignation(colourBet2));
            labelBetOn2.setTextFill(ColorService.getColorColour(colourBet2));
            labelBetOn2.setFont(font);
            sequencesGP.add(labelBetOn2, 1, row);
        }

        for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
            Number value = sequence.getValues().remove();
            Label labelValue = new Label();
            labelValue.setText(value.getName());
            labelValue.setTextFill(ColorService.getColorColour(value.getColour()));
            sequencesGP.add(labelValue, j, row);
        }
    }

    private void writeSequenceParitiesToRow(Sequence<?> sequence, List<?> betOn, int row) {
        Parity parityBet1 = (Parity) betOn.get(0);
        Parity parityBet2 = betOn.size() > 1 ? (Parity) betOn.get(1) : null;

        sequencesGP.add(getLabelLength(sequence), 2, row);

        Label labelBetOn1 = new Label();
        labelBetOn1.setText(DesignationService.getParityDesignation(parityBet1));
        labelBetOn1.setTextFill(ColorService.getColorParity(parityBet1));
        labelBetOn1.setFont(font);
        sequencesGP.add(labelBetOn1, 0, row);

        if (parityBet2 != null) {
            Label labelBetOn2 = new Label();
            labelBetOn2.setText(DesignationService.getParityDesignation(parityBet2));
            labelBetOn2.setTextFill(ColorService.getColorParity(parityBet2));
            labelBetOn2.setFont(font);
            sequencesGP.add(labelBetOn2, 1, row);
        }

        for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
            Number value = sequence.getValues().remove();
            Label labelValue = new Label();
            labelValue.setText(value.getName());
            labelValue.setTextFill(ColorService.getColorParity(value.getParity()));
            sequencesGP.add(labelValue, j, row);
        }
    }

    private void writeSequenceRangesToRow(Sequence<?> sequence, List<?> betOn, int row) {
        Range rangeBet1 = (Range) betOn.get(0);
        Range rangeBet2 = betOn.size() > 1 ? (Range) betOn.get(1) : null;

        sequencesGP.add(getLabelLength(sequence), 2, row);

        Label labelBetOn1 = new Label();
        labelBetOn1.setText(DesignationService.getRangeDesignation(rangeBet1));
        labelBetOn1.setTextFill(ColorService.getColorRange(rangeBet1));
        labelBetOn1.setFont(font);
        sequencesGP.add(labelBetOn1, 0, row);

        if (rangeBet2 != null) {
            Label labelBetOn2 = new Label();
            labelBetOn2.setText(DesignationService.getRangeDesignation(rangeBet2));
            labelBetOn2.setTextFill(ColorService.getColorRange(rangeBet2));
            labelBetOn2.setFont(font);
            sequencesGP.add(labelBetOn2, 1, row);
        }

        for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
            Number value = sequence.getValues().remove();
            Label labelValue = new Label();
            labelValue.setText(value.getName());
            labelValue.setTextFill(ColorService.getColorRange(value.getRange()));
            sequencesGP.add(labelValue, j, row);
        }
    }

    private void writeSequenceSectorsToRow(Sequence<?> sequence, List<?> betOn, int row) {
        Sector sectorBet1 = (Sector) betOn.get(0);
        Sector sectorBet2 = betOn.size() > 1 ? (Sector) betOn.get(1) : null;

        sequencesGP.add(getLabelLength(sequence), 2, row);

        Label labelBetOn1 = new Label();
        labelBetOn1.setText(DesignationService.getSectorDesignation(sectorBet1));
        labelBetOn1.setTextFill(ColorService.getColorSector(sectorBet1));
        labelBetOn1.setFont(font);
        sequencesGP.add(labelBetOn1, 0, row);

        if (sectorBet2 != null) {
            Label labelBetOn2 = new Label();
            labelBetOn2.setText(DesignationService.getSectorDesignation(sectorBet2));
            labelBetOn2.setTextFill(ColorService.getColorSector(sectorBet2));
            labelBetOn2.setFont(font);
            sequencesGP.add(labelBetOn2, 1, row);
        }

        for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
            Number value = sequence.getValues().remove();
            Label labelValue = new Label();
            labelValue.setText(value.getName());
            labelValue.setTextFill(ColorService.getColorSector(value.getSector()));
            sequencesGP.add(labelValue, j, row);
        }
    }

    private void writeSequenceRowsToRow(Sequence<?> sequence, List<?> betOn, int row) {
        Row rowBet1 = (Row) betOn.get(0);
        Row rowBet2 = betOn.size() > 1 ? (Row) betOn.get(1) : null;

        sequencesGP.add(getLabelLength(sequence), 2, row);

        Label labelBetOn1 = new Label();
        labelBetOn1.setText(DesignationService.getRowDesignation(rowBet1));
        labelBetOn1.setTextFill(ColorService.getColorRow(rowBet1));
        labelBetOn1.setFont(font);
        sequencesGP.add(labelBetOn1, 0, row);

        if (rowBet2 != null) {
            Label labelBetOn2 = new Label();
            labelBetOn2.setText(DesignationService.getRowDesignation(rowBet2));
            labelBetOn2.setTextFill(ColorService.getColorRow(rowBet2));
            labelBetOn2.setFont(font);
            sequencesGP.add(labelBetOn2, 1, row);
        }

        for (int j = 3; j < sequencesGP.getColumnCount() && !sequence.getValues().isEmpty(); j++) {
            Number value = sequence.getValues().remove();
            Label labelValue = new Label();
            labelValue.setText(value.getName());
            labelValue.setTextFill(ColorService.getColorRow(value.getRow()));
            sequencesGP.add(labelValue, j, row);
        }
    }

    private void loadSettings() {
        GameSettings gameSettings = GameService.getGameSettings();
        tMinSizeCombinations.setText(String.valueOf(gameSettings.getMinSizeCombinations()));
        tMaxSizePartsCombinationsX2.setText(String.valueOf(gameSettings.getMaxSizePartsCombinationsX2()));
        tMaxSizePartsCombinationsX3.setText(String.valueOf(gameSettings.getMaxSizePartsCombinationsX3()));
        cExclusionSequencesOfIdenticalValues.setSelected(gameSettings.isExclusionSequencesOfIdenticalValues());
        cZerosAsAnyValue.setSelected(gameSettings.isZerosAsAnyValue());
        cMarkingSameValuesSequences.setSelected(gameSettings.isMarkingSameValuesSequences());
        cAutomaticallySaveGameAfterExiting.setSelected(gameSettings.isAutomaticallySaveGameAfterExiting());
        cStatisticsLog.setSelected(gameSettings.isStatisticsLog());
        cOpeningAppOnTopOfOtherWindows.setSelected(gameSettings.isOpeningAppOnTopOfOtherWindows());
        App.getAppStage().setAlwaysOnTop(gameSettings.isOpeningAppOnTopOfOtherWindows());
        cBetColour.setSelected(gameSettings.isBetColour());
        cBetParity.setSelected(gameSettings.isBetParity());
        cBetRange.setSelected(gameSettings.isBetRange());
        cBetSector.setSelected(gameSettings.isBetSector());
        cBetRow.setSelected(gameSettings.isBetRow());
    }

    private void saveSettings() throws IOException {
        GameSettings gameSettings = GameService.getGameSettings();

        String tMinSizeCombinationsText = tMinSizeCombinations.getText();
        if (NumberUtils.isParsable(tMinSizeCombinationsText)) {
            int minSizeCombinations = Integer.parseInt(tMinSizeCombinationsText);
            if (minSizeCombinations >= gameSettings.getLowLimitMinSizeCombinations() &&
                    minSizeCombinations <= gameSettings.getUpLimitMinSizeCombinations()) {
                gameSettings.setMinSizeCombinations(minSizeCombinations);
            }
        }

        String tMaxSizePartsCombinationsX2Text = tMaxSizePartsCombinationsX2.getText();
        if (NumberUtils.isParsable(tMaxSizePartsCombinationsX2Text)) {
            int maxSizePartsCombinationsX2 = Integer.parseInt(tMaxSizePartsCombinationsX2Text);
            if (maxSizePartsCombinationsX2 >= gameSettings.getLowLimitMaxSizePartsCombinationsX2() &&
                    maxSizePartsCombinationsX2 <= gameSettings.getUpMaxSizePartsCombinationsX2()) {
                gameSettings.setMaxSizePartsCombinationsX2(maxSizePartsCombinationsX2);
            }
        }

        String tMaxSizePartsCombinationsX3Text = tMaxSizePartsCombinationsX3.getText();
        if (NumberUtils.isParsable(tMaxSizePartsCombinationsX3Text)) {
            int maxSizePartsCombinationsX3 = Integer.parseInt(tMaxSizePartsCombinationsX3Text);
            if (maxSizePartsCombinationsX3 >= gameSettings.getLowLimitMaxSizePartsCombinationsX3() &&
                    maxSizePartsCombinationsX3 <= gameSettings.getUpMaxSizePartsCombinationsX3()) {
                gameSettings.setMaxSizePartsCombinationsX3(maxSizePartsCombinationsX3);
            }
        }

        gameSettings.setExclusionSequencesOfIdenticalValues(cExclusionSequencesOfIdenticalValues.isSelected());
        gameSettings.setZerosAsAnyValue(cZerosAsAnyValue.isSelected());
        gameSettings.setMarkingSameValuesSequences(cMarkingSameValuesSequences.isSelected());
        gameSettings.setAutomaticallySaveGameAfterExiting(cAutomaticallySaveGameAfterExiting.isSelected());
        gameSettings.setStatisticsLog(cStatisticsLog.isSelected());
        gameSettings.setOpeningAppOnTopOfOtherWindows(cOpeningAppOnTopOfOtherWindows.isSelected());
        gameSettings.setBetColour(cBetColour.isSelected());
        gameSettings.setBetParity(cBetParity.isSelected());
        gameSettings.setBetRange(cBetRange.isSelected());
        gameSettings.setBetSector(cBetSector.isSelected());
        gameSettings.setBetRow(cBetRow.isSelected());
        GameService.saveSettings();

        loadSettings();
    }
}