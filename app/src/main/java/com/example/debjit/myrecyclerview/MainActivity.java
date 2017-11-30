package com.example.debjit.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    private String[] textList = {"Orange", "Strawberry", "Banana", "Lichi", "Mango", "Peach"};
    private int[] imageList = {R.drawable.orange, R.drawable.strawberry, R.drawable.banana, R.drawable.lichi, R.drawable.mango, R.drawable.peach};
    private ArrayList<ModuleActivity> moduleActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItemsToArrayList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(moduleActivities));
    }

    private void addItemsToArrayList() {
        moduleActivities.add(new ModuleActivity("orange", "Orange"));
        moduleActivities.add(new ModuleActivity("strawberry", "Strawberry"));
        moduleActivities.add(new ModuleActivity("banana", "Banana"));
        moduleActivities.add(new ModuleActivity("lichi", "Lichi"));
        moduleActivities.add(new ModuleActivity("mango", "Mango"));
        moduleActivities.add(new ModuleActivity("peach", "Peach"));
    }

    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        //the array list initiated via constructor
        private final ArrayList<ModuleActivity> moduleActivities;

        //the constructor
        public MyRecyclerAdapter(ArrayList<ModuleActivity> moduleActivities) {
            this.moduleActivities = moduleActivities;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final ImageView imageView;
            final TextView textView;
            final View view;
            //inflate for new view
            View rootView = getLayoutInflater().inflate(R.layout.activity_module, parent, false);
            return new MyViewHolder(rootView);              //return the view holder object to be used in the onBindViewHolder method
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            //get the corresponding student pojo object for a given position
            ModuleActivity moduleActivity = moduleActivities.get(position);
            //update views values
            holder.textView.setText(moduleActivity.getText());

        }
        @Override
        public int getItemCount() {
            return moduleActivities.size();
        }


    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final View view;

        MyViewHolder(View rootView) {
            imageView = rootView.findViewById(R.id.imageview_child_id);
            textView = rootView.findViewById(R.id.textview_child_id);
            view = rootView;
        }
    }
}
