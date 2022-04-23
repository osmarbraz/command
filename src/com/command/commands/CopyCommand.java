package com.command.commands;

import com.command.editor.Editor;

/**
 * Copiar texto selecionado para a área de transferência.
 */
public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    /**
     * O comando copy (copiar) não é salvo no histórico já que não muda o estado
     * do editor.
     *
     * @return
     */
    @Override
    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
