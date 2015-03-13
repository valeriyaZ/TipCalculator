package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        Button btn = (Button)findViewById(R.id.btnCalculate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtTExt = (EditText)findViewById(R.id.edtBillAmount);
                String amountText = edtTExt.getText().toString();
                CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
                double amountDouble = Double.parseDouble(amountText);
                double tip = 0.12*amountDouble;

                DecimalFormat newDec;
                if(chkRound.isChecked()){
                    tip = (double)Math.round(tip);
                    newDec = new DecimalFormat("#");
                }
                else{
                    newDec = new DecimalFormat("#.##");
                }
                TextView result = (TextView)findViewById(R.id.txtTipResult);
                result.setText("Tip : " + newDec.format(tip));



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
