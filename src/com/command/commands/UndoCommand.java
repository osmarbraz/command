package com.command.commands;

import com.command.editor.Editor;

/**
 * Comandos concretos para desfazer.
 */
public class UndoCommand extends Command {

    private CommandHistory history;

    public UndoCommand(Editor editor, CommandHistory history) {
        super(editor);
        this.history = history;
    }

    /**
     * O comando undo (desfazer) desfaz as alterações. Pega o comando mais
     * recente do histórico e executa seu método undo(desfazer). Observe que nós
     * não sabemos a classe desse comando. Mas nós não precisamos saber, já que
     * o comando sabe como desfazer sua própria ação.
     *
     * @return
     */
    @Override
    public boolean execute() {
        if (history.isEmpty()) {
            return false;
        }
        //Recupera o último comando da pilha de histórico
        Command command = history.pop();
        if (command != null) {
            //Desfaz o comando desempilhado
            command.undo();
        }
        return true;
    }
}
