package com.command;

/**
 * Colar texto da área de transferência.
 */
public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    /**
     * O comando paste (colar) não é salvo no histórico já que não muda o estado
     * do editor.
     *
     * @return
     */
    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) {
            return false;
        }

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
