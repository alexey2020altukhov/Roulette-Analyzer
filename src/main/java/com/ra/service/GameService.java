package com.ra.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ra.model.GameSettings;
import com.ra.model.Log;
import com.ra.model.Number;
import com.ra.model.Sequence;
import com.ra.util.JsonUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameService {

    private static Map<String, Number> numbers = new LinkedHashMap<>();
    @Getter
    private static LinkedList<Number> historyThisGame = new LinkedList<>();
    private static Map<Number, Integer> numberOfDropsThisGame = new LinkedHashMap<>();
    private static Map<Number, Integer> numberOfDrops = new LinkedHashMap<>();
    private static Map<Number, Integer> numberOfNonDropsThisGame = new LinkedHashMap<>();
    private static Map<Number, Map<Number, Integer>> numberOfDropsFollowingNumbers = new LinkedHashMap<>();

    private static String folderData = "/data";
    private static String numbersJsonName = "numbers.json";
    private static String numberOfDropsJsonName = "numberOfDrops.json";
    private static String numberOfDropsFollowingNumbersJsonName = "numberOfDropsFollowingNumbers.json";

    @Getter
    private static GameSettings gameSettings = new GameSettings();

    private static String folderSettings = "/settings";
    private static String settingsJsonName = "settings.json";

    private static String folderLog = "/log";
    private static String logJsonName = "log.json";
    private static String logTxtName = "log.txt";

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void init() throws IOException {
        //Инициализация настроек
        initSettings();
        //Инициализация списка numbers
        initNumbers();
        //Инициализация списка numberOfDropsThisGame
        initNumberOfDropsThisGame();
        //Инициализация списка numberOfDrops
        initNumberOfDrops();
        //Инициализация списка numberOfNonDropsThisGame
        initNumberOfNonDropsThisGame();
        //Инициализация списка numberOfDropsFollowingNumbers
        initNumberOfDropsFollowingNumbers();
    }

    private static void initSettings() throws IOException {
        GameSettings settingsJson = getGameSettingsFromJson();
        gameSettings = settingsJson == null ? gameSettings : settingsJson;
    }

    private static void initNumbers() throws IOException {
        List<Number> jsonNumbers = getNumbersFromJson();
        jsonNumbers.forEach(a -> numbers.put(a.getName(), a));
    }

    private static void initNumberOfDropsThisGame() {
        numbers.values().forEach(a -> numberOfDropsThisGame.put(a, 0));
    }

    private static void initNumberOfDrops() throws IOException {
        numberOfDrops = getNumberOfDropsFromJson();
        if (numberOfDrops.isEmpty()) {
            numbers.values().forEach(a -> numberOfDrops.put(a, 0));
        }
    }

    private static void initNumberOfNonDropsThisGame() {
        numbers.values().forEach(a -> numberOfNonDropsThisGame.put(a, 0));
    }

    private static void initNumberOfDropsFollowingNumbers() throws IOException {
        numberOfDropsFollowingNumbers = getNumberOfDropsFollowingNumbersFromJson();
        if (numberOfDropsFollowingNumbers.isEmpty()) {
            numbers.values().forEach(a -> {
                Map<Number, Integer> temp = new LinkedHashMap<>();
                numbers.values().forEach(b -> temp.put(b, 0));
                numberOfDropsFollowingNumbers.put(a, temp);
            });
        }
    }

    private static GameSettings getGameSettingsFromJson() throws IOException {
        File file = JsonUtil.getFile(folderSettings.concat("/").concat(settingsJsonName));
        if (file == null) {
            return null;
        }
        return mapper.readValue(file, new TypeReference<>() {
        });
    }

    private static List<Number> getNumbersFromJson() throws IOException {
        return mapper.readValue(JsonUtil.getFile(folderData.concat("/").concat(numbersJsonName)), new TypeReference<>() {
        });
    }

    private static Map<Number, Integer> getNumberOfDropsFromJson() throws IOException {
        File file = JsonUtil.getFile(folderData.concat("/").concat(numberOfDropsJsonName));
        if (file != null) {
            Map<String, Integer> jsonNumberOfDrops = mapper.readValue(file, new TypeReference<>() {
            });
            return jsonNumberOfDrops.entrySet().stream().collect(Collectors.toMap(a -> findNumber(a.getKey()),
                    Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        }
        return new LinkedHashMap<>();
    }

    private static Map<Number, Map<Number, Integer>> getNumberOfDropsFollowingNumbersFromJson() throws IOException {
        File file = JsonUtil.getFile(folderData.concat("/").concat(numberOfDropsFollowingNumbersJsonName));
        if (file != null) {
            Map<String, Map<String, Integer>> jsonNumberOfDropsFollowingNumbers = mapper.readValue(file, new TypeReference<>() {
            });
            return jsonNumberOfDropsFollowingNumbers.entrySet().stream()
                    .collect(Collectors.toMap(a -> findNumber(a.getKey()),
                            a -> a.getValue().entrySet().stream()
                                    .collect(Collectors.toMap(b -> findNumber(b.getKey()), Map.Entry::getValue, (b, c) -> b, LinkedHashMap::new)),
                            (b, c) -> b, LinkedHashMap::new));

        }
        return new LinkedHashMap<>();
    }

    private static List<Log> getLogFromJson() throws IOException {
        File file = JsonUtil.getFile(folderLog.concat("/").concat(logJsonName));
        if (file != null) {
            return mapper.readValue(file, new TypeReference<>() {
            });
        }
        return new ArrayList<>();
    }

    public static Number findNumber(String name) {
        return numbers.get(name);
    }

    public static void addNumber(String name) {
        //Получение прошлого числа
        Number pastNumber = historyThisGame.isEmpty() ? null : historyThisGame.getFirst();

        //Поиск добавляемого числа
        Number number = findNumber(name);

        //Добавление числа в historyThisGame
        historyThisGame.push(number);

        //Обновление списка numberOfDropsThisGame
        numberOfDropsThisGame.put(number, numberOfDropsThisGame.get(number) + 1);

        //Обновление списка numberOfDrops
        numberOfDrops.put(number, numberOfDrops.get(number) + 1);

        //Обновление списка numberOfNonDropsThisGame
        numberOfNonDropsThisGame.entrySet().forEach(a -> a.setValue(a.getKey().equals(number) ? 0 : a.getValue() + 1));

        //Обновление списка numberOfDropsFollowingNumbers
        if (pastNumber != null) {
            numberOfDropsFollowingNumbers.get(pastNumber).put(number, numberOfDropsFollowingNumbers.get(pastNumber).get(number) + 1);
        }
    }

    public static void removeNumber() {
        //Получение и удаление последнего числа в historyThisGame
        Number number = historyThisGame.removeFirst();

        //Получение текущего последнего числа из historyThisGame
        Number lastNumber = historyThisGame.isEmpty() ? null : historyThisGame.getFirst();

        //Обновление списка numberOfDropsThisGame
        numberOfDropsThisGame.put(number, numberOfDropsThisGame.get(number) - 1);

        //Обновление списка numberOfDrops
        numberOfDrops.put(number, numberOfDrops.get(number) - 1);

        //Обновление списка numberOfNonDropsThisGame
        numberOfNonDropsThisGame.entrySet().forEach(a -> a.setValue(a.getKey().equals(number) ?
                (int) historyThisGame.stream().takeWhile(b -> !b.equals(number)).count() : a.getValue() - 1));

        //Обновление списка numberOfDropsFollowingNumbers
        if (lastNumber != null) {
            numberOfDropsFollowingNumbers.get(lastNumber).put(number, numberOfDropsFollowingNumbers.get(lastNumber).get(number) - 1);
        }
    }

    public static Map<Number, Integer> getNumberOfDropsThisGame() {
        return numberOfDropsThisGame.entrySet().stream()
                .sorted(Map.Entry.<Number, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    public static Map<Number, Integer> getNumberOfDrops() {
        return numberOfDrops.entrySet().stream()
                .sorted(Map.Entry.<Number, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    public static Map<Number, Integer> getNumberOfNonDropsThisGame() {
        return numberOfNonDropsThisGame.entrySet().stream()
                .sorted(Map.Entry.<Number, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
    }

    public static Map<Number, Double> getChanceNumbersFallingOut() {
        if (historyThisGame.isEmpty()) {
            return new LinkedHashMap<>();
        }
        Map<Number, Integer> map = numberOfDropsFollowingNumbers.get(historyThisGame.getFirst());
        int totalNumbers = map.values().stream().reduce(0, Integer::sum);
        return map.entrySet().stream()
                .sorted(Comparator.comparing(a -> a.getKey().getOrder()))
                .sorted(Map.Entry.<Number, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        a -> Math.round(a.getValue().doubleValue() / totalNumbers * 10000) / 100.0,
                        (a, b) -> a, LinkedHashMap::new));
    }

    public static void saveGame() throws IOException {
        //Сохранение данных списка numberOfDrops
        Map<String, Integer> numberOfDropsJson = numberOfDrops.entrySet().stream()
                .collect(Collectors.toMap(a -> a.getKey().getName(), Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        JsonUtil.saveFile(folderData.concat("/").concat(numberOfDropsJsonName), numberOfDropsJson);

        //Сохранение данных списка numberOfDropsFollowingNumbers
        Map<String, Map<String, Integer>> numberOfDropsFollowingNumbersJson =
                numberOfDropsFollowingNumbers.entrySet().stream()
                        .collect(Collectors.toMap(a -> a.getKey().getName(),
                                a -> a.getValue().entrySet().stream()
                                        .collect(Collectors.toMap(b -> b.getKey().getName(),
                                                Map.Entry::getValue, (b, c) -> b, LinkedHashMap::new)),
                                (b, c) -> c, LinkedHashMap::new));
        JsonUtil.saveFile(folderData.concat("/").concat(numberOfDropsFollowingNumbersJsonName), numberOfDropsFollowingNumbersJson);

        //Сохранение данных в лог
        if (gameSettings.isStatisticsLog()) {
            saveLog();
        }

        //Очистка списка historyThisGame
        historyThisGame.clear();

        //Очистка списка numberOfDropsThisGame
        numberOfDropsThisGame.entrySet().forEach(a -> a.setValue(0));

        //Очистка списка numberOfNonDropsThisGame
        numberOfNonDropsThisGame.entrySet().forEach(a -> a.setValue(0));
    }

    public static void newGame() throws IOException {
        //Очистка списка historyThisGame
        historyThisGame.clear();

        //Очистка списка numberOfDropsThisGame
        numberOfDropsThisGame.entrySet().forEach(a -> a.setValue(0));

        //Повторная инициализация списка numberOfDrops
        initNumberOfDrops();

        //Очистка списка numberOfNonDropsThisGame
        numberOfNonDropsThisGame.entrySet().forEach(a -> a.setValue(0));

        //Повторная инициализация списка numberOfDropsFollowingNumbers
        initNumberOfDropsFollowingNumbers();
    }

    public static void saveSettings() throws IOException {
        JsonUtil.saveFile(folderSettings.concat("/").concat(settingsJsonName), gameSettings);
    }

    public static void saveLog() throws IOException {
        List<Log> logList = getLogFromJson();
        LinkedList<Number> history = new LinkedList<>(historyThisGame);
        LinkedList<Number> historyTemp = new LinkedList<>();

        while (history.size() > 1) {
            historyTemp.push(history.removeLast());
            Number nextNumber = history.getLast();
            LinkedList<Sequence<?>> sequences = SequenceSearchService.getSequences(historyTemp);
            for (Sequence<?> sequence : sequences) {
                Log log = null;
                int index = 0;
                boolean exitsInLog = false;
                while (index < logList.size()) {
                    Log l = logList.get(index);
                    if (sequence.getSequenceLength() == l.getSequenceLength() && sequence.getType().equals(l.getTypeSequence())) {
                        log = new Log(l);
                        exitsInLog = true;
                        break;
                    }
                    index++;
                }
                log = log == null ? new Log().setSequenceLength(sequence.getSequenceLength())
                        .setTypeSequence(sequence.getType()) : log;
                log.setTotalGames(log.getTotalGames() + 1);

                switch (sequence.getType()) {
                    case COLOUR: {
                        log.setWins(nextNumber.getColour() != null && sequence.getBetOn().contains(nextNumber.getColour()) ?
                                log.getWins() + 1 : log.getWins());
                        break;
                    }
                    case PARITY: {
                        log.setWins(nextNumber.getParity() != null && sequence.getBetOn().contains(nextNumber.getParity()) ?
                                log.getWins() + 1 : log.getWins());
                        break;
                    }
                    case RANGE: {
                        log.setWins(nextNumber.getRange() != null && sequence.getBetOn().contains(nextNumber.getRange()) ?
                                log.getWins() + 1 : log.getWins());
                        break;
                    }
                    case SECTOR: {
                        log.setWins(nextNumber.getSector() != null && sequence.getBetOn().contains(nextNumber.getSector()) ?
                                log.getWins() + 1 : log.getWins());
                        break;
                    }
                    case ROW: {
                        log.setWins(nextNumber.getRow() != null && sequence.getBetOn().contains(nextNumber.getRow()) ?
                                log.getWins() + 1 : log.getWins());
                        break;
                    }
                    default:
                        break;
                }

                if (exitsInLog) {
                    logList.set(index, log);
                } else {
                    logList.add(log);
                }
            }
        }

        JsonUtil.saveFile(folderLog.concat("/").concat(logJsonName), logList);
        LogService.saveLogs(folderLog.concat("/".concat(logTxtName)), logList);
    }
}