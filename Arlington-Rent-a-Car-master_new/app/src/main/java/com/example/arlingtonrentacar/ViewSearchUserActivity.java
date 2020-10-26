package com.example.arlingtonrentacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.LinkedList;

public class ViewSearchUserActivity extends AppCompatActivity {

    private RecyclerView viewUsersRecyclerView;
    private String lastnameStr;
    private RecyclerView userRecyclerView;
    private SearchUserListAdapter userAdapter;

    // TODO: change the following in Iteration 3
    private final LinkedList<String> usersList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_user);

        Intent intent = getIntent();
        lastnameStr = intent.getStringExtra(SearchUserActivity.LASTNAME);
        initUserList();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        viewUsersRecyclerView = findViewById(R.id.recyclerView_usersList);
        userAdapter = new SearchUserListAdapter(this, usersList);
        userRecyclerView.setAdapter(userAdapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.addItemDecoration(itemDecoration);
        userRecyclerView.hasFixedSize();
    }

    public void initUserList(){

        usersList.addLast(makeViewSearchUserItemStr("johndoe", "Doe", "John",
                "john@demo.com", 123565, "Renter", 10017));
        usersList.addLast(makeViewSearchUserItemStr("jimdoe", "Doe", "Jim",
                "jim@demo.com", 123565, "Renter", 10018));
        usersList.addLast(makeViewSearchUserItemStr("micdoe", "Doe", "mic",
                "mic@demo.com", 123565, "Renter", 10019));
    }

    private String makeViewSearchUserItemStr(String Username, String LastName, String FirstName, String Email, int Phone,
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