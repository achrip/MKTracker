package com.achrip.mktracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.achrip.mktracker.databinding.SwitchInputDialogBinding;

public class InputDialogFragment extends AppCompatDialogFragment {

    private InputDialogListener dialogListener;
    private SwitchInputDialogBinding binding; //TODO: Use Binding
    public interface InputDialogListener {
        void onInputConfirmed(Switches s);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.switch_input_dialog, null);

        EditText ETmodel = view.findViewById(R.id.model_input);
        EditText ETbrand = view.findViewById(R.id.brand_input);
        Spinner Stype = view.findViewById(R.id.type_spinner);
        EditText ETpre = view.findViewById(R.id.pretravel_input);
        EditText ETtravel = view.findViewById(R.id.travel_input);
        Spinner Spins = view.findViewById(R.id.pin_spinner);
        EditText ETforce = view.findViewById(R.id.actuation_input);

        builder.setView(view)
                .setTitle("Add new switch")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                })
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String model = ETmodel.getText().toString().trim();
                        String brand = ETbrand.getText().toString().trim();
//                        String type = Stype.toString().trim();
                        double pre = Double.parseDouble(ETpre.getText().toString().trim());
                        double travel = Double.parseDouble(ETtravel.getText().toString().trim());
//                        int pins = Integer.parseInt(Spins.toString().trim());
                        double force = Double.parseDouble(ETforce.getText().toString().trim());
                        String type = "";
                        int pins = 5;

                        dialogListener.onInputConfirmed(new MechanicalSwitch(brand, model,
                                type, pre, travel, force, pins));
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            dialogListener = (InputDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement InputDialogListener");
        }
    }
}
