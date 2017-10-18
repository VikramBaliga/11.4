package projects.android.my.basicdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 18-10-2017.
 */

public class MyDatabase extends SQLiteOpenHelper
{
    public MyDatabase(Context context) {
        super(context, "PeopleDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table tblEmployee(id TEXT,firstName TEXT,lastName TEXT)");

}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
