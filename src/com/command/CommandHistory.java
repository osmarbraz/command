package com.command;

import java.util.Stack;

/**
 * Hístórico de comandos. z O comando global history (histórico) é apenas uma
 * pilha.
 */
public class CommandHistory {

    private Stack<Command> history = new Stack<>();

    /**
     * Último a entrar...
     *
     * @param c
     */
    public void push(Command c) {
        // Empurra o comando para o fim da pilha do histórico.
        history.push(c);
    }

    /**
     * ...primeiro a sair.
     *
     * @return
     */
    public Command pop() {
        // Obtêm o comando mais recente do histórico.
        return history.pop();
    }

    /**
     * Retorna se a pilha está vazia.
     *
     * @return
     */
    public boolean isEmpty() {
        return history.isEmpty();
    }
}
