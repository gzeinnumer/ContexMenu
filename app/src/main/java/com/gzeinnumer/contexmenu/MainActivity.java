package com.gzeinnumer.contexmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    String[] data = {"M", "Fadli", "Zein", "GZeinNumer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        //method yang sudah ada di android
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Pilih menu");
        menu.add(0, v.getId(),0,"Delete");
        menu.add(0, v.getId(),0,"UpperCase");
        menu.add(0, v.getId(),0,"LowerCase");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Delete")
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        else if(item.getTitle() =="UpperCase")
            Toast.makeText(this, "UpperCase", Toast.LENGTH_SHORT).show();
        else if(item.getTitle() == "LowerCase")
            Toast.makeText(this, "LowerCase", Toast.LENGTH_SHORT).show();
        return true;

    }
}
