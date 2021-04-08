package SOLID.Exercise.Logger.model.appenders;

import SOLID.Exercise.Logger.api.Appender;
import SOLID.Exercise.Logger.api.Layout;
import SOLID.Exercise.Logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppendedCount;

    public BaseAppender(Layout layout) {
        this.layout = layout;
        this.messagesAppendedCount = 0;
        this.reportLevel = ReportLevel.INFO;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal() >= this.reportLevel.ordinal()){
            String result = String.format(this.layout.getLayout(), dateTime, reportLevel, message);
            this.append(result);
            messagesAppendedCount++;
        }
    }

    protected abstract void append(String result);

    @Override
    public String toString() {
        //Appender type: ConsoleAppender, Layout type: SimpleLayout, Report level: CRITICAL, Messages appended: 2
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.messagesAppendedCount);
    }
}
