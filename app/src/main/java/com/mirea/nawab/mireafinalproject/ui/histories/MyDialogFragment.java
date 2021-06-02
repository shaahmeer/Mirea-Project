package com.mirea.nawab.mireafinalproject.ui.histories;



import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.List;
import com.mirea.nawab.mireafinalproject.R;

public class MyDialogFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        EditText valueKey = view.findViewById(R.id.editTextDialog);
        builder.setTitle("Add a note to history?")
                .setView(view)
                .setMessage("Enter your note")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Save", (dialog, id) -> {
                    Toast.makeText(getContext(), "History saved",
                            Toast.LENGTH_SHORT).show();
                    com.mirea.nawab.mireafinalproject.ui.histories.AppDatabase db = App.getInstance().getDatabase();
                    HistoriesDao historiesDao = db.storyDao();
                    com.mirea.nawab.mireafinalproject.ui.histories.Cell cell = new com.mirea.nawab.mireafinalproject.ui.histories.Cell();
                    cell.text = String.valueOf(valueKey.getText());
                    historiesDao.insert(cell);
                    dialog.cancel();
                })
                .setNegativeButton("cancel",
                        (dialog, id) -> {
                            dialog.cancel();
                        })
                .setNeutralButton("Clear stories",
                        (dialog, id) -> {
                            Toast.makeText(getContext(), "Stories cleared",
                                    Toast.LENGTH_SHORT).show();
                            com.mirea.nawab.mireafinalproject.ui.histories.AppDatabase db = App.getInstance().getDatabase();
                            HistoriesDao historiesDao = db.storyDao();
                            List<com.mirea.nawab.mireafinalproject.ui.histories.Cell> cells = historiesDao.getAll();
                            for (com.mirea.nawab.mireafinalproject.ui.histories.Cell cell : cells){
                                historiesDao.delete(cell);
                            }
                            dialog.cancel();
                        });
        return builder.create();
    }
}


