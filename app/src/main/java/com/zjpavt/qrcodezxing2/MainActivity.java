package com.zjpavt.qrcodezxing2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zjpavt.zxinglib.zxing.app.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_QR=0;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button.setText("扫描二维码");

        //http://blog.csdn.net/ITermeng/article/details/69403918?locationNum=2&fps=1
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(this, CaptureActivity.class), REQUEST_CODE_QR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QR) {
            String result = data.getStringExtra("QR_Result");
            mTv.setText(result);
        }
    }

}
