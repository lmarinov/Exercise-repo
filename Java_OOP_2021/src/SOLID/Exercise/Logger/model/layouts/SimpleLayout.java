package SOLID.Exercise.Logger.model.layouts;

import SOLID.Exercise.Logger.api.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
