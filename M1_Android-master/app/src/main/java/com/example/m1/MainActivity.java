package com.example.m1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private MyStack stack;
    private TextView topDisplay;
    private EditText pushInput;
    private EditText deleteInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            This does not retain the stack object during configuration change
            See: https://developer.android.com/guide/topics/resources/runtime-changes.html
         */
        stack = new MyStack();
        topDisplay = (TextView) findViewById(R.id.topDisplay);
        pushInput = (EditText) findViewById(R.id.pushInput);
        deleteInput = (EditText) findViewById(R.id.deleteInput);
    }

    private void updateTopDisplay() {
        if (stack.top() == null) {
            topDisplay.setText("Error: null top");
        } else {
            topDisplay.setText(stack.top());
        }
    }

    public void onPush(View view) {
        stack.push(pushInput.getText().toString());
        pushInput.getText().clear();
        updateTopDisplay();
    }

    public void onPop(View view) {
        stack.pop();
        updateTopDisplay();
    }

    public void onDelete(View view) {
        stack.delete(Integer.parseInt(pushInput.getText().toString()));
        deleteInput.getText().clear();
        updateTopDisplay();
    }
}