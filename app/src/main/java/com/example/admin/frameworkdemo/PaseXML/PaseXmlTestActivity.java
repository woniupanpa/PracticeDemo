package com.example.admin.frameworkdemo.PaseXML;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.frameworkdemo.PaseXML.Model.Book;
import com.example.admin.frameworkdemo.PaseXML.Paser.BookParser;
import com.example.admin.frameworkdemo.PaseXML.Paser.PullBookParser;
import com.example.admin.frameworkdemo.R;

public class PaseXmlTestActivity extends Activity {

    private static final String TAG = PaseXmlTestActivity.class.getSimpleName();

    private BookParser parser;
    private List<Book> books;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pase_xml);


        Button readBtn = (Button)findViewById(R.id.readBtn);
        Button writeBtn = (Button) findViewById(R.id.writeBtn);

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is = getAssets().open("books.xml");
                    //parser = new SaxBookParser();  //创建SaxBookParser实例
                    //parser = new DomBookParser();
                    parser = new PullBookParser();
                    books = parser.parse(is);  //解析输入流
                    for (Book book : books) {
                        Log.d(TAG, book.toString());
                    }
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String xml = parser.serialize(books);  //序列化
                    FileOutputStream fos = openFileOutput("books.xml", Context.MODE_PRIVATE);
                    fos.write(xml.getBytes("UTF-8"));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

}
