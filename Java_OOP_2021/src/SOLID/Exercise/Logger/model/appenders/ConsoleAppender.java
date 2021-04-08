package SOLID.Exercise.Logger.model.appenders;

import SOLID.Exercise.Logger.api.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}