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


    @GET("api/Pizzas")
    Observable<PizzaMapped[]> getPizzas(@QueryMap Map<String, String> ingredientCollection,
                                           @Query("latitude") Double lat,
                                           @Query("longitude") Double lng);

//
//    @GET("/measurements")
//    Observable<Measure> getMeasurementsNotOlderThan(@Header("sessionToken") String sessionToken,
//                                                    @Query("notOlderThan") String datetime,
//                                                    @Query("types[]") String type,
//                                                    @Query("latestForUsers") Integer oneMeasure,
//                                                    @Query("order[createdAt]") String desc);
//
//    @GET("/measurements")
//    Observable<Measure> getMyPrivateMeasurements(@Header("sessionToken") String sessionToken,
//                                                 @Query("createdBy[]") Integer userId,
//                                                 @Query("types[]") String type,
//                                                 @Query("limit") Integer limit,
//                                                 @Query("order[createdAt]") String desc);
//
//    @FormUrlEncoded
//    @POST("/measurements")
//    Observable<Measurement> sendMeasure(@Header("sessionToken") String sessionToken,
//                                        @Field("type") String type,
//                                        @Field("lat") Float lat,
//                                        @Field("lng") Float lng,
//                                        @Field("pm25") Integer pm25,
//                                        @Field("pm10") Integer pm10,
//                                        @Field("pm1") Integer pm1,
//                                        @Field("createdBy") Integer createdBy);
//
//    @FormUrlEncoded
//    @POST("/sessions")
//    Observable<LoginResponse> logIn(@Field("username") String email,
//                                    @Field("password") String password);
//
//    @POST("/sessions/facebook/{accessToken}")
//    Observable<LoginResponse> logInFacebook(@Path("accessToken") String accessToken);
//
//
//    @GET("/sessions/{sessionToken}")
//    Observable<LoginResponse> getInfoForToken(@Path("token") String token);
//
//    @DELETE("/sessions/{sessionToken}")
//    Observable<Void> logout(@Path("sessionToken") String token);
//
//    @PATCH("/users/{username}/forgot-password")
//    Observable<Void> forgotPassword(@Path("username") String username);
//
//    @FormUrlEncoded
//    @POST("/users")
//    Observable<RegisterResponse> createUser(@Field("username") String email,
//                                            @Field("password") String password);
//
//    @GET("/texts")
//    Observable<NewsFeederResponse> getNews(@Header("sessionToken") String sessionToken,
//                                           @Query("limit") Integer limit,
//                                           @Query("order[type]") String desc,
//                                           @Query("order[publicationDate.from]") String _desc);
//

}
