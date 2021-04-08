package SOLID.Exercise.Logger.api;

import SOLID.Exercise.Logger.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);
}
