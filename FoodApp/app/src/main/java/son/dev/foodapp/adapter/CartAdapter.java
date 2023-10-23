package son.dev.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;
import com.bumptech.glide.Glide;

import son.dev.foodapp.R;
import son.dev.foodapp.data.AppDatabase;
import son.dev.foodapp.data.dao.ProductDao;
import son.dev.foodapp.data.model.OrderItem;
import son.dev.foodapp.data.model.Product;
import son.dev.foodapp.util.Constants;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private Context mContext;
    private List<OrderItem> mOrderItemList;

    private AppDatabase db;
    private ProductDao productDao;

    public CartAdapter(Context mContext, List<OrderItem> productList) {
        this.mContext = mContext;
        this.mOrderItemList = productList;
        db = Room.databaseBuilder(mContext,
                        AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset(Constants.DB_NAME)
                .build();
        productDao = db.productDao();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.product_cart_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem orderItem = mOrderItemList.get(position);
        Product product = productDao.find(orderItem.productId);

        Glide.with(mContext)
                .load(product.thumbnail)
                .circleCrop()
                .into(holder.ivThumbnail);

        holder.tvProductName.setText(product.name);
        holder.tvProductQuantity.setText(String.valueOf(orderItem.quantity));
        holder.tvProductPrice.setText(String.valueOf(orderItem.price));
        holder.tvTotalPrice.setText(String.valueOf(orderItem.price * orderItem.quantity));
    }

    @Override
    public int getItemCount() {
        return mOrderItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivThumbnail;
        private TextView tvProductName;
        private TextView tvProductQuantity;
        private TextView tvProductPrice;
        private TextView tvTotalPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductQuantity = itemView.findViewById(R.id.tv_product_quantity);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            tvTotalPrice = itemView.findViewById(R.id.tv_total_price);
        }
    }
}
