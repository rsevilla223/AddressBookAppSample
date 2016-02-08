package com.example.ryansevilla.addressbookappsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import info.androidhive.jsonparsing.R;

public class MainActivity extends AppCompatActivity {

    //private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "https://solstice.applauncher.com/external/contacts.json";

    // JSON Node names

    private static final String TAG_NAME = "name";
    private static final String TAG_EMPLOYEE_ID = "employeeId";
    private static final String TAG_COMPANY = "company";
    private static final String TAG_DETAILS_URL = "detailsURL";
    private static final String TAG_SMALLIMAGE_URL = "smallImageURL";
    private static final String TAG_BIRTHDATE = "birthdate";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_PHONE_WORK = "work";
    private static final String TAG_PHONE_HOME = "home";
    private static final String TAG_PHONE_MOBILE = "mobile";

    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    private List<Contact> myContacts = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<HashMap<String, String>>();
        //ListView lv = (ListView);

        populateContactList();
        populateListView();
        registerClickCallback();
    }



    private void populateContactList(){
        myContacts.add(new Contact("Ryan Sevilla", "Loyola University Chicago",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Essie Vaill", "Litronic Industries",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Cruz Roudabush", "Metropolitan Elevator Co",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Billie Tinnes", "Meridian Products",
                "041395", 324, R.drawable.contact_icon, "8478189362", "2242344454", "2245432343"));
        myContacts.add(new Contact("Zackary Mockus", "D & M Plywood Inc",
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
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                int empnum = clickedContact.getEmployeeId();
                intent.putExtra("parameter name", clickedContact.getName());
                intent.putExtra("parameter company", clickedContact.getCompany());
                intent.putExtra("parameter birthdate", clickedContact.getBirthdate());
                intent.putExtra("parameter employee", clickedContact.getEmployeeId());
                intent.putExtra("parameter home_phone", clickedContact.getHome_number());
                intent.putExtra("parameter mobile_phone", clickedContact.getMobile_number());
                intent.putExtra("parameter work_phone", clickedContact.getWork_number());
                startActivity(intent);
                //String message = "You clicked position " + position + " Whose name is " + clickedContact.getName();
                //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
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
