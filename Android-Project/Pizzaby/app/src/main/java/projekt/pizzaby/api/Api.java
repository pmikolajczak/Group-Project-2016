package projekt.pizzaby.api;

import java.util.Collection;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface Api {

    @GET("api/Pizzerias")
    Observable<Collection<PizzeriaMapped>> getData(@QueryMap Map<String, String> ingredientCollection,
                                                   @Query("latitude") Double lat,
                                                   @Query("longitude") Double lng,
                                                   @Query("minSize") Integer minSize,
                                                   @Query("maxSize") Integer maxSize);
}
