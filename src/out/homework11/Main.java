package out.homework11;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static String pattern = "([\\d\\D]*)\\s\\W\\s([INFO\\sWARN\\sDEBUG]*)(.*|[[^]]+])\\s\\W\\s(.*$)";
    public static final Map<String, List<Log>> allLogs = new HashMap<>();

    private static String sortedType;

    private static FileLogsThread lastFile = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите тип логов для вывода(INFO|WARN|DEBUG):");
        sortedType = br.readLine();

        Path file = Path.of("data");
        String[] fileTypes = {"txt", "log"};
        Collection<File> allFiles = FileUtils.listFiles(new File(String.valueOf(file)), fileTypes,true);

        AtomicInteger filesCount = new AtomicInteger();

        allFiles.forEach((element) -> {
            filesCount.getAndIncrement();
            if (filesCount.get() != allFiles.size() - 1) {
                createThread(element, false);
            } else {
                createThread(element, true);
            }
        });

        lastFile.join();

        if (!lastFile.isAlive()) {
            for (Map.Entry<String, List<Log>> entry: allLogs.entrySet()) {
                List<Log> logs = entry.getValue();
                for (int i = 0; i < logs.size(); i++) {
                    if (logs.get(i).getLevel().equals(sortedType)) {
                        System.out.println(logs.get(i).toString());
                    }
                }
            }
        } else {
            throw new Exception("Последний поток еще жив!");
        }


    }

    public static void createThread(File file, Boolean isLastFile) {
        if (isLastFile) {
            lastFile = new FileLogsThread(file);
            lastFile.start();
        } else {
            new FileLogsThread(file).start();
        }
    }
}
