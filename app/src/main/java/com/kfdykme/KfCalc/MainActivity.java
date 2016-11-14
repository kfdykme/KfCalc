package com.kfdykme.KfCalc;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;


public class MainActivity extends Activity implements OnClickListener
{
		 //初始化控件1
		 //用于存储 显示输入的数字 符号的TextView
		 private TextView calcTextView;
		 //用于存储 显示整个表达式包括结果的Textview
		 private TextView resTextView;
		 //输入数字 符号和清除 清空的按钮
		 private Button numberButton1;
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

		 //实现存放 显示计算结果的TextView可以竖直滑动的ScrollView
		 private ScrollView resScrollView;
		 //实现存放 显示计算结果的TextView可以水平滑动的HorizontalScrollView
		 private HorizontalScrollView resHorezontalScrollView;

		 //初始化变量
		 //通过记录按钮id记录当前将进行加／减／乘／除法的int
		 public int symbolId = 0;
		 //存储算数符号在整个输入的文本中所处位置的int
		 public int symbolLocation;

		 //存储第一个加数／被减数／因数／被除数的String
		 public String number1String = "";
		 //存储第二个加数／减数／因数／除数的String
		 public String number2String = "";

		 //存储第一个加数／被减数／因数／被除数的double
		 public double number1Double;
		 //存储第二个加数／减数／因数／除数的double
		 public double number2Double;
		 //存储计算结果的double
		 public double resultDouble;


