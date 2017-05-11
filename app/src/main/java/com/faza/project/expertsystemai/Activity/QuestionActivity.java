package com.faza.project.expertsystemai.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.faza.project.expertsystemai.Application.ExpertSystemAI;
import com.faza.project.expertsystemai.Model.SymptomsChart;
import com.faza.project.expertsystemai.R;

public class QuestionActivity extends AppCompatActivity {
    private int symptompsIndex;
    private int TOTAL_QUESTION = ExpertSystemAI.getSymptoms().size();
    private TextView tvStep, tvQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Button btnYes = (Button) findViewById(R.id.btn_yes);
        Button btnNo = (Button) findViewById(R.id.btn_no);

        btnYes.setOnClickListener(new AnswerClickListener());
        btnNo.setOnClickListener(new AnswerClickListener());

        tvStep = (TextView) findViewById(R.id.tv_step);
        tvQuestion = (TextView) findViewById(R.id.tv_question);

        setQuestion();
    }

    private void setQuestion() {
        if (symptompsIndex == TOTAL_QUESTION) {
            Intent resultIntent = new Intent(QuestionActivity.this, ResultActivity.class);
            startActivity(resultIntent);

            finish();
        } else {
            String question = ExpertSystemAI.getSymptoms().get(symptompsIndex).getQuestion();

            tvStep.setText((symptompsIndex + 1) + " / " + TOTAL_QUESTION);
            tvQuestion.setText(question);
        }
    }

    private class AnswerClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();

            SymptomsChart symptoms = ExpertSystemAI.getSymptoms().get(symptompsIndex);

            switch (id) {
                case R.id.btn_yes:
                    symptoms.setTrue(true);
                    break;
                case R.id.btn_no:
                    symptoms.setTrue(false);
                    break;
            }

            symptompsIndex++;
            setQuestion();
        }
    }
}