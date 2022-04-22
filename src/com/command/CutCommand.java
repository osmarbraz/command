package com.command;

/**
 * Cortar texto para a área de transferência.
 */
public class CutCommand extends Command {

    public CutCommand(Editor editor) {
        super(editor);
    }

    /**
     * O comando cut (cortar) muda o estado do editor, portanto deve ser salvo
     * no histórico. E ele será salvo desde que o método retorne verdadeiro.
     *
     * @return
     */
    @Override
    public boolean execute() {

        if (editor.textField != null) {
            return false;
        }

        if (editor.textField.getSelectedText().isEmpty()) {
            return false;
        }

        //Faz o backup
        backup();

        String source = editor.textField.getText();
        editor.clipboard = editor.textField.getSelectedText();
        editor.textField.setText(cutString(source));

        return true;
    }

    /**
     * Recorta a String selecionada do texto.
     *
     * @param source
     * @return
     */
    private String cutString(String source) {
        String start = source.substring(0, editor.textField.getSelectionStart());
        String end = source.substring(editor.textField.getSelectionEnd());
        return start + end;
    }
}
