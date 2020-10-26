package com.example.arlingtonrentacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class SearchCarAdmin extends AppCompatActivity {

    //references to buttons and other control on layout
    Button search_renter_btn;
    EditText enterLastName;

    // TODO: change the following in Iteration 3
    private final LinkedList<String> renterList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_car_admin);

        Intent intent = getIntent();
        search_renter_btn = findViewById(R.id.search_renter_btn);
        enterLastName = findViewById(R.id.enterLastName);
    }

    public void SearchUser(){
        Intent intent;

        enterLastName = findViewById(R.id.enterLastName);
        if(enterLastName == null){
            Toast.makeText(this, "Please enter Last name.", Toast.LENGTH_LONG).show();
        } else {
            intent = new Intent(SearchCarAdmin.this, SearchCarAdmin.class);
            startActivity(intent);
        }
    }

    // TODO: Change this in Iteration 3
    private void initrenterList(){

        renterList.addLast(makeViewRequestedCarItemStr("johndoe", "Doe", "John",
                "john@demo.com", 123565, "Renter", 10017));
        renterList.addLast(makeViewRequestedCarItemStr("jimdoe", "Doe", "Jim",
                "jim@demo.com", 123565, "Renter", 10017));
    }
    private String makeViewRequestedCarItemStr(String Username, String LastName, String FirstName, String Email, int Phone,
                                               String Role, int UTAID){

        String row_item = "User Name: " + Username + "\n";
        row_item += "First Name: " + FirstName + "\n";
        row_item += "Last Name: " + LastName + "\n";
        row_item += "Email: " + Email + "\n";
        row_item += "Phone: " + Phone + "\n";
        row_item += "Role: " + Role + "\n";
        row_item += "UTAID: " + UTAID;
        return row_item;
    }
}
