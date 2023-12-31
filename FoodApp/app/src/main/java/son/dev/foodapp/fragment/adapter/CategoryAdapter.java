package son.dev.foodapp.fragment.adapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import son.dev.foodapp.CategoryActivity;
import son.dev.foodapp.DetailActivity;
import son.dev.foodapp.R;
import son.dev.foodapp.adapter.CartAdapter;
import son.dev.foodapp.data.model.Category;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private Context mContext;
    private List<Category> mCategoryList;
    public CategoryAdapter(Context mContext, List<Category> categoryList) {
        this.mContext = mContext;
        this.mCategoryList = categoryList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.category_item, parent, false);
        CategoryAdapter.ViewHolder viewHolder = new CategoryAdapter.ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = mCategoryList.get(position);
        Glide.with(mContext)
                .load(category.thumbnail)
                .circleCrop()
                .into(holder.ivThumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CategoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.CATEGORY_ID, category.Id);
                intent.putExtras(bundle);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivThumbnail;
        private TextView tvCategoryName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvCategoryName = itemView.findViewById(R.id.tv_category_name);
        }
    }
}
