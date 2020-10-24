package ru.samsung.itschool.book.equation243;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  // Вызывается при создании Активности
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// Инициализирует Активность.
	setContentView(R.layout.activity_main);
  }

  /**
   * Вызывается при нажатии пользователем на кнопку Решить
   */
  public void solveEquation(View view) {
	// ax+b=c
	double a = Double.parseDouble(((EditText)
			findViewById(R.id.coefficient_a)).getText().toString());
	double b = Double.parseDouble(((EditText)
			findViewById(R.id.coefficient_b)).getText().toString());
	double c = Double.parseDouble(((EditText)
			findViewById(R.id.coefficient_c)).getText().toString());
	TextView result = (TextView) findViewById(R.id.result);

	double discriminant = Math.pow(b, 2) - 4 * a * c;
	double sqrt = Math.sqrt(discriminant);

	double firstRoot;
	double secondRoot;

	String stringResult = "";

	if (discriminant > 0) {
	  firstRoot = (-b + sqrt) / (2 * a);
	  secondRoot = (-b - sqrt) / (2 * a);
	  stringResult = "Roots are :: " + firstRoot + " and " + secondRoot;
	} else if (discriminant == 0) {
	  stringResult = "Root is :: " + (-b + sqrt) / (2 * a);
	}

	result.setText(stringResult);
  }

}
