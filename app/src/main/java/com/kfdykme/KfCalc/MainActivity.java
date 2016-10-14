package com.kfdykme.KfCalc;
//this java have a bug when you press "=" whitout a " " in text
import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.util.*;

public class MainActivity extends Activity implements OnClickListener
{
	private TextView calcTextView;
	private TextView resTextView;
	
	private Button nB1;
	private Button nB2;
	private Button nB3;
	private Button nB4;
	private Button nB5;
	private Button nB6;
	private Button nB7;
	private Button nB8;
	private Button nB9;
	private Button nB0;
	private Button nBPoint;
	private Button cBAdd;
	private Button cBMult;
	private Button cBDiv;
	private Button cBMinus;
	private Button cBEqual;
	private Button cBDel;
	private Button cBClear;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	
		calcTextView = (TextView) findViewById((R.id.calcTextView));
		resTextView = (TextView) findViewById((R.id.resTextView));
		
		nB1 = (Button) findViewById(R.id.numberButton1);
		nB2 = (Button) findViewById(R.id.numberButton2);
		nB3 = (Button) findViewById(R.id.numberButton3);
		nB4 = (Button) findViewById(R.id.numberButton4);
		nB5 = (Button) findViewById(R.id.numberButton5);
		nB6 = (Button) findViewById(R.id.numberButton6);
		nB7 = (Button) findViewById(R.id.numberButton7);
		nB8 = (Button) findViewById(R.id.numberButton8);
		nB9 = (Button) findViewById(R.id.numberButton9);
		nB0 = (Button) findViewById(R.id.numberButton0);
		nBPoint = (Button) findViewById(R.id.numberButtonPoint);
		cBClear = (Button) findViewById(R.id.calcButtonClear);
		cBAdd = (Button) findViewById(R.id.calcButtonAdd);
		cBMult = (Button) findViewById(R.id.calcButtonMult);
		cBMinus = (Button) findViewById(R.id.calcButtonMinus);
		cBDiv = (Button) findViewById(R.id.calcButtonDivi);
		cBDel = (Button) findViewById(R.id.calcButtonDel);
		cBEqual = (Button) findViewById(R.id.calcButtonEqu);
		
		
		
		nB1.setOnClickListener(this);
		nB2.setOnClickListener(this);
		nB3.setOnClickListener(this);
		nB4.setOnClickListener(this);
		nB5.setOnClickListener(this);
		nB6.setOnClickListener(this);
		nB7.setOnClickListener(this);
		nB8.setOnClickListener(this);
		nB9.setOnClickListener(this);
		nB0.setOnClickListener(this);
		nBPoint.setOnClickListener(this);
		cBAdd.setOnClickListener(this);
		cBMult.setOnClickListener(this);
		cBMinus.setOnClickListener(this);
		cBDel.setOnClickListener(this);
		cBDiv.setOnClickListener(this);
		cBClear.setOnClickListener(this);
		cBEqual.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View p1)
	{
		String bText = ((Button)p1).getText().toString();
		
		switch(bText){
			case "1": case "2": case "3": 
			case "4": case "5": case "6": 
			case "7": case "8": case "9": 
			case ".": case "0":
				calcTextView.setText(calcTextView.getText().toString() + ((Button)p1).getText().toString());
				break;
			case "+": case "-": 
			case "*": case "/":
				calcTextView.setText(calcTextView.getText() + " " + bText + " " );
				break;
			case "Del": 
				if ( calcTextView.getText().length() != 0 ){
					if(calcTextView.getText().toString().substring(calcTextView.getText().length()).equals(" ")){
						if(calcTextView.getText().toString().substring(calcTextView.getText().length()-2,calcTextView.getText().length()-2).equals(" ")){
							calcTextView.setText(calcTextView.getText().toString().substring(0,calcTextView.getText().length()-3));
							resTextView.setText("thi is a try");
						}
					}else {
						calcTextView.setText(calcTextView.getText().toString().substring(0,calcTextView.getText().length()-1));
						
					}
					}
					
				/*switch ( calcTextView.getText().toString()
				.substring(calcTextView.getText().
				length() -2,calcTextView.getText().length()-2)){
					case "+":case "-":case "*":case "/":
			 			calcTextView.setText(calcTextView.getText().toString().substring(0,calcTextView.getText().length()-3));
						break;
				}*/
				break;
			case "C":
				calcTextView.setText("");
				break;
			case "=":
				if (!calcTextView.getText().toString().equals("")&&calcTextView.getText().toString().contains(" "))
					doCalculate();
				break;
		}
		// TODO: Implement this method
	}
	
	public void doCalculate(){
		String calcString = calcTextView.getText().toString();
		String s1 = calcString.substring(0,calcString.indexOf(" "));
		if (s1.contains("")) return;
		String op = calcString.substring(calcString.indexOf(" ") + 1, calcString.indexOf(" ") + 2);
		if (!op.contains("+")&!op.contains("-")&!op.contains("*")&!op.contains("/")) return; 
		String s2 = calcString.substring(calcString.indexOf(" ") + 3);
		if (s2.equals("")) return;
		if (s2.contains(" ")) return;
		double r = 0;
		double n1 = Double.parseDouble(s1);
		
		double n2 = Double.parseDouble(s2);
 		
		switch(op){
			case "+":
				r = n1 + n2;
				break;
			case "-":
				r = n1 - n2;
				break;
			case "*":
				r = n1 * n2;
				break;
			case "/":
				r = n1 / n2;
				break;
			default:
				return;
				
		}
		//calcTextView.setText(s1 + "\n" + op + "\n" + s2);
		
		resTextView.setText(resTextView.getText().toString() + "\n" + calcString + " = " + Double.toString(r));
		calcTextView.setText("");
	}

	
	
	
}
