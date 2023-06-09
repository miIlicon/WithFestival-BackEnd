package com.festival.domain.foodTruck.data.dto.response;

import com.festival.domain.foodTruck.data.entity.FoodTruck;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodTruckResponse {

    private String title;
    private String subTitle;

    private String content;

    private String mainFilePath;
    private List<String> subFilePaths;

    private float latitude;
    private float longitude;

    private Boolean state;

    @Builder
    @QueryProjection
    public FoodTruckResponse(String title, String subTitle, String content,
                       String mainFilePath, List<String> subFilePaths, float latitude, float longitude, Boolean state) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.mainFilePath = mainFilePath;
        this.subFilePaths = subFilePaths;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    public static FoodTruckResponse of(final FoodTruck foodTruck, String filePath) {

        List<String> list = new ArrayList<>();
        for (String subFilePath : foodTruck.getFoodTruckImage().getSubFileNames()) {
            list.add(filePath + subFilePath);
        }

        return FoodTruckResponse.builder()
                .title(foodTruck.getTitle())
                .subTitle(foodTruck.getSubTitle())
                .content(foodTruck.getContent())
                .mainFilePath(filePath + foodTruck.getFoodTruckImage().getMainFileName())
                .subFilePaths(list)
                .latitude(foodTruck.getLatitude())
                .longitude(foodTruck.getLongitude())
                .state(foodTruck.getFoodTruckState())
                .build();
    }
}
