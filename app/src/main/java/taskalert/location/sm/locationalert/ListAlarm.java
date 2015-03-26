package taskalert.location.sm.locationalert;


import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ListAlarm extends ListActivity implements AdapterView.OnItemClickListener {

    TasksSQLiteOpenHelper myDB;
    ListView lvAlarmList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_alarm);
        lvAlarmList = (ListView) findViewById(R.id.lvxAlarmList);

        //open database
        myDB = new TasksSQLiteOpenHelper(this);
        myDB.open();

        populateListViewFromDb();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDB.close();
    }

    public void populateListViewFromDb() {

        Cursor cursor = myDB.getAlarmRows();

        //set up mapping between database fields and layout
        String[] fromDBFields = new String[]{TasksSQLiteOpenHelper.TASK_NAME, TasksSQLiteOpenHelper.TASK_COMPLETE, TasksSQLiteOpenHelper.TASK_TGLONOFF};
        int[] toViewFields = new int[]{R.id.tvAlarmtext, R.id.checkedTextView, R.id.tglAlarmButton,};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(), R.layout.list_alarm_row, cursor, fromDBFields, toViewFields, 0);
        lvAlarmList.setAdapter(myCursorAdapter);

        // RelativeLayout rLayout = (RelativeLayout) view;
        lvAlarmList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Item Clicked",Toast.LENGTH_LONG).show();
    }
}