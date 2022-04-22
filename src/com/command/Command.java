package com.command;

/**
 * A classe comando base define a interface comum para todos comandos concretos.
 */
public abstract class Command {

    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    /**
     * Faz um backup do estado do editor.
     */
    void backup() {
        backup = editor.textField.getText();
    }

    /**
     * Restaura o estado do editor.
     */
    public void undo() {
        editor.textField.setText(backup);
    }

    /**
     * O método de execução é declarado abstrato para forçar todos os comandos
     * concretos a fornecer suas próprias implementações. O método deve retornar
     * verdadeiro ou falso dependendo se o comando muda o estado do editor.
     *
     * @return Boolean
     */
    public abstract boolean execute();
}
