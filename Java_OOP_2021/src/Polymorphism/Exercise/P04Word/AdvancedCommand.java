package Polymorphism.Exercise.P04Word;

import java.util.List;

public class AdvancedCommand extends CommandImpl {
    private String lastCut;
    private String pasteText;

    protected class CutTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            lastCut = text.substring(startIndex, endIndex);

            if (startIndex < endIndex && startIndex >= 0) {
                text.delete(startIndex, endIndex);
            }
        }
    }

    protected class PasteTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            setPasteText();
            if (startIndex < endIndex && startIndex >= 0) {
                text.replace(startIndex, endIndex, pasteText);
            } else if (startIndex == endIndex) {
                text.insert(startIndex, pasteText);
            }
        }
    }

    public AdvancedCommand(StringBuilder text) {
        super(text);
        this.lastCut = "";
        this.pasteText = "";
    }

    public String getLastCut() {
        return this.lastCut;
    }

    private void setPasteText() {
        this.pasteText = this.getLastCut();
    }

    @Override
    protected List<Command> initCommands() {
        List<Command> commands = super.initCommands();
        commands.add(new Command("cut", new CutTransform()));
        commands.add(new Command("paste", new PasteTransform()));
        return commands;
    }
}
