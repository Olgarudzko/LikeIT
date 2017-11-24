package by.rudzko.jwd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static final String LOG_TXT = "log.txt";
    private static Logger instance;


    public static Logger getLogger() {
        if (instance == null)
            instance = new Logger();

        return instance;
    }

    private Logger() {
    }

    public void printError(Class context, Exception exception) {
        URL address = context.getClassLoader().getResource(LOG_TXT);
        File file;
        PrintWriter printer = null;
        if (address != null) {
            file = new File(address.getFile());
            Date date = new Date(System.currentTimeMillis());
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
            String time = df.format(date);
            try {
                printer = new PrintWriter(new FileWriter(file, true));
                printer.println(time);
                printer.println(exception.getLocalizedMessage());
                printer.flush();
            } catch (IOException e) {
            }finally{
                if (printer != null)
                    printer.close();
            }
        }
    }
}