package tcx.hieuvv.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class PreCsv {

    private static final String DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

    private static final String XUONG_DONG = "\n";

    public static void main(String[] args) {
        readfile();
    }

    private static void readfile() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("/home/hieuvv/data/test_file_have_json.csv"), StandardCharsets.UTF_8);
                BufferedWriter bw = Files.newBufferedWriter(Paths.get("smoother-bhxh.csv"), StandardCharsets.UTF_8)) {
            String line = br.readLine();
            if (Objects.nonNull(line)) {
                int numberHeader = line.split(DELIMITER, -1).length;
                bw.append(line).append(XUONG_DONG);
                StringBuilder sb = new StringBuilder();
                while (Objects.nonNull(line = br.readLine())) {
                    sb.append(line);
                    int countQuote = countQuote(sb.toString());
                    if (countQuote % 2 != 0) {
                        sb.append("XUONG_DONG");
                        continue;
                    }
                    String[] lineSplit = sb.toString().split(DELIMITER, -1);
                    int numberCurrent = lineSplit.length;
                    while (numberCurrent < numberHeader) {
                        line = br.readLine();
                        sb.append("XUONG_DONG").append(line);
                        if (countQuote(sb.toString()) % 2 != 0) {
                            continue;
                        }
                        numberCurrent = sb.toString().split(DELIMITER, -1).length;
                    }
                    if (numberCurrent == numberHeader) {
                        bw.append(sb.toString()).append(XUONG_DONG);
                    } else {
                        System.out.println(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Count qoute
     * 
     * @update hieuvv
     * @lastModifier 23/07/2020 18:22:22
     * @param line
     * @return
     */
    private static int countQuote(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == '\"') {
                count++;
            }
        }
        return count;
    }
}
