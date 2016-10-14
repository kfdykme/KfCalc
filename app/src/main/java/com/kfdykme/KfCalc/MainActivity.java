package com.kfdykme.KfCalc;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import java.util.*;

// you can calclulate "1+6+-" or "1+7*/" but you can't "1+6+"

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
	public int symbolId = 0;
	public String number1String = "";
	public double number1Double;
	public String number2String = "";
	public double number2Double;
	public int symbolLocation;
	public int sL;
	public double resultDouble;
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
	public void onClick(View v)
	{
		switch(((Button)v).getId()){
			
			//input text to calctext by id	
			case R.id.calcButtonAdd:
			case R.id.calcButtonMinus:
			case R.id.calcButtonMult:
			case R.id.calcButtonDivi:
					symbolId = ((Button)v).getId();
					symbolLocation = calcTextView.getText().length() + 1;
					sL = symbolLocation;
			case R.id.numberButton0:
			case R.id.numberButton1:
			case R.id.numberButton2:
			case R.id.numberButton3:
			case R.id.numberButton4:
			case R.id.numberButton5:
			case R.id.numberButton6:
			case R.id.numberButton7:
			case R.id.numberButton8:
			case R.id.numberButton9:
			case R.id.numberButtonPoint:
				calcTextView.setText(calcTextView.getText().toString() + ((Button)v).getText().toString());
					
				break;
			//do clear to ""
			case R.id.calcButtonClear:
				calcTextView.setText("");
				break;
			//do delete a char
			case R.id.calcButtonDel:
				if (calcTextView.getText().length() != 0){
						calcTextView.setText(calcTextView.getText().toString().substring(0,calcTextView.getText().length()-1));
				}
				break;		
			case R.id.calcButtonEqu:
				if (!calcTextView.getText().equals("")){
						if(calcTextView.getText().toString().contains("+") 
								|| calcTextView.getText().toString().contains("-") 
								|| calcTextView.getText().toString().contains("*") 
								|| calcTextView.getText().toString().contains("/") ){
										doCalculate();
						 }else{
								 Toast.makeText(getApplicationContext(),"Please do currently!1",Toast.LENGTH_SHORT).show();
										
								} 
				} else{
						Toast.makeText(getApplicationContext(),"Please do currently!2",Toast.LENGTH_SHORT).show();
						
				}
				break;
		}

		}
		
		public void doCalculate() {
				//Toast.makeText(getApplicationContext(),"Docalculate" +"\n" + number1String + "\n" +number2String + "\n"  ,Toast.LENGTH_SHORT).show();
				if (calcTextView.getText().toString().substring(0,symbolLocation -1).isEmpty()) {
						number1String = "0";
						//Toast.makeText(getApplicationContext(),"number1String = '' ",Toast.LENGTH_SHORT).show();
				} else {
						number1String = calcTextView.getText().toString().substring(0,symbolLocation -1);
						//Toast.makeText(getApplicationContext(),"number1String = " + number1String,Toast.LENGTH_SHORT).show();
						
				}
				if(number1String.contains("+")
					 ||number1String.contains("-")
					 ||number1String.contains("*")
					 ||number1String.contains("/")){
						//Toast.makeText(getApplicationContext(),"+" +"\n" + number1String + "\n" +number2String + "\n"  ,Toast.LENGTH_SHORT).show();
				}else{
						number1Double = Double.parseDouble(number1String);
						//Toast.makeText(getApplicationContext(),"number1Double =",1).show();
				}
				
				
				/*
				if(number1String.contains("+")
					 ||number1String.contains("-")
					 ||number1String.contains("*")
					 ||number1String.contains("/")){
						//Toast.makeText(getApplicationContext(),"+" +"\n" + number1String + "\n" +number2String + "\n"  ,Toast.LENGTH_SHORT).show();
						}else{
						number1Double = Double.parseDouble(number1String);
						//Toast.makeText(getApplicationContext(),"number1Double =",1).show();
						}
				*/
				//number2String = calcTextView.getText().toString().substring(sL+1,calcTextView.getText().length());
				
				/*if(number2String.contains("+")
					 ||number2String.contains("-")
					 ||number2String.contains("*")
					 ||number2String.contains("/")){
						
				}else{
						//number2Double = Double.parseDouble(number2String);
						Toast.makeText(getApplicationContext(), "\number2String =" +number2String,1).show();
						
						}*/
				
						
				switch(symbolId){
						case R.id.calcButtonAdd:
							//	Toast.makeText(getApplicationContext(), "+",2).show();
								if(calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("+")+1,calcTextView.getText().length()).isEmpty()){
										number2String = "0";
								}else{
										number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
										indexOf("+")+1,calcTextView.getText().length());
							}
								if(!number2String.contains("+")
									 &&!number2String.contains("-")
									 &&!number2String.contains("*")
									 &&!number2String.contains("/")){
										number2Double = Double.parseDouble(number2String);											 
								} else{
										return;
								}
								resultDouble = number1Double + number2Double;
							break;
						case R.id.calcButtonMinus:
							//Toast.makeText(getApplicationContext(), "-",2).show();
								if(calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("-")+1,calcTextView.getText().length()).isEmpty()){
										number2String = "0";
								}else{
							number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
								indexOf("-")+1,calcTextView.getText().length());
								}
								if(!number2String.contains("+")
									 &&!number2String.contains("-")
									 &&!number2String.contains("*")
									 &&!number2String.contains("/")){
										number2Double = Double.parseDouble(number2String);											 
								} else{
										return;
}
							resultDouble = number1Double - number2Double;
							break;
						case R.id.calcButtonMult:
						//	Toast.makeText(getApplicationContext(), "*",2).show();
								if(calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("*")+1,calcTextView.getText().length()).isEmpty()){
										number2String = "0";
								}else{
										number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("*")+1,calcTextView.getText().length());		
								}
								if(!number2String.contains("+")
									 &&!number2String.contains("-")
									 &&!number2String.contains("*")
									 &&!number2String.contains("/")){
										number2Double = Double.parseDouble(number2String);											 
								} else{
										return;
								}							
								resultDouble = number1Double * number2Double;
								break;
						case R.id.calcButtonDivi:
							//	Toast.makeText(getApplicationContext(), "/",2).show();
								if(calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("/")+1,calcTextView.getText().length()).isEmpty()){
										number2String = "0";
								}else{
										number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
								indexOf("/")+1,calcTextView.getText().length());
								}
								if(!number2String.contains("+")
									 &&!number2String.contains("-")
									 &&!number2String.contains("*")
									 &&!number2String.contains("/")){
										number2Double = Double.parseDouble(number2String);											 
								} else{
									return;
								}
								resultDouble = number1Double / number2Double;
								break;
				} 
				
				//Toast.makeText(getApplicationContext(),"resultDouble=" + Double.toString(resultDouble) + "\number2String =" +number2String,1).show();
				
				resTextView.setText(resTextView.getText().toString() 
				+ "\n" + calcTextView.getText().toString() +"="+ Double.toString(resultDouble));
				calcTextView.setText("");
				
				}
	
		
	
}
