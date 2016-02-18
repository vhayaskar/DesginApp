package adler.com.desginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    GridAdapter gridAdapter;
    ArrayList<Integer> img = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_tb_toolbar);
        setSupportActionBar(toolbar);
        init();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.activity_main_tb_toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_rv_masonry_grid);
        setAdaptere();

    }

    private void setAdaptere() {
        img.add(R.drawable.image1);
        img.add(R.drawable.image4);
        img.add(R.drawable.image2);
        img.add(R.drawable.image3);
        img.add(R.drawable.image5);



        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        gridAdapter = new GridAdapter(getApplicationContext(), img, new GridAdapter.OnItemclickListener1() {
            @Override
            public void onItemClick(int i) {
                Toast.makeText(getApplicationContext(), "Selected item" + i, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(getApplicationContext(),UmbrellaActivity.class);
                startActivity(intent);

            }


        });
        recyclerView.setAdapter(gridAdapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(0);
        recyclerView.addItemDecoration(decoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
