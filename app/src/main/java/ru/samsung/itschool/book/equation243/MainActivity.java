package ru.samsung.itschool.book.equation243;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
  }

  public void solveEquation(View view) {

	if (!((EditText) findViewById(R.id.coefficient_a)).getText().toString().isEmpty() &&
			!((EditText) findViewById(R.id.coefficient_b)).getText().toString().isEmpty() &&
			!((EditText) findViewById(R.id.coefficient_c)).getText().toString().isEmpty()) {

	  double a = Double.parseDouble(((EditText)
			  findViewById(R.id.coefficient_a)).getText().toString());
	  double b = Double.parseDouble(((EditText)
			  findViewById(R.id.coefficient_b)).getText().toString());
	  double c = Double.parseDouble(((EditText)
			  findViewById(R.id.coefficient_c)).getText().toString());
	  TextView result = findViewById(R.id.result);

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
	  TextView result = findViewById(R.id.result);
	  result.setText(getString(R.string.emptyFieldError));
	}
  }
}



