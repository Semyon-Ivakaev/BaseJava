package out.Homework10;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static String pattern = "([\\d\\D]*)\\s\\W\\s([INFO\\sWARN\\sDEBUG]*)(.*|[[^]]+])\\s\\W\\s(.*$)";

    private static String sortedType;

    private static Map<String, List<Log>> allLogs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите тип логов для вывода(INFO|WARN|DEBUG):");
        sortedType = br.readLine();

        Path file = Path.of("data");
        String[] fileTypes = {"txt", "log"};
        Collection<File> allFiles = FileUtils.listFiles(new File(String.valueOf(file)), fileTypes,true);
        allFiles.forEach((el) -> {
            try {
                readFile(el);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

       for (Map.Entry<String, List<Log>> entry: allLogs.entrySet()) {
            List<Log> logs = entry.getValue();
            for (int i = 0; i < logs.size(); i++) {
                if (logs.get(i).getLevel().equals(sortedType)) {
                    System.out.println(logs.get(i).toString());
                }
            }
        }
    }

    public static void readFile(File path) throws IOException {
        List<Log> logs = new ArrayList<>();
        File file = new File(String.valueOf(path));
        try (BufferedReader reader = new BufferedReader((new FileReader(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Log log = parseLog(line, file);
                if (!logs.contains(log)) {
                    logs.add(log);
                }
            }
        }
        allLogs.put(file.getName(), logs);
    }

    public static Log parseLog(String stringLog, File file) {
        String timestamp = null;
        String level = null;
        String logger = null;
        String message = null;

        Matcher line = Pattern.compile(pattern).matcher(stringLog);

        try {
            if (line.matches()) {
                timestamp = line.group(1).trim();
                level = line.group(2).trim();
                logger = line.group(3).trim();
                message = line.group(4).trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Log(timestamp, level, logger, message, file.getName());
    }
}
