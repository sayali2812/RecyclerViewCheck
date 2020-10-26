package com.example.arlingtonrentacar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SearchUserListAdapter extends RecyclerView.Adapter<SearchUserListAdapter.SearchUserViewHolder>{

    private final LinkedList<String> usersList;
    private LayoutInflater mInflater;
    private Context context;

    public SearchUserListAdapter(Context context, LinkedList<String> userList){
        mInflater = LayoutInflater.from(context);
        this.usersList = userList;
    }
    @NonNull
    @Override
    public SearchUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rItemView = mInflater.inflate(R.layout.searchuserlist_rows, parent, false);
        return new SearchUserViewHolder(rItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchUserViewHolder holder, int position) {
        String rCurrent = usersList.get(position);
        holder.userItemView.setText(rCurrent);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SearchUserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView userItemView;
        final SearchUserListAdapter nAdapter;

        public SearchUserViewHolder(View itemView, SearchUserListAdapter adapter){
            super(itemView);
            userItemView = itemView.findViewById(R.id.requestedcar_rowitem);
            this.nAdapter = adapter;
            userItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // TODO: for Interation 3 will need to change this, for now just call the target activity
            Intent intent = new Intent(context, UserProfile.class);
            context.startActivity(intent);
        }
    }

}
