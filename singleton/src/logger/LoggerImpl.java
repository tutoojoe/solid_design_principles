package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.springframework.boot.logging.LogLevel;
import java.util.logging.Level;


public class LoggerImpl implements Logger {
    private static LoggerImpl instance;
    private PrintWriter writer;
    private String logFilePath;

    private LoggerImpl(){

    }

    public static synchronized LoggerImpl getInstance(){
        if (instance == null){
            instance = new LoggerImpl();
        }
        return instance;
    }

    public static synchronized void resetInstance(){
        if (instance != null){
            instance.close();
        }
        instance = null;
    }


    @Override
    //public void log(LogLevel level, String message) {
    public void log(Level level, String message) {
        if (writer==null){
            throw new IllegalStateException("Logger is not initialized");
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        //log message
        //writer.println(timeStamp + " [" + level.name() + "] " + message);
        writer.println(timeStamp + " [" + level + "] " + message);

    }

    @Override
    public synchronized void setLogFile(String filePath) {
        if (writer!=null){
            throw new IllegalStateException("Logger is already initialized with log file.");

        }
        this.logFilePath = filePath;
        try {
            writer = new PrintWriter(new FileWriter(filePath, true), true);
        } catch (IOException e){
            throw new RuntimeException("Error Initializing log file");
        }
    }

    @Override
    public String getLogFile() {
        return this.logFilePath;
    }

    @Override
    public void flush() {
        if (writer !=null){
            writer.flush();
        }

    }

    @Override
    public synchronized void close() {
        if (writer !=null){
            writer.close();
            writer = null;
        }

    }
}