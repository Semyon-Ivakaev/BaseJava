package out.homework11;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static String pattern = "([\\d\\D]*)\\s\\W\\s([INFO\\sWARN\\sDEBUG]*)(.*|[[^]]+])\\s\\W\\s(.*$)";
    public static final Map<String, List<Log>> allLogs = new HashMap<>();

    private static String sortedType;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите тип логов для вывода(INFO|WARN|DEBUG):");
        sortedType = br.readLine();

        Path path = Path.of("data");
        String[] fileTypes = {"txt", "log"};
        Collection<File> allFiles = FileUtils.listFiles(new File(String.valueOf(path)), fileTypes,true);

        List<FileLogsThread> threads = allFiles.stream().map((FileLogsThread::new)).collect(Collectors.toList());
        threads.forEach(FileLogsThread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
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
}
