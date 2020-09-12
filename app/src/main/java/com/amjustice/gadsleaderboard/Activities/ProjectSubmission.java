package com.amjustice.gadsleaderboard.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
;
import com.amjustice.gadsleaderboard.Fragments.AlertDialogs.ConfirmationDialog;
import com.amjustice.gadsleaderboard.R;


public class ProjectSubmission extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        Button submitFormButton = findViewById(R.id.submit_form_button);
        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConfirmationDialog();
            }
        });

    }

    private void openConfirmationDialog() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
        confirmationDialog.show(getSupportFragmentManager(),null);
    }
}