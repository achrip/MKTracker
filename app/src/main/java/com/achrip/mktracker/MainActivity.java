package com.achrip.mktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.achrip.mktracker.R;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InputDialogFragment.InputDialogListener{

    private ArrayList<Switches> switchbank;
    private SwichListAdapter swichListAdapter;
    private FloatingActionButton faBtn;
    private TextView totalSwitchView;
    private ListView switchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicColors.applyToActivitiesIfAvailable(this.getApplication());
        setContentView(R.layout.activity_main);

        switchbank = new ArrayList<>();

        switchbank.add(new MechanicalSwitch("Cherry", "MX Black",
                "Linear", 5));
        faBtn = findViewById(R.id.homeFAB);
        totalSwitchView = findViewById(R.id.totalItems);
        switchList = findViewById(R.id.itemList);

        swichListAdapter = new SwichListAdapter(this, switchbank);
        switchList.setAdapter(swichListAdapter);

        faBtn.setOnClickListener(this::fabClickHandler);
        totalSwitchView.setText(String.format("Presses: %d", switchbank.size()));

    }

    private void fabClickHandler(View view) {
//        Toast.makeText(getApplicationContext(), "Ye clicked FAB", Toast.LENGTH_SHORT)
//             .show();
//        totalSwitchView.setText(String.format("Presses: %d", n++));
        InputDialogFragment dialogFragment = new InputDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "input_dialog_fragment");
    }


    @Override
    public void onInputConfirmed(Switches s) {
//        Toast.makeText(getApplicationContext(), "AIGHT WE HERE", Toast.LENGTH_SHORT)
//                .show();
        switchbank.add(s);
        swichListAdapter.notifyDataSetChanged();
        totalSwitchView.setText(String.format("Presses: %d", switchbank.size()));
    }
}