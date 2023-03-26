package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class QuestionDAO {
    private  DBHelper dbHelper;

    public QuestionDAO(DBHelper dbHelper)
    {
        this.dbHelper= dbHelper;
    }


    /*public ArrayList<QuestionDTO>getQuestion(Integer MD){
        ArrayList<QuestionDTO> lsData= new ArrayList<>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM tbl_Question WHERE MD="+MD,null);
        cursor.moveToFirst();
            do{
                QuestionDTO item;
                item=new QuestionDTO(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5),cursor.getString(6),cursor.getString(7),
                        cursor.getString(8),cursor.getString(9),cursor.getInt(10));
                lsData.add(item);
            }while (cursor.moveToNext());
            return lsData;
    }*/

   /* public QuestionController(DBHelper dbHelper){
        this.dbHelper=dbHelper;
    }*/
    public ArrayList<QuestionDTO>findQuestionByMD(Integer MD){
        ArrayList<QuestionDTO>list=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        String sqlQuery="SELECT * FROM tbl_Question WHERE MD";
        Log.e("Query",sqlQuery);
        Cursor cursor= sqLiteDatabase.rawQuery(sqlQuery,null);

       cursor.moveToFirst();
       if(cursor.getCount()!=0){
            do{
                QuestionDTO item =new QuestionDTO(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getInt(10));

            list.add(item);
            }while (cursor.moveToNext());
       }

        return list;
    }
}
