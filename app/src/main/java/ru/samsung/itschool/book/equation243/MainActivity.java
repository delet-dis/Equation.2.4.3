package ru.samsung.itschool.book.equation243;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private EditText coefA;
  private EditText coefB;
  private EditText coefC;
  private TextView result;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	coefA = findViewById(R.id.coefficient_a);
	coefB = findViewById(R.id.coefficient_b);
	coefC = findViewById(R.id.coefficient_c);

	result = findViewById(R.id.result);
  }

  public void solveEquation(View view) {

	if (!coefA.getText().toString().isEmpty() &&
			!coefB.getText().toString().isEmpty() &&
			!coefC.getText().toString().isEmpty()) {

	  double a = Double.parseDouble(coefA.getText().toString());
	  double b = Double.parseDouble(coefB.getText().toString());
	  double c = Double.parseDouble(coefC.getText().toString());


	  double discriminant = Math.pow(b, 2) - 4 * a * c;
	  double sqrt = Math.sqrt(discriminant);

	  double firstRoot;
	  double secondRoot;

	  String stringResult;

	  if (a > 0) {
		if (discriminant > 0.0) {
		  firstRoot = (-b + sqrt) / (2 * a);
		  secondRoot = (-b - sqrt) / (2 * a);
		  stringResult = getString(R.string.rootsAre) + " " + firstRoot + " " + getString(R.string.and) + " " + secondRoot;
		} else if (discriminant == 0) {
		  stringResult = getString(R.string.rootIs) + " " + (-b + sqrt) / (2 * a);
		} else {
		  stringResult = getString(R.string.noRoots);
		}
	  } else {
		stringResult = getString(R.string.zeroACoefficient);
	  }

	  result.setText(stringResult);
	} else {
	  result.setText(getString(R.string.emptyFieldError));
	}
  }
}



