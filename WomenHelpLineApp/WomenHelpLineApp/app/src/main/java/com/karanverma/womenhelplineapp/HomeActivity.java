package com.karanverma.womenhelplineapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView gv;
    private Context context;
    private ImageView selfAudit, sos, menuItems;
    private static String name[] = {"Nearest Police Station", "Nearest Hospital", "Send Message", "Nearest Help Provider", "Guardian Details"};
    private LinearLayout topTenTips, selfDefence;
    public static String[] itemNameList = {"Unsafe", "Doubtful", "Safe", "Police", "Fire", "Ambulance", "Whistle", "Light", "WHL Call"};
    public static int[] itemImages = {R.drawable.unsafe, R.drawable.doubtful, R.drawable.safe, R.drawable.police, R.drawable.fire, R.drawable.ambulance, R.drawable.whistle, R.drawable.light, R.drawable.whl};
    private ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gv = (GridView) findViewById(R.id.gridview);
        context = HomeActivity.this;
        selfAudit = findViewById(R.id.self_audit);
        sos = findViewById(R.id.sos);
        menuItems = findViewById(R.id.menu_items);
        topTenTips = findViewById(R.id.toptentips);
        selfDefence = findViewById(R.id.selfdefencevideo);
        gv.setAdapter(new CustomAdaptor(this, itemNameList, itemImages));
        for (int i = 0; i < name.length; i++) {
            list.add(i, name[i]);
        }

        items = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);

        selfAudit.setOnClickListener(this);
        sos.setOnClickListener(this);
        menuItems.setOnClickListener(this);
        topTenTips.setOnClickListener(this);
        selfDefence.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == selfAudit.getId()) {

        }
        if (view.getId() == sos.getId()) {

        }
        if (view.getId() == selfDefence.getId()) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://youtu.be/T7aNSRoDCmg")));
        }
        if (view.getId() == topTenTips.getId()) {

        }
        if (view.getId() == menuItems.getId()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.soslisting, null);
            builder.setView(view1);
            final ListView listView = view1.findViewById(R.id.soslisting);
            builder.setMessage("SOS Menu:-");
            listView.setAdapter(items);
            registerForContextMenu(listView);
            AlertDialog alertDialog = builder.create();
            alertDialog.setTitle("SOS Menu_-");
            builder.show();

        }


    }
}
