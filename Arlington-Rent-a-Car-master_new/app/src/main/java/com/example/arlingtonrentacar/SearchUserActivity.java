package com.example.arlingtonrentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class SearchUserActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String LASTNAME = "com.example.arlingtonrentacar.LASTNAME";
    private String enterLastName;
    private final LinkedList<String> userList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
    }

    public void searchUser(){
        Intent intent;
        enterLastName = (findViewById(R.id.editText_lastName)).toString();

        Toast.makeText(this, "lastname is :"+enterLastName, Toast.LENGTH_LONG).show();

        if(enterLastName.length() == 0 || enterLastName == null){
            Toast.makeText(this, "Please enter lastname.", Toast.LENGTH_LONG).show();
        }
        else {
            intent = new Intent(SearchUserActivity.this, ViewSearchUserActivity.class);
            intent.putExtra(LASTNAME,enterLastName);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}