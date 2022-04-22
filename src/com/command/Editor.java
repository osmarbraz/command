package com.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface gráfica do editor de texto. A classe do editor tem verdadeiras
 * operações de edição de texto. Ela faz o papel de destinatária: todos os
 * comandos acabam delegando a execução para os métodos do editor.
 */
public class Editor {

    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();

    /**
     * Inicialização do interface gráfica do editor.
     */
    public void init() {
        JFrame frame = new JFrame("Editor de texto(tipo digite e use botões!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;

        // A classe da aplicação define as relações de objeto. Ela age
        // como uma remetente: quando alguma coisa precisa ser feita,
        // ela cria um objeto comando e executa ele.
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(editor));
            }
        });
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(editor));
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(editor));
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new UndoCommand(editor, history));
            }
        });
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);

        //Define o tamanho da janela 
        frame.setSize(450, 200);
        //Posicionamento da janela
        frame.setLocationRelativeTo(null);
        //Exibe a janela
        frame.setVisible(true);
    }

    /**
     * Executa um comando e adiciona ao histórico.
     *
     * @param command Um comando a ser executado.
     */
    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }
}
