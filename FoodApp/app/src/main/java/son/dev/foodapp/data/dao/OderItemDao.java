package son.dev.foodapp.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import son.dev.foodapp.data.model.OderItem;

@Dao
public interface OderItemDao {
    @Query("SELECT * FROM oderItems")
    List<OderItem> getAll();

    @Insert
    void insertAll(OderItem oderItem);

    @Delete
    void delete(OderItem oderItem);
}

