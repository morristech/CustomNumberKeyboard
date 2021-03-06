package com.carlos.keyboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.carlos.number.keyboard.CurrencyEditText;
import com.carlos.number.keyboard.KeyBoardLayout;
import com.carlos.number.keyboard.NumberDecimalEditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class CustomKeyboardActivity extends AppCompatActivity {

    private CurrencyEditText mCurrencyTwoDecimalDigitsView;
    private CurrencyEditText mCurrencyNoneDecimalDigitsView;

    private NumberDecimalEditText mNumberDecimalEditText;
    private NumberDecimalEditText mPhoneNumberEditText;
    private NumberDecimalEditText mPhoneNumberLineEditText;

    private KeyBoardLayout mKeyBoardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        mCurrencyTwoDecimalDigitsView = (CurrencyEditText) findViewById(R.id.et_currency1);
        mCurrencyTwoDecimalDigitsView.requestFocus();
        mCurrencyTwoDecimalDigitsView.setFocusableInTouchMode(true);
        mCurrencyTwoDecimalDigitsView.setOnFocusChangeListener(mNumberWithDecimalsKeyboard);

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) currencyFormatter).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) currencyFormatter).setDecimalFormatSymbols(decimalFormatSymbols);
        mCurrencyTwoDecimalDigitsView.setCurrencyFormatter(currencyFormatter);

        mCurrencyNoneDecimalDigitsView = (CurrencyEditText) findViewById(R.id.et_currency2);
        mCurrencyNoneDecimalDigitsView.setOnFocusChangeListener(mNumberWithDecimalsKeyboard);
        mCurrencyNoneDecimalDigitsView.setCurrencyFormatter(currencyFormatter);

        mNumberDecimalEditText = (NumberDecimalEditText) findViewById(R.id.et_number);
        mNumberDecimalEditText.setOnFocusChangeListener(mNumberWithDecimalsKeyboard);

        mPhoneNumberEditText = (NumberDecimalEditText) findViewById(R.id.et_phone_number);
        mPhoneNumberEditText.setOnFocusChangeListener(mNumberWithClearKeyboard);
        mPhoneNumberLineEditText = (NumberDecimalEditText) findViewById(R.id.et_phone_number_line);
        mPhoneNumberLineEditText.setOnFocusChangeListener(mNumberWithClearWitｈLineKeyboard);

        mKeyBoardLayout = (KeyBoardLayout) findViewById(R.id.keyboard_layout);
        mKeyBoardLayout.addKeyBoardCallback(mCurrencyTwoDecimalDigitsView);
        mKeyBoardLayout.addKeyBoardCallback(mCurrencyNoneDecimalDigitsView);
        mKeyBoardLayout.addKeyBoardCallback(mNumberDecimalEditText);
        mKeyBoardLayout.addKeyBoardCallback(mPhoneNumberEditText);
        mKeyBoardLayout.addKeyBoardCallback(mPhoneNumberLineEditText);

        mKeyBoardLayout.setDrawLine(false);
        mKeyBoardLayout.showKeyBoard();
    }

    private View.OnFocusChangeListener mNumberWithDecimalsKeyboard = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                mKeyBoardLayout.setKeyBoardType(KeyBoardLayout.TYPE_KEY_BOARD_NUMBER_WITH_DECIMALS);
                mKeyBoardLayout.setDrawLine(false);
                mKeyBoardLayout.showKeyBoard();
            }
        }
    };

    private View.OnFocusChangeListener mNumberWithClearKeyboard = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                mKeyBoardLayout.setKeyBoardType(KeyBoardLayout.TYPE_KEY_BOARD_NUMBER_WITH_CLEAR);
                mKeyBoardLayout.setDrawLine(false);
                mKeyBoardLayout.showKeyBoard();
            }
        }
    };

    private View.OnFocusChangeListener mNumberWithClearWitｈLineKeyboard = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                mKeyBoardLayout.setKeyBoardType(KeyBoardLayout.TYPE_KEY_BOARD_NUMBER_WITH_CLEAR);
                mKeyBoardLayout.setDrawLine(true);
                mKeyBoardLayout.showKeyBoard();
            }
        }
    };
}
