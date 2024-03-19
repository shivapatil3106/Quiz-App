package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private RadioGroup radioGroupOptions;
    private Button buttonSubmit;

    private String[] questions = {
            "What is the capital of France?",
            "What is 5 + 3?",
            "Who wrote 'Romeo and Juliet'?",
            "Which planet is known as the Red Planet?",
            "Who painted the Mona Lisa?",
            "What is the largest mammal in the world?",
            "What is the chemical symbol for water?",
            "What is the tallest mountain in the world?",
            "What is the currency of Japan?",
            "What is the capital of Australia?",
    };
    private String[][] options = {
            {"Paris", "London", "Berlin"},
            {"7", "8", "10"},
            {"Shakespeare", "Dickens", "Twain"},
            {"Mars", "Venus", "Jupiter"},
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso"},

            {"Elephant", "Blue whale", "Giraffe"},
            {"H2O", "CO2", "O2"},
            {"Mount Everest", "K2", "Makalu"},
            {"Yen", "Euro", "Dollar"},
            {"Canberra", "Sydney", "Melbourne"},

    };
    private String[] correctAnswers = {"Paris", "8", "Shakespeare", "Mars", "Leonardo da Vinci",
            // Add more correct answers here
            "Blue whale", "H2O", "Mount Everest", "Yen", "Canberra"};
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        displayQuestion();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void displayQuestion() {

        textViewQuestion.setText(questions[currentQuestionIndex]);

        radioGroupOptions.removeAllViews();

        for (int i = 0; i < options[currentQuestionIndex].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(options[currentQuestionIndex][i]);
            radioButton.setId(i);
            radioGroupOptions.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroupOptions.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            if (selectedAnswer.equals(correctAnswers[currentQuestionIndex])) {
                Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                Toast.makeText(MainActivity.this, "Quiz completed!", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(MainActivity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
        }
    }
}
