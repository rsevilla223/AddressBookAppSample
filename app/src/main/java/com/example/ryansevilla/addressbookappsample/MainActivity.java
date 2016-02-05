package com.example.ryansevilla.addressbookappsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.view.ViewGroup;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private List<Contact> myContacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateContactList();
        populateListView();
    }

    private void populateContactList(){
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, "8478189362", "2242344454", "2245432343"));
    }

    private void populateListView(){
        ArrayAdapter<Contact> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.ContactsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Contact> {
        public MyListAdapter(){
            super(MainActivity.this, R.layout.item_view, myContacts);
        }

    }
}
