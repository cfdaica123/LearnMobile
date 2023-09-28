package son.dev.foodapp.data.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import son.dev.foodapp.data.model.Oder;

public interface OderDao {
    @Query("SELECT * FROM oders")
    List<Oder> getAll();

    @Insert
    void insertAll(Oder oder);

    @Delete
    void delete(Oder oder);
}
