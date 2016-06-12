package com.example.vinaykumar.readfromexcel;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order(View v) {
        try {

            AssetManager am=getAssets();// If this line gives you ERROR then try AssetManager am=getActivity().getAssets();
            InputStream is=am.open("Cell Id.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s=wb.getSheet(0);
            int row =s.getRows();
            int col=s.getColumns();
            String xx="";
            /*
            for(int i=0;i<row;i++)
            {
                for (int c=0;c<col;c++)
                {
                    Cell z=s.getCell(c,i);
                    xx=xx+z.getContents();

                }
                xx=xx+"\n";
            }
            display(xx);*/

            /*int i=1, c=0;
            Cell z=s.getCell(c,i);
            display(z.getContents());*/

           int i=0,c=0;
            Cell z=s.getCell(c,i);
            //display(z.getContents());

            if(z.getContents().equals("1901")){
                //display("Do something awesome");
                Cell y=s.getCell(c+1,i);
                display(y.getContents());
            }

        }

        catch (Exception e)
        {

        }


    }
    public void display(String value)
    {
        TextView x=(TextView) findViewById(R.id.textView);
        x.setText(value);
    }
}
