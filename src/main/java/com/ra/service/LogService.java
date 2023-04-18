package com.ra.service;

import com.ra.enums.TypeSequence;
import com.ra.model.Log;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogService {

    private static final String COLUMNS = "Длина последовательности | Количество побед | Общее количество игр | Процент побед\n";
    private static final String DIVING_LINE = "-".repeat(100).concat("\n");

    public static void saveLogs(String pathFromContentRoot, List<Log> logList) throws IOException {
        try (FileWriter writer = new FileWriter(System.getProperty("user.dir").concat(pathFromContentRoot))) {
            logList = logList.stream().sorted(Comparator.comparing(Log::getSequenceLength).reversed())
                    .collect(Collectors.toList());

            writer.write(DIVING_LINE);
            writer.write("Общая статистика\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            int lengthSequence = logList.isEmpty() ? 0 : logList.get(0).getSequenceLength();
            int wins = 0;
            int totalGames = 0;
            for (int i = 0; i < logList.size(); i++) {
                Log log = logList.get(i);
                if (log.getSequenceLength() != lengthSequence || i == logList.size() - 1) {
                    writer.write(formatString(String.valueOf(lengthSequence), 27));
                    writer.write(formatString(String.valueOf(wins), 19));
                    writer.write(formatString(String.valueOf(totalGames), 23));
                    writer.write(formatString(String.format("%.2f", totalGames == 0 ? 0.00 : ((double) wins / totalGames) * 100).concat("%"), 13).concat("\n"));

                    lengthSequence = log.getSequenceLength();
                    wins = 0;
                    totalGames = 0;
                }
                wins += log.getWins();
                totalGames += log.getTotalGames();
            }

            writer.write("\n");
            writer.write(DIVING_LINE);
            writer.write("Статистика красное/чёрное\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            for (Log log : logList) {
                if (log.getTypeSequence().equals(TypeSequence.COLOUR)) {
                    writeLog(writer, log);
                }
            }

            writer.write("\n");
            writer.write(DIVING_LINE);
            writer.write("Статистика чётное/нечётное\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            for (Log log : logList) {
                if (log.getTypeSequence().equals(TypeSequence.PARITY)) {
                    writeLog(writer, log);
                }
            }

            writer.write("\n");
            writer.write(DIVING_LINE);
            writer.write("Статистика 1-18/19-36\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            for (Log log : logList) {
                if (log.getTypeSequence().equals(TypeSequence.RANGE)) {
                    writeLog(writer, log);
                }
            }

            writer.write("\n");
            writer.write(DIVING_LINE);
            writer.write("Статистика секторов\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            for (Log log : logList) {
                if (log.getTypeSequence().equals(TypeSequence.SECTOR)) {
                    writeLog(writer, log);
                }
            }

            writer.write("\n");
            writer.write(DIVING_LINE);
            writer.write("Статистика рядов\n");
            writer.write(DIVING_LINE);
            writer.write(COLUMNS);

            for (Log log : logList) {
                if (log.getTypeSequence().equals(TypeSequence.ROW)) {
                    writeLog(writer, log);
                }
            }
        }
    }

    private static void writeLog(FileWriter writer, Log log) throws IOException {
        writer.write(formatString(String.valueOf(log.getSequenceLength()), 27));
        writer.write(formatString(String.valueOf(log.getWins()), 19));
        writer.write(formatString(String.valueOf(log.getTotalGames()), 23));
        writer.write(formatString(String.format("%.2f", log.getTotalGames() == 0 ?
                0.00 : ((double) log.getWins() / log.getTotalGames()) * 100).concat("%"), 13).concat("\n"));
    }

    private static String formatString(String str, int fullStringLength) {
        if (str.length() >= fullStringLength) {
            return str;
        }
        return str.concat(" ".repeat(fullStringLength - str.length()));
    }
}