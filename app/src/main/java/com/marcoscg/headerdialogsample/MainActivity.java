package com.marcoscg.headerdialogsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.marcoscg.headerdialog.HeaderDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21 && getSupportActionBar()!=null)
            getSupportActionBar().setElevation(0f);
    }
    
    public void showHeaderDialog(View v) {
        CheckBox hideIcon = (CheckBox) findViewById(R.id.hideIcon);
        CheckBox hideTitle = (CheckBox) findViewById(R.id.hideTitle);
        CheckBox justify = (CheckBox) findViewById(R.id.justify);

        HeaderDialog headerDialog = new HeaderDialog(this);
        headerDialog.setColor(getResources().getColor(R.color.colorAccent));

        if (!hideIcon.isChecked())
            headerDialog.setIcon(getResources().getDrawable(R.drawable.ic_info_outline_black_48dp));

        if (!hideTitle.isChecked())
            headerDialog.setTitle(getResources().getString(R.string.app_name));

        headerDialog.setMessage(getResources().getString(R.string.lorem));

        if (justify.isChecked())
            headerDialog.justifyContent(true);

        headerDialog.setTitleColor(Color.parseColor("#212121"));
        headerDialog.setTitleGravity(Gravity.CENTER_HORIZONTAL);
        headerDialog.setView(R.layout.custom);
        headerDialog.setPositiveButton(android.R.string.ok, null);
        headerDialog.show();

        ((CheckBox)headerDialog.getInflatedView().findViewById(R.id.checkbox))
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "Checkbox checked: " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            showAboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAboutDialog() {
        String msg = getResources().getString(R.string.about_text);
        new HeaderDialog(this)
                .setColor(getResources().getColor(R.color.colorAccent))
                .setIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                .setTitle(getResources().getString(R.string.library_name))
                .setMessage(Html.fromHtml(msg))
                .setElevation(true)
                .justifyContent(false) // Default false
                .setTitleColor(getResources().getColor(R.color.colorPrimary))
                .setTitleGravity(Gravity.CENTER_HORIZONTAL)
                .setMessageGravity(Gravity.CENTER_HORIZONTAL)
                .setPositiveButton("Close", null)
                .setNeutralButton("View on GitHub", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/marcoscgdev/HeaderDialog/")));
                    }
                })
                .show();
    }
}
