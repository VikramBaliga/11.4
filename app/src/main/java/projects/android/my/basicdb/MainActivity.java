package projects.android.my.basicdb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabase myDb = new MyDatabase(this);
        db = myDb.getWritableDatabase();
        db.delete("tblEmployee",null,null);
        prepareData();
        ListView listView = (ListView) findViewById(R.id.userList);
        Cursor cursor = db.query("tblEmployee",null,null,null,null,null,null);


        String[] user = new String[cursor.getCount()];
        String[] firstName = new String[cursor.getCount()];
        String[] lastName = new String[cursor.getCount()];

        int i=0;
        cursor.moveToFirst();
        do
        {   user[i]=cursor.getString(0);
            firstName[i]=cursor.getString(1);
            lastName[i]=cursor.getString(2);
            i++;
        }while (cursor.moveToNext());

        UserAdapter ua = new UserAdapter(user,firstName,lastName);

        listView.setAdapter(ua);

    }

    private void prepareData()
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id","1");
        contentValues.put("firstName","Vikram");
        contentValues.put("lastName","Baliga");
        db.insert("tblEmployee",null,contentValues);
        contentValues.put("id","2");
        contentValues.put("firstName","Ravi");
        contentValues.put("lastName","Baliga");
        db.insert("tblEmployee",null,contentValues);
        contentValues.put("id","3");
        contentValues.put("firstName","ABCD");
        contentValues.put("lastName","Baliga");
        db.insert("tblEmployee",null,contentValues);
        contentValues.put("id","4");
        contentValues.put("firstName","EFGH");
        contentValues.put("lastName","Baliga");
        db.insert("tblEmployee",null,contentValues);
    }

    public  class UserAdapter extends BaseAdapter
    {

        String[] user;
        String[] firstName;
        String[] lastName;
        public  UserAdapter(String[] user,String[] firstName,String[] lastName)
        {
            this.user = user;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        @Override
        public int getCount() {
            return user.length;
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_list,null);

            TextView userId = (TextView) view.findViewById(R.id.userId);
            TextView fname = (TextView) view.findViewById(R.id.fname);
            TextView lname = (TextView) view.findViewById(R.id.lname);

            userId.setText(user[position]);
            fname.setText(firstName[position]);
            lname.setText(lastName[position]);



            return  view;
        }
    }
}
