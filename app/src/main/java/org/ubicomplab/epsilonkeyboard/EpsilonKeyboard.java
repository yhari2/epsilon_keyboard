package org.ubicomplab.epsilonkeyboard;

import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputConnection;


// ADAPTED FROM:https://code.tutsplus.com/tutorials/create-a-custom-keyboard-on-android--cms-22615

public class EpsilonKeyboard extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;


    @Override
    public View onCreateInputView() {
        keyboardView = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int i) {
    }

    @Override
    public void onRelease(int i) {
    }


    @Override
    public void onKey(int primaryCode, int[] ints) {
        InputConnection ic = getCurrentInputConnection();

        if(primaryCode == -5) {
            // Backspace
            ic.deleteSurroundingText(1, 0);
        } else if(primaryCode > 1000) {
            // autocorrect keys
            // TODO : IMPLEMENT ME
        } else if(primaryCode == -4) {
            // Done key
        } else {
            // normal text keys
            String keyValue = "";
            for(Keyboard.Key key : keyboard.getKeys()) {
                if(key.codes[0] == primaryCode) {
                    keyValue = key.label.toString();
                }
            }

            ic.commitText(keyValue, 1);
        }

        // TODO: LOG key presses
    }

    @Override
    public void onText(CharSequence charSequence) {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeUp() {
    }
}
