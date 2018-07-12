package org.ubicomplab.epsilonkeyboard;

import android.app.Activity;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.io.FileWriter;

public class EKActvity extends Activity implements KeyboardView.OnKeyListener, KeyboardView.OnClickListener{

    private FileWriter fileWriter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ek_activity);

        // set up EpsilonKeyboard service
        Intent serviceIntent = new Intent();
        serviceIntent.setAction("org.ubicomplab.epsilonkeyboard.EpsilonKeyboard"); // calls onCreateMethod
        startService(serviceIntent);
    }


    @Override
    public void onClick(View view) {
    }


    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}
