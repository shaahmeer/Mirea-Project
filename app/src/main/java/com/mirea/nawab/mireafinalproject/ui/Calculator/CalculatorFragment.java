package com.mirea.nawab.mireafinalproject.ui.Calculator;

import com.mirea.nawab.mireafinalproject.*;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mirea.nawab.mireafinalproject.ui.Calculator.Calculator;

public class CalculatorFragment extends Fragment {
    TextView textViewNumbers;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.calculator, container, false);
        textViewNumbers = root.findViewById(R.id.text_numbers);
        Calculator calculator = new Calculator();
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onClickNumber(view.getId());
                textViewNumbers.setText(calculator.toString());
            }
        };

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onClickOperation(view.getId());
                textViewNumbers.setText(calculator.toString());
            }
        };

        root.findViewById(R.id.button_1).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_2).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_3).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_4).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_5).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_6).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_7).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_8).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_9).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_plus).setOnClickListener(operationClickListener);
        root.findViewById(R.id.button_minus).setOnClickListener(operationClickListener);
        root.findViewById(R.id.button_multi).setOnClickListener(operationClickListener);
        root.findViewById(R.id.button_division).setOnClickListener(operationClickListener);
        root.findViewById(R.id.button_0).setOnClickListener(numberClickListener);
        root.findViewById(R.id.button_clear).setOnClickListener(operationClickListener);
        root.findViewById(R.id.button_equal).setOnClickListener(operationClickListener);
        return root;
    }
}
