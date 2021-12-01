package out.homework11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static out.homework11.Main.allLogs;
import static out.homework11.Main.pattern;

public class FileLogsThread extends Thread{
    private File file;

    public FileLogsThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            readFile(this.file);
        } catch (IOException e) {
            e.printStackTrace();
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
        putLogsInSynchronizedMap(file.getName(), logs);
    }

    public static void putLogsInSynchronizedMap(String fileName, List<Log> logs) {
        synchronized (allLogs) {
            allLogs.put(fileName, logs);
        }
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
