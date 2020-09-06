package org.example.exceptions;

import org.example.logic.AbstractCharacter;

public class NoSuchCharacterException extends Exception {
    public NoSuchCharacterException(String message) {
        super(message);
    }
}
