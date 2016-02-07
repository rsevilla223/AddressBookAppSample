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
        registerClickCallback();
    }



    private void populateContactList(){
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));

    }

    private void populateListView(){
        ArrayAdapter<Contact> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.ContactsListView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback(){
        ListView list = (ListView) findViewById(R.id.ContactsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {
                Contact clickedContact = myContacts.get(position);
                String message = "You clicked position " + position + " Whose name is " + clickedContact.getName();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Contact> {
        public MyListAdapter(){
            super(MainActivity.this, R.layout.item_view, myContacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Checks to make sure there is a view to work with.
            View itemView = convertView;
            if (itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
        }

            //Find the current contact to work with
            Contact currentContact = myContacts.get(position);

            //Fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentContact.getIconID());

            //Name
            TextView nameText = (TextView) itemView.findViewById(R.id.item_Name);
            nameText.setText(currentContact.getName());

            //number
            TextView numberText = (TextView) itemView.findViewById(R.id.item_Number);
            numberText.setText(currentContact.getMobile_number());

            return itemView;
        }



    }
}
