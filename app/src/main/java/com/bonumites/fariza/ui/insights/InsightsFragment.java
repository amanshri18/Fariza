package com.bonumites.fariza.ui.insights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bonumites.fariza.R;

public class InsightsFragment extends Fragment {

    private InsightsViewModel insightsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        insightsViewModel =
                ViewModelProviders.of(this).get(InsightsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_insights, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        insightsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}