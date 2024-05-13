package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    static class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<RecyclerViewItem> items;
        private LayoutInflater layoutInflater;
        private com.example.project.RecyclerViewAdapter.OnClickListener onClickListener;

        RecyclerViewAdapter(Context context, List<RecyclerViewItem> items, com.example.project.RecyclerViewAdapter.OnClickListener onClickListener) {
            this.layoutInflater = LayoutInflater.from(context);
            this.items = items;
            this.onClickListener = onClickListener;
        }

        @Override
        @NonNull
        public com.example.project.RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new com.example.project.RecyclerViewAdapter.ViewHolder(layoutInflater.inflate(R.layout.recycle, parent, false));
        }

        @Override
        public void onBindViewHolder(com.example.project.RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.title.setText(items.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView title;

            ViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                title = itemView.findViewById(R.id.title);
            }

            @Override
            public void onClick(View view) {
                onClickListener.onClick(items.get(getAdapterPosition()));
            }
        }

        public interface OnClickListener {
            void onClick(RecyclerViewItem item);
        }
    }
}