		 @Override
		 protected void onCreate(Bundle savedInstanceState)
		 {
					super.onCreate(savedInstanceState);
					setContentView(R.layout.main);
					//初始化控件2
					//通过id找到控件  	
					calcTextView = (TextView) findViewById((R.id.calcTextView));
					resTextView = (TextView) findViewById((R.id.resTextView));

					numberButton1 = (Button) findViewById(R.id.numberButton1);
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
					resScrollView = (ScrollView) findViewById(R.id.resScrollView);
					resHorezontalScrollView = (HorizontalScrollView) findViewById(R.id.resHorizontalScrollView);

					//为按钮控件设置onClickListener
					numberButton1.setOnClickListener(this);
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

		 public String onPauseCalcTextView;
public String onPauseResTextView;
		 @Override
		 protected void onPause()
		 {
					// TODO: Implement this method
					super.onPause();
					onPauseCalcTextView =calcTextView.getText().toString();
					onPauseResTextView = resTextView.getText().toString();
		 }

		 @Override
		 protected void onStop()
		 {
					// TODO: Implement this method
					super.onStop();
		 }

		 @Override
		 protected void onResume()
		 {
					// TODO: Implement this method
					super.onResume();
					calcTextView.setText(onPauseCalcTextView);
					resTextView.setText(onPauseResTextView);
		 }

		 @Override
		 protected void onRestart()
		 {
					// TODO: Implement this method
					super.onRestart();
		 }

		 @Override
		 protected void onDestroy()
		 {
					// TODO: Implement this method
					super.onDestroy();
		 }

		 
		 @Override
		 public void onClick(View v)
		 {
					//switch通过获得按钮的id判断按下的是哪一个按钮，该执行什么程序
					switch (((Button)v).getId())
					{
							 //选择输入的文本
							 //input text to calctext by id	
							 case R.id.calcButtonAdd:
							 case R.id.calcButtonMinus:
							 case R.id.calcButtonMult:
							 case R.id.calcButtonDivi:
										//要输入算数符号，必须calcTextView当前文本长度不为零，不然无意义且容易出错
										if (calcTextView.getText().length() != 0)
										{
												 //如果最新输入的是一个算数符号，在再次输入一个算术符号前应该减去这个已有的算术符号，避免出现多个算术符号
												 if (calcTextView.getText().toString().substring(calcTextView.getText().length() - 1).equals("+")
														 || calcTextView.getText().toString().substring(calcTextView.getText().length() - 1).equals("-")
														 || calcTextView.getText().toString().substring(calcTextView.getText().length() - 1).equals("*")
														 || calcTextView.getText().toString().substring(calcTextView.getText().length() - 1).equals("/"))
												 {
															calcTextView.setText(calcTextView.getText().toString().substring(0, calcTextView.getText().length() - 1));
												 } 
												 //当calcTextView当前文本长度不为零，则已经输入了至少一个数字，这时如果最新输入的不是算数符号，则判断calcText当前文本中是否包含了“＋”“－”“＊”“／”,如果已经有加减乘除，就证明已经输入了完整的合法表达式，不再输入新的加减乘除符号了
												 else if (calcTextView.getText().toString().contains("+") 
																	|| calcTextView.getText().toString().contains("-") 
																	|| calcTextView.getText().toString().contains("*") 
																	|| calcTextView.getText().toString().contains("/"))
												 {
															break;
												 }
										}
										else
										{
												 break;
										}
										//在calcTextView当前文本长度不为零，且最后一位输入的不是算术符号同时当前文本不包括任何算术符号时，先根据按下按钮的id设置将要进行的加／减／乘／除／法，将按钮id存储在symbolId中用作判断
										symbolId = ((Button)v).getId();
										//将算术符号在当前文本中的位置存储在symbolLocation中
										symbolLocation = calcTextView.getText().length() + 1;
							 //这几个case中没有break；继续执行下面的代码
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
										//根据按下的按钮将对应的文本加到calcTextView的文本中	
										calcTextView.setText(calcTextView.getText().toString() + ((Button)v).getText().toString());
										break;
							 //执行清空
							 //do clear to ""
							 case R.id.calcButtonClear:
										calcTextView.setText("");
										break;
							 //减一格字符
							 //do delete a char
							 case R.id.calcButtonDel:
										if (calcTextView.getText().length() != 0)
										{
												 calcTextView.setText(calcTextView.getText().toString().substring(0, calcTextView.getText().length() - 1));
										}
										break;
							 //按下等于号，执行doCalculate方法		
							 case R.id.calcButtonEqu:
										//只有在calcTextView当前文本不为“”且包含加减乘除符号时按“="才有效，否则提示表达式错误
										if (!calcTextView.getText().equals(""))
										{
												 if (calcTextView.getText().toString().contains("+") 
														 || calcTextView.getText().toString().contains("-") 
														 || calcTextView.getText().toString().contains("*") 
														 || calcTextView.getText().toString().contains("/"))
												 {
															doCalculate();
												 }
												 else
												 {
															Toast.makeText(getApplicationContext(), "请正确输入表达式\nPlease enter expression currently!1", Toast.LENGTH_SHORT).show();

												 } 
										}
										else
										{
												 Toast.makeText(getApplicationContext(), "请正确输入表达式\nPlease enter expression currently!1", Toast.LENGTH_SHORT).show();

										}
										break;
					}

		 }

		 public void doCalculate()
		 {
					/*用于当算术符号前无文本时给第一个数赋值零 此时无用 故注释
					 if (calcTextView.getText().toString().substring(0,symbolLocation -1).isEmpty()) {
					 number1String = "0";
					 } else {
					 number1String = calcTextView.getText().toString().substring(0,symbolLocation -1);
					 //Toast.makeText(getApplicationContext(),"number1String = " + number1String,Toast.LENGTH_SHORT).show();

					 }*/
					//给第一个数字所在文本赋值
					number1String = calcTextView.getText().toString().substring(0, symbolLocation - 1);
					//如果读入的第一个数字的文本包含加减乘除符号则不将其转化为double格式以免闪退
					if (number1String.contains("+")
							|| number1String.contains("-")
							|| number1String.contains("*")
							|| number1String.contains("/"))
					{
							 //测试用toast 
							 //Toast.makeText(getApplicationContext(),"+" +"\n" + number1String + "\n" +number2String + "\n"  ,Toast.LENGTH_SHORT).show();
					}
					else
					{
							 number1Double = Double.parseDouble(number1String);
							 //测试用toast
							 //Toast.makeText(getApplicationContext(),"number1Double =",1).show();
					}
					//switch通过symbolId判断执行加／减／乘／除							
					switch (symbolId)
					{
							 case R.id.calcButtonAdd:
										//测试用Toast
										//	Toast.makeText(getApplicationContext(), "+",2).show();
										//如果加号后面没有可以读入的文本，则给第二个数字的String赋值“0”
										if (calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("+") + 1, calcTextView.getText().length()).isEmpty())
										{
												 number2String = "0";
										}
										else
										{
												 number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
																																										 indexOf("+") + 1, calcTextView.getText().length());
										}
										//第二个数字的String中含有加减乘除号，则不将其转化为double以免闪退，此时无用故注释
										/*
										 if(!number2String.contains("+")
										 &&!number2String.contains("-")
										 &&!number2String.contains("*")
										 &&!number2String.contains("/")){
										 number2Double = Double.parseDouble(number2String);											 
										 } else{
										 return;
										 }*/
										//将第二个数字的string转化为double
										number2Double = Double.parseDouble(number2String);											 //加法计算结果
										resultDouble = number1Double + number2Double;
										break;
							 //减法计算，同上
							 case R.id.calcButtonMinus:
										//Toast.makeText(getApplicationContext(), "-",2).show();
										if (calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("-") + 1, calcTextView.getText().length()).isEmpty())
										{
												 number2String = "0";
										}
										else
										{
												 number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
																																										 indexOf("-") + 1, calcTextView.getText().length());
										}
										/*
										 if(!number2String.contains("+")
										 &&!number2String.contains("-")
										 &&!number2String.contains("*")
										 &&!number2String.contains("/")){
										 number2Double = Double.parseDouble(number2String);											 
										 } else{
										 return;
										 }*/
										number2Double = Double.parseDouble(number2String);									
										resultDouble = number1Double - number2Double;
										break;
							 //乘法
							 case R.id.calcButtonMult:
										//	Toast.makeText(getApplicationContext(), "*",2).show();
										if (calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("*") + 1, calcTextView.getText().length()).isEmpty())
										{
												 number2String = "0";
										}
										else
										{
												 number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("*") + 1, calcTextView.getText().length());		
										}
										/*
										 if(!number2String.contains("+")
										 &&!number2String.contains("-")
										 &&!number2String.contains("*")
										 &&!number2String.contains("/")){
										 number2Double = Double.parseDouble(number2String);											 
										 } else{
										 return;
										 }							
										 */
										number2Double = Double.parseDouble(number2String);											 
										resultDouble = number1Double * number2Double;
										break;
							 //除法					
							 case R.id.calcButtonDivi:
										//	Toast.makeText(getApplicationContext(), "/",2).show();
										if (calcTextView.getText().toString().substring(calcTextView.getText().toString().indexOf("/") + 1, calcTextView.getText().length()).isEmpty())
										{
												 number2String = "0";
										}
										else
										{
												 number2String = calcTextView.getText().toString().substring(calcTextView.getText().toString().
																																										 indexOf("/") + 1, calcTextView.getText().length());
										}
										/*				if(!number2String.contains("+")
										 &&!number2String.contains("-")
										 &&!number2String.contains("*")
										 &&!number2String.contains("/")){
										 number2Double = Double.parseDouble(number2String);											 
										 } else{
										 return;
										 }
										 */
										number2Double = Double.parseDouble(number2String);											 
										resultDouble = number1Double / number2Double;
										break;
					} 
					//测试用Toast
					//Toast.makeText(getApplicationContext(),"resultDouble=" + Double.toString(resultDouble) + "\number2String =" +number2String,1).show();

					//将计算结果加到resTextView中			
					resTextView.setText(resTextView.getText().toString() 
															+ "\n" + calcTextView.getText().toString() + "=" + Double.toString(resultDouble));
					//将resScrollView滑动到最下端
					resScrollView.scrollTo(0, resScrollView.getHeight() + 1);
					//将resHorizontalScrollView滑动到最右端
					resHorezontalScrollView.scrollTo((calcTextView.getText().toString() + "=" + Double.toString(resultDouble)).length(), 0);
					//重置，将calcTextView中文本清为“”，同时将symbolId设为0
					calcTextView.setText(Double.toString(resultDouble));
					symbolId = 0;
		 }



}
