package com.example.donal.totalsapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import realm.User;

public class HomePage extends AppCompatActivity {

    //TextViews
    private TextView runTextView;
    private TextView cycleTextView;
    private TextView swimTextView;

    //Realm user
    private Realm realm;
    private User user;

    //Dialog
    private View customView;

    private EditText Distance;
    private EditText Time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder().name("totalsApplication.realm").build();
        Realm.setDefaultConfiguration(config);

        realm = Realm.getInstance(config);

        Log.d("donal", "path: " + realm.getPath());
        setContentView(R.layout.activity_home__page);

        runTextView = (findViewById(R.id.runTextView));
        swimTextView = (findViewById(R.id.swimTextView));
        cycleTextView = (findViewById(R.id.cycleTextView));

        setValues();
//        realm.beginTransaction();
//        User user = realm.createObject(User.class, "Donal");
//        realm.commitTransaction();

    }

    private void setValues(){

        RealmQuery<User> query = realm.where(User.class);
        user = query.findFirst();

        runTextView.setText(String.format(Locale.ENGLISH, "%,.2f", user.getRunDistance()) + "Km");
        swimTextView.setText(String.format(Locale.ENGLISH, "%,.2f", user.getSwimDistance()) + "Km");
        cycleTextView.setText(String.format(Locale.ENGLISH, "%,.2f", user.getCycleDistance()) + "Km");
    }

    public void displayDialog(View view){

        new MaterialDialog.Builder(this)
                .title("test")
                .content("test")
                .positiveText("test")
                .negativeText("test")
                .show();
    }

    public void addRunDistance(View view){

        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(this)
                .title(R.string.add_run)
                .customView(R.layout.home_run_dialog, wrapInScrollView)
                .theme(Theme.LIGHT)
                .positiveColorRes(R.color.colorAccent)
                .negativeColorRes(R.color.colorAccent)
                .negativeText(R.string.cancel)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        // TODO
                    }
                })
                .positiveText(R.string.submit)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        customView = dialog.getCustomView();

                        Distance = customView.findViewById(R.id.runDistanceEditText);
                        Time = customView.findViewById(R.id.runTimeEditText);

                        realm.beginTransaction();
                        RealmQuery<User> query = realm.where(User.class);
                        user = query.findFirst();

                        user.setRunDistance(user.getRunDistance() + Double.parseDouble(Distance.getText().toString()));
                        user.setRunTime(user.getRunTime() + Double.parseDouble(Time.getText().toString()));

                        realm.copyToRealmOrUpdate(user);
                        realm.commitTransaction();
                        Log.i("Realm", "Added new Run distance and time");

                        setValues();
//                        Log.i("editText", Distance.getText().toString());
                    }
                })
                .show();

    }

    public void addSwimDistance(View view){
        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(this)
                .title(R.string.add_swim)
                .customView(R.layout.home_swim_dialog, wrapInScrollView)
                .theme(Theme.LIGHT)
                .positiveColorRes(R.color.colorAccent)
                .negativeColorRes(R.color.colorAccent)
                .negativeText(R.string.cancel)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        // TODO
                    }
                })
                .positiveText(R.string.submit)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        customView = dialog.getCustomView();

                        Distance = customView.findViewById(R.id.swimDistanceEditText);
                        Time = customView.findViewById(R.id.swimTimeEditText);

                        realm.beginTransaction();
                        RealmQuery<User> query = realm.where(User.class);
                        user = query.findFirst();

                        user.setSwimDistance(user.getSwimDistance() + Double.parseDouble(Distance.getText().toString()));
                        user.setSwimTime(user.getSwimTime() + Double.parseDouble(Time.getText().toString()));

                        realm.copyToRealmOrUpdate(user);
                        realm.commitTransaction();
                        Log.i("Realm", "Added new Swim distance and time");

                        setValues();
//                        Log.i("editText", Distance.getText().toString());
                    }
                })
                .show();

    }

    public void addCycleDistance(View view){
        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(this)
                .title(R.string.add_cycle)
                .customView(R.layout.home_cycle_dialog, wrapInScrollView)
                .theme(Theme.LIGHT)
                .positiveColorRes(R.color.colorAccent)
                .negativeColorRes(R.color.colorAccent)
                .negativeText(R.string.cancel)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        // TODO
                    }
                })
                .positiveText(R.string.submit)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(MaterialDialog dialog, DialogAction which) {
                        customView = dialog.getCustomView();

                        Distance = customView.findViewById(R.id.cycleDistanceEditText);
                        Time = customView.findViewById(R.id.cycleTimeEditText);

                        realm.beginTransaction();
                        RealmQuery<User> query = realm.where(User.class);
                        user = query.findFirst();

                        user.setCycleDistance(user.getCycleDistance() + Double.parseDouble(Distance.getText().toString()));
                        user.setCycleTime(user.getCycleTime() + Double.parseDouble(Time.getText().toString()));

                        realm.copyToRealmOrUpdate(user);
                        realm.commitTransaction();
                        Log.i("Realm", "Added new Cycle distance and time");

                        setValues();
//                        Log.i("editText", Distance.getText().toString());
                    }
                })
                .show();
    }
}